package com.jaouan.android.kerandroid.annotation.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.jaouan.android.kerandroid.annotation.KerAnnotation;
import com.jaouan.android.kerandroid.annotation.field.instancestate.InstanceState;
import com.jaouan.android.kerandroid.annotation.field.viewbyid.FindViewById;
import com.jaouan.android.kerandroid.annotation.method.check.CheckedChange;
import com.jaouan.android.kerandroid.annotation.method.click.Click;
import com.jaouan.android.kerandroid.annotation.method.text.TextChange;
import com.jaouan.android.kerandroid.example.BigKerActivity;
import com.jaouan.android.kerandroid.example.MainActivity;
import com.jaouan.android.kerandroid.exception.KerException;

/**
 * 10 000 iterations (20 views, 20 instance states) testMassiveInject() (first) : ~4350ms testMassiveInject() (cached) : ~3650ms
 * 10 000 iterations (40 listeners) testMassiveHandle() (first) : ~7450ms testMassiveInject() (cached) : ~7000ms
 * 
 * 10 iterations 5ms
 */
public class KerAnnotationTest extends android.test.ActivityUnitTestCase<BigKerActivity> {

	private BigKerActivity activity;

	public KerAnnotationTest() {
		super(BigKerActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
		startActivity(intent, null, null);
		activity = getActivity();
	}

	public void testMassiveInject() throws KerException {
		final Bundle bundle = new Bundle();
		activity.onSaveInstanceState(bundle);

		for (int u = 0; u < 10; u++) {
			final long startTime = System.currentTimeMillis();

			for (int i = 0; i < 100; i++) {
				KerAnnotation.inject(activity, bundle, //
						InstanceState.class, //
						FindViewById.class //
						);
			}

			Log.i("timer", "testMassiveInject() : " + (System.currentTimeMillis() - startTime) + "ms");
		}
	}

	public void testMassiveHandle() throws KerException {
		final Bundle bundle = new Bundle();
		activity.onSaveInstanceState(bundle);

		for (int u = 0; u < 10; u++) {
			final long startTime = System.currentTimeMillis();

			for (int i = 0; i < 100; i++) {
				KerAnnotation.handle(activity, //
						Click.class, //
						CheckedChange.class, //
						TextChange.class //
						);
			}

			Log.i("timer", "testMassiveHandle() : " + (System.currentTimeMillis() - startTime) + "ms");
		}
	}
}