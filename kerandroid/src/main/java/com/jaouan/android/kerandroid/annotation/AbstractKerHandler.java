package com.jaouan.android.kerandroid.annotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.Fragment;

import com.jaouan.android.kerandroid.exception.KerException;

/**
 * 
 * Abstract KerHandler used to handle methods.
 * 
 * @author Maxence Jaouan
 * 
 */
public class AbstractKerHandler {

	/**
	 * Cache.
	 */
	private final Map<Method, Object> cache = new HashMap<Method, Object>();

	/**
	 * Handle method in activity.
	 * 
	 * @param method
	 *            Method to handle.
	 * @param activity
	 *            Activity.
	 */
	public void handle(final Method method, final Activity activity) throws Exception {
		throw new KerException("Handler not implemented for activity.");
	}

	/**
	 * Handle method in fragment.
	 * 
	 * @param method
	 *            Method to handle.
	 * @param fragment
	 *            Fragment.
	 */
	public void handle(final Method method, final Fragment fragment) throws Exception {
		throw new KerException("Handler not implemented for fragment.");
	}

	/**
	 * Handle method in support fragment.
	 * 
	 * @param method
	 *            Method to handle.
	 * @param fragment
	 *            Support fragment.
	 */
	public void handle(final Method method, final android.support.v4.app.Fragment fragment) throws Exception {
		throw new KerException("Handler not implemented for support fragment.");
	}

	/**
	 * Check if inputs parameters allow handleion.
	 * 
	 * @param activity
	 *            Input activity.
	 * @return TRUE if handleable.
	 */
	public boolean isHandleable(final Activity activity) {
		return true;
	}

	/**
	 * Check if inputs parameters allow handleion.
	 * 
	 * @param framgent
	 *            Input fragment.
	 * @return TRUE if handleable.
	 */
	public boolean isHandleable(final Fragment fragment) {
		return true;
	}

	/**
	 * Check if inputs parameters allow handleion.
	 * 
	 * @param fragment
	 *            Input support fragment.
	 * @return TRUE if handleable.
	 */
	public boolean isHandleable(final android.support.v4.app.Fragment fragment) {
		return true;
	}

	/**
	 * Get object from cache.
	 * 
	 * @param method
	 *            Method.
	 * @return Cached object (null if not cached).
	 */
	protected Object getFromCache(final Method method) {
		return this.cache.get(method);
	}

	/**
	 * Put object in cache.
	 * 
	 * @param method
	 *            Method.
	 * @param object
	 *            Object to cache.
	 */
	protected void putToCache(final Method method, final Object object) {
		this.cache.put(method, object);
	}

}
