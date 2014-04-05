package com.jaouan.android.kerandroid.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.jaouan.android.kerandroid.exception.KerException;

/**
 * 
 * Abstract KerInjector used for inject fields.
 * 
 * @author Maxence Jaouan
 * 
 */
public class AbstractKerInjector {

	/**
	 * Cache.
	 */
	private final Map<Field, Object> cache = new HashMap<Field, Object>();

	/**
	 * Inject field in activity.
	 * 
	 * @param field
	 *            Field to inject.
	 * @param activity
	 *            Activity.
	 * @param savedInstanceState
	 *            Saved instance state.
	 */
	public void inject(final Field field, final Activity activity, final Bundle savedInstanceState) throws Exception {
		throw new KerException("Injector not implemented for activity.");
	}

	/**
	 * Inject field in fragment.
	 * 
	 * @param field
	 *            Field to inject.
	 * @param fragment
	 *            Fragment.
	 * @param savedInstanceState
	 *            Saved instance state.
	 */
	public void inject(final Field field, final Fragment fragment, final Bundle savedInstanceState) throws Exception {
		throw new KerException("Injector not implemented for fragment.");
	}

	/**
	 * Inject field in support fragment.
	 * 
	 * @param field
	 *            Field to inject.
	 * @param fragment
	 *            Support fragment.
	 * @param savedInstanceState
	 *            Saved instance state.
	 */
	public void inject(final Field field, final android.support.v4.app.Fragment fragment, final Bundle savedInstanceState) throws Exception {
		throw new KerException("Injector not implemented for support fragment.");
	}

	/**
	 * Check if inputs parameters allow injection.
	 * 
	 * @param activity
	 *            Input activity.
	 * @param savedInstanceState
	 *            Input saved instance state.
	 * @return TRUE if injectable.
	 */
	public boolean isInjectable(Activity activity, Bundle savedInstanceState) {
		return true;
	}
	
	/**
	 * Check if inputs parameters allow injection.
	 * 
	 * @param framgent
	 *            Input fragment.
	 * @param savedInstanceState
	 *            Input saved instance state.
	 * @return TRUE if injectable.
	 */
	public boolean isInjectable(Fragment fragment, Bundle savedInstanceState) {
		return true;
	}

	/**
	 * Check if inputs parameters allow injection.
	 * 
	 * @param framgent
	 *            Input support fragment.
	 * @param savedInstanceState
	 *            Input saved instance state.
	 * @return TRUE if injectable.
	 */
	public boolean isInjectable(android.support.v4.app.Fragment fragment, Bundle savedInstanceState) {
		return true;
	}

	/**
	 * Get object from cache.
	 * 
	 * @param field
	 *            Field.
	 * @return Cached object (null if not cached).
	 */
	protected Object getFromCache(Field field) {
		return cache.get(field);
	}

	/**
	 * Put object in cache.
	 * 
	 * @param field
	 *            Field.
	 * @param object
	 *            Object to cache.
	 */
	protected void putToCache(Field field, Object object) {
		cache.put(field, object);
	}

}
