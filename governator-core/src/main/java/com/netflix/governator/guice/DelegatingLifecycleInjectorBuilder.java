package com.netflix.governator.guice;

import java.util.Collection;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import com.netflix.governator.guice.BootstrapModule;
import com.netflix.governator.guice.LifecycleInjector;
import com.netflix.governator.guice.LifecycleInjectorBuilder;
import com.netflix.governator.guice.LifecycleInjectorMode;
import com.netflix.governator.guice.ModuleTransformer;
import com.netflix.governator.guice.PostInjectorAction;
import com.netflix.governator.lifecycle.ClasspathScanner;

/**
 * Decorator for the default LifecycleInjectorBuilder.  Note that this class
 * treats all withXXX methods like withAdditionalXXX methods so all calls are
 * additive instead of replacing the previous value.  
 * 
 * @author elandau
 *
 */
public class DelegatingLifecycleInjectorBuilder implements LifecycleInjectorBuilder {
    private final LifecycleInjectorBuilder delegate;
    
    public DelegatingLifecycleInjectorBuilder(LifecycleInjectorBuilder delegate) {
        this.delegate = delegate;
    }
    
    @Override
    public LifecycleInjectorBuilder withBootstrapModule(BootstrapModule module) {
        delegate.withAdditionalBootstrapModules(module);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withAdditionalBootstrapModules(
            BootstrapModule... modules) {
        delegate.withAdditionalBootstrapModules(modules);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withAdditionalBootstrapModules(
            Iterable<? extends BootstrapModule> modules) {
        delegate.withAdditionalBootstrapModules(modules);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withModules(Module... modules) {
        delegate.withAdditionalModules(modules);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withModules(
            Iterable<? extends Module> modules) {
        delegate.withAdditionalModules(modules);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withAdditionalModules(
            Iterable<? extends Module> modules) {
        delegate.withAdditionalModules(modules);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withAdditionalModules(Module... modules) {
        delegate.withAdditionalModules(modules);
        return this;
    }

    @Override
    @Deprecated
    public LifecycleInjectorBuilder withRootModule(Class<?> mainModule) {
        delegate.withRootModule(mainModule);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withModuleClass(
            Class<? extends Module> module) {
        delegate.withAdditionalModuleClasses(module);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withModuleClasses(
            Iterable<Class<? extends Module>> modules) {
        delegate.withAdditionalModuleClasses(modules);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withModuleClasses(
            Class<?>... modules) {
        delegate.withAdditionalModuleClasses(modules);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withAdditionalModuleClasses(
            Iterable<Class<? extends Module>> modules) {
        delegate.withAdditionalModuleClasses(modules);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withAdditionalModuleClasses(Class<?>... modules) {
        delegate.withAdditionalModuleClasses(modules);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder ignoringAutoBindClasses(
            Collection<Class<?>> ignoreClasses) {
        delegate.ignoringAutoBindClasses(ignoreClasses);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder ignoringAllAutoBindClasses() {
        delegate.ignoringAllAutoBindClasses();
        return this;
    }

    @Override
    public LifecycleInjectorBuilder usingBasePackages(String... basePackages) {
        delegate.usingBasePackages(basePackages);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder usingBasePackages(
            Collection<String> basePackages) {
        delegate.usingBasePackages(basePackages);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder usingClasspathScanner(
            ClasspathScanner scanner) {
        delegate.usingClasspathScanner(scanner);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder inStage(Stage stage) {
        delegate.inStage(stage);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withMode(LifecycleInjectorMode mode) {
        delegate.withMode(mode);
        return this;
    }

    @Override
    public LifecycleInjector build() {
        return delegate.build();
    }

    @Override
    @Deprecated
    public Injector createInjector() {
        return delegate.createInjector();
    }

    @Override
    public LifecycleInjectorBuilder withModuleTransformer(
            ModuleTransformer transformer) {
        delegate.withModuleTransformer(transformer);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withModuleTransformer(
            Collection<? extends ModuleTransformer> transformers) {
        delegate.withModuleTransformer(transformers);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withModuleTransformer(
            ModuleTransformer... transformers) {
        delegate.withModuleTransformer(transformers);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withPostInjectorAction(
            PostInjectorAction action) {
        delegate.withPostInjectorAction(action);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withPostInjectorActions(
            Collection<? extends PostInjectorAction> actions) {
        delegate.withPostInjectorActions(actions);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withPostInjectorActions(
            PostInjectorAction... actions) {
        delegate.withPostInjectorActions(actions);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withSuite(LifecycleInjectorBuilderSuite suite) {
        suite.configure(this);
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withSuites(Iterable<? extends LifecycleInjectorBuilderSuite> suites) {
        for (LifecycleInjectorBuilderSuite suite : suites) {
            suite.configure(this);
        }
        return this;
    }

    @Override
    public LifecycleInjectorBuilder withSuites(LifecycleInjectorBuilderSuite... suites) {
        for (LifecycleInjectorBuilderSuite suite : suites) {
            suite.configure(this);
        }
        return this;
    }

}
