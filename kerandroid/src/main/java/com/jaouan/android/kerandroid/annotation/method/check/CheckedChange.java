package com.jaouan.android.kerandroid.annotation.method.check;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jaouan.android.kerandroid.annotation.KerHandler;

/**
 * 
 * Handles checked change event methods.
 * 
 * @author Maxence Jaouan
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@KerHandler(CheckedChangeKerHandler.class)
public @interface CheckedChange {

	/**
	 * Get views resource id.
	 * 
	 * @return Views resource id.
	 */
	int[] value();

}
