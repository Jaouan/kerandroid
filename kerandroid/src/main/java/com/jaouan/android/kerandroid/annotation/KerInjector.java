package com.jaouan.android.kerandroid.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * KerInjector annotation that specify AbstractKerInjector implementation's class to use for injection.
 * 
 * @author Maxence
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface KerInjector {

	/**
	 * Get KerInjector's class to use for injection.
	 * 
	 * @return KerInjector implementation's class to use for injection
	 */
	Class<? extends AbstractKerInjector> value();

}
