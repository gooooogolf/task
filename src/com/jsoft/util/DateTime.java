/**
 * 
 */
package com.jsoft.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

/**
 * @author 006223
 * 
 */
public class DateTime {
	
	private static Logger log = Logger.getLogger(DateTime.class);
	
	public static String formatDate(Date date, String pattern,
			Locale currentLocale) {
		if (date == null)
			return null;
		SimpleDateFormat formatter;
		String output;
		try {
			formatter = new SimpleDateFormat(pattern, currentLocale);
			output = formatter.format(date);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
		return output;
	}

	public static Date stringtoDate(String strDate, String format)
			 {
		if (strDate == null)
			return null;
		try {
			// String format = "yyyy-MM-dd";
			SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.US);
			ParsePosition pos = new ParsePosition(0);
			java.util.Date d = formatter.parse(strDate, pos);
			return d;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}
	
	public static String dateNow_ddMMyyyy(){
	  	String DATETIME_FORMAT_NOW = "dd/MM/yyyy";
		Locale.setDefault(new Locale("en", "US"));
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT_NOW);
	    //System.out.println(sdf.format(cal.getTime()));
	    return sdf.format(cal.getTime());
	  }

	public static String dateNow() {
		String DATETIME_FORMAT_NOW = "yyyy-MM-dd";
		Locale.setDefault(new Locale("en", "US"));
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}
	public static String yyyy()  {
		String DATETIME_FORMAT_NOW = "yyyy";
		Locale.setDefault(new Locale("en", "US"));
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}
	
	public static String yyyy_TH()  {
		String DATETIME_FORMAT_NOW = "yyyy";
		Locale.setDefault(new Locale("th", "TH"));
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}
	
	public static String mm()  {
		String DATETIME_FORMAT_NOW = "MM";
		Locale.setDefault(new Locale("en", "US"));
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}
	public static String dd() {
		String DATETIME_FORMAT_NOW = "dd";
		Locale.setDefault(new Locale("en", "US"));
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}
	public static String timeNow() {
		String DATETIME_FORMAT_NOW = "HH:mm:ss";
		Locale.setDefault(new Locale("en", "US"));
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}
}
