package com.jaouan.android.kerandroid.example;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jaouan.android.kerandroid.KerFragmentActivity;
import com.jaouan.android.kerandroid.annotation.field.instancestate.InstanceState;
import com.jaouan.android.kerandroid.annotation.field.viewbyid.FindViewById;
import com.jaouan.android.kerandroid.annotation.method.check.CheckedChange;
import com.jaouan.android.kerandroid.annotation.method.click.Click;
import com.jaouan.android.kerandroid.annotation.method.text.TextChange;
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

	@Click(R.id.button1)
	protected void buttonClick(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

	@CheckedChange({ R.id.radioButton1, R.id.radioButton2 })
	protected void checkedChange(final View view, final boolean value) {
		Toast.makeText(this, "Radio changed.", Toast.LENGTH_LONG).show();
	}

	@TextChange(R.id.editText1)
	protected void buttonClicked(final String text) {
		Toast.makeText(this, "Text changed : " + text, Toast.LENGTH_LONG).show();
	}
	
}


