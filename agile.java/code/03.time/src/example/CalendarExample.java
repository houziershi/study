package example;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * 这是 <b>一个简单的类</b> 注释。
 *
 * @author Jade
 * @author 阿左
 *
 *
 */
public class CalendarExample{

	/**
	 * create date
	 * @param year 
	 * 	year
	 * @param month 
	 * 	month
	 * @param day 
	 * 	day
	 */ 
	public Date createDate(int year, int month, int day){
		Calendar cal = new GregorianCalendar();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	/**
	 * add days.
	 *
	 * @param date 
	 * 	ori date
	 * @param dayNum 
	 * 	how many day to add
	 *
	 */
	public Date addDay(Date date, int dayNum) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, dayNum);
		return cal.getTime();
	}
}
