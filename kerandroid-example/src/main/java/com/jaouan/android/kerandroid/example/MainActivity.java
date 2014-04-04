package com.jaouan.android.kerandroid.example;

import android.os.Bundle;
import android.widget.TextView;

import com.jaouan.android.kerandroid.KerFragmentActivity;
import com.jaouan.android.kerandroid.annotation.field.instancestate.InstanceState;
import com.jaouan.android.kerandroid.annotation.field.viewbyid.FindViewById;
import com.jaouan.android.kerandroid.annotation.type.Layout;

@Layout(R.layout.activity_main)
public class MainActivity extends KerFragmentActivity {

	@InstanceState
	protected int count = 0;

	@InstanceState
	protected String countStr = "";

	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.count++;
		this.countStr = this.countStr + "\n" + "Count : " + this.count;

		this.textView.setText(this.countStr);
	}

}
