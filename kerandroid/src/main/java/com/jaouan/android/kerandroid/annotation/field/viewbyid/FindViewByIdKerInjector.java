package com.jaouan.android.kerandroid.annotation.field.viewbyid;

import java.lang.reflect.Field;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jaouan.android.kerandroid.annotation.AbstractKerInjector;

/**
 * 
 * KerInjector for {@link FindViewById} annotation.
 * 
 * @author Maxence Jaouan
 * 
 */
public class FindViewByIdKerInjector extends AbstractKerInjector {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inject(Field field, Activity activity, Bundle savedInstanceState) throws Exception {
		// - Read annotation's value from cache if exists.
		Integer value = (Integer) getFromCache(field);
		if (null == value) {
			// - Find view by id.
			final FindViewById findViewById = field.getAnnotation(FindViewById.class);
			value = findViewById.value();
			putToCache(field, value);

			// - Enable field access.
			field.setAccessible(true);
		}

		// - Set field value.
		field.set(activity, activity.findViewById(value));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inject(Field field, Fragment fragment, Bundle savedInstanceState) throws Exception {
		// - Read annotation's value from cache if exists.
		Integer value = (Integer) getFromCache(field);
		if (null == value) {
			// - Find view by id.
			final FindViewById findViewById = field.getAnnotation(FindViewById.class);
			value = findViewById.value();
			putToCache(field, value);

			// - Enable field access.
			field.setAccessible(true);
		}

		// - Set field value.
		field.set(fragment, fragment.getView().findViewById(value));
	}

}
