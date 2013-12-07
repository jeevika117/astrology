package jyotish.main.calc;


import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;

import jyotish.main.TimeRange;

/*
*	Created 25 March, 2003, by Michael W. Taft
*/

public class PanchangBasics 
{
	private String nakshathra,pada,yoga, tithi, karana;
	private GregorianCalendar sunrise, sunset;
	private String sunriseString, sunsetString;
	private String day;
	private double ayanamsa;
	private String rahukal, yamaganda,gulika;
	private int nakshatra_count;
	
	public String getNakshathra() {
		return nakshathra;
	}

	public void setNakshathra(String nakshathra) {
		this.nakshathra = nakshathra;
	}

	public String getPada() {
		return pada;
	}

	public void setPada(String pada) {
		this.pada = pada;
	}

	public void setYoga(String yoga)
	{
		this.yoga = yoga;
	}
	
	public String getYoga()
	{
		return yoga;
	}

	public void setTithi(String tithi)
	{
		this.tithi = tithi;
	}
	
	public String getTithi()
	{
		return tithi;
	}
	
	public void setKarana(String karana)
	{
		this.karana = karana;
	}
	
	public String getKarana()
	{
		return karana;
	}
	
	public void setDay(String day) 
	{
		this.day = day;
	}

	public String getDay() 
	{
		return day;
	}

	
	public void setAyanamsa(double ayan) 
	{
		ayanamsa = ayan;
	}

	public double getAyanamsa() 
	{
		return ayanamsa;
	}
	
	public void setSunrise(GregorianCalendar gc)
	{
		sunrise = gc;
		setSunriseString(sunrise.getTime());
	}
	
	public GregorianCalendar getSunrise()
	{
		
		return sunrise;
	}
	
	public void setSunset(GregorianCalendar gc)
	{
		sunset = gc;
		setSunsetString(gc.getTime());
	}
	
	public GregorianCalendar getSunset()
	{
		
		return sunset;
	}

	public String getRahukal() {
		return rahukal;
	}

	public void setRahukal(String rahukal) {
		this.rahukal = rahukal;
	}

	public String getYamaganda() {
		return yamaganda;
	}

	public void setYamaganda(String yamaganda) {
		this.yamaganda = yamaganda;
	}

	public String getGulika() {
		return gulika;
	}

	public void setGulika(String gulika) {
		this.gulika = gulika;
	}

	public String getSunriseString() {
		return sunriseString;
	}

	public void setSunriseString(String sunriseString) {
		this.sunriseString = sunriseString;
	}
	public void setSunriseString(Date sunrise) {
		DateTime sunriseDT = new DateTime(sunrise);
		this.sunriseString = sunriseDT.toString("HH:mm");
	}

	public String getSunsetString() {
		return sunsetString;
	}

	public void setSunsetString(String sunsetString) {
		this.sunsetString = sunsetString;
	}
	public void setSunsetString(Date sunset) {
		DateTime sunsetDT = new DateTime(sunset);
		this.sunsetString = sunsetDT.toString("HH:mm");
	}

	public int getNakshatra_count() {
		return nakshatra_count;
	}

	public void setNakshatra_count(int nakshatra_count) {
		this.nakshatra_count = nakshatra_count;
	}
}

