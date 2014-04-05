package com.jaouan.android.kerandroid.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.jaouan.android.kerandroid.annotation.field.instancestate.InstanceState;
import com.jaouan.android.kerandroid.annotation.field.instancestate.InstanceStateKerInjector;
import com.jaouan.android.kerandroid.annotation.type.Layout;
import com.jaouan.android.kerandroid.exception.KerException;

/**
 * 
 * KerAndroid - KerAnnotation. Allows a lot of injection by annotating classes or types (views, instance states, etc.).
 * 
 * @author Maxence Jaouan
 * 
 */
public class KerAnnotation {

	/**
	 * Fields cache (avoid fields retrieving for each injection).
	 */
	private static Map<Class<?>, Field[]> fieldsCache = new HashMap<Class<?>, Field[]>();

	/**
	 * KerInjectors map (avoid KerInjector instantiating for each injection).
	 */
	private static Map<Class<? extends Annotation>, AbstractKerInjector> kerInstances = new HashMap<Class<? extends Annotation>, AbstractKerInjector>();

	/**
	 * Inject fields of an activity.
	 * 
	 * @param activity
	 *            Activity.
	 * @param savedInstanceState
	 *            Saved instance state (may be use by KerInjectors).
	 * @param annotationClasses
	 *            Annotations classes concerned by injection.
	 */
	@SafeVarargs
	public static void inject(final Activity activity, final Bundle savedInstanceState, final Class<? extends Annotation>... annotationClasses) throws KerException {
		// - For each annotations.
		for (final Class<? extends Annotation> kerAnnotationClass : annotationClasses) {

			AbstractKerInjector kerInjectors;

			try {
				// - Retrieve it KerInjector.
				kerInjectors = retrieveKerInjector(kerAnnotationClass);

				// - Try to inject each fields annotated with current annotation in input object using retrieved KerInjector.
				if (kerInjectors.isInjectable(activity, savedInstanceState)) {
					for (final Field field : retrieveAllFields(activity)) {
						if (field.isAnnotationPresent(kerAnnotationClass)) {
							try {
								kerInjectors.inject(field, activity, savedInstanceState);
							} catch (final Throwable cause) {
								throw new KerException("Unable to inject field " + field.getName() + " annotated with " + kerAnnotationClass.getName(), cause);
							}
						}
					}
				}

			} catch (final Throwable cause) {
				throw new KerException("Unable to inject fields annotated with " + kerAnnotationClass.getName(), cause);
			}

		}
	}

	/**
	 * Inject fields of a fragment.
	 * 
	 * @param fragment
	 *            Fragment.
	 * @param savedInstanceState
	 *            Saved instance state (may be use by KerInjectors).
	 * @param annotationClasses
	 *            Annotations classes concerned by injection.
	 */
	@SafeVarargs
	public static void inject(final Fragment fragment, final Bundle savedInstanceState, final Class<? extends Annotation>... kerAnnotationClasses) throws KerException {
		// - For each annotations.
		for (final Class<? extends Annotation> kerAnnotationClass : kerAnnotationClasses) {

			AbstractKerInjector kerAnnotationInjector;

			try {
				// - Retrieve it KerInjector.
				kerAnnotationInjector = retrieveKerInjector(kerAnnotationClass);

				// - Try to inject each fields annotated with current annotation in input object using retrieved KerInjector.
				if (kerAnnotationInjector.isInjectable(fragment, savedInstanceState)) {
					for (final Field field : retrieveAllFields(fragment)) {
						if (field.isAnnotationPresent(kerAnnotationClass)) {
							try {
								kerAnnotationInjector.inject(field, fragment, savedInstanceState);
							} catch (final Throwable cause) {
								throw new KerException("Unable to inject field " + field.getName() + " annotated with " + kerAnnotationClass.getName(), cause);
							}
						}
					}
				}

			} catch (final Throwable cause) {
				throw new KerException("Unable to inject fields annotated with " + kerAnnotationClass.getName(), cause);
			}

		}
	}

	/**
	 * Inject fields of a support fragment.
	 * 
	 * @param fragment
	 *            Support Fragment.
	 * @param savedInstanceState
	 *            Saved instance state (may be use by KerInjectors).
	 * @param annotationClasses
	 *            Annotations classes concerned by injection.
	 */
	@SafeVarargs
	public static void inject(final android.support.v4.app.Fragment fragment, final Bundle savedInstanceState, final Class<? extends Annotation>... kerAnnotationClasses) throws KerException {
		// - For each annotations.
		for (final Class<? extends Annotation> kerAnnotationClass : kerAnnotationClasses) {

			AbstractKerInjector kerAnnotationInjector;

			try {
				// - Retrieve it KerInjector.
				kerAnnotationInjector = retrieveKerInjector(kerAnnotationClass);

				// - Try to inject each fields annotated with current annotation in input object using retrieved KerInjector.
				if (kerAnnotationInjector.isInjectable(fragment, savedInstanceState)) {
					for (final Field field : retrieveAllFields(fragment)) {
						if (field.isAnnotationPresent(kerAnnotationClass)) {
							try {
								kerAnnotationInjector.inject(field, fragment, savedInstanceState);
							} catch (final Throwable cause) {
								throw new KerException("Unable to inject field " + field.getName() + " annotated with " + kerAnnotationClass.getName(), cause);
							}
						}
					}
				}

			} catch (final Throwable cause) {
				throw new KerException("Unable to inject fields annotated with " + kerAnnotationClass.getName(), cause);
			}

		}
	}

	/**
	 * Retrieve annotation KerInjector from cache or instantiate it if necessary.
	 * 
	 * @param annotationClass
	 *            Annotation class.
	 * @return Annotation's KerInjector.
	 */
	public static AbstractKerInjector retrieveKerInjector(Class<? extends Annotation> annotationClass) throws InstantiationException, IllegalAccessException {
		AbstractKerInjector kerInjector = null;

		// - Retrieve remembered KerInjector instance if exists.
		if (kerInstances.containsKey(annotationClass)) {
			kerInjector = kerInstances.get(annotationClass);
		}
		// - Else instantiate it if necessary
		else {
			// - Retrieve KerInjector.
			final KerInjector kerInjectorAnnotation = annotationClass.getAnnotation(KerInjector.class);
			final Class<? extends AbstractKerInjector> kerInjectorClass = kerInjectorAnnotation.value();

			// - Instantiate it.
			kerInjector = kerInjectorClass.newInstance();

			// - Remember it.
			kerInstances.put(annotationClass, kerInjector);
		}

		return kerInjector;
	}

	/**
	 * Save instance state fields into bundle. Must be called from *.onSaveInstanceState().
	 * 
	 * @param object
	 *            Instance containing instance state fields.
	 * @param outState
	 *            Ouput bundle.
	 */
	public static void onSaveInstanceState(final Object object, final Bundle outState) throws KerException {
		// - Retrieve all fields.
		final Field[] fields = KerAnnotation.retrieveAllFields(object);

		// - Save instance state fields into new bundle to avoid key conflict.
		for (final Field field : fields) {
			// - If field is annotated with @InstanceState.
			if (field.isAnnotationPresent(InstanceState.class)) {
				InstanceStateKerInjector.saveInstanceState(field, object, outState);
			}
		}
	}

	/**
	 * Get layout resource id from {@link Layout}.
	 * 
	 * @param object
	 *            Object annonated with {@link Layout}.
	 * @return Layout resource id.
	 */
	public static int getLayoutResId(final Object object) throws KerException {
		int layoutResId = 0;

		// - If object is annotated with @Layout.
		if (object.getClass().isAnnotationPresent(Layout.class)) {
			// - Retrieve @Layout's value.
			final Layout layout = object.getClass().getAnnotation(Layout.class);
			layoutResId = layout.value();
		}

		return layoutResId;
	}

	/**
	 * Retrieve all fields from object.
	 * 
	 * @param object
	 *            Object containing fields.
	 * @return Object's fields.
	 */
	private static Field[] retrieveAllFields(final Object object) {
		Field[] fieldsArray = null;

		// - Retrieve fields array from cache if exists.
		if (fieldsCache.containsKey(object.getClass())) {
			fieldsArray = fieldsCache.get(object.getClass());
		}
		// - Else get fields and cache them.
		else {
			// - Aggregate all annotated fields (declared, inherited, etc.).
			final Set<Field> fields = new HashSet<Field>();

			for (final Field field : object.getClass().getFields()) {
				if (field.getAnnotations().length > 0) {
					fields.add(field);
				}
			}
			for (final Field field : object.getClass().getDeclaredFields()) {
				if (field.getAnnotations().length > 0) {
					fields.add(field);
				}
			}

			// - Convert set to array.
			fieldsArray = fields.toArray(new Field[0]);

			// - Cache array.
			fieldsCache.put(object.getClass(), fieldsArray);
		}

		return fieldsArray;
	}

}