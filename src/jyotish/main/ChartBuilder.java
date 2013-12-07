package jyotish.main;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.prefs.Preferences;

import org.joda.time.DateTime;

import swisseph.SweConst;
import swisseph.SweDate;
import swisseph.SwissEph;
import jyotish.main.AllPlanets;
import jyotish.main.BirthData;
import jyotish.main.Chart;
import jyotish.main.HouseData;
import jyotish.main.IChartCalculator;
import jyotish.main.calc.AllPlanetsCalculator;
import jyotish.main.calc.Astakavarga;
import jyotish.main.calc.AstakavargaCalculator;
import jyotish.main.calc.BirthDataValidator;
import jyotish.main.calc.FJCalculationInputException;
import jyotish.main.calc.HouseDataCalculator;
import jyotish.main.calc.PanchangBasics;
import jyotish.main.calc.PanchangBasicsCalculator;
import jyotish.main.calc.VargaData;
import jyotish.main.calc.VargaDataCalculator;
/*

* Created 4 April, 2003 by Michael W. Taft

*

*/
public class ChartBuilder implements IChartCalculator {
	private SwissEph sw;
	private Chart chart;
	private AllPlanets allPlanets;
	private BirthData nativeInfo;
	//private CalculationPreferences calcPrefs;
	private HouseData houseData;
	private String zodiac;
	private int ayanamsa;
	private String node;
	private char houseSystem;
	private static final int iflag_SID =
		SweConst.SEFLG_SIDEREAL + SweConst.SEFLG_NONUT + SweConst.SEFLG_SPEED;
	private static final int iflag_TROP = SweConst.SEFLG_SPEED;
	private static int iflag;
	public ChartBuilder() {
		sw = new SwissEph();
		
	}
	public void setCalculationPreferences() {
		
		Preferences prefs = Preferences.userRoot().node("/jyotish");
		zodiac = prefs.get("mode", "sidereal");
		ayanamsa = prefs.getInt("ayanamsa", 1);
		node = prefs.get("node", "true");
		if (zodiac.equals("tropical"))
			iflag = iflag_TROP;
		else
			iflag = iflag_SID;
			String houseString = prefs.get("houseType", "Shripati");
		if (houseString.equals("Shripati")) houseSystem = 'O';
		else if (houseString.equals("Koch")) houseSystem = 'K';
		else if (houseString.equals("Placidus")) houseSystem = 'P';
		else if (houseString.equals("Alcabitus")) houseSystem = 'B';
		else if (houseString.equals("Regiomontanus")) houseSystem = 'R';
		else if (houseString.equals("Campanus")) houseSystem = 'C';
		else houseSystem = 'O'; //IF ALL ELSE FAILS, USE SHRIPATI HOUSES
	}
	public Chart calculateChart(BirthData ni, InputPreference ip) {
		nativeInfo = ni;
		try
		{
		BirthDataValidator.checkBirthDataValidity(nativeInfo);
		} 
		catch (FJCalculationInputException fje) 
		{
			///Currently catches exceptions, but doesn't stop the calculation. In the future, this needs to stop the calculation.
			System.out.println(fje);
		}
		chart = new Chart();
		double tjd_ut = getTJD_UT();
		DateTime birthdatetime = new DateTime(ni.getBirthYear(),ni.getBirthMonth(),ni.getBirthDate(),ni.getBirthHour(),ni.getBirthMinute());
		ni.setBirthDay(birthdatetime.getDayOfWeek());
		System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+birthdatetime.getDayOfWeek());
		allPlanets =
			AllPlanetsCalculator.calculateAllPlanets(
				sw,
				tjd_ut,
				zodiac,
				ayanamsa,
				node,
				iflag);
		double lon = getDecimalLongitude();
		double lat = getDecimalLatitude();
		VargaData vargaData =null;
		PanchangBasics panchangBasics =null;
		Astakavarga AV = null;
		if(ip.getType()<20){
		houseData =
			HouseDataCalculator.calculateHouseData(
				sw,
				tjd_ut,
				lon,
				lat,
				iflag,
				houseSystem);
		vargaData =
			VargaDataCalculator.calculateVargaData(
				allPlanets,
				houseData.getAscendant());
		AstakavargaCalculator avCalculator = new AstakavargaCalculator();
		AV = avCalculator.calculateAstakavarga(vargaData);
		}
		else if(ip.getType()==20){
		panchangBasics =
			PanchangBasicsCalculator.calculatePanchangBasics(
				sw,
				tjd_ut,
				lon,
				lat,
				allPlanets.getPlanet("Sun"),
				allPlanets.getPlanet("Moon"),
				ni.getBirthDay(),
				ni.getTimeZoneOffset());
		
		}
		chart.setNativeInfo2(nativeInfo);
		chart.setPlanetInfo(allPlanets);
		chart.setHouseInfo(houseData);
		chart.setVargaData(vargaData);
		chart.setPanchangBasics(panchangBasics);
		chart.setAstakavarga(AV);
		return chart;
	}
	public double getTJD_UT() //converts local time to the Julian Date of GMT
	{
		int year = nativeInfo.getBirthYear();
		int mon = nativeInfo.getBirthMonth();
		int day = nativeInfo.getBirthDate();
		;
		int hour = nativeInfo.getBirthHour();
		;
		int min = nativeInfo.getBirthMinute();
		int sec = nativeInfo.getBirthSecond();
		double offset = nativeInfo.getTimeZoneOffset();
		int dst = nativeInfo.getDSTOffset();
		Calendar birth =
			new GregorianCalendar(year, mon - 1, day, hour, min, sec);
		birth.add(Calendar.SECOND, (int) (-3600 * (offset + dst)));
		//Changes time to UTC
		double UTHour = (double) birth.get(Calendar.HOUR_OF_DAY);
		double UTMin = (double) birth.get(Calendar.MINUTE);
		double UTSec = (double) birth.get(Calendar.SECOND);
		double ut = UTHour + UTMin / 60 + UTSec / 3600;
		SweDate sd =
			new SweDate(
				birth.get(Calendar.YEAR),
				birth.get(Calendar.MONTH) + 1,
				birth.get(Calendar.DATE),
				ut);
		return sd.getJulDay();
	}
	private double getDecimalLongitude() {
		double longitude =
			(double) Math.abs(nativeInfo.getLongitude_Deg())
				+ ((double) nativeInfo.getLongitude_Min()) / 60
				+ ((double) nativeInfo.getLongitude_Sec()) / 3600;
		if (nativeInfo.getLongitude_Deg() < 0)
			longitude = -1 * longitude;
		//System.out.println("Longitude = " + longitude);///TEST CODE
		return longitude;
	}
	private double getDecimalLatitude() {
		double latitude =
			(double) Math.abs(nativeInfo.getLatitude_Deg())
				+ ((double) nativeInfo.getLatitude_Min()) / 60
				+ ((double) nativeInfo.getLatitude_Sec()) / 3600;
		if (nativeInfo.getLatitude_Deg() < 0)
			latitude = -1 * latitude;
		//System.out.println("Latitude = " + latitude);///TEST CODE
		return latitude;
	}
	
}
