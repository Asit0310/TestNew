package com.tcs.salesforce.library;

import org.apache.log4j.Logger;

public class Log {

	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());

	// Need to create these methods, so that they can be called
	public static void info(String message) {
		Log.info(getCallInfo() + message);
	}

	public static void warn(String message) {
		Log.warn(getCallInfo() + message);
	}

	public static void error(String message) {
		Log.error(getCallInfo() + message);
	}

	public static void fatal(String message) {
		Log.fatal(getCallInfo() + message);
	}

	public static void debug(String message) {
		Log.debug(getCallInfo() + message);
	}

	/**
	 * This method gets the class name at the runtime for all the log level
	 * methods of the Log Class from the StackTrace.
	 * 
	 * @return ClassName
	 */
	public static String getClassName() {

		return new Throwable().getStackTrace()[3].getClassName();
	}

	/**
	 * This method gets the name of the method which is calling the other method
	 * at the runtime.
	 * 
	 * @return LineNumber
	 */
	public static int getLineNumber() {

		return new Throwable().fillInStackTrace().getStackTrace()[2]
				.getLineNumber();

	}

	/**
	 * Method returns the information the class:method & and line number from
	 * where the logging method ( info(),debug().. ) is called. This is not the
	 * best way.. but had to get it to work
	 * 
	 * @return Returns call information in <ClassName>:<MethodName> [<Line
	 *         Number>] format
	 */
	public static String getCallInfo() {

		String callInfo;
		String methodName = Thread.currentThread().getStackTrace()[3]
				.getMethodName();
		int lineNumber = Thread.currentThread().getStackTrace()[3]
				.getLineNumber();

		callInfo = getClassName() + ":" + methodName + " [" + lineNumber
				+ "] - ";
		return callInfo;

	}
}
