package com.jaouan.android.kerandroid.annotation.method.click;

import java.lang.reflect.Method;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.jaouan.android.kerandroid.annotation.AbstractKerHandler;

/**
 * 
 * KerHandler for {@link Click} annotation.
 * 
 * @author Maxence Jaouan
 * 
 */
public class ClickKerHandler extends AbstractKerHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handle(final Method method, final Activity activity) throws Exception {
		// - Retrieve annotation value.
		int[] viewsResId = getAnnotationValue(method);

		// - Bind event listener.
		for (final int viewResId : viewsResId) {
			final View view = activity.findViewById(viewResId);
			view.setOnClickListener(createClickListener(method, activity));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handle(final Method method, final Fragment fragment) throws Exception {
		// - Retrieve annotation value.
		int[] viewsResId = getAnnotationValue(method);

		// - Bind event listener.
		for (final int viewResId : viewsResId) {
			final View view = fragment.getView().findViewById(viewResId);
			view.setOnClickListener(createClickListener(method, fragment));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handle(final Method method, final android.support.v4.app.Fragment fragment) throws Exception {
		// - Retrieve annotation value.
		int[] viewsResId = getAnnotationValue(method);

		// - Bind event listener.
		for (final int viewResId : viewsResId) {
			final View view = fragment.getView().findViewById(viewResId);
			view.setOnClickListener(createClickListener(method, fragment));
		}
	}

	/**
	 * Create click listener.
	 * 
	 * @param method
	 *            Method to invoke.
	 * @param object
	 *            Object.
	 * @return Click listener.
	 */
	private OnClickListener createClickListener(final Method method, final Object object) {
		return new OnClickListener() {
			@Override
			public void onClick(View view) {
				try {
					// - Set method accessible if necessary.
					if (!method.isAccessible()) {
						method.setAccessible(true);
					}

					// - Invoke method.
					method.invoke(object, view);
				} catch (final Throwable cause) {
					Log.e("KerAndroid", "Unable to invoke method.", cause);
				}
			}
		};
	}

	/**
	 * Get annotation value.
	 * 
	 * @param method
	 *            Method.
	 * @return Annotation value.
	 */
	private int[] getAnnotationValue(final Method method) {
		int[] viewsResId = (int[]) getFromCache(method);
		if (null == viewsResId) {
			// - Find view by id.
			final Click clicked = method.getAnnotation(Click.class);
			viewsResId = clicked.value();
			this.putToCache(method, viewsResId);
		}
		return viewsResId;
	}

}
