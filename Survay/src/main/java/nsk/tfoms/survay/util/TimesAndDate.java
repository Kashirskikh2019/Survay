package nsk.tfoms.survay.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimesAndDate
{
	public static Date parseDate(String cunvertCurrentDate,String format) throws ParseException
	 {
		  Date date = new Date();
		  DateFormat df = new SimpleDateFormat(format);
		  date = df.parse(cunvertCurrentDate);
		  return date;
	 }
}
