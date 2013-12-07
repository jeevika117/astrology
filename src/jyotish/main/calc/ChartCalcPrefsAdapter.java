package jyotish.main.calc;



/*
*	First created 5 April, 2003 by Michael W. Taft
*
*/

///The idea here is to separate the ChartCalcPrefs from the SwissEph implementation of the IChartCalculator interface

public class ChartCalcPrefsAdapter
{
	private String houseSystemChoice;
	private String ayanamsaChoice;
	private String zodiacChoice;
	//private ChartCalcPrefs calcPrefs;

	

	public String getHouseSystemChoice()
	{
		return houseSystemChoice;
	}
	
	public String getAyanamsaSystemChoice()
	{
		return ayanamsaChoice;
	}
	
	public String getZodiacChoice()
	{
		return zodiacChoice;
	}

}
