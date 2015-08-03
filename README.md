# KerAndroid
KerAndroid is a tiny Android library that helps you to speed up and to simplify development by injecting Activities and Fragments fields.

# Add KerAndroid to your project
Gradle template.
```
repositories {
	maven { url "https://jitpack.io" }
}
dependencies {
	compile 'com.github.jaouan:kerandroid:1.0.3'
}
```

# Using examples
## Activity

By extending KerActivity or KerFragmentActivity.
```
@Layout(R.layout.activity_main) // <- Layout you want to use as content view.
public class MainActivity extends KerFragmentActivity {
    @InstanceState // <- Handle saving/restoring value.
    protected int count = 0;

    @InstanceState
    protected String countStr = "";

    @FindViewById(R.id.helloWorldTextView) // <- Inject view instance.
    protected TextView textView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.count++;
        this.countStr = this.countStr + "\n" + "Count : " + this.count;

        this.textView.setText(this.countStr);
    }

	// Please respect parameter (View).
    @Click(R.id.button1)
	protected void buttonClick(final View view) {
		Toast.makeText(this, "Button clicked.", Toast.LENGTH_LONG).show();
	}

	// Please respect parameters (View, boolean).
	@CheckedChange({ R.id.radioButton1, R.id.radioButton2 })
	protected void checkedChange(final View view, final boolean value) {
		Toast.makeText(this, "Radio changed.", Toast.LENGTH_LONG).show();
	}

	// Please respect parameter (String).
	@TextChange(R.id.editText1)
	protected void buttonClicked(final String text) {
		Toast.makeText(this, "Text changed : " + text, Toast.LENGTH_LONG).show();
	}

    // Called when an exception is raised during injection.
    @Override
    protected void onKerException(final KerException kerException) {
        Log.e("KerAnnotation", kerException.getMessage());
    }
    
}
```

## Fragment
By extending KerFragment (support).
```
@Layout(R.layout.fragment_example) // <- Layout you want to use as content view.
public class ExampleFragment extends KerFragment {

    @ClassLogger // <- Inject Logger from SLF4J Logger Factory
    protected Logger LOGGER;

    @InstanceState // <- Auto save/restore value.
    protected ExampleModel exampleModel = new ExampleModel();

    @FindViewById(R.id.textView1) // <- Inject view instance.
    protected TextView textView;

    @Argument
    protected String myArgument;

    @Argument("argument-name");
    protected String mySecondArgument;

    @Override
    public void onStart() {
        super.onStart();

        LOGGER.info("Hi!");

        this.textView.setText(this + "\n" + this.exampleModel);
    }
    
    // @Click, @TextChange, @CheckChange also compatible.

}
```

## Other
By calling KerAnnotation's methods.
```
public class CustomActivity extends Activity {

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
                    
            // - Handle...
			KerAnnotation.handle(this, //
					Click.class, // ... view click event, ...
					CheckedChange.class, // ... checked change event, ...
					TextChange.class); // ... text changed event.

        } catch (final KerException kerException) {
            // ...
        }
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);

        try {
            // - Save instance state fields into bundle.
            KerAnnotation.onSaveInstanceState(this, outState);
        } catch (final KerException kerException) {
            // ...
        }
    }

}
```

# Performance
## Reflection is cool, but expensive
KerAndroid uses reflection in order to inject values in object's fields. This solution is expensive but there's no other way to inject fields dynamically.
## Cache datas to make injection less costly
KerAndroid caches annotations' values in order to avoid the repetition of slow works.
## KerAndroid vs "classic" solution
Here a performance comparison (tested on Samsung GT-N8010) :
 - Injecting an activity/fragment that contains 20 views and 20 instance states to inject takes ~0.5ms (no significant differences with "classic" solution).
 - Injecting 10 times the same activity (400 injections) takes ~5ms, while it takes ~3ms with "classic" solution.
 - Injecting 10 000 times the same activity (400 000 injections) takes ~4.3s at first execution then ~3.5s, while it takes only ~1s with "classic" solution.
 - Handling 10 000 times 40 listeners takes ~7s against ~3s with "classic" solution.

Then, using KerAndroid on Android application should no spoil user experience even on little device.


# Add custom injector
At first, create your injector.
```
public class CustomKerInjector extends AbstractKerInjector {

    @Override
    public void inject(Field field, Activity activity, Bundle savedInstanceState) throws Exception {
        // Handle activity's field injection.
    }

    @Override
    public void inject(Field field, Fragment fragment, Bundle savedInstanceState) throws Exception {
        // Handle fragment's field injection.
    }
    
    @Override
    public void isInjectable(Field field, Activity activity, Bundle savedInstanceState) throws Exception {
        // Is activity injectable.
    }

}
```
 
Then, create your custom annotation.
```
@Retention(RetentionPolicy.RUNTIME)
@Target( ElementType.FIELD )
@KerInjector(CustomKerInjector.class) // <- Your custom KerInjector's class.
public @interface CustomAnnotation {
    // ... What you want here ...
}
```

Finally, ask KerAndroid to inject fields annotated with your custom annotation.
```
@Override
protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    try {
        // - Inject fields.
        KerAnnotation.inject(this, savedInstanceState, //
                // ... Others annotations here ...
                CustomAnnotation.class); // Your custom annotation.
    } catch (final KerException kerException) {
        // ...
    }
}
```

# Add custom method handler
At first, create your handler.
```
public class CustomKerHandler extends AbstractKerHandler {

    @Override
    public void handle(Method method, Activity activity) throws Exception {
        // Handle activity's method.
    }

    @Override
    public void handle(Method method, Fragment fragment) throws Exception {
        // Handle fragment's method.
    }
    
    @Override
    public void isHandleable(Method method, Activity activity) throws Exception {
        // Is activity handleable.
    }

}
```
 
Then, create your custom annotation.
```
@Retention(RetentionPolicy.RUNTIME)
@Target( ElementType.METHOD )
@KerHandler(CustomKerHandler.class) // <- Your custom KerHandler's class.
public @interface CustomAnnotation {
    // ... What you want here ...
}
```

Finally, ask KerAndroid to inject fields annotated with your custom annotation.
```
@Override
protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    try {
        // - Inject fields.
        KerAnnotation.handle(this, //
                // ... Others annotations here ...
                CustomAnnotation.class); // Your custom annotation.
    } catch (final KerException kerException) {
        // ...
    }
}
```
