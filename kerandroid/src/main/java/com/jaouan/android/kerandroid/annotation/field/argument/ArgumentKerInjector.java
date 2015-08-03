package com.jaouan.android.kerandroid.annotation.field.argument;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

import com.jaouan.android.kerandroid.annotation.AbstractKerInjector;

import java.lang.reflect.Field;

/**
 *
 * KerInjector for {@link Argument} annotation.
 * 
 * @author Maxence Jaouan
 * 
 */
public class ArgumentKerInjector extends AbstractKerInjector {

	/**
	 * {@inheritDoc}
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void inject(final Field field, final Fragment fragment, final Bundle savedInstanceState) throws Exception {
		// - Inject argument.
		this.injectArgument(field, fragment, fragment.getArguments());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inject(final Field field, final android.support.v4.app.Fragment fragment, final Bundle savedInstanceState) throws Exception {
		// - Inject argument.
		this.injectArgument(field, fragment, fragment.getArguments());
	}

	/**
	 * Inject argument.
	 * 
	 * @param field
	 *            Field to inject.
	 * @param object
	 *            Input object.
	 * @param arguments
	 *            Arguments.
	 */
	private void injectArgument(final Field field, final Object object, final Bundle arguments) throws Exception {
		// - Retrieve field's name.
		final String fieldName = getFieldId(field);

		// - Set fieldName key's value to field.
		if (!field.isAccessible()) {
			field.setAccessible(true);
		}
		field.set(object, arguments.get(fieldName));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInjectable(final Activity activity, final Bundle savedInstanceState) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInjectable(final android.support.v4.app.Fragment fragment, final Bundle savedInstanceState) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInjectable(final Fragment fragment, final Bundle savedInstanceState) {
		return true;
	}

	/**
	 * Get unique field id.
	 *
	 * @param field
	 *            Field.
	 * @return Unique field id.
	 */
	private String getFieldId(final Field field) {
		String fieldId = getAnnotationValue(field);
		if(fieldId != null){
			fieldId = field.getName();
		}
		return fieldId;
	}

	/**
	 * Get annotation value.
	 *
	 * @param field
	 *            Field.
	 * @return Annotation value.
	 */
	private String getAnnotationValue(final Field field) {
		String value = (String) this.getFromCache(field);
		if (null == value) {
			// - Find view by id.
			final Argument findViewById = field.getAnnotation(Argument.class);
			value = findViewById.value();
			this.putToCache(field, value);

			// - Enable field access.
			field.setAccessible(true);
		}
		return value;
	}

}
