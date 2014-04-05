package com.jaouan.android.kerandroid.annotation.type;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jaouan.android.kerandroid.annotation.KerInjector;

/**
 * 
 * Injects layout resource id.
 * 
 * @author Maxence Jaouan
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@KerInjector(LayoutKerInjector.class)
public @interface Layout {

	/**
	 * Get layout resource id.
	 * 
	 * @return Layout resource id.
	 */
	int value() default 0;

}
