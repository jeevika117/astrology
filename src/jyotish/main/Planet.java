package jyotish.main;
import java.io.Serializable;
public class Planet implements Serializable
{
	//private PlanetData data;
	private String planetName;
	private int planetNumber;
	private double longitude;
	private double latitude;
	private double velocity;
	//private String nakshatra;
	//private int pada;
	public Planet()
	{}
	public Planet(String planetName, int planetNumber)
	{
		//this.data = data;
		this.planetName = planetName;
		this.planetNumber = planetNumber;
	}

	/*public PlanetData getPlanetData()
	{
		return data;
	}*/

	public void setLongitude(double lon)
	{
		longitude = lon;
	}
	public double getLongitude()
	{
		return longitude;
	}
	public int getLongitudeAsInt()
	{	
		return (int)(longitude/30)+1;
	}

	public void setLatitude(double lat)
	{
		latitude = lat;
	}
	public double getLatitude()
	{
		return latitude;
	}
	public void setVelocity(double vel)
	{
		velocity = vel;
	}
	public double getVelocity()
	{
		return velocity;
	}

	public String getVelocityString()	
	{
		return ""+ velocity;
	}

	public void setPlanetName(String name)
	{
		planetName = name;
	}
	public String getPlanetName()
	{
		return planetName;
	}
	
	public void setPlanetNumber(int n)
	{
		planetNumber =n;
	}
	
	public int getPlanetNumber()
	{
		return planetNumber;
	}

	public String getNakshatra()
	{
		return FJUtility.getNakshatra(longitude);
	}

	public String getPada()
	{
		return FJUtility.getPada(longitude);
	}

	public String getNakshatraAndPada()
	{
		return FJUtility.getNakshatra(longitude)+ ", p." + FJUtility.getPada(longitude);
	}

	public String getRetrograde()
	{
		if(velocity<0)return "R";
		else if(velocity>=0)return "";
		else return"";
	}

}
