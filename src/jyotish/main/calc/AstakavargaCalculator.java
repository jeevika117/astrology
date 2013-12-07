/*ASTAKAVARGA CALCULATIONS - 18 June, 2001 Michael W. Taft

//Calculates the AV points for each planet, and the sarva AV points.

//Assumes input of planets in houses AS ARRAY INDICES, i.e. the lagna is house 0,

//and so on up to house 11. Specifically:

//Ascendant = 0

//Second house/sign = 1

//Third house/sign = 2

//Fourth house/sign = 3

//Fifth house/sign = 4

//Sixth house/sign = 5

//Seventh house/sign = 6

//Eighth house/sign = 7

//Ninth house/sign = 8

//Tenth house/sign = 9

//Eleventh house/sign = 10

//Twelth house/sign = 11

//

//So, for example, if Mars is in the fifth house, int Mars = 4

//

//THIS VERSION IS VAHARAMIRA

//

//Returns number of points in each house.

//Tested. Functions perfectly

*/

package jyotish.main.calc;



public class AstakavargaCalculator

{





   //private static int sun, moon, merc, venus, mars, jupiter, saturn, lagna;

    private static int[] sunTotal;

    private static int[] moonTotal;

    private static int[] mercTotal;

    private static int[] venusTotal;

    private static int[] marsTotal;

    private static int[] jupiterTotal;

    private static int[] saturnTotal;

    private static int[] sarvaTotal;



public static final int sunPoints[][] =

{   {1,1,0,1,0,0,1,1,1,1,1,0},//sun

    {0,0,1,0,0,1,0,0,0,1,1,0},//moon

    {0,0,1,0,1,1,0,0,1,1,1,1},//merc

    {0,0,0,0,0,1,1,0,0,0,0,1},//venus

    {1,1,0,1,0,0,1,1,1,1,1,0},//mars

    {0,0,0,0,1,1,0,0,1,0,1,0},//jupiter

    {1,1,0,1,0,0,1,1,1,1,1,0},//saturn

    {0,0,1,1,0,1,0,0,0,1,1,1}};//lagna





public static final int moonPoints[][]=

{   {0,0,1,0,0,1,1,1,0,1,1,0},//sun

    {1,0,1,0,0,1,1,0,0,1,1,0},//moon

    {1,0,1,1,1,0,1,1,0,1,1,0},//merc

    {0,0,1,1,1,0,1,0,1,1,1,0},//venus

    {0,1,1,0,1,1,0,0,1,1,1,0},//mars

    {1,0,0,1,0,0,1,1,0,1,1,1},//jupiter

    {0,0,1,0,1,1,0,0,0,0,1,0},//saturn

    {0,0,1,0,0,1,0,0,0,1,1,0}};//lagna



public static final int mercPoints[][] =

{   {0,0,0,0,1,1,0,0,1,0,1,1},//sun

    {0,1,0,1,0,1,0,1,0,1,1,0},//moon

    {1,0,1,0,1,1,0,0,1,1,1,1},//merc

    {1,1,1,1,1,0,0,1,1,0,1,0},//venus

    {1,1,0,1,0,0,1,1,1,1,1,0},//mars

    {0,0,0,0,0,1,0,1,0,0,1,1},//jupiter

    {1,1,0,1,0,0,1,1,1,1,1,0},//saturn

    {1,1,0,1,0,1,0,1,0,1,1,0}};//lagna



public static final int venusPoints[][] =

{   {0,0,0,0,0,0,0,1,0,0,1,1},//sun

    {1,1,1,1,1,0,0,1,1,0,1,1},//moon

    {0,0,1,0,1,1,0,0,1,0,1,0},//merc

    {1,1,1,1,1,0,0,1,1,1,1,0},//venus

    {0,0,1,0,1,1,0,0,1,0,1,1},//mars

    {0,0,0,0,1,0,0,1,1,1,1,0},//jupiter

    {0,0,1,1,1,0,0,1,1,1,1,0},//saturn

    {1,1,1,1,1,0,0,1,1,0,1,0}};//lagna



public static final int marsPoints[][] =

{   {0,0,1,0,1,1,0,0,0,1,1,0},//sun

    {0,0,1,0,0,1,0,0,0,0,1,0},//moon

    {0,0,1,0,1,1,0,0,0,0,1,0},//merc

    {0,0,0,0,0,1,0,1,0,0,1,1},//venus

    {1,1,0,1,0,0,1,1,0,1,1,0},//mars

    {0,0,0,0,0,1,0,0,0,1,1,1},//jupiter

    {1,0,0,1,0,0,1,1,1,1,1,0},//saturn

    {1,0,1,0,0,1,0,0,0,1,1,0}};//lagna



public static final int jupiterPoints[][] =

{   {1,1,1,1,0,0,1,1,1,1,1,0},//sun

    {0,1,0,0,1,0,1,0,1,0,1,0},//moon

    {1,1,0,1,1,1,0,0,1,1,1,0},//merc

    {0,1,0,0,1,1,0,0,1,1,1,0},//venus

    {1,1,0,1,0,0,1,1,0,1,1,0},//mars

    {1,1,1,1,0,0,1,1,0,1,1,0},//jupiter

    {0,0,1,0,1,1,0,0,0,0,0,1},//saturn

    {1,1,0,1,1,1,1,0,1,1,1,0}};//lagna



public static final int saturnPoints[][] =

{   {1,1,0,1,0,0,1,1,0,1,1,0},//sun

    {0,0,1,0,0,1,0,0,0,0,1,0},//moon

    {0,0,0,0,0,1,0,1,1,1,1,1},//merc

    {0,0,0,0,0,1,0,0,0,0,1,1},//venus

    {0,0,1,0,1,1,0,0,0,1,1,1},//mars

    {0,0,0,0,1,1,0,0,0,0,1,1},//jupiter

    {0,0,1,0,1,1,0,0,0,0,1,0},//saturn

    {1,0,1,1,0,1,0,0,0,1,1,0}};//lagna

    

    

public Astakavarga calculateAstakavarga(VargaData vargaData)

{
	//NOTE: The -1 added to each value is to change the value to any array index value (which starts with zero, not one).
	int sun = vargaData.getVargaData()[0][0]-1;

	int moon = vargaData.getVargaData()[0][1]-1;

	int merc  = vargaData.getVargaData()[0][2]-1;

	int venus  = vargaData.getVargaData()[0][3]-1;

	int mars = vargaData.getVargaData()[0][4]-1;

	int jupiter  = vargaData.getVargaData()[0][5]-1;

	int saturn  = vargaData.getVargaData()[0][6]-1;

	int lagna  = vargaData.getVargaData()[0][13]-1;
	

	Astakavarga av = new Astakavarga(getAVTable(sun,moon,merc,venus,mars,jupiter,saturn,lagna));

	

	return av;

	

}



public static int[] getSunAV(int sun, int moon, int merc, int venus, int mars, int jupiter,

int saturn, int lagna)//works perfectly

{

int[] start = {sun,moon,merc,venus,mars,jupiter,saturn,lagna};

sunTotal = new int[12];





for (int i = 0;i<8;i++)//iterate through each planet

{   int z = start[i];

    for (int j = 0;j<12;j++)//get all twelve houses of that planet

    {

        int r = z + j;

        if(r>11){r=r-12;}

        sunTotal[r] = sunTotal[r] + sunPoints[i][j];
	
    }

}



return sunTotal;



}



public static int[] getMoonAV(int sun, int moon, int merc, int venus, int mars, int jupiter,

int saturn, int lagna)//works perfectly

{

int[] start = {sun,moon,merc,venus,mars,jupiter,saturn,lagna};

moonTotal = new int[12];





for (int i = 0;i<8;i++)//iterate through each planet

{   int z = start[i];

    for (int j = 0;j<12;j++)//get all twelve houses of that planet

    {

        int r = z + j;

        if(r>11){r=r-12;}

        moonTotal[r] = moonTotal[r] + moonPoints[i][j];}



}



return moonTotal;



}



public static int[] getMercAV(int sun, int moon, int merc, int venus, int mars, int jupiter,

int saturn, int lagna)//works perfectly

{

int[] start = {sun,moon,merc,venus,mars,jupiter,saturn,lagna};

mercTotal = new int[12];





for (int i = 0;i<8;i++)//iterate through each planet

{   int z = start[i];

    for (int j = 0;j<12;j++)//get all twelve houses of that planet

    {

        int r = z + j;

        if(r>11){r=r-12;}

        mercTotal[r] = mercTotal[r] + mercPoints[i][j];}



}



return mercTotal;



}

public static int[] getVenusAV(int sun, int moon, int merc, int venus, int mars, int jupiter,

int saturn, int lagna)//works perfectly

{

int[] start = {sun,moon,merc,venus,mars,jupiter,saturn,lagna};

venusTotal = new int[12];





for (int i = 0;i<8;i++)//iterate through each planet

{   int z = start[i];

    for (int j = 0;j<12;j++)//get all twelve houses of that planet

    {

        int r = z + j;

        if(r>11){r=r-12;}

        venusTotal[r] = venusTotal[r] + venusPoints[i][j];}



}



return venusTotal;



}

public static int[] getMarsAV(int sun, int moon, int merc, int venus, int mars, int jupiter,

int saturn, int lagna)//works perfectly

{

int[] start = {sun,moon,merc,venus,mars,jupiter,saturn,lagna};

marsTotal = new int[12];





for (int i = 0;i<8;i++)//iterate through each planet

{   int z = start[i];

    for (int j = 0;j<12;j++)//get all twelve houses of that planet

    {

        int r = z + j;

        if(r>11){r=r-12;}

        marsTotal[r] = marsTotal[r] + marsPoints[i][j];}



}



return marsTotal;



}



public static int[] getJupiterAV(int sun, int moon, int merc, int venus, int mars, int jupiter,

int saturn, int lagna)//works perfectly

{

int[] start = {sun,moon,merc,venus,mars,jupiter,saturn,lagna};

jupiterTotal = new int[12];





for (int i = 0;i<8;i++)//iterate through each planet

{   int z = start[i];

    for (int j = 0;j<12;j++)//get all twelve houses of that planet

    {

        int r = z + j;

        if(r>11){r=r-12;}

        jupiterTotal[r] = jupiterTotal[r] + jupiterPoints[i][j];}



}



return jupiterTotal;



}

public static int[] getSaturnAV(int sun, int moon, int merc, int venus, int mars, int jupiter,

int saturn, int lagna)//works perfectly

{

int[] start = {sun,moon,merc,venus,mars,jupiter,saturn,lagna};

saturnTotal = new int[12];





for (int i = 0;i<8;i++)//iterate through each planet

{   int z = start[i];

    for (int j = 0;j<12;j++)//get all twelve houses of that planet

    {

        int r = z + j;

        if(r>11){r=r-12;}

        saturnTotal[r] = saturnTotal[r] + saturnPoints[i][j];}



}



return saturnTotal;



}



public static int[] getSarvaAV(int sun, int moon, int merc, int venus, int mars, int jupiter,

int saturn, int lagna)

{

int[] start = {sun,moon,merc,venus,mars,jupiter,saturn,lagna};

sarvaTotal = new int[12];

int[][]holdPoints;





getSunAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getMoonAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getMercAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getVenusAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getMarsAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getJupiterAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getSaturnAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

for (int i=0;i<12;i++)

{sarvaTotal[i] = sunTotal[i]+ moonTotal[i]+ mercTotal[i]+ venusTotal[i]+

marsTotal[i] + jupiterTotal[i] + saturnTotal[i];}



return sarvaTotal;



}



public static int[][] getAVTable(int sun, int moon, int merc, int venus, int mars, int jupiter, int saturn, int lagna)

{

	int[][] avTable = new int[8][12];

getSunAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getMoonAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getMercAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getVenusAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getMarsAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getJupiterAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getSaturnAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);

getSarvaAV(sun,moon,merc,venus,mars,jupiter,saturn,lagna);


System.arraycopy(sunTotal, 0, avTable[0], 0, sunTotal.length);
System.arraycopy(moonTotal, 0, avTable[1], 0, moonTotal.length);
System.arraycopy(mercTotal, 0, avTable[2], 0, mercTotal.length);
System.arraycopy(venusTotal, 0, avTable[3], 0, venusTotal.length);
System.arraycopy(marsTotal, 0, avTable[4], 0, marsTotal.length);
System.arraycopy(jupiterTotal, 0, avTable[5], 0, jupiterTotal.length);
System.arraycopy(saturnTotal, 0, avTable[6], 0, saturnTotal.length);
System.arraycopy(sarvaTotal, 0, avTable[7], 0, sarvaTotal.length);

///TESTING ONLY/////

/*for(int column = 0; column<12; column++)
	{
		System.out.println("SUN AV value at "  + column + " is : " + sunTotal[column]);
	}

for (int row = 0; row<8; row++)
{
System.out.println("AV for " + Constants.planetLongNames[row]);
	for(int column = 0; column<12; column++)
	{
		System.out.println("AV value at " + row + ":" + column + " is : " + avTable[row][column]);
	}
	
}*/

return avTable;

}





}