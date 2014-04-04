# KerAndroid
KerAndroid is a tiny Android library that helps you to speed up and to simplify development by injecting Activities and Fragments fields.

# Add KerAndroid to your project
Gradle template.
```
repositories {
	maven { url "https://github.com/Jaouan/mvn-repo/raw/master" }
}
dependencies {
	compile group: 'com.jaouan', name: 'kerandroid', version: '0.0.0'
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

    @Override
    public void onStart() {
        super.onStart();

        LOGGER.info("Hi!");

        this.textView.setText(this + "\n" + this.exampleModel);
    }

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
Here a performance comparison (executed on Samsung GT-N8010) :
 - Injecting an activity/fragment that contains 20 views and 20 instance states to inject takes ~0.5ms (no significant differences with "classic" solution).
 - Injecting 10 times the same activity (400 injections) takes ~5ms, while it takes ~3ms with "classic" solution.
 - Injecting 10 000 times the same activity (400 000 injections) takes ~4.3s at first execution then ~3.5s, while it takes only ~1s with "classic" solution.

Then, using KerAndroid on Android application should not spoil user experience even on little device.


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

}
```
 
Then, create your custom annotation.
```
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
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
