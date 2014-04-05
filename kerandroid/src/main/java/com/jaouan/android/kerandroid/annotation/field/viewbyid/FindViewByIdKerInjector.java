package com.jaouan.android.kerandroid.annotation.field.viewbyid;

import java.lang.reflect.Field;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

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
	public void inject(final Field field, final Activity activity, final Bundle savedInstanceState) throws Exception {
		// - Read annotation's value from cache if exists.
		Integer value = (Integer) this.getFromCache(field);
		if (null == value) {
			// - Find view by id.
			final FindViewById findViewById = field.getAnnotation(FindViewById.class);
			value = findViewById.value();
			this.putToCache(field, value);

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
	public void inject(final Field field, final Fragment fragment, final Bundle savedInstanceState) throws Exception {
		// - Read annotation's value from cache if exists.
		Integer value = (Integer) this.getFromCache(field);
		if (null == value) {
			// - Find view by id.
			final FindViewById findViewById = field.getAnnotation(FindViewById.class);
			value = findViewById.value();
			this.putToCache(field, value);

			// - Enable field access.
			field.setAccessible(true);
		}

		// - Set field value.
		field.set(fragment, fragment.getView().findViewById(value));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inject(final Field field, final android.support.v4.app.Fragment fragment, final Bundle savedInstanceState) throws Exception {
		// - Read annotation's value from cache if exists.
		Integer value = (Integer) this.getFromCache(field);
		if (null == value) {
			// - Find view by id.
			final FindViewById findViewById = field.getAnnotation(FindViewById.class);
			value = findViewById.value();
			this.putToCache(field, value);

			// - Enable field access.
			field.setAccessible(true);
		}

		// - Set field value.
		field.set(fragment, fragment.getView().findViewById(value));
	}

}
