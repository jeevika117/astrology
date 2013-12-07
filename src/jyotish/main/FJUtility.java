package jyotish.main;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/*
 *  This class provides some utility functions which can't be part
 *  of any other class
 */
/**
 *  Description of the Class
 *
 *@author     Michael W. Taft
 *@created    May 19, 2002
 */
public class FJUtility
{

	/**
	 *  Description of the Method
	 *
	 *@param  hour    Description of the Parameter
	 *@param  min     Description of the Parameter
	 *@param  second  Description of the Parameter
	 *@param  offset  Description of the Parameter
	 *@return         Description of the Return Value
	 */
	public static double universal(int hour, int min, int second, double offset)
	{
		return 1.0 * (hour - offset) + min / 60.0 + second / 3600.0;
		//Universal Time
	}


	/**
	 *  Description of the Method
	 *
	 *@param  date   Description of the Parameter
	 *@param  month  Description of the Parameter
	 *@param  year   Description of the Parameter
	 *@param  ut     Description of the Parameter
	 *@return        Description of the Return Value
	 */
	public static double julDate(int date, int month, int year, double ut)
	{
		//Julian Date

		double A;
		double B;
		double Mjd;

		A = 10000.0 * year + 100.0 * month + date;
		if (month <= 2)
		{
			month = month + 12;
			year = year - 1;
		}
		if (A <= 15821004.1)
		{
			B = -2 + (int) ((year + 4716) / 4) - 1179;
		}
		else
		{
			B = (int) (year / 400) - (int) (year / 100) + (int) (year / 4);
		}
		A = 365.0 * year - 679004.0;
		Mjd = A + B + (int) (30.6001 * (month + 1)) + date + ut / 24.0;
		return Mjd + 2400000.5;
	}


	/**
	 *  Description of the Method
	 *
	 *@param  deg  Description of the Parameter
	 *@return      Description of the Return Value
	 */
	public static double rev(double deg)
	{
		deg = deg % 360;
		while (deg < 0)
		{
			deg += 360;
		}
		return deg;
	}


	/**
	 *  Description of the Method
	 *
	 *@param  degrees  Description of the Parameter
	 *@param  sign     Description of the Parameter
	 *@return          Description of the Return Value
	 */
	public static String DegToSign(double degrees, int sign)
	{
		int deg;
		int min;
		int sec;

		int totSecs = (int) (degrees * 60 * 60);

		sec = totSecs % 60;
		min = (totSecs / 60) % 60;
		deg = (totSecs / (60 * 60));

		return new String(deg + "°" + Constants.zodiacShortNames[sign] + min + "'" + sec);
	}

	public static String zodiacDMS (double lon)//display planets's longitude in DMS format + zodiac sign
    {
        String sign = "AriTauGemCanLeoVirLibScoSagCapAquPis";

        double dd = (int)lon;
        double j = dd/30;
        int z = (int)j * 3;
        String zn = sign.substring(z, z+3);
        double mm = Math.abs((lon - dd) * 60);
        double ss = Math.abs((mm - (int)mm) * 60);
        ss = Math.round(ss);
        dd = dd%30;
        String deg;
        if(dd<10.0){deg = "0" + String.valueOf((int)dd);}
        else deg = String.valueOf((int)dd);
        String min;
        if (mm<10.0){min = "0" + String.valueOf((int)mm);}
        else min = String.valueOf((int)mm);
        String sec;
        if (ss<10.0){sec = "0" + String.valueOf((int)ss);}
        else sec = String.valueOf((int)ss);


        return (deg + "° " + zn + " " + min + "' " + sec + "\"");
        }

	public static String toDMS (double lat)//display planets's latitude in DMS
    {
        
        double dd = (int)lat;
        double j = dd/30;
        int z = (int)j * 3;
        double mm = Math.abs((lat - dd) * 60);
        double ss = Math.abs((mm - (int)mm) * 60);
        ss = Math.round(ss);
        dd = Math.abs(dd%30); 
	String deg;
        if(dd<10.0){deg = "0" + String.valueOf((int)dd);}
        else deg = String.valueOf((int)dd);
        String min;
        if (mm<10.0){min = "0" + String.valueOf((int)mm);}
        else min = String.valueOf((int)mm);
        String sec;
        if (ss<10.0){sec = "0" + String.valueOf((int)ss);}
        else sec = String.valueOf((int)ss);
	if(lat<0)deg = "-"+deg;
	else deg = " "+deg;


        return (deg + "° " + " " + min + "' " + sec + "\"");
        }
	
	public static String formatAyanamsa (double ayan)//display planets's latitude in DMS
    {
        
        double dd = (int)ayan;
        double j = dd/30;
        int z = (int)j * 3;
        double mm = Math.abs((ayan - dd) * 60);
        double ss = Math.abs((mm - (int)mm) * 60);
        ss = Math.round(ss);
        dd = Math.abs(dd%30); 
	String deg;
        if(dd<10.0){deg = "0" + String.valueOf((int)dd);}
        else deg = String.valueOf((int)dd);
        String min;
        if (mm<10.0){min = "0" + String.valueOf((int)mm);}
        else min = String.valueOf((int)mm);
        String sec;
        if (ss<10.0){sec = "0" + String.valueOf((int)ss);}
        else sec = String.valueOf((int)ss);
	if(ayan<0)deg = "-"+deg;
	else deg = " "+deg;


        return (deg + ":" + min + ":" + sec);
        }




	/**
	 *  Gets the nakshatra attribute of the FJUtility class
	 *
	 *@param  temp  Description of the Parameter
	 *@return       The nakshatra value
	 */
	public static String getNakshatra(double temp)
	{
		int i = 0;
		while ((temp -= Constants.nakshatraDeg) > 0)
		{
			i++;
		}
		return Constants.nakshatra[i];
	}

	public static String getPada (double lon)//returns nakshatra pada
              {
                String pada = "0";
                lon = lon%13.333333333;
                if (0.0<=lon&&lon<3.333333333)pada = "1";
                if (3.333333333<=lon&&lon<6.666666666)pada = "2";
                if (6.666666666<=lon&&lon<10.0) pada = "3";
                if (10.0<=lon&&lon<13.333333333) pada = "4";
                return pada;
          }


	/**
	 *  Description of the Method
	 *
	 *@param  deg  Description of the Parameter
	 *@return      Description of the Return Value
	 */
	public static double toRadians(double deg)
	{
		return deg * (Math.PI / 180);
	}


	/**
	 *  Description of the Method
	 *
	 *@param  rad  Description of the Parameter
	 *@return      Description of the Return Value
	 */
	public static double toDegrees(double rad)
	{
		return rad * (180.0 / Math.PI);
	}


	/**
	 *  Gets the numeric attribute of the FJUtility class
	 *
	 *@param  x  Description of the Parameter
	 *@return    The numeric value
	 */
	public static boolean isNumeric(String x)
	{
		//will not handle a negative number, very large number, or decimal number

		try
		{
			int n = Integer.parseInt(x);

			return true;
		}
		catch (NumberFormatException nfe)
		{
			return false;
		}

	}


	/**
	 *  Gets the withinLongitudeLimits attribute of the FJUtility class
	 *
	 *@param  x  Description of the Parameter
	 *@return    The withinLongitudeLimits value
	 */
	public static boolean isWithinLongitudeLimits(int x)
	{
		//positive numbers only

		if (0 <= x && x <= 180)
		{
			return true;
		}

		else
		{
			return false;
		}

	}


	/**
	 *  Gets the withinLatitudeLimits attribute of the FJUtility class
	 *
	 *@param  x  Description of the Parameter
	 *@return    The withinLatitudeLimits value
	 */
	public static boolean isWithinLatitudeLimits(int x)
	{
		//positive numbers only

		if (0 <= x && x <= 90)
		{
			return true;
		}

		else
		{
			return false;
		}

	}


	/**
	 *  Gets the withinDegSecLimits attribute of the FJUtility class
	 *
	 *@param  x  Description of the Parameter
	 *@return    The withinDegSecLimits value
	 */
	public static boolean isWithinDegSecLimits(int x)
	{
		//positive numbers only

		if (0 <= x && x < 60)
		{
			return true;
		}

		else
		{
			return false;
		}

	}
	
public  static Date getDate(int year, int month, int dayOfMonth, int hour, 
   int minute, int second, TimeZone tz) {
   Calendar cal = Calendar.getInstance();
   cal.clear();
   cal.setTimeZone(tz);
   cal.set(Calendar.YEAR, year);
   cal.set(Calendar.MONTH, month);
   cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
   cal.set(Calendar.HOUR_OF_DAY, hour);
   cal.set(Calendar.MINUTE, minute);
   cal.set(Calendar.SECOND, second);
   return cal.getTime();
 }
	
}

