package com.jaouan.android.kerandroid.annotation.field.logger;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.jaouan.android.kerandroid.annotation.AbstractKerInjector;

/**
 * KerInjector for {@link ClassLogger} annotation.
 * 
 * @author Maxence Jaouan
 * 
 */
public class ClassLoggerKerInjector extends AbstractKerInjector {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inject(final Field field, final Activity activity, final Bundle savedInstanceState) throws Exception {
		// - Inject logger.
		this.injectLogger(field, activity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inject(final Field field, final Fragment fragment, final Bundle savedInstanceState) throws Exception {
		// - Inject logger.
		this.injectLogger(field, fragment);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inject(final Field field, final android.support.v4.app.Fragment fragment, final Bundle savedInstanceState) throws Exception {
		// - Inject logger.
		this.injectLogger(field, fragment);
	}

	/**
	 * Inject logger.
	 * 
	 * @param field
	 *            Field to inject.
	 * @param object
	 *            Input object.
	 */
	private void injectLogger(final Field field, final Object object) throws IllegalAccessException {
		// - Get logger from factory.
		final Logger logger = LoggerFactory.getLogger(object.getClass());

		// - Set field value.
		if (!field.isAccessible()) {
			field.setAccessible(true);
		}
		field.set(object, logger);
	}
}
