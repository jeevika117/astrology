package jyotish;

import java.awt.List;
import java.util.ArrayList;

import swisseph.SweConst;
import swisseph.SweDate;
import swisseph.SwissEph;
import swisseph.SwissLib;


public class asttoTest {

	static double ayansamaConst=0.0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* input */
		int year =2011;
		int month= 9;
		int day = 3;
		double longitude =80+17/60.0;
		double lattitude =13+5/60.0;
		double time = 23+55/60.0;
		
		/*Instances of Utility Classes */
		SwissEph swissEph = new SwissEph();
		swissEph.swe_set_ephe_path("D\\:\\Projects\\Astrology\\swiseph_data");
		SweDate sweDate = new SweDate(year,month,day,time,SweDate.SE_GREG_CAL);
		SwissLib swiislib =new SwissLib();
		
			
		/*Set some constants*/
		
		
		swissEph.swe_set_sid_mode(SweConst.SE_SIDM_LAHIRI, 0, 0);
		int houseSys = (int)'A';
		
		
		planet_position(longitude, lattitude, swissEph, sweDate, swiislib,houseSys);	
		
		}

	private static void planet_position(double longitude, double lattitude,
			SwissEph swissEph, SweDate sweDate, SwissLib swiislib, int houseSys) {
		
		/*intialize program variables */
		double[] cusps = new double[13];
		double[] acsc = new double[10];
		double[] xx= new double[6];
		double[] xp= new double[6];
		double[] ipl = new double[6];
		StringBuffer serr = new StringBuffer();
		StringBuffer serr1 = new StringBuffer();
		double planetposition=0;
		ArrayList<Integer> planets = new ArrayList();
		planets.add(SweConst.SE_SUN);
		planets.add(SweConst.SE_MOON);
		planets.add(SweConst.SE_MARS);
		planets.add(SweConst.SE_MERCURY);
		planets.add(SweConst.SE_VENUS);
		planets.add(SweConst.SE_JUPITER);
		planets.add(SweConst.SE_SATURN);
		planets.add(SweConst.SE_MEAN_NODE);				
		/*Temporary variables*/
		double julDay = sweDate.getJulDay();
		double sidetime = swiislib.swe_sidtime(julDay);
				
		/*Print input Details */
		System.out.println(sweDate);
		
		/*Print Sidereal Time*/
		System.out.print("Sidereal Time:");System.out.println(sidetime);
				
		/* Calculate Ascendant */
		double ayansama =swissEph.swe_get_ayanamsa_ut(julDay);
		System.out.print("Ayansama");System.out.println(ayansama);
		
		ayansamaConst =ayansama/100;
		
		int iflagConst = SweConst.SEFLG_SIDEREAL;
		
		int result = swissEph.swe_houses(julDay, iflagConst, lattitude, longitude, houseSys, cusps,acsc);
		
		System.out.println("Cusp"+cusps[0]+"::"+cusps[1]);
		
		System.out.print("Ascendant :"); 	System.out.println(acsc[0]);
		sidetime = acsc[2];
		System.out.print("ARMC/Sidereal Time:");System.out.println(acsc[2]);
		
		/*get the position of ascendant */
		double ascendant = acsc[0];
		int ascPos = (int) (Math.floor(ascendant / 30));
		System.out.println("Ascendant Position: "+ ascPos);
			
		/* Calculate Ecliptic Obliquity as xp[0] */
		int resultnew = swissEph.swe_calc_ut(julDay, SweConst.SE_ECL_NUT, 0, xp, serr);
		System.out.println(xp[0]);
		
		/* calculate position of Planets */
		System.out.println("--------------------------------------------");
		
		double rahupos=0;
		double position =0;
		for(Integer planet:planets){
			String planetName = swissEph.swe_get_planet_name(planet.intValue());
			xp[0]=0;
			System.out.println(serr.toString());
			swissEph.swe_calc_ut(julDay, planet.intValue(), iflagConst, xx, serr);
			position = swissEph.swe_house_pos(sidetime, lattitude, xp[0], houseSys, xx, serr1);
			System.out.println(xx[0]+"\n"+xx[1]+"\n"+xx[2]);
			position=position - ayansamaConst;
			if(planetName.contains("Node")){planetName="Rahu"; rahupos=position;}
			printPlanetPos(ascPos, position, planetName);
			
		}

		/* calculate position of KETU */
		position=rahupos +6;
		position=(position<12)?position:position-12;
		printPlanetPos(ascPos, position, "Ketu");
		System.out.println(serr+"\n"+serr1);
	}

	private static void printPlanetPos(int ascPos, double position,
			String planetName) {
		double planetposition;
		System.out.println(planetName);System.out.print("House Postion From Ascendant  :  ");System.out.println(position);
		planetposition = calPlanetPos(ascPos, position);
		System.out.print(planetName);System.out.print(" Position :  ");System.out.println(planetposition);
		
		System.out.println("--------------");
	}

	private static double calPlanetPos(int ascPos, double position) {
		double planetposition = ascPos*30 + ((int)position-1)*30 + (position-Math.floor(position))*30;
		if(planetposition>360){planetposition = planetposition- 360;}
		return planetposition;
	}
}