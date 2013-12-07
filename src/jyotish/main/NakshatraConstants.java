package jyotish.main;

import java.util.HashMap;

public class NakshatraConstants {
	
			public static final int ASHWINI =1;
			public static final int BHARANI =2;
			public static final int KRITIKA =3;
			public static final int ROHINI =4;
			public static final int MIRIGAHIRA =5;
			public static final int ARDRA =6;
			public static final int PUNERVASU =7;
			public static final int PUSHYA =8;
			public static final int ASHLESHA =9;
			public static final int MAGHA =10;
			public static final int POORVA_PALGHUNI =11;
			public static final int UTTRA_PALGHUNI =12;
			public static final int HASTA =13;
			public static final int CHITRA =14;
			public static final int SWATI =15;
			public static final int VISHAKA =16;
			public static final int ANURADHA =17;
			public static final int JYESTHA =18;
			public static final int MULA =19;
			public static final int POORVASADHA =20;
			public static final int UTTRRASHDHA =21;
			public static final int SHRAVAN =22;
			public static final int DHANISHTHA =23;
			public static final int SHATBHIISHAJ =24;
			public static final int POORVABHADRRA =25;
			public static final int UTTRABHADRA =26;
			public static final int REVATI =27;
			
			public static final int GANA_DEVA = 2;
			public static final int GANA_MANUSHYA = 1;
			public static final int GANA_RAKSHASA = 0;
			
			public static final String PORUTHAM_UTHAMAM = "Uthamam";
			public static final String PORUTHAM_MADHIYAMAM = "Madhiyamam";
			public static final String PORUTHAM_ATHAMAM = "Athamam";
			
			public static final int ANIMAL_HORSE =0;
			public static final int ANIMAL_ELEPHANT =1;
			public static final int ANIMAL_GOAT =2;
			public static final int ANIMAL_SNAKE =3;
			public static final int ANIMAL_DOG =4;
			public static final int ANIMAL_CAT =5;
			public static final int ANIMAL_RAT =6;
			public static final int ANIMAL_COW =7;
			public static final int ANIMAL_BUFFALO =8;
			public static final int ANIMAL_TIGER =9;
			public static final int ANIMAL_DEER =10;
			public static final int ANIMAL_MONKEY =11;
			public static final int ANIMAL_MONGOOSE =12;
			public static final int ANIMAL_LION =13;
			
						
			
			
			//matrix  x:girl,y:boy
			public static final int[][] YONI_MATCH={
														{4,2,3,2,2,3,3,3,0,1,3,2,2,1},
														{2,4,3,2,2,3,3,3,3,1,3,2,2,0},
														{3,3,4,2,2,3,2,3,3,1,3,0,3,1},
														{2,2,2,4,2,1,1,2,2,2,2,2,0,2},
														{2,2,2,2,4,1,1,2,2,1,0,2,2,1},
														{3,3,3,1,1,4,0,2,2,1,2,2,2,2},
														{3,2,2,2,1,0,4,2,2,2,2,2,2,1},
														{3,2,3,1,2,2,2,4,3,0,2,2,3,1},
														{0,3,3,2,2,2,2,3,4,1,2,2,2,3},
														{1,2,1,2,1,1,2,0,1,4,1,1,2,2},
														{3,3,3,2,0,2,2,3,2,1,4,2,2,2},
														{2,3,0,2,2,2,2,2,2,1,2,4,2,3},
														{2,2,3,0,2,2,2,2,2,2,2,2,4,2},
														{1,0,1,2,1,2,1,1,3,2,2,2,2,4}
													};
			
			public static final int[][] RASI_FRIENDSHIP={
													{9,1,1,0,1,-1,-1,-1,-1},
													{1,9,0,1,0,0,0,-1,-1},
													{1,1,9,-1,1,0,0,-1,-1},
													{1,-1,0,9,0,1,0,0,0},
													{1,1,1,-1,9,-1,0,0,0},
													{-1,-1,0,1,0,9,1,1,1},
													{-1,-1,-1,1,0,1,9,1,1}, 
													{-1,-1,-1,0,0,1,1,9,9}, 
													{-1,-1,-1,0,0,1,1,9,9} 
											};
			
			
			//head=0,Neck=1,Middle=2,Thigh=3,Foot=4
			public static final int[] RAJU_PARTS={
													 4,3,3,1,0,
													 1,2,3,4,4,
													 3,2,1,0,1,
													 2,3,4,4,3,
													 2,1,0,1,2,
													 3,4
													};
}