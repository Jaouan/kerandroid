package com.jaouan.android.kerandroid.annotation.field.instancestate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jaouan.android.kerandroid.annotation.KerInjector;

/**
 * 
 * Injects instance state fields.
 * 
 * @author Maxence Jaouan
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@KerInjector(InstanceStateKerInjector.class)
public @interface InstanceState {
}
