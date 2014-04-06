package com.jaouan.android.kerandroid.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * KerHandler annotation that specify AbstractKerHandle implementation's class to use for handling.
 * 
 * @author Maxence Jaouan
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface KerHandler {

	/**
	 * Get KerHander implementation's class to use for injection.
	 * 
	 * @return KerHandler implementation's class to use for injection
	 */
	Class<? extends AbstractKerHandler> value();

}
