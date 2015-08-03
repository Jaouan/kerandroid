package com.jaouan.android.kerandroid.annotation.field.argument;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jaouan.android.kerandroid.annotation.KerInjector;

/**
 * 
 * Injects argument fields.
 * 
 * @author Maxence Jaouan
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@KerInjector(ArgumentKerInjector.class)
public @interface Argument {

    /**
     * Get resource id.
     *
     * @return Resource id.
     */
    String value();

}
