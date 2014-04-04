package com.jaouan.android.kerandroid.annotation.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.jaouan.android.kerandroid.example.BigNativeActivity;
import com.jaouan.android.kerandroid.example.MainActivity;
import com.jaouan.android.kerandroid.exception.KerException;

/**
 * 10 000 iterations (20 views, 20 instance states) testMassiveNoInject() : ~950ms
 */
public class NoKerAnnotationTest extends android.test.ActivityUnitTestCase<BigNativeActivity> {

	private BigNativeActivity activity;

	public NoKerAnnotationTest() {
		super(BigNativeActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
		startActivity(intent, null, null);
		activity = getActivity();
	}

	public void testMassiveNoInject() throws KerException {
		final Bundle bundle = new Bundle();
		activity.onSaveInstanceState(bundle);

		final long startTime = System.currentTimeMillis();

		for (int i = 0; i < 10000; i++) {
			activity.findViews();
			activity.restoreInstanceState(bundle);
		}

		Log.e("timer", "testMassiveNoInject() : " + (System.currentTimeMillis() - startTime) + "ms");
	}
}