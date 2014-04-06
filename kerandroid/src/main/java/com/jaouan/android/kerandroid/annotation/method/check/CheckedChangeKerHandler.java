package com.jaouan.android.kerandroid.annotation.method.check;

import java.lang.reflect.Method;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.jaouan.android.kerandroid.annotation.AbstractKerHandler;

/**
 * 
 * KerHandler for {@link CheckedChange} annotation.
 * 
 * @author Maxence Jaouan
 * 
 */
public class CheckedChangeKerHandler extends AbstractKerHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handle(final Method method, final Activity activity) throws Exception {
		// - Retrieve annotation value.
		int[] viewsResId = getAnnotationValue(method);

		// - Bind event listener.
		for (final int viewResId : viewsResId) {
			final CompoundButton view = (CompoundButton) activity.findViewById(viewResId);
			view.setOnCheckedChangeListener(createCheckedListener(method, activity));
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
			final CompoundButton view = (CompoundButton) fragment.getView().findViewById(viewResId);
			view.setOnCheckedChangeListener(createCheckedListener(method, fragment));
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
			final CompoundButton view = (CompoundButton) fragment.getView().findViewById(viewResId);
			view.setOnCheckedChangeListener(createCheckedListener(method, fragment));
		}
	}

	/**
	 * Create Checked State listener.
	 * 
	 * @param method
	 *            Method to invoke.
	 * @param object
	 *            Object.
	 * @return Checked change listener.
	 */
	private OnCheckedChangeListener createCheckedListener(final Method method, final Object object) {
		return new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				try {
					// - Set method accessible if necessary.
					if (!method.isAccessible()) {
						method.setAccessible(true);
					}

					// - Invoke method.
					method.invoke(object, buttonView, isChecked);
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
			final CheckedChange checkedChanged = method.getAnnotation(CheckedChange.class);
			viewsResId = checkedChanged.value();
			this.putToCache(method, viewsResId);
		}
		return viewsResId;
	}

}
