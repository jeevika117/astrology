package jyotish.main;

import java.io.Serializable;
import java.util.HashSet;

import jyotish.main.calc.Astakavarga;
import jyotish.main.calc.PanchangBasics;
import jyotish.main.calc.VargaData;

/**
 *  Description of the Class
 *
 *@author     Michael W. Taft
 *@created    May 14, 2002
 */
public class Chart implements Serializable
{
	private HashSet chartListeners;
	private BirthData nativeInfo2;
	private AllPlanets planetInfo;
	private HouseData houseData;
	private PanchangBasics panchangBasics;
	private VargaData vargaData;
	private Astakavarga aVData;
	
	public Chart() 
	{

	}
	/**
	 *  Constructor for the Chart object
	 *
	 *@param  nativeInfo2  Description of the Parameter
	 */
	public Chart(BirthData nativeInfo2)
	{
		this.nativeInfo2 = nativeInfo2;
	}


	/**
	 *  Sets the nativeInfo2 attribute of the Chart object
	 *
	 *@param  nativeInfo2  The new nativeInfo2 value
	 */
	public void setNativeInfo2(BirthData nativeInfo2)
	{
		this.nativeInfo2 = nativeInfo2;
	}


	/**
	 *  Sets the planetInfo attribute of the Chart object
	 *
	 *@param  planetInfo  The new planetInfo value
	 */
	public void setPlanetInfo(AllPlanets planetInfo)
	{
		this.planetInfo = planetInfo;
	}

	public void setHouseInfo(HouseData houseData)
	{
		this.houseData = houseData;
	}
	
	public void setVargaData(VargaData vargaData)
	{
		this.vargaData = vargaData;
	}

	/**
	 *  Gets the nativeInfo2 attribute of the Chart object
	 *
	 *@return    The nativeInfo2 value
	 */
	public BirthData getNativeInfo2()
	{
		return nativeInfo2;
	}

	public String getChartName()
	{
		return nativeInfo2.getFirstName() + " " + nativeInfo2.getLastName();
	}

	public HouseData getHouseData()
	{
		return houseData;
		
	}
	
	public VargaData getVargaData()
	{
		return vargaData;
	}
	/**
	 *  Gets the planetInfo attribute of the Chart object
	 *
	 *@return    The planetInfo value
	 */
	public AllPlanets getPlanetInfo()
	{
		return planetInfo;
	}

	public int getAscendantSignAsInt()
	{
		double asc = houseData.getAscendant();
		return (int)(asc/30)+1;
	}

	public double getAscendant()
	{
		return houseData.getAscendant();

	}

	public void setPanchangBasics(PanchangBasics panchB)
	{
		panchangBasics = panchB;
	}

	public PanchangBasics getPanchangBasics()
	{
		return panchangBasics;
	}
	
	public void setAstakavarga(Astakavarga av)
	{
		aVData = av;
	}
	
	public Astakavarga getAstakavarga()
	{
		return aVData;
	}


}

