package jyotish.main.calc;
import swisseph.SwissEph;
import jyotish.main.FJUtility;
import jyotish.main.HouseData;

public class HouseDataCalculator {
	public static HouseData calculateHouseData(
		SwissEph sw,
		double tjd_ut,
		double lon,
		double lat,
		int iflag,
		char houseSystem) {
		double[] cusp = new double[13];
		double[] ascmc = new double[10];
		
		System.out.println("House System = " + houseSystem);//////////TESTING ONLY
		
//		the actual calculation
		sw.swe_houses(tjd_ut, iflag, lat, lon, houseSystem, cusp, ascmc);
		
		System.out.println("Ascendant = " + FJUtility.zodiacDMS(ascmc[0]));
		HouseData houseData = new HouseData(ascmc, cusp);
		houseData.setHouseSystem(new Character(houseSystem).toString());
		return houseData;
	}
}
