package com.jaouan.android.kerandroid.annotation.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.jaouan.android.kerandroid.annotation.KerAnnotation;
import com.jaouan.android.kerandroid.annotation.field.instancestate.InstanceState;
import com.jaouan.android.kerandroid.annotation.field.viewbyid.FindViewById;
import com.jaouan.android.kerandroid.example.BigKerActivity;
import com.jaouan.android.kerandroid.example.MainActivity;
import com.jaouan.android.kerandroid.exception.KerException;

/**
 * 10 000 iterations (20 views, 20 instance states) testMassiveInject() (first) : ~4350ms testMassiveInject() (cached) : ~3650ms
 * 
 * 10 iterations 5ms
 */
@SuppressWarnings("unchecked")
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

		final long startTime = System.currentTimeMillis();

		for (int i = 0; i < 10; i++) {
			KerAnnotation.inject(activity, bundle, //
					InstanceState.class, //
					FindViewById.class //
					);
		}

		Log.i("timer", "testMassiveInject() : " + (System.currentTimeMillis() - startTime) + "ms");
	}
}