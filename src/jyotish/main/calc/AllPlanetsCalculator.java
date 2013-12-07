package jyotish.main.calc;
import swisseph.*;
import jyotish.main.*;

/*
*	Created 5 April, 2003 by Michael W. Taft
*
*/



public class AllPlanetsCalculator
{
	
	private static AllPlanets planets;
	private static String snam = null;
	private static String retro = "";
	private static StringBuffer serr = new StringBuffer();
	private static double x2[] = new double[6];
	private static long iflgret;
	
	
	public static AllPlanets calculateAllPlanets(SwissEph sw, double tjd_ut, String zodiac, int ayanamsa, String node, int iflag)
	{
		
		
		planets = new AllPlanets();
		Planet planet;
		int p;
		int nd;
		if (zodiac.equals("sidereal"))
		{
			sw.swe_set_sid_mode(ayanamsa, 0, 0);
		}
		
		if (node.equals("true")) nd = 11;
		else nd = 10;
			//System.out.println("node = " + nd);
		
		for (p = SweConst.SE_SUN; p <= nd; p++)
		{
			if (nd == 11 && p == 10)
			{
				continue;
			}
			
			
			//System.out.println("Calculating p#: " + p);
			iflgret = sw.swe_calc_ut(tjd_ut, p, (int) iflag, x2, serr);
			
			if (iflgret < 0)
			{
				System.out.print("error: " + serr.toString() + "\n");
			}
			else if (iflgret != iflag)
			{
				System.out.print("warning: iflgret != iflag. " + serr.toString() + "\n");
			}
			
			if (p <= 10)
			{
			snam = Constants.planetLongNames[p];
			planet = new Planet(snam, p);
			planet.setLongitude(x2[0]);//longitude
			planet.setLatitude(x2[1]);//latitude
			planet.setVelocity(x2[3]);//velocity in longitude
			}
			else 
			{
			snam = "Rahu";
			planet = new Planet(snam, p);
			planet.setLongitude(x2[0]);//longitude
			planet.setLatitude(x2[1]);//latitude
			planet.setVelocity(x2[3]);//velocity in longitude
			}				
			planets.setPlanet(planet);

		}
				snam = "Ketu";
				planet = new Planet(snam, p);
				double rahuLong = planets.getPlanet("Rahu").getLongitude();
				double ketuLong = (rahuLong+180)%360;
				planet.setLongitude(ketuLong);
				planet.setLatitude(planets.getPlanet("Rahu").getLatitude());
				planet.setVelocity(planets.getPlanet("Rahu").getVelocity());
				planets.setPlanet(planet);
		return planets;
	
	}
	

}
