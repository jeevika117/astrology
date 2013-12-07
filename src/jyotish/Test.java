package jyotish;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;

import jyotish.main.BirthData;
import jyotish.main.Chart;
import jyotish.main.Constants;
import jyotish.main.TimeRange;
import jyotish.main.ChartBuilder;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			generateBirthChart(null);
		

	}

	public static Chart generateBirthChart(BirthData birthdata) {
		if(birthdata==null){
		birthdata = new BirthData();
		birthdata.setBirthDate(7);
		birthdata.setBirthMonth(10);
		birthdata.setBirthYear(2013);
		birthdata.setBirthHour(5);
		birthdata.setBirthMinute(30);
		birthdata.setBirthSecond(0);
		birthdata.setIsEast(true);
		birthdata.setIsNorth(true);
		birthdata.setLongitude_Deg(80);
		birthdata.setLongitude_Min(17);
		birthdata.setLongitude_Sec(0);
		birthdata.setLatitude_Deg(13);
		birthdata.setLatitude_Min(5);
		birthdata.setLatitude_Sec(0);
		birthdata.setTimeZoneOffset(5.5);
		}
		
		ChartBuilder chartbuilder = new ChartBuilder();
		
		chartbuilder.setCalculationPreferences();
		Chart calculateChart = chartbuilder.calculateChart(birthdata,null);
				
		return calculateChart;
		/*
		 * Use jodaTime for all calendar calculations............
		 */
		
		
	}

}
