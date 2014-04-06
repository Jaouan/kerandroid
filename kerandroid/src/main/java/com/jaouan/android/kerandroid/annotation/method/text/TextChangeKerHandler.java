package com.jaouan.android.kerandroid.annotation.method.text;

import java.lang.reflect.Method;

import android.app.Activity;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.jaouan.android.kerandroid.annotation.AbstractKerHandler;

/**
 * 
 * KerHandler for {@link TextChange} annotation.
 * 
 * @author Maxence Jaouan
 * 
 */
public class TextChangeKerHandler extends AbstractKerHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void handle(final Method method, final Activity activity) throws Exception {
		// - Retrieve annotation value.
		int[] viewsResId = getAnnotationValue(method);

		// - Bind event listener.
		for (final int viewResId : viewsResId) {
			final EditText view = (EditText) activity.findViewById(viewResId);
			view.addTextChangedListener(createTextWatcher(method, activity));
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
			final EditText view = (EditText) fragment.getView().findViewById(viewResId);
			view.addTextChangedListener(createTextWatcher(method, fragment));
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
			final EditText view = (EditText) fragment.getView().findViewById(viewResId);
			view.addTextChangedListener(createTextWatcher(method, fragment));
		}
	}

	/**
	 * Create text watcher.
	 * 
	 * @param method
	 *            Method to invoke.
	 * @param object
	 *            Object.
	 * @return Text watcher.
	 */
	private TextWatcher createTextWatcher(final Method method, final Object object) {
		return new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
				try {
					// - Set method accessible if necessary.
					if (!method.isAccessible()) {
						method.setAccessible(true);
					}

					// - Invoke method.
					method.invoke(object, String.valueOf(charSequence));
				} catch (final Throwable cause) {
					Log.e("KerAndroid", "Unable to invoke method.", cause);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
				// Not handled.
			}

			@Override
			public void afterTextChanged(Editable editable) {
				// Not handled.
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
			final TextChange checkedChanged = method.getAnnotation(TextChange.class);
			viewsResId = checkedChanged.value();
			this.putToCache(method, viewsResId);
		}
		return viewsResId;
	}

}
