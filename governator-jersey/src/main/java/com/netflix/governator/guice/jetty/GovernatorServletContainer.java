package com.netflix.governator.guice.jetty;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer.ServletGuiceComponentProviderFactory;
import com.sun.jersey.spi.container.WebApplication;
import com.sun.jersey.spi.container.servlet.WebConfig;

/**
 * Enhancement to {@link GuiceContainer} by allowing the Jersey to be configured via bindings instead of 
 * statically in a {@link JerseyServletModule}.  To enable just provide the following binding,
 * 
 * ```java
 * bind(GuiceContainer.class).to(GovernatorServletContainer.class).asEagerSingleton();
 * ```
 * 
 * You can provide the configuration values to Jersey using the binding
 * 
 * ```java
 *  @Provides
 *  @ServletContainerProperties 
 *  Map<String, Object> getJerseyProperties() {
 *      return ...;
 *  }
 * ```
 * 
 * In addition installing this module will automatically turn on the WADL (which can be turned off
 * by setting the property, com.sun.jersey.config.feature.DisableWADL=true.  Also, when running
 * in Stage.DEVELOPMENT all scanning singleton resources will be eagerly created.
 * 
 */
@Singleton
public final class GovernatorServletContainer extends GuiceContainer {
    private static final long serialVersionUID = -1350697205980976818L;

    private static final Logger LOG = LoggerFactory.getLogger(GovernatorServletContainer.class);
    
    private final Injector injector;
    private ResourceConfig args;
    
    static class Arguments {
        @com.google.inject.Inject(optional=true)
        ResourceConfig config;
    }
    
    @Inject
    GovernatorServletContainer(Injector injector, Arguments args) {
        super(injector);
        
        this.injector = injector;
        this.args = args.config;
    }

    @Override
    protected ResourceConfig getDefaultResourceConfig(
            Map<String, Object> props,
            WebConfig webConfig) throws ServletException {
        
        if (args == null) {
            args = super.getDefaultResourceConfig(props, webConfig);
        }
        
        for (Class<?> resource : args.getRootResourceClasses()) {
            if (Scopes.isSingleton(injector.getBinding(resource))) {
                LOG.info("Creating resource '{}'.", resource.getName());
                injector.getInstance(resource);
            }
            else {
                LOG.info("Resource '{}' will be created on first request.  Mark as @Singleton to create eagerly.", resource.getName());
            }
        }
        return args;
    }
}
