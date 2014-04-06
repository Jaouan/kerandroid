package com.jaouan.android.kerandroid.example;

import android.os.Bundle;
import android.util.Log;
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

/**
 * onCreate() (first) : 70-80ms onCreate() (after rotation) : 15-30ms onSaveInstanceState() : 0-1ms
 */
@Layout(R.layout.activity_simple)
public class BigKerActivity extends KerFragmentActivity {

	@InstanceState
	protected String str1 = "abc";
	@InstanceState
	protected String str2 = "abcabc";
	@InstanceState
	protected String str3 = "abcabcabc";
	@InstanceState
	protected String str4 = "abcabcabcabc";
	@InstanceState
	protected String str5 = "abcabcabcabcabc";
	@InstanceState
	protected String str6 = "abcabcabcabcabcabc";
	@InstanceState
	protected String str7 = "abcabcabcabcabcabcabc";
	@InstanceState
	protected String str8 = "abcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str9 = "abcabcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str10 = "abcabcabcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str11 = "abcabcabcabcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str12 = "abcabcabcabcabcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str13 = "abcabcabcabcabcabcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str14 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str15 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str16 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str17 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str18 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str19 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	@InstanceState
	protected String str20 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";

	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView1;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView2;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView3;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView4;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView5;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView6;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView7;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView8;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView9;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView10;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView11;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView12;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView13;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView14;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView15;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView16;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView17;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView18;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView19;
	@FindViewById(value = R.id.helloWorldTextView)
	protected TextView textView20;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		final long startTime = System.currentTimeMillis();

		super.onCreate(savedInstanceState);

		Log.d("timer", "onCreate() : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		final long startTime = System.currentTimeMillis();

		super.onSaveInstanceState(outState);

		Log.d("timer", "onSaveInstanceState() : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	@Click(R.id.button1)
	protected void buttonClick1(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

	@CheckedChange({ R.id.radioButton1, R.id.radioButton2 })
	protected void checkedChange1(final View view, final boolean value) {
		Toast.makeText(this, "Radio changed.", Toast.LENGTH_LONG).show();
	}

	@TextChange(R.id.editText1)
	protected void buttonClicked1(final String text) {
		Toast.makeText(this, "Text changed : " + text, Toast.LENGTH_LONG).show();
	}

	@Click(R.id.button1)
	protected void buttonClick2(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

	@CheckedChange({ R.id.radioButton1, R.id.radioButton2 })
	protected void checkedChange2(final View view, final boolean value) {
		Toast.makeText(this, "Radio changed.", Toast.LENGTH_LONG).show();
	}

	@TextChange(R.id.editText1)
	protected void buttonClicked2(final String text) {
		Toast.makeText(this, "Text changed : " + text, Toast.LENGTH_LONG).show();
	}

	@Click(R.id.button1)
	protected void buttonClick3(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

	@CheckedChange({ R.id.radioButton1, R.id.radioButton2 })
	protected void checkedChange3(final View view, final boolean value) {
		Toast.makeText(this, "Radio changed.", Toast.LENGTH_LONG).show();
	}

	@TextChange(R.id.editText1)
	protected void buttonClicked4(final String text) {
		Toast.makeText(this, "Text changed : " + text, Toast.LENGTH_LONG).show();
	}

	@Click(R.id.button1)
	protected void buttonClick4(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

	@CheckedChange({ R.id.radioButton1, R.id.radioButton2 })
	protected void checkedChange5(final View view, final boolean value) {
		Toast.makeText(this, "Radio changed.", Toast.LENGTH_LONG).show();
	}

	@TextChange(R.id.editText1)
	protected void buttonClicked5(final String text) {
		Toast.makeText(this, "Text changed : " + text, Toast.LENGTH_LONG).show();
	}

	@Click(R.id.button1)
	protected void buttonClick5(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

	@CheckedChange({ R.id.radioButton1, R.id.radioButton2 })
	protected void checkedChange6(final View view, final boolean value) {
		Toast.makeText(this, "Radio changed.", Toast.LENGTH_LONG).show();
	}

	@TextChange(R.id.editText1)
	protected void buttonClicked6(final String text) {
		Toast.makeText(this, "Text changed : " + text, Toast.LENGTH_LONG).show();
	}

	@Click(R.id.button1)
	protected void buttonClick6(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

	@CheckedChange({ R.id.radioButton1, R.id.radioButton2 })
	protected void checkedChange7(final View view, final boolean value) {
		Toast.makeText(this, "Radio changed.", Toast.LENGTH_LONG).show();
	}

	@TextChange(R.id.editText1)
	protected void buttonClicked7(final String text) {
		Toast.makeText(this, "Text changed : " + text, Toast.LENGTH_LONG).show();
	}

	@Click(R.id.button1)
	protected void buttonClick7(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

	@CheckedChange({ R.id.radioButton1, R.id.radioButton2 })
	protected void checkedChange8(final View view, final boolean value) {
		Toast.makeText(this, "Radio changed.", Toast.LENGTH_LONG).show();
	}

	@TextChange(R.id.editText1)
	protected void buttonClicked8(final String text) {
		Toast.makeText(this, "Text changed : " + text, Toast.LENGTH_LONG).show();
	}

	@Click(R.id.button1)
	protected void buttonClick8(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

	@CheckedChange({ R.id.radioButton1, R.id.radioButton2 })
	protected void checkedChange9(final View view, final boolean value) {
		Toast.makeText(this, "Radio changed.", Toast.LENGTH_LONG).show();
	}

	@TextChange(R.id.editText1)
	protected void buttonClicked9(final String text) {
		Toast.makeText(this, "Text changed : " + text, Toast.LENGTH_LONG).show();
	}

	@Click(R.id.button1)
	protected void buttonClick9(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

	@CheckedChange({ R.id.radioButton1, R.id.radioButton2 })
	protected void checkedChange10(final View view, final boolean value) {
		Toast.makeText(this, "Radio changed.", Toast.LENGTH_LONG).show();
	}

	@TextChange(R.id.editText1)
	protected void buttonClicked10(final String text) {
		Toast.makeText(this, "Text changed : " + text, Toast.LENGTH_LONG).show();
	}

	@Click(R.id.button1)
	protected void buttonClick10(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

}
