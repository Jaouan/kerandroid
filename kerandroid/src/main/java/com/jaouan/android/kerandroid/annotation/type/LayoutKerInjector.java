package com.jaouan.android.kerandroid.annotation.type;

import java.lang.reflect.Field;

import android.app.Activity;
import android.os.Bundle;

import com.jaouan.android.kerandroid.annotation.AbstractKerInjector;

/**
 * 
 * KerInjector for {@link Layout} annotation.
 * 
 * @author Maxence Jaouan
 * 
 */
public class LayoutKerInjector extends AbstractKerInjector {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inject(Field field, Activity activity, Bundle savedInstanceState) throws Exception {
		// - Read annotation's value from cache if exists.
		Integer value = (Integer) getFromCache(field);
		if (null == value) {
			// - Retrieve layout annotation.
			final Layout layout = activity.getClass().getAnnotation(Layout.class);
			value = layout.value();
		}
		
		// - Set activity's content view.
		activity.setContentView(value);
	}

}
