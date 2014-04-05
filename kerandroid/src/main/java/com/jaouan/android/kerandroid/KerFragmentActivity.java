package com.jaouan.android.kerandroid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.jaouan.android.kerandroid.annotation.KerAnnotation;
import com.jaouan.android.kerandroid.annotation.field.instancestate.InstanceState;
import com.jaouan.android.kerandroid.annotation.field.logger.ClassLogger;
import com.jaouan.android.kerandroid.annotation.field.viewbyid.FindViewById;
import com.jaouan.android.kerandroid.exception.KerException;

/**
 * 
 * KerActivity is an {@link FragmentActivity} that handles members injection (views, instance state, etc.).
 * 
 * @author Maxence Jaouan
 * 
 */
public class KerFragmentActivity extends FragmentActivity {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			// - Set layout from @Layout.
			this.setContentView(KerAnnotation.getLayoutResId(this));

			// - Inject...
			KerAnnotation.inject(this, savedInstanceState, //
					ClassLogger.class, // ... logger, ...
					InstanceState.class, // ... instance state, ...
					FindViewById.class); // ... views.
		} catch (final KerException kerException) {
			this.onKerException(kerException);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onSaveInstanceState(final Bundle outState) {
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
