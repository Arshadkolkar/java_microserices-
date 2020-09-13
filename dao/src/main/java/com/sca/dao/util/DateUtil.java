/**
 * 
 */
package com.sca.dao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author subhash
 *
 */
public class DateUtil {

	public static final String DATE_FORMAT_1 = "yyyy-MM-dd";

	/**
	 * 
	 * @param dateFormatStr
	 * @param inDate
	 * @return
	 */
	public static boolean isValidDate(String dateFormatStr, String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param dateFormatStr
	 * @param inDate
	 * @return
	 */
	public static Date convertStringToDate(String dateFormatStr, String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
		dateFormat.setLenient(false);
		Date parsedDate = null;
		try {
			if (inDate != null && !inDate.isEmpty())
				parsedDate = dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return parsedDate;
		}

		return parsedDate;
	}

	/**
	 * 
	 * @param dateFormatStr
	 * @param indate
	 * @return
	 */
	public static String convertDateToString(String dateFormatStr, Date indate) {
		String dateString = "";
		SimpleDateFormat sdfr = new SimpleDateFormat(dateFormatStr);
		try {
			dateString = sdfr.format(indate);
		} catch (Exception ex) {
			return dateString;
		}
		return dateString;
	}

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDiffYears(LocalDate startDate, LocalDate endDate) {
		Period age = Period.between(startDate, endDate);
		return age.getYears();
	}

	/**
	 * 
	 * @param dateFormatStr
	 * @param inDate
	 * @return
	 */
	public static Calendar convertStringToCalendar(String dateFormatStr, String inDate) {
		Date date = convertStringToDate(dateFormatStr, inDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar;
	}

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDiffDays(LocalDate startDate, LocalDate endDate) {
		Period age = Period.between(startDate, endDate);
		return age.getDays();
	}

}
