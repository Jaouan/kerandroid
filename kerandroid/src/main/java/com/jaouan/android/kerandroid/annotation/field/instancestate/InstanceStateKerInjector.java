package com.jaouan.android.kerandroid.annotation.field.instancestate;

import java.io.Serializable;
import java.lang.reflect.Field;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.jaouan.android.kerandroid.annotation.AbstractKerInjector;
import com.jaouan.android.kerandroid.exception.KerException;

/**
 * 
 * KerInjector for {@link InstanceState} annotation.
 * 
 * @author Maxence Jaouan
 * 
 */
public class InstanceStateKerInjector extends AbstractKerInjector {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inject(final Field field, final Activity activity, final Bundle savedInstanceState) throws Exception {
		// - Inject instance state.
		this.injectInstanceState(field, activity, savedInstanceState);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inject(final Field field, final Fragment fragment, final Bundle savedInstanceState) throws Exception {
		// - Inject instance state.
		this.injectInstanceState(field, fragment, savedInstanceState);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inject(final Field field, final android.support.v4.app.Fragment fragment, final Bundle savedInstanceState) throws Exception {
		// - Inject instance state.
		this.injectInstanceState(field, fragment, savedInstanceState);
	}

	/**
	 * Inject instance state.
	 * 
	 * @param field
	 *            Field to inject.
	 * @param object
	 *            Input object.
	 * @param savedInstanceState
	 *            Saved instance state.
	 */
	private void injectInstanceState(final Field field, final Object object, final Bundle savedInstanceState) throws Exception {
		// - Retrieve field's name.
		final String fieldName = InstanceStateKerInjector.getFieldId(object, field);

		// - Set fieldName key's value to field.
		if (!field.isAccessible()) {
			field.setAccessible(true);
		}
		field.set(object, savedInstanceState.get(fieldName));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInjectable(final Activity activity, final Bundle savedInstanceState) {
		return null != savedInstanceState;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInjectable(final android.support.v4.app.Fragment fragment, final Bundle savedInstanceState) {
		return null != savedInstanceState;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInjectable(final Fragment fragment, final Bundle savedInstanceState) {
		return null != savedInstanceState;
	}

	/**
	 * Save instance state.
	 * 
	 * @param object
	 *            Field container.
	 * @param field
	 *            Field to remember.
	 * @param object
	 *            Object.
	 * @param outState
	 *            Out bundle.
	 */
	public static void saveInstanceState(final Field field, final Object object, final Bundle outState) throws KerException {
		// - Retrieve field's name.
		final String fieldName = InstanceStateKerInjector.getFieldId(object, field);

		try {
			// - Save field's value as serializable in bundle.
			field.setAccessible(true);
			outState.putSerializable(fieldName, (Serializable) field.get(object));
		} catch (final Exception exception) {
			throw new KerException("Unable to save instance state for field : " + fieldName, exception);
		}
	}

	/**
	 * Get unique field id.
	 * 
	 * @param field
	 *            Field.
	 * @return Unique field id.
	 */
	private static String getFieldId(final Object object, final Field field) {
		return object.getClass().getCanonicalName() + "." + field.getName();
	}

}
