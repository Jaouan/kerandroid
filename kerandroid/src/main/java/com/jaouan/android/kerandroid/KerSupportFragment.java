package com.jaouan.android.kerandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaouan.android.kerandroid.annotation.KerAnnotation;
import com.jaouan.android.kerandroid.annotation.field.instancestate.InstanceState;
import com.jaouan.android.kerandroid.annotation.field.logger.ClassLogger;
import com.jaouan.android.kerandroid.annotation.field.viewbyid.FindViewById;
import com.jaouan.android.kerandroid.exception.KerException;

/**
 * 
 * KerActivity is an {@link Fragment} that handles members injection (views, instance state, etc.).
 * 
 * @author Maxence Jaouan
 * 
 */
public class KerSupportFragment extends Fragment {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			// - Inject...
			KerAnnotation.inject(this, savedInstanceState, //
					ClassLogger.class, // ... logger, ...
					InstanceState.class); // ... instance state.
		} catch (final KerException kerException) {
			this.onKerException(kerException);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
		// - Get @Layout's value.
		int layoutResId = 0;
		try {
			layoutResId = KerAnnotation.getLayoutResId(this);
		} catch (final KerException kerException) {
			this.onKerException(kerException);
		}

		// - Inflate view using layout annotation value.
		final View view = inflater.inflate(layoutResId, container, false);

		// - Return fragment's view.
		return view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onStart() {
		super.onStart();

		try {
			// - Inject views.
			KerAnnotation.inject(this, null, FindViewById.class);
		} catch (final KerException kerException) {
			this.onKerException(kerException);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onSaveInstanceState(final Bundle outState) {
		super.onSaveInstanceState(outState);

		try {
			// - Save instance state fields into bundle.
			KerAnnotation.onSaveInstanceState(this, outState);
		} catch (final KerException kerException) {
			this.onKerException(kerException);
		}
	}

	/**
	 * Callback for KerException.
	 * 
	 * @param kerException
	 *            Raised KerException.
	 */
	protected void onKerException(final KerException kerException) {
		Log.e("KerAnnotation", kerException.getMessage());
	}

}
