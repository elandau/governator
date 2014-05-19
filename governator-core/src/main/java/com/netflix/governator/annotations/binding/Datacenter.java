package com.netflix.governator.annotations.binding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

@BindingAnnotation
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/**
 * Facilitates an annotated binding of string to the amazon region
 * 
 * bind(String.class).annotatedWith(Environment.class).toInstance("cloud");
 * 
 * @author elandau
 */
public @interface Datacenter {

}
