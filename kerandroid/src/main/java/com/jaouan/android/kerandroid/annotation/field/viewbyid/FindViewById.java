package com.jaouan.android.kerandroid.annotation.field.viewbyid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jaouan.android.kerandroid.annotation.KerInjector;

/**
 * 
 * Injects view fields.
 * 
 * @author Maxence Jaouan
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@KerInjector(FindViewByIdKerInjector.class)
public @interface FindViewById {

	/**
	 * Get resource id.
	 * 
	 * @return Resource id.
	 */
	int value();

}
