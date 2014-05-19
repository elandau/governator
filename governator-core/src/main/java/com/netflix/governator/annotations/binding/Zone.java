package com.netflix.governator.annotations.binding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

/**
 * Facilitates an annotated binding of string to the amazon zone.  
 * This can also be analogous to a rack in a datacenter
 * 
 * bind(String.class).annotatedWith(Environment.class).toInstance("us-east-1a");
 * 
 * @author elandau
 */
@BindingAnnotation
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Zone {

}
