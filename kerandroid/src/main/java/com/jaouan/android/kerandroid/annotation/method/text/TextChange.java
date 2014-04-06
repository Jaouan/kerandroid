package com.jaouan.android.kerandroid.annotation.method.text;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jaouan.android.kerandroid.annotation.KerHandler;

/**
 * 
 * Handles text change event methods.
 * 
 * @author Maxence Jaouan
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@KerHandler(TextChangeKerHandler.class)
public @interface TextChange {

	/**
	 * Get views resource id.
	 * 
	 * @return Views resource id.
	 */
	int[] value();

}
