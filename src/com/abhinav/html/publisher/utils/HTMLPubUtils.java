/*
 * Created By: Abhinav Kumar Mishra
 * Copyright &copy; 2013-2016. Abhinav Kumar Mishra. 
 * All rights reserved.
 */
package com.abhinav.html.publisher.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * The Class HTMLPubUtils.<br/>
 * This is a utility class, It will have all utility methods, which can be used in 
 * report generation.
 * 
 * @since 2016
 * @author Abhinav Kumar Mishra
 */
public final class HTMLPubUtils {

	/** The Constant BOLL_FALSE. */
	public static final boolean BOLL_FALSE = false;
	
	/** The Constant BOOL_TRUE. */
	public static final boolean BOOL_TRUE = true;

	public static final int ONE =1;
	
	/** The Constant EMPTY. */
	public static final String EMPTY = "";
	
	/** The Constant INDEX. */
	public static final String INDEX = "index.html";

	/** The Constant FILE_SEPERATOR_WIN. */
	public static final String FILE_SEPERATOR_WIN = "\\";
	
	/** The Constant FILE_SEPERATOR_LINUX. */
	public static final String FILE_SEPERATOR_LINUX = "/";
	
	/**
	 * Gets the current date time.
	 *
	 * @param format the format
	 * @return the current date time
	 */
	public static String getCurrentDateTime(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	/**
	 * Convert to linux format.
	 *
	 * @param inputPath the input path
	 * @return the string
	 */
	public static String convertToLinuxFormat(String inputPath) {
		return inputPath.replace(FILE_SEPERATOR_WIN,FILE_SEPERATOR_LINUX);
	}
	
	/**
	 * Check the linux seperator.
	 *
	 * @param aStr the a str
	 * @return the string
	 */
	public static String checkLinuxSeperator(String aStr) {
		if (!aStr.endsWith(FILE_SEPERATOR_LINUX)) {
			aStr = aStr + FILE_SEPERATOR_LINUX;
		}
		return aStr;
	}
	
	/**
	 * Creates the dir for reports.
	 *
	 * @param dirPath the dir path
	 * @return true, if successful
	 */
	public static boolean createDir(String dirPath){
		boolean isDirCreated=false;
		File createDir=new File(dirPath);			
		//If the directory does not exist, create it
		if (!createDir.exists()) {
		  isDirCreated=createDir.mkdir();  
		}
		return isDirCreated;
	}
	
	
	/**
	 * Substring after last.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String substringAfterLast(final String str){
		return str.substring(str.lastIndexOf('/') + ONE);
	}
	
	/**
	 * Substring before last.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String substringBeforeLast(final String str){
		return str.substring(0,str.lastIndexOf('/'));
	}
}
