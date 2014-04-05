package com.jaouan.android.kerandroid.exception;

/**
 * 
 * Basic KerException.
 * 
 * @author Maxence Jaouan
 * 
 */
public class KerException extends Exception {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 2470441186472899320L;

	/**
	 * KerException's constructor.
	 * 
	 * @param message
	 *            Message.
	 * @param cause
	 *            Cause.
	 */
	public KerException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * KerException's constructor.
	 * 
	 * @param message
	 *            Message.
	 */
	public KerException(final String message) {
		super(message);
	}
}
