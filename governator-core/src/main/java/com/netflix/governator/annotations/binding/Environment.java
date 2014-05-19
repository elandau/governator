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
 * Facilitates an annotated binding of string to the runtime environment
 * 
 * bind(String.class).annotatedWith(Environment.class).toInstance("test");
 * 
 * Examples are : 'dev', 'test', 'prod'
 * @author elandau
 */
public @interface Environment {

}
