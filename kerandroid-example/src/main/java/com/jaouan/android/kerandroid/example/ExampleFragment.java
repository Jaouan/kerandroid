package com.jaouan.android.kerandroid.example;

import org.slf4j.Logger;

import android.widget.TextView;

import com.jaouan.android.kerandroid.KerFragment;
import com.jaouan.android.kerandroid.annotation.field.instancestate.InstanceState;
import com.jaouan.android.kerandroid.annotation.field.logger.ClassLogger;
import com.jaouan.android.kerandroid.annotation.field.viewbyid.FindViewById;
import com.jaouan.android.kerandroid.annotation.type.Layout;
import com.jaouan.android.kerandroid.example.model.ExampleModel;

@Layout(R.layout.fragment_example)
public class ExampleFragment extends KerFragment {

	@ClassLogger
	protected Logger LOGGER;
	
	@InstanceState
	protected ExampleModel exampleModel = new ExampleModel();

	@FindViewById(value = R.id.textView1)
	protected TextView textView;

	@Override
	public void onStart() {
		super.onStart();

		LOGGER.info("Hi!");
		
		this.textView.setText(this + "\n" + this.exampleModel);
	}

}
