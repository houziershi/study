package example;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExample{

	public static Date createDate(int year, int month, int day){
		Calendar cal = new GregorianCalendar();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	public static Date addDay(Date date, int dayNum) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, dayNum);
		return cal.getTime();
	}

}
