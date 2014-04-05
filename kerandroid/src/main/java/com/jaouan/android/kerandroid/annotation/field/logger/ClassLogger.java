package com.jaouan.android.kerandroid.annotation.field.logger;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jaouan.android.kerandroid.annotation.KerInjector;

/**
 * 
 * Injects SLF4J Logger.
 * 
 * @author Maxence Jaouan
 * 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@KerInjector(ClassLoggerKerInjector.class)
public @interface ClassLogger {
}
