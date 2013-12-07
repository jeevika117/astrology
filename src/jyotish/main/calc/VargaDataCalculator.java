package jyotish.main.calc;
import jyotish.main.*;

public class VargaDataCalculator
{


	private static int[][] vargaDataArray;
	private static AllPlanets allPlanets;
	private static double ascendant;
	private static VargaData vargaData;


	
	public static VargaData calculateVargaData(AllPlanets allPlanets, double asc)
	{
		
		ascendant = asc;
		vargaDataArray = new int[18][14];
		vargaData = new VargaData(calculateAllVargaPositions(allPlanets));
		
		return vargaData;
		
	}
	
	
	


	private static int[][] calculateAllVargaPositions(AllPlanets allPlanets)
	{
			int varga = 0;		
			switch(varga)
			{
				case 0:
					//System.out.println("Rasi: ");
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						System.out.println(Constants.planetLongNames[i]);
						vargaDataArray[0][i] = getRasi(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						System.out.print(" Rasi Positions: " + vargaDataArray[0][i] + "\n");
					}
					vargaDataArray[0][13] = getRasi(ascendant);
					//System.out.print(" " + vargaDataArray[0][13]);
					//System.out.println("");
				case 1:
					//System.out.println("Hora: ");
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[1][i] =  getHora(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						//System.out.print(" " + vargaDataArray[1][i]);
					}
					vargaDataArray[1][13] = getHora(ascendant); 
					//System.out.println("");
				case 2:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[2][i] = getDrekkana(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[2][13] = getDrekkana(ascendant);
				case 3:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[3][i] = getChaturtamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[3][13] = getChaturtamsa(ascendant);
				case 4:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[4][i] = getPanchamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[4][13] = getPanchamsa(ascendant);
				case 5:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[5][i] = getSaptamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[5][13] = getSaptamsa(ascendant);
				case 6:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[6][i] = getAshtamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[6][13] = getAshtamsa(ascendant);
				case 7:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[7][i] = getNavamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[7][13] = getNavamsa(ascendant); 
				case 8:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[8][i] = getDasamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[8][13] = getDasamsa(ascendant);
				case 9:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[9][i] = getDwadasamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[9][13] = getDwadasamsa(ascendant);
				case 10:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[10][i] = getShodasamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[10][13] = getShodasamsa(ascendant);
				case 11:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[11][i] = getVimshamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[11][13] = getVimshamsa(ascendant);
				case 12:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[12][i] = getSiddhamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[12][13] = getSiddhamsa(ascendant);
				case 13:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[13][i] = getBhamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[13][13] = getBhamsa(ascendant);
				case 14:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[14][i] = getTrimshamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[14][13] = getTrimshamsa(ascendant);
				case 15:
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[15][i] = getKhavedamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						
					}
					vargaDataArray[15][13] = getKhavedamsa(ascendant);
				case 16:
					//System.out.println("Akshvedamsa: ");
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[16][i] = getAkshvedamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						//System.out.print(" " + vargaDataArray[16][i]);
					}
					vargaDataArray[16][13] = getAkshvedamsa(ascendant);
					//System.out.println("");
				case 17:
					//System.out.println("Shatiamsa: ");
					for(int i = 0; i<allPlanets.getSize(); i++)
					{	
						vargaDataArray[17][i] = getShastiamsa(allPlanets.getPlanet(Constants.planetLongNames[i]).getLongitude());
						//System.out.print(" " + vargaDataArray[17][i]);
					}
					vargaDataArray[17][13] = getShastiamsa(ascendant);
					//System.out.println("");


			}

		
		return vargaDataArray;

	}

//Rasi

	public static int getRasi(double deg)
	{
		System.out.println("Degree"+deg);
		int house = (int)(deg/30) + 1;
		return house;

	}

//Hora
	/**
	 *  Gets the hora attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The hora value
	 */
	public static int getHora(double deg)
	{
		//calculates V2 positions

		int house = 0;
		int sign = 0;
		double longit = deg;
		int lg = (int) longit;
		lg = (lg / 30) + 1;
		lg = lg % 2;

		if (lg == 0)
		{
			sign = 0;
		}
		//sign is even
		if (lg > 0)
		{
			sign = 1;
		}
		//sign is odd

		double horaLong = deg;
		int hora = (int) horaLong % 30;

		if (hora < 15 && sign == 0)
		{
			house = 4;
		}
		if (hora < 15 && sign > 0)
		{
			house = 5;
		}
		if (hora >= 15 && sign == 0)
		{
			house = 5;
		}
		if (hora >= 15 && sign > 0)
		{
			house = 4;
		}

		return house;
	}


//Drekkana
	/**
	 *  Gets the drekkana attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The drekkana value
	 */
	public static int getDrekkana(double deg)
	{
		//calculates V3 positions

		int house = 0;

		double longit = deg;
		int lg = (int) longit;
		longit = longit % 30;
		lg = (lg / 30);

		if (0.0 <= longit && longit < 10.0)
		{
			house = lg + 1;
		}
		if (10.0 <= longit && longit < 20.0)
		{
			house = lg + 5;
		}
		if (20.0 <= longit && longit <= 30.0)
		{
			house = lg + 9;
		}

		house = house % 12;
		if (house == 0)
		{
			house = 12;
		}

		return house;
	}


//Chaturtamsa
	/**
	 *  Gets the chaturtamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The chaturtamsa value
	 */
	public static int getChaturtamsa(double deg)
	{
		//calculates V4 positions

		int house = 0;
		double loc = deg;
		double signLoc = loc % 30;
		int x = 0;
		int startSign = (int) (loc / 30) + 1;
		final double chat = 7.5;
		for (int i = 0; i < 4; i++)
		{
			if ((i * chat) <= signLoc && signLoc < (i + 1) * chat)
			{
				x = (int) i + 1;
				break;
			}

		}
		switch (x)
		{
						case 1:
							house = startSign;
							break;
						case 2:
							house = startSign + 3;
							break;
						case 3:
							house = startSign + 6;
							break;
						case 4:
							house = startSign + 9;
							break;
		}
		house = house % 12;
		if (house == 0)
		{
			house = 12;
		}

		return house;
	}


///Panchamsa
	/**
	 *  Gets the panchamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The panchamsa value
	 */
	public static int getPanchamsa(double deg)
	{
		//calculates V5 positions

		int house = 0;
		int x = 0;
		double panch = 6.0;
		double signLoc = deg % 30;
		//gives it's location within a 30 degree arc
		int startSign = (int) (deg / 30) + 1;
		//tells which sign it's in
		for (int i = 0; i < 5; i++)
		{

			if ((i * panch) <= signLoc && signLoc < (i + 1) * panch)
			{
				x = (int) i;
				break;
			}

		}
		switch (startSign)
		{
						case 1:
						case 4:
						case 7:
						case 10:
							house = startSign + x;
							break;
						case 2:
						case 5:
						case 8:
						case 11:
							house = startSign + 4 + x;
							break;
						case 3:
						case 6:
						case 9:
						case 12:
							house = startSign + 8 + x;
							break;
		}
		house = house % 12;
		if (house == 0)
		{
			house = 12;
		}
		return house;
	}


	//Saptamsa
	/**
	 *  Gets the saptamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The saptamsa value
	 */
	public static int getSaptamsa(double deg)
	{
		//calculates V7 positions

		int house = 0;

		double longit = deg;
		int lg = (int) longit;
		lg = (lg / 30) + 1;
		//shows what sign it's in
		int oddEven = lg % 2;
		//sign is odd or even
		int sapt = (int) longit % 30;
		final double saptDiv = 4.2857138;

		int x = 0;
		double i = 0;
		for (i = 0; i <= 7; i++)
		{
			if ((i * saptDiv) <= sapt && sapt < ((i + 1) * saptDiv))
			{
				x = (int) i;
				break;
			}

		}

		if (oddEven > 0)
		{
			house = (lg + x) % 12;
		}
		//sign is odd
		if (oddEven == 0)
		{
			house = (lg + 6 + x) % 12;
		}
		//sign is even

		return house;
	}


///Ashtamsa
	/**
	 *  Gets the ashtamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The ashtamsa value
	 */
	public static int getAshtamsa(double deg)
	{
		//calculates V8 positions

		int house = 0;
		int x = 0;
		double ashta = 3.75;
		double signLoc = deg % 30;
		//gives it's location within a 30 degree arc
		int startSign = (int) (deg / 30) + 1;
		//tells which sign it's in
		for (int i = 0; i < 8; i++)
		{

			if ((i * ashta) <= signLoc && signLoc < (i + 1) * ashta)
			{
				x = i;
			}
			break;
		}
		switch (startSign)
		{
						case 1:
						case 4:
						case 7:
						case 10:
							house = 1 + x;
							break;
						case 2:
						case 5:
						case 8:
						case 11:
							house = 9 + x;
							break;
						case 3:
						case 6:
						case 9:
						case 12:
							house = 5 + x;
							break;
		}
		house = house % 12;
		if (house == 0)
		{
			house = 12;
		}
		return house;
	}


//Navamsa
	/**
	 *  Gets the navamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The navamsa value
	 */
	public static int getNavamsa(double deg)
	{
		//calculates V9 positions

		int house = 0;
		int x = 0;
		double nav = 3.33333333333;
		double signLoc = deg % 30;
		//gives it's location within a 30 degree arc
		int startSign = (int) (deg / 30) + 1;
		//tells which sign it's in
		for (int i = 0; i < 30; i++)
		{

			if ((i * nav) <= signLoc && signLoc < (i + 1) * nav)
			{
				x = (int) i;
				//System.out.println("X = " + x);
				break;
			}
		}
		switch (startSign)
		{
						case 1:
						case 4:
						case 7:
						case 10:
							house = startSign + x;
							break;
						case 2:
						case 5:
						case 8:
						case 11:
							house = startSign + 8 + x;
							break;
						case 3:
						case 6:
						case 9:
						case 12:
							house = startSign + 4 + x;
							break;
		}
		house = house % 12;
		if (house == 0)
		{
			house = 12;
		}
		return house;

	}


//Dasamasa
	/**
	 *  Gets the dasamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The dasamsa value
	 */
	public static int getDasamsa(double deg)
	{
		//calculates V10 positions

		int house = 0;
		double longit = deg;
		int lg = (int) longit;
		lg = (lg / 30) + 1;
		//shows what sign it's in
		int oddEven = lg % 2;
		//sign is odd or even
		int dasa = (int) longit % 30;

		int x = 0;
		double i = 0;
		for (i = 0; i <= 10; i++)
		{
			if ((i * 3) <= dasa && dasa < ((i + 1) * 3))
			{
				x = (int) i;
				break;
			}

		}

		if (oddEven > 0)
		{
			house = (lg + x) % 12;
		}
		//sign is odd
		if (oddEven == 0)
		{
			house = (lg + 8 + x) % 12;
		}
		//sign is even
		if (house == 0)
		{
			house = 12;
		}
		return house;
	}


//Dwadasamsa
	/**
	 *  Gets the dwadasamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The dwadasamsa value
	 */
	public static int getDwadasamsa(double deg)
	{
		//calculates V12 positions

		int house = 0;
		double longit = deg;
		int lg = (int) longit;
		lg = (lg / 30) + 1;
		//shows what sign it's in
		int dwa = (int) longit % 30;
		final double dwaDiv = 2.5;

		int x = 0;
		double i = 0;
		for (i = 0; i <= 12; i++)
		{
			if ((i * dwaDiv) <= dwa && dwa < ((i + 1) * dwaDiv))
			{
				x = (int) i;
				break;
			}

		}

		house = (lg + x) % 12;
		if (house == 0)
		{
			house = 12;
		}

		return house;
	}


//Shodasamsa
	/**
	 *  Gets the shodasamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The shodasamsa value
	 */
	public static int getShodasamsa(double deg)
	{
		//calculates V16 positions
		int house = 0;
		int startSign = 0;
		double shoDas = 1.875;
		double longit = deg;
		int lg = (int) longit;
		lg = (lg / 30) + 1;
		//shows what sign it's in

		double position = longit % 30;

		int x = 0;
		double i = 0;
		for (i = 0; i <= 16; i++)
		{
			if ((i * shoDas) <= position && position < ((i + 1) * shoDas))
			{
				x = (int) i;
				break;
			}

		}

		switch (lg)
		{
						case 1:
						case 4:
						case 7:
						case 10:
							startSign = 1;
							break;
						case 2:
						case 5:
						case 8:
						case 11:
							startSign = 5;
							break;
						case 3:
						case 6:
						case 9:
						case 12:
							startSign = 9;
							break;
		}
		//if (lg == 1 || lg == 4 || lg == 7 || lg == 10) startSign = 1;
		//else if (lg == 2 || lg == 5 || lg == 8 || lg == 11) startSign = 5;
		//else if (lg == 3 || lg == 6 || lg == 9 || lg == 12) startSign = 9;

		house = (startSign + x) % 12;
		if (house == 0)
		{
			house = 12;
		}

		return house;

	}



//Vimshamsa
	/**
	 *  Gets the vimshamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The vimshamsa value
	 */
	public static int getVimshamsa(double deg)
	{
		//calculates V20 positions

		int house = 0;
		double loc = deg;
		double signLoc = loc % 30;
		int x = 0;
		int startSign = (int) (loc / 30) + 1;
		final double vim = 1.5;
		for (int i = 0; i < 20; i++)
		{
			if ((i * vim) <= signLoc && signLoc < (i + 1) * vim)
			{
				x = (int) i;
				break;
			}

		}
		switch (startSign)
		{
						case 1:
						case 4:
						case 7:
						case 10:
							house = 1 + x;
							break;
						case 2:
						case 5:
						case 8:
						case 11:
							house = 9 + x;
							break;
						case 3:
						case 6:
						case 9:
						case 12:
							house = 5 + x;
							break;
		}
		house = house % 12;
		if (house == 0)
		{
			house = 12;
		}

		return house;
	}


//Siddhamsa
	/**
	 *  Gets the siddhamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The siddhamsa value
	 */
	public static int getSiddhamsa(double deg)
	{
		//calculates V24 positions

		int house = 0;
		double loc = deg;
		double signLoc = loc % 30;
		int x = 0;
		int startSign = (int) (loc / 30) + 1;
		int oddEven = startSign % 2;
		//System.out.println("oddEven = " + oddEven);
		final double sid = 1.25;
		for (int i = 0; i < 24; i++)
		{
			if ((i * sid) <= signLoc && signLoc < (i + 1) * sid)
			{
				x = (int) i;
				break;
			}

		}
		switch (oddEven)
		{
						case 0:
							house = 4 + x;
							break;
						case 1:
							house = 5 + x;
							break;
		}
		house = house % 12;
		if (house == 0)
		{
			house = 12;
		}

		return house;
	}


//Bhamsa
	/**
	 *  Gets the bhamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The bhamsa value
	 */
	public static int getBhamsa(double deg)
	{
		//calculates V27 positions

		int house = 0;
		double loc = deg;
		double signLoc = loc % 30;
		int x = 0;
		int startSign = (int) (loc / 30) + 1;

		final double bha = 1.111111111111;
		for (int i = 0; i < 27; i++)
		{
			if ((i * bha) <= signLoc && signLoc < (i + 1) * bha)
			{
				x = i;
				break;
			}

		}
		switch (startSign)
		{
						case 1:
						//Fire signs
						case 5:
						case 9:
							house = 1 + x;
							break;
						case 2:
						//Earth signs
						case 6:
						case 10:
							house = 4 + x;
							break;
						case 3:
						//Air signs
						case 7:
						case 11:
							house = 7 + x;
							break;
						case 4:
						//Water signs
						case 8:
						case 12:
							house = 10 + x;
							break;
		}
		house = house % 12;
		if (house == 0)
		{
			house = 12;
		}

		return house;
	}


//Trimshamsa

	/**
	 *  Gets the trimshamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The trimshamsa value
	 */
	public static int getTrimshamsa(double deg)
	{
		//Calculates V30 positions
		int house = 0;

		double longit = deg;
		int lg = (int) longit;
		lg = (lg / 30) + 1;
		//shows what sign it's in
		int oddEven = lg % 2;
		//sign is odd or even
		double trim = longit % 30;

		int x = 0;
		double i = 0;
		for (i = 0; i <= 30; i++)
		{
			if (i <= trim && trim < (i + 1))
			{
				x = (int) i;
				break;
			}

		}

		if (oddEven > 0)
		{
			//sign is odd

			if (x < 5)
			{
				house = 1;
			}
			else if (5 <= x && x < 10)
			{
				house = 11;
			}
			else if (10 <= x && x < 18)
			{
				house = 9;
			}
			else if (18 <= x && x < 25)
			{
				house = 3;
			}
			else if (25 <= x && x < 30)
			{
				house = 7;
			}

		}

		else if (oddEven == 0)
		{
			//sign is even

			if (x < 5)
			{
				house = 2;
			}
			else if (5 <= x && x < 12)
			{
				house = 6;
			}
			else if (12 <= x && x < 20)
			{
				house = 12;
			}
			else if (20 <= x && x < 25)
			{
				house = 10;
			}
			else if (25 <= x && x < 30)
			{
				house = 8;
			}

		}

		return house;
	}


	//Khavedamsa
	/**
	 *  Gets the khavedamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The khavedamsa value
	 */
	public static int getKhavedamsa(double deg)
	{
		//calculates V40 positions

		int house = 0;
		double loc = deg;
		double signLoc = loc % 30;
		int x = 0;
		int startSign = (int) (loc / 30) + 1;
		int oddEven = startSign % 2;
		final double kha = 0.75;
		for (int i = 0; i < 40; i++)
		{
			if ((i * kha) <= signLoc && signLoc < (i + 1) * kha)
			{
				x = i;
			}

		}
		switch (oddEven)
		{
						case 0:
							//Even signs

							house = 7 + x;
							break;
						case 1:
							//Odd signs

							house = 1 + x;
							break;
		}
		house = house % 12;
		if (house == 0)
		{
			house = 12;
		}
		return house;
	}



//Akshvedamsa
	/**
	 *  Gets the akshvedamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The akshvedamsa value
	 */
	public static int getAkshvedamsa(double deg)
	{
		//calculates V45 positions

		int house = 0;
		double loc = deg;
		double signLoc = loc % 30;
		int x = 0;
		int startSign = (int) (loc / 30) + 1;

		final double aksh = 0.666666666667;
		for (int i = 0; i < 45; i++)
		{
			if ((i * aksh) <= signLoc && signLoc < (i + 1) * aksh)
			{
				x = i;
			}

		}
		switch (startSign)
		{
						case 1:
						//Moveable signs
						case 4:
						case 7:
						case 10:
							house = 1 + x;
							break;
						case 2:
						//Fixed signs
						case 5:
						case 8:
						case 11:
							house = 5 + x;
							break;
						case 3:
						//Dual signs
						case 6:
						case 9:
						case 12:
							house = 9 + x;
							break;

		}
		house = house % 12;
		if (house == 0)
		{
			house = 12;
		}

		return house;
	}


//Shastiamsa
	/**
	 *  Gets the shastiamsa attribute of the Vargas class
	 *
	 *@param  deg  Description of the Parameter
	 *@return      The shastiamsa value
	 */
	public static int getShastiamsa(double deg)
	{
		//calculates V60 positions
		int house = 0;
		double position = deg;
		
		double posit2 = position * 2;
		int pos = (int) posit2;
		int lg = (int) position;
		lg = (lg / 30) + 1;
		//shows what sign it's in
		house = (lg + pos) % 12;
		if (house == 0)
		{
			house = 12;
		}
		
		
		return house;
	}

}






