package jyotish.main.calc;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;

import swisseph.DblObj;
import swisseph.SweConst;
import swisseph.SweDate;
import swisseph.SwissEph;
import jyotish.main.BirthData;
import jyotish.main.Constants;
import jyotish.main.Planet;
import jyotish.main.TimeRange;
/*
*	Created by Michael W. Taft, 25 March, 2003
*/
public class PanchangBasicsCalculator {
	private static String yoga, tithi, karana;
	private static double diff,
		sum,
		location_lon,
		location_lat,
		sunLon,
		moonLon;
	private static PanchangBasics panch_basics;
	//private static SwissEph sw;
	public static PanchangBasics calculatePanchangBasics(
		SwissEph sw,
		double tjd_ut,
		double location_lon,
		double location_lat,
		Planet sun,
		Planet moon,
		int birthday,
		double offset
		) {
		panch_basics = new PanchangBasics();
		sunLon = sun.getLongitude();
		moonLon = moon.getLongitude();
		diff = getDiff(sunLon, moonLon);
		sum = getSum(sunLon, moonLon);
		int nak_no =calculateNakshatra(moonLon);
		panch_basics.setNakshathra(Constants.nakshatra[nak_no]);
		panch_basics.setNakshatra_count(nak_no+1);
		panch_basics.setPada(calculatePada(diff));
		panch_basics.setDay(calculateDay(birthday));
		panch_basics.setYoga(calculateYoga(sum));
		panch_basics.setTithi(calculateTithi(diff));
		panch_basics.setKarana(calculateKarana(diff));
		panch_basics.setSunrise(
			calculateSunrise(sw, location_lon, location_lat, tjd_ut,offset));
		panch_basics.setSunset(
			calculateSunset(sw, location_lon, location_lat, tjd_ut,offset));
		panch_basics.setAyanamsa(calculateAyanamsa(sw, tjd_ut));
		Date sunrise =panch_basics.getSunrise().getTime();
		Date sunset =panch_basics.getSunset().getTime();
		int diffSec = (int)((sunset.getTime()-sunrise.getTime())/1000);
		int period=diffSec/8;
		//System.out.println("period"+period);
		
		panch_basics.setRahukal(calulateRange(sunrise,sunset,birthday,Constants.rahu,period));
		panch_basics.setYamaganda(calulateRange(sunrise,sunset,birthday,Constants.yamaganda,period));
		panch_basics.setGulika(calulateRange(sunrise,sunset,birthday,Constants.gulika,period));
		
		
		return panch_basics;
	}
	private static String calulateRange(Date sunrise, Date sunset,int birthday,int[] constant,int period) {
		//Calculate Rahukal
		//birthday=(birthday>0?birthday:6);
		DateTime from = new DateTime(sunrise);
		DateTime to = new DateTime(sunrise);
		to = to.plusSeconds(constant[birthday]*period);
		from = to.minusSeconds(period);
		TimeRange range = new TimeRange(from,to);
		return range.toString();
	}
	private static double getDiff(double sunLon, double moonLon) {
		double diff = moonLon - sunLon;
		if (diff < 0)
			diff = diff + 360;
		return diff;
	}
	private static double getSum(double sunLon, double moonLon) {
		double sum = moonLon + sunLon;
		return sum % 360;
	}
	public static String calculateTithi(double diff) {
		int ti = (int) (diff / 12)-1;
		//classical calculation involves adding a one here; stripped because of array positions
		if(ti<0){
			ti=0;
		}
		String[] tithiNames =
			{
				"1. Pratipat",
				"2. Dvitiya",
				"3. Tritiya",
				"4. Chaturthi",
				"5. Panchami",
				"6. Shashti",
				"7. Saptami",
				"8. Ashtami",
				"9. Navami",
				"10. Dashami",
				"11. Ekadashi",
				"12. Dvadashi",
				"13. Trayodashi",
				"14. Chaturdashi",
				"15. Purnima",
				"1. Pratipat",
				"2. Dvitiya",
				"3. Tritiya",
				"4. Chaturthi",
				"5. Panchami",
				"6. Shashti",
				"7. Saptami",
				"8. Ashtami",
				"9. Navami",
				"10. Dashami",
				"11. Ekadashi",
				"12. Dvadashi",
				"13. Trayodashi",
				"14. Chaturdashi",
				"15. Amavasya" };
		if (ti < 15)
			tithi = tithiNames[ti] + ", " + "Shukla paksha";
		else if (15 <= ti)
			tithi = tithiNames[ti] + ", " + "Krishna paksha";
		return tithi;
	}
	public static String calculateKarana(double diff) {
		int ka = (int) (diff / 6);
		//classical calculation involves adding a one here; stripped because of array positions
		if(ka<0){
			ka=0;
		}
		String[] karanaNames =
			{
				"1. Kinstughna",
				"2. Bava",
				"3. Balava",
				"4. Kaulava",
				"5. Taitila",
				"6. Gara",
				"7. Vanija",
				"8. Vishti",
				"9. Bava",
				"10. Balava",
				"11. Kaulava",
				"12. Taitila",
				"13. Gara",
				"14. Vanija",
				"15. Vishti",
				"16. Bava",
				"17. Balava",
				"18. Kaulava",
				"19. Taitila",
				"20. Gara",
				"21. Vanija",
				"22. Vishti",
				"23. Bava",
				"24. Balava",
				"24. Kaulava",
				"26. Taitila",
				"27. Gara",
				"28. Vanija",
				"29. Vishti",
				"30. Bava",
				"31. Balava",
				"32. Kaulava",
				"33. Taitila",
				"34. Gara",
				"35. Vanija",
				"36. Vishti",
				"37. Bava",
				"38. Balava",
				"39. Kaulava",
				"40. Taitila",
				"41. Gara",
				"42. Vanija",
				"43. Vishti",
				"44. Bava",
				"45. Balava",
				"46. Kaulava",
				"47. Taitila",
				"48. Gara",
				"49. Vanija",
				"50. Vishti",
				"51. Bava",
				"52. Balava",
				"53. Kaulava",
				"54. Taitila",
				"55. Gara",
				"56. Vanija",
				"57. Vishti",
				"58. Shakuni",
				"Chatushpada",
				"Naga" };
		return karanaNames[ka];
	}
	public static String calculateYoga(double sum) {
		int yo = (int) (sum / (13 + 1 / 3))-1;
		if(yo<0){
			yo=0;
		}
		String[] yogaNames =
			{
				"1. Vishkambha",
				"2. Priti",
				"3. Ayushman",
				"4. Saubhagya",
				"5. Shobhana",
				"6. Atiganda",
				"7. Sukarma",
				"8. Dhriti",
				"9. Shula",
				"10. Ganda",
				"11. Vriddhi",
				"12. Dhruva",
				"13. Vyaghata",
				"14. Harshana",
				"15. Vajra",
				"16. Siddhi",
				"17. Vyatipat",
				"18. Variyana",
				"19. Parigha",
				"20. Shiva",
				"21. Siddha",
				"22. Sadhya",
				"23. Shubha",
				"24. Shukla",
				"25. Brahma",
				"26. Indra",
				"27. Vaidhriti" };
		return yogaNames[yo];
	}
	public static GregorianCalendar calculateSunrise(
		SwissEph sw,
		double lon,
		double lat,
		double tjd_ut,
		double offset) {
		double[] lonLatH = { lon, lat, 0 };
		DblObj sunrise = new DblObj();
		StringBuffer star = new StringBuffer();
		sw.swe_rise_trans(
			tjd_ut,
			SweConst.SE_SUN,
			star,
			SweConst.SEFLG_SWIEPH,
			SweConst.SE_CALC_RISE
				+ SweConst.SE_BIT_DISC_CENTER
				+ SweConst.SE_BIT_NO_REFRACTION,
			lonLatH,
			0.0,
			0.0,
			sunrise,
			star);
		//calculates disc center, no refraction.
		SweDate sr = new SweDate(sunrise.val);
		int sunHour = (int) sr.getHour();
		double rem1 = sr.getHour() - (double) sunHour;
		double sun2 = rem1 * 60.0;
		int sunMin = (int) sun2;
		double rem2 = sun2 - (double) sunMin;
		double sun3 = rem2 * 60.0;
		int sunSec = (int) sun3;
		GregorianCalendar sunriseGreg =
			new GregorianCalendar(
				(int) sr.getYear(),
				(int) sr.getMonth(),
				(int) sr.getDay(),
				sunHour,
				sunMin,
				sunSec);
		//add the timezone offset
		sunriseGreg.add(Calendar.SECOND, (int)(offset*3600));
		System.out.println(
			"[PanchangBasics]: Sunrise = "
				+ (int) sr.getYear()
				+ ":"
				+ (int) sr.getMonth()
				+ ":"
				+ (int) sr.getDay()
				+ ":"
				+ sunHour
				+ ":"
				+ sunMin
				+ ":"
				+ sunSec);
		return sunriseGreg;
	}
	public static GregorianCalendar calculateSunset(
		SwissEph sw,
		double lon,
		double lat,
		double tjd_ut,
		double offset) {
		double[] lonLatH = { lon, lat, 0 };
		DblObj sunset = new DblObj();
		StringBuffer star = new StringBuffer();
		sw.swe_rise_trans(
			tjd_ut,
			SweConst.SE_SUN,
			star,
			SweConst.SEFLG_SWIEPH,
			SweConst.SE_CALC_SET
				+ SweConst.SE_BIT_DISC_CENTER
				+ SweConst.SE_BIT_NO_REFRACTION,
			lonLatH,
			0.0,
			0.0,
			sunset,
			star);
		//calculates disc center, no refraction.
		SweDate ss = new SweDate(sunset.val);
		int sunHour = (int) ss.getHour();
		double rem1 = ss.getHour() - (double) sunHour;
		double sun2 = rem1 * 60.0;
		int sunMin = (int) sun2;
		double rem2 = sun2 - (double) sunMin;
		double sun3 = rem2 * 60.0;
		int sunSec = (int) sun3;
		GregorianCalendar sunsetGreg =
			new GregorianCalendar(
				(int) ss.getYear(),
				(int) ss.getMonth(),
				(int) ss.getDay(),
				sunHour,
				sunMin,
				sunSec);
		sunsetGreg.add(Calendar.SECOND, (int)(offset*3600));
		System.out.println(
			"[PanchangBasics]: Sunset = "
				+ (int) ss.getYear()
				+ ":"
				+ (int) ss.getMonth()
				+ ":"
				+ (int) ss.getDay()
				+ ":"
				+ sunHour
				+ ":"
				+ sunMin
				+ ":"
				+ sunSec);
		return sunsetGreg; ///TESTING ONLY
	}
	public static double calculateAyanamsa(SwissEph sw, double tjd_ut) {
		return sw.swe_get_ayanamsa_ut(tjd_ut);
	}
	public static String calculateDay(int dayNo) {
		
		if(0<dayNo && dayNo<8)
			return Constants.weekday[dayNo];
		else
			return "NOT SET";
		
	}
	

	public static int calculateNakshatra(double moonlog)
	{

		int i = (int) (moonlog / (13.333333)-1);
		if(i<0){
			i=0;
		}
		return i;
	}

	public static String calculatePada (double lon)//returns nakshatra pada
              {
                String pada = "0";
                lon = lon%13.333333333;
                if (0.0<=lon&&lon<3.333333333)pada = "1";
                if (3.333333333<=lon&&lon<6.666666666)pada = "2";
                if (6.666666666<=lon&&lon<10.0) pada = "3";
                if (10.0<=lon&&lon<13.333333333) pada = "4";
                return pada;
          }

}
