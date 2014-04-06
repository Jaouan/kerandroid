package com.jaouan.android.kerandroid.example;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * onCreate() (first) : 60-70ms onCreate() (after rotation) : 15-25ms onSaveInstanceState() : 0-1ms
 */
public class BigNativeActivity extends FragmentActivity {

	protected String str1 = "abc";
	protected String str2 = "abcabc";
	protected String str3 = "abcabcabc";
	protected String str4 = "abcabcabcabc";
	protected String str5 = "abcabcabcabcabc";
	protected String str6 = "abcabcabcabcabcabc";
	protected String str7 = "abcabcabcabcabcabcabc";
	protected String str8 = "abcabcabcabcabcabcabcabc";
	protected String str9 = "abcabcabcabcabcabcabcabcabc";
	protected String str10 = "abcabcabcabcabcabcabcabcabcabc";
	protected String str11 = "abcabcabcabcabcabcabcabcabcabcabc";
	protected String str12 = "abcabcabcabcabcabcabcabcabcabcabcabc";
	protected String str13 = "abcabcabcabcabcabcabcabcabcabcabcabcabc";
	protected String str14 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	protected String str15 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	protected String str16 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	protected String str17 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	protected String str18 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	protected String str19 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
	protected String str20 = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";

	protected TextView textView1;
	protected TextView textView2;
	protected TextView textView3;
	protected TextView textView4;
	protected TextView textView5;
	protected TextView textView6;
	protected TextView textView7;
	protected TextView textView8;
	protected TextView textView9;
	protected TextView textView10;
	protected TextView textView11;
	protected TextView textView12;
	protected TextView textView13;
	protected TextView textView14;
	protected TextView textView15;
	protected TextView textView16;
	protected TextView textView17;
	protected TextView textView18;
	protected TextView textView19;
	protected TextView textView20;

	@SuppressLint("CutPasteId")
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		final long startTime = System.currentTimeMillis();

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_simple);

		findViews();

		restoreInstanceState(savedInstanceState);

		Log.d("timer", "onCreate() : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	public void restoreInstanceState(final Bundle savedInstanceState) {
		if (null != savedInstanceState) {
			str1 = savedInstanceState.getString("str1");
			str2 = savedInstanceState.getString("str2");
			str3 = savedInstanceState.getString("str3");
			str4 = savedInstanceState.getString("str4");
			str5 = savedInstanceState.getString("str5");
			str6 = savedInstanceState.getString("str6");
			str7 = savedInstanceState.getString("str7");
			str8 = savedInstanceState.getString("str8");
			str9 = savedInstanceState.getString("str9");
			str10 = savedInstanceState.getString("str10");
			str11 = savedInstanceState.getString("str11");
			str12 = savedInstanceState.getString("str12");
			str13 = savedInstanceState.getString("str13");
			str14 = savedInstanceState.getString("str14");
			str15 = savedInstanceState.getString("str15");
			str16 = savedInstanceState.getString("str16");
			str17 = savedInstanceState.getString("str17");
			str18 = savedInstanceState.getString("str18");
			str19 = savedInstanceState.getString("str19");
			str20 = savedInstanceState.getString("str20");
		}
	}

	public void findViews() {
		textView1 = (TextView) findViewById(R.id.helloWorldTextView);
		textView2 = (TextView) findViewById(R.id.helloWorldTextView);
		textView3 = (TextView) findViewById(R.id.helloWorldTextView);
		textView4 = (TextView) findViewById(R.id.helloWorldTextView);
		textView5 = (TextView) findViewById(R.id.helloWorldTextView);
		textView6 = (TextView) findViewById(R.id.helloWorldTextView);
		textView7 = (TextView) findViewById(R.id.helloWorldTextView);
		textView8 = (TextView) findViewById(R.id.helloWorldTextView);
		textView9 = (TextView) findViewById(R.id.helloWorldTextView);
		textView10 = (TextView) findViewById(R.id.helloWorldTextView);
		textView11 = (TextView) findViewById(R.id.helloWorldTextView);
		textView12 = (TextView) findViewById(R.id.helloWorldTextView);
		textView13 = (TextView) findViewById(R.id.helloWorldTextView);
		textView14 = (TextView) findViewById(R.id.helloWorldTextView);
		textView15 = (TextView) findViewById(R.id.helloWorldTextView);
		textView16 = (TextView) findViewById(R.id.helloWorldTextView);
		textView17 = (TextView) findViewById(R.id.helloWorldTextView);
		textView18 = (TextView) findViewById(R.id.helloWorldTextView);
		textView19 = (TextView) findViewById(R.id.helloWorldTextView);
		textView20 = (TextView) findViewById(R.id.helloWorldTextView);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		final long startTime = System.currentTimeMillis();

		super.onSaveInstanceState(outState);

		outState.putString("str1", str1);
		outState.putString("str2", str2);
		outState.putString("str3", str3);
		outState.putString("str4", str4);
		outState.putString("str5", str5);
		outState.putString("str6", str6);
		outState.putString("str7", str7);
		outState.putString("str8", str8);
		outState.putString("str9", str9);
		outState.putString("str10", str10);
		outState.putString("str11", str11);
		outState.putString("str12", str12);
		outState.putString("str13", str13);
		outState.putString("str14", str14);
		outState.putString("str15", str15);
		outState.putString("str16", str16);
		outState.putString("str17", str17);
		outState.putString("str18", str18);
		outState.putString("str19", str19);
		outState.putString("str20", str20);

		Log.d("timer", "onSaveInstanceState() : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	public void bindViews() {
		for (int i = 0; i < 10; i++) {
			findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				}
			});

			((EditText) findViewById(R.id.editText1)).addTextChangedListener(new TextWatcher() {
				@Override
				public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				}

				@Override
				public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				}

				@Override
				public void afterTextChanged(Editable arg0) {
				}
			});
			
			((RadioButton)findViewById(R.id.radioButton1)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				}
			});
			((RadioButton)findViewById(R.id.radioButton2)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				}
			});
		}
	}

}
