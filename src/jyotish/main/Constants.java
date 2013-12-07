package jyotish.main;

/**
 *  Description of the Class
 *
 *@author     Michael W. Taft
 *@created    May 14, 2002
 */
 
import java.util.TimeZone;
public class Constants
{
	/**
	 *  Constructor for the Constants object
	 */
	public Constants() { }
    /*
    static {
        timeZones = TimeZone.getDefault.getAvailableIDs();
    }
    */

	//Sex of native
	/**
	 *  Native is of undetermined sex
	 */
	public static final int NONE = 0;
	/**
	 *  Native is male
	 */
	public static final int MALE = 1;
	/**
	 *  Native is female
	 */
	public static final int FEMALE = 2;

	//Time Zones
	/**
	 *  Description of the Field
	 */
	public static final String[] timeZones = TimeZone.getAvailableIDs();

	/**
	 *  Description of the Field
	 */
	public static final String[] DSToffsets = {"0", "1", "2"};

	//Names of Signs
	/**
	 *  Description of the Field
	 */
	public static final int ARIES = 1;
	/**
	 *  Description of the Field
	 */
	public static final int TAURUS = 2;
	/**
	 *  Description of the Field
	 */
	public static final int GEMINI = 3;
	/**
	 *  Description of the Field
	 */
	public static final int CANCER = 4;
	/**
	 *  Description of the Field
	 */
	public static final int LEO = 5;
	/**
	 *  Description of the Field
	 */
	public static final int VIRGO = 6;
	/**
	 *  Description of the Field
	 */
	public static final int LIBRA = 7;
	/**
	 *  Description of the Field
	 */
	public static final int SCORPIO = 8;
	/**
	 *  Description of the Field
	 */
	public static final int SAGITTARIUS = 9;
	/**
	 *  Description of the Field
	 */
	public static final int CAPRICORN = 10;
	/**
	 *  Description of the Field
	 */
	public static final int AQUARIUS = 11;
	/**
	 *  Description of the Field
	 */
	public static final int PISCES = 12;

	public static final Object[] signNames = {(Object)"Ari", (Object)"Tau", (Object)"Gem", (Object)"Can", (Object)"Leo", (Object)"Vir", (Object)"Lib", (Object)"Sco", (Object)"Sag", (Object)"Cap", (Object)"Aqu", (Object)"Pis"};

	//Names of Planets
	/**
	 *  Description of the Field
	 */
	public static final int SUN = 0;
	/**
	 *  Description of the Field
	 */
	public static final int MOON = 1;
	/**
	 *  Description of the Field
	 */
	public static final int MERCURY = 2;
	/**
	 *  Description of the Field
	 */
	public static final int VENUS = 3;
	//public static final int EARTH = 4;//this is used for heliocentric calculations
	/**
	 *  Description of the Field
	 */
	public static final int MARS = 4;
	/**
	 *  Description of the Field
	 */
	public static final int JUPITER = 5;
	/**
	 *  Description of the Field
	 */
	public static final int SATURN = 6;
	/**
	 *  Description of the Field
	 */
	public static final int URANUS = 7;
	/**
	 *  Description of the Field
	 */
	public static final int NEPTUNE = 8;
	/**
	 *  Description of the Field
	 */
	public static final int PLUTO = 9;
	/**
	 *  Description of the Field
	 */
	public static final int MEAN_RAHU = 10;
	/**
	 *  Description of the Field
	 */
	public static final int TRUE_RAHU = 11;

	///////////////Natural Planetary Relationship//////////////
	// 0 = neutral
	// 1 = friend
	// -1 = enemy
	// 9 = self
	public static final int[] sunRelations = {9,1,1,0,1,-1,-1};
	public static final int[] moonRelations = {1,9,0,1,0,0,0};
	public static final int[] marsRelations = {1,1,9,-1,1,0,0};
	public static final int[] mercuryRelations = {1,-1,0,9,0,1,0};
	public static final int[] jupiterRelations = {1,1,1,-1,9,-1,0};
	public static final int[] venusRelations = {-1,-1,0,1,0,9,1};
	public static final int[] saturnRelations = {-1,-1,-1,1,0,1,9}; 
	/**
	 *  Description of the Field
	 */
	public static final double navamsaDeg = 3 + (1/3);
	/**
	 *  Description of the Field
	 */
	public static final String planetShortNames[] = {"SU", "MO", "ME", "VE", "MA", "JU", "SA", "UR", "NE", "PL", "RA", "KE"};
	/**
	 *  Description of the Field
	 */
	public static final String planetLongNames[] = {"Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Rahu", "Ketu"};
	
	public static final String astakavargaLongNames[] = {"Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Sarva"};
	
	
	/**
	 *  Description of the Field
	 */
	public static final String zodiacShortNames[] = {"Ari", "Tau", "Gem", "Can", "Leo", "Vir", "Lib", "Sco", "Sag", "Cap", "Aqu", "Pis"};
	/**
	 *  Description of the Field
	 */
	public static final String zodiacFullNames[] = {"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"};
	/**
	 *  Description of the Field
	 */
	public static final double nakshatraDeg = (13.0 + 1.0/3.0);
	/**
	 *  Description of the Field
	 */
	public static final String nakshatra[] = {"Ashwini", "Bharani", "Krittika", "Rohini", "Mrigshira", "Ardra", "Punarvasu", "Pushya", "Ashlesha", "Magha", "Purva Phalguni", "Uttara Phalguni", "Hasta", "Chitra", "Swati", "Vishakha", "Anuradha", "Jyestha", "Mula", "Purva Ashadha", "Uttara Ashadha", "Shravana", "Dhanishta", "Satabhisha", "Purva Bhadrapada", "Uttara Bhadrapada", "Revati", "Ashwini"};

	//Chart styles
	/**
	 *  North Indian-style chart
	 */
	public static final int NORTH = 0;
	/**
	 *  South Indian-style chart
	 */
	public static final int SOUTH = 1;

	//Vargas
	public static final int RASI = 0;

	/**
	 *  Description of the Field
	 */
	public static final int HORA = 1;
	//v2
	/**
	 *  Description of the Field
	 */
	public static final int DREKKANA = 2;
	//v3
	/**
	 *  Description of the Field
	 */
	public static final int CHATURTAMSA = 3;
	//v4
	/**
	 *  Description of the Field
	 */
	public static final int PANCHAMSA = 4;
	//v5
	/**
	 *  Description of the Field
	 */
	public static final int ASHTAMSA = 5;
	//v8
	/**
	 *  Description of the Field
	 */
	public static final int SAPTAMSA = 6;
	//v7
	/**
	 *  Description of the Field
	 */
	public static final int NAVAMSA = 7;
	//v9
	/**
	 *  Description of the Field
	 */
	public static final int DASAMSA = 8;
	//v10
	/**
	 *  Description of the Field
	 */
	public static final int DWADASAMSA = 9;
	//v12
	/**
	 *  Description of the Field
	 */
	public static final int SHODASAMSA = 10;
	//v16
	/**
	 *  Description of the Field
	 */
	public static final int VIMSHAMSA = 11;
	//v20
	/**
	 *  Description of the Field
	 */
	public static final int SIDDHAMSA = 12;
	//v24
	/**
	 *  Description of the Field
	 */
	public static final int BHAMSA = 13;
	//v27
	/**
	 *  Description of the Field
	 */
	public static final int TRIMSHAMSA = 14;
	//v30
	/**
	 *  Description of the Field
	 */
	public static final int KHAVEDAMSA = 15;
	//v40
	/**
	 *  Description of the Field
	 */
	public static final int AKSHVEDASAMSA = 16;
	//v45
	/**
	 *  Description of the Field
	 */
	public static final int SHASTIAMSA = 17;
	//v60
    public static final String[] monthNames = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        
	public static final Object[] vargaNames = {(Object)"Rasi", (Object)"Hora", (Object)"Drekkana", (Object)"Chaturtamsa", (Object)"Panchamsa", (Object)"Saptamsa", (Object)"Ashtamsa", (Object)"Navamsa", (Object)"Dasamsa", (Object)"Dwadasamsa", (Object)"Shodasamsa", (Object)"Vimshamsa", (Object)"Siddhamsa", (Object)"Bhamsa", (Object)"Trimshamsa", (Object)"Khavedamsa", (Object)"Akshvedasamsa", (Object)"Shastiamsa"}; 

	public static final Object[] ayanamsaNames = {(Object) "Fagan/Bradley", (Object)"Lahiri", (Object)"Deluce", (Object)"Raman", (Object)"Ushashashi", (Object)"Krishnamurti", (Object)"Dhwaj_Khul", (Object)"Yukteshwar", (Object)"JN_BHASIN"};
	
	public static final String[] ayanamsaStrings = { "Fagan/Bradley", "Lahiri", "Deluce", "Raman", "Ushashashi", "Krishnamurti", "Dhwaj_Khul", "Yukteshwar", "JN_Bhasin"};
	
	
	public static final String[] ascmcValues = {"ascendant", "midheaven", "armc", "vertex", "equitorial_ac", "coascendant_koch", "coascendant_munkasey", "polar_ac", "reserved", "reserved"};
	
	public static final String[] houseSystemStrings = {"Shripati", "Placidus", "Koch", "Alcabitus", "Regiomontanus", "Campanus"};
	
	public static final char[] houseSystemChars = {'O', 'P', 'K', 'A', 'R', 'C'}; //These chars must be keyed to the Strings
	
	
	///These constants specifically for the AstroGadget font.
	public static final String[] planetGlyphs = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
	///These constants specifically for the AstroGadget font.
	public static final String[] signGlyphs = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"};
	
	///These constants specifically for the Astro font.
	public static final String[] simpleSignGlyphs = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
	///These constants specifically for the Astro font.
	public static final String[] simplePlanetGlyphs = {"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "<", ">"};
	
	
	public static final String[] stateAbbr_USA = {"AL", "AK", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"};
	
	public static final String[] stateAbbr_CANADA = {"AB", "BC", "MB", "NB", "NF", "NT", "NS", "NU", "ON", "PE", "QC", "SK", "YT"};
	public static final String[] weekday = {"Sunday","Monday","Tuesday","Wednesday","Thursaday","Friday","Saturday"};
	public static final int[] gulika ={7,6,5,4,3,2,1};
	public static final int[] rahu ={8,2,7,5,6,4,3};
	public static final int[] yamaganda ={5,4,3,2,1,6,7};
	public static final String[] shoolam ={"West","East", "North","North","South","West","East"};
	
	public static final int TYPE_BIRTHCHART =0;
	public static final int TYPE_HORA =1;
	public static final int TYPE_DREKKANNA =2;
	public static final int TYPE_CHATURAMSA =3;
	public static final int TYPE_PANCHAMSA =4;
	public static final int TYPE_SAPTAMSA =5;
	public static final int TYPE_ASHTAMSA =6;
	public static final int TYPE_NAVAMSA =7;
	public static final int TYPE_DASAMSA =8;
	public static final int TYPE_DWADASAMSA =9;
	public static final int TYPE_SHODASAMSA =10;
	public static final int TYPE_VIMSHAMSA=11;
	public static final int TYPE_SIDDHAMSA =12;
	public static final int TYPE_BHAMSA =13;
	public static final int TYPE_TRIMSHAMSA =14;
	public static final int TYPE_KHAVEDAMSA =15;
	public static final int TYPE_AKSHVEDAMSA =16;
	public static final int TYPE_SHASTIAMSA =17;
	
	public static final int TYPE_PANCHANG =20;
	
}

