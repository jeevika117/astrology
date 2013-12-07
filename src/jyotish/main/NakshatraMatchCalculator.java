package jyotish.main;

public class NakshatraMatchCalculator {
	
	private IndividualStar boyStar ;
	private IndividualStar girlStar;
	private int boystarNo;
	private int girlstarNo;
	private int starDiff;
	private int rasiDiff;
	
	public NakshatraMatchCalculator(int girlstar, int boystar) {
		starDiff =boystarNo-girlstarNo;
		if(starDiff<0){
			starDiff=starDiff+27;
		}
	}
	
	// Porutham No 1
	public Match calculateDinam(){
		
		Match match = new Match();
		
		if(starDiff==0){
			switch(boystarNo){
			
			case NakshatraConstants.ROHINI:
				
			case NakshatraConstants.ARDRA:
				
			case NakshatraConstants.MAGHA:
				
			case NakshatraConstants.VISHAKA:
				
			case NakshatraConstants.SHRAVAN:
				
			case NakshatraConstants.HASTA:
				
			case NakshatraConstants.UTTRRASHDHA:
				
			case NakshatraConstants.REVATI:
				match.setMatch(NakshatraConstants.PORUTHAM_MADHIYAMAM);
				break;
			default:
				match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
				break;
			}
			
		}
		
		else if(starDiff==2 ||
				starDiff==4 ||
				starDiff==6 ||
				starDiff==8 ||
				starDiff==9 ||
				starDiff==11 ||
				starDiff==13 ||
				starDiff==15 ||
				starDiff==18 ||
				starDiff==20 ||
				starDiff==24 ||
				starDiff==26 ){
			match.setMatch(NakshatraConstants.PORUTHAM_UTHAMAM);
		}
		else{
			match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
		}
		match.setDescription("The presence of Dina Koota agreement ensures that the husband and wife remain healthy and" +
				" free from all sorts of diseases and will enjoy all comforts and a long lease of life.");
		match.setScore(calculateScore(match));
		return match;
	}
	
	// Porutham No 2
	public Match calculateGanam(){
		Match match = new Match();
		int boyGana = getGana(boystarNo);
		int girlGana= getGana(girlstarNo);
		if(boyGana==girlGana && boyGana !=NakshatraConstants.GANA_RAKSHASA ){
			match.setMatch(NakshatraConstants.PORUTHAM_UTHAMAM);
		}
		else if(girlGana==NakshatraConstants.GANA_RAKSHASA){
			match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
		}
		else {
			match.setMatch(NakshatraConstants.PORUTHAM_MADHIYAMAM);
		}
		calculateScore(match);
		return match;
	}

	private int getGana(int star) {
		if( star==NakshatraConstants.ASHWINI ||
				star==NakshatraConstants.MIRIGAHIRA ||
						star==NakshatraConstants.PUNERVASU ||
								star==NakshatraConstants.PUSHYA ||
										star==NakshatraConstants.HASTA ||
												star==NakshatraConstants.SWATI ||
														star==NakshatraConstants.ANURADHA ||
																star==NakshatraConstants.SHRAVAN ||
																		star==NakshatraConstants.REVATI){
			 return NakshatraConstants.GANA_DEVA;
		}
		else if(star==NakshatraConstants.BHARANI ||
				star==NakshatraConstants.ROHINI ||
						star==NakshatraConstants.ARDRA ||
								star==NakshatraConstants.POORVA_PALGHUNI ||
										star==NakshatraConstants.UTTRA_PALGHUNI ||
												star==NakshatraConstants.POORVASADHA ||
														star==NakshatraConstants.UTTRRASHDHA ||
																star==NakshatraConstants.POORVABHADRRA ||
																		star==NakshatraConstants.UTTRABHADRA){
			return NakshatraConstants.GANA_MANUSHYA;
		}
		else{
			return NakshatraConstants.GANA_RAKSHASA;
		}
	}
	

	// Porutham No 3
	public Match calculateYoni(){
		Match match = new Match();
		boyStar.setYoniAnimal(getYoni(boystarNo));
		girlStar.setYoniAnimal(getYoni(girlstarNo));
		match.setScore(NakshatraConstants.YONI_MATCH[girlStar.getYoniAnimal()][boyStar.getYoniAnimal()]);
		calculatePorutham(match);
		return match;
	}
	
	private int getYoni(int starNo) {
		if(boystarNo==NakshatraConstants.ASHWINI ||
				boystarNo==NakshatraConstants.SHATBHIISHAJ){
			return NakshatraConstants.ANIMAL_HORSE;
		}
		else if(boystarNo==NakshatraConstants.KRITIKA ||
				boystarNo==NakshatraConstants.PUSHYA){
			return NakshatraConstants.ANIMAL_GOAT;
		}
		else if(boystarNo==NakshatraConstants.MIRIGAHIRA ||
				boystarNo==NakshatraConstants.ROHINI){
			return NakshatraConstants.ANIMAL_SNAKE;
		}
		else if(boystarNo==NakshatraConstants.PUNERVASU ||
				boystarNo==NakshatraConstants.ASHLESHA){
			return NakshatraConstants.ANIMAL_CAT;
		}
		else if(boystarNo==NakshatraConstants.POORVA_PALGHUNI ||
				boystarNo==NakshatraConstants.MAGHA){
			return NakshatraConstants.ANIMAL_RAT;
		}
		else if(boystarNo==NakshatraConstants.HASTA ||
				boystarNo==NakshatraConstants.SWATI){
			return NakshatraConstants.ANIMAL_BUFFALO;
		}
		else if(boystarNo==NakshatraConstants.ANURADHA ||
				boystarNo==NakshatraConstants.JYESTHA){
			return NakshatraConstants.ANIMAL_DEER;
		}
		else if(boystarNo==NakshatraConstants.MULA ||
				boystarNo==NakshatraConstants.ARDRA){
			return NakshatraConstants.ANIMAL_DOG;
		}
		else if(boystarNo==NakshatraConstants.UTTRRASHDHA){
			return NakshatraConstants.ANIMAL_MONGOOSE;
		}
		else if(boystarNo==NakshatraConstants.DHANISHTHA ||
				boystarNo==NakshatraConstants.POORVABHADRRA){
			return NakshatraConstants.ANIMAL_LION;
		}
		else if(boystarNo==NakshatraConstants.REVATI ||
				boystarNo==NakshatraConstants.BHARANI){
			return NakshatraConstants.ANIMAL_ELEPHANT;
		}
		else if(boystarNo==NakshatraConstants.MIRIGAHIRA){
			return NakshatraConstants.ANIMAL_SNAKE;
		}
		else if(boystarNo==NakshatraConstants.CHITRA ||
				boystarNo==NakshatraConstants.VISHAKA){
			return NakshatraConstants.ANIMAL_TIGER;
		}
		else if(boystarNo==NakshatraConstants.SHRAVAN ||
				boystarNo==NakshatraConstants.POORVASADHA){
			return NakshatraConstants.ANIMAL_MONKEY;
		}
		else if(boystarNo==NakshatraConstants.UTTRABHADRA ||
				boystarNo==NakshatraConstants.UTTRA_PALGHUNI){
			return NakshatraConstants.ANIMAL_COW;
		}
		else{
		return -1;
		}
	}
	
	// Porutham No 4
	public Match calculateRasi(){
		Match match = new Match();
		int mod =rasiDiff%2;
		if(rasiDiff<13 && rasiDiff==10 && mod == 0 ){
			match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
		}
		else if(rasiDiff == 0){
			match.setMatch(NakshatraConstants.PORUTHAM_UTHAMAM);
			int rasi = boyStar.getRasi();
			if(rasi==Constants.AQUARIUS ||
				rasi==Constants.LEO ||
				rasi==Constants.CANCER ||
				rasi==Constants.CAPRICORN){
				match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
			}
		}
		else if(rasiDiff == 7){
			match.setMatch(NakshatraConstants.PORUTHAM_UTHAMAM);
		}
		else if(rasiDiff == 3 || rasiDiff == 4){
			match.setMatch(NakshatraConstants.PORUTHAM_MADHIYAMAM);
		}
		else{
			match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
		}
		
		match.setScore(calculateScore(match));
		return match;
	}
	
	// Porutham No 5
	public Match calculateRasiathipathy(){
		Match match = new Match();
		int friendship =NakshatraConstants.RASI_FRIENDSHIP[boyStar.getRasi()][girlStar.getRasi()];
		if(friendship==-1){
			match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
		}
		else if(friendship==1){
			match.setMatch(NakshatraConstants.PORUTHAM_UTHAMAM);
		}
		else {
			match.setMatch(NakshatraConstants.PORUTHAM_MADHIYAMAM);
		}     
		
		
		match.setScore(calculateScore(match));
		return match;
	}
	
	
	// Porutham No 6
	public Match calculateRajju(){
		Match match = new Match();
		if(NakshatraConstants.RAJU_PARTS[boystarNo]==NakshatraConstants.RAJU_PARTS[girlstarNo]){
			match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
		}
		else{
			match.setMatch(NakshatraConstants.PORUTHAM_UTHAMAM);
		}
		match.setScore(calculateScore(match));
		return match;
	}
	
	// Porutham No 7
		public Match calculateVeda(){
			Match match = new Match();
			
			if(boystarNo==NakshatraConstants.ASHWINI && girlstarNo==NakshatraConstants.JYESTHA ||
					boystarNo==NakshatraConstants.JYESTHA && girlstarNo==NakshatraConstants.ASHWINI ||
					
					boystarNo==NakshatraConstants.BHARANI && girlstarNo==NakshatraConstants.ANURADHA ||
					boystarNo==NakshatraConstants.ANURADHA && girlstarNo==NakshatraConstants.BHARANI ||
					
					boystarNo==NakshatraConstants.KRITIKA && girlstarNo==NakshatraConstants.VISHAKA ||
					boystarNo==NakshatraConstants.VISHAKA && girlstarNo==NakshatraConstants.KRITIKA ||
					
					boystarNo==NakshatraConstants.ROHINI && girlstarNo==NakshatraConstants.SWATI ||
					boystarNo==NakshatraConstants.SWATI && girlstarNo==NakshatraConstants.ROHINI ||
					
					boystarNo==NakshatraConstants.ARDRA && girlstarNo==NakshatraConstants.SHRAVAN ||
					boystarNo==NakshatraConstants.SHRAVAN && girlstarNo==NakshatraConstants.ARDRA ||
					
					boystarNo==NakshatraConstants.PUNERVASU && girlstarNo==NakshatraConstants.UTTRRASHDHA ||
					boystarNo==NakshatraConstants.UTTRRASHDHA && girlstarNo==NakshatraConstants.PUNERVASU ||
					
					boystarNo==NakshatraConstants.PUSHYA && girlstarNo==NakshatraConstants.POORVASADHA ||
					boystarNo==NakshatraConstants.POORVASADHA && girlstarNo==NakshatraConstants.PUSHYA ||
					
					boystarNo==NakshatraConstants.ASHLESHA && girlstarNo==NakshatraConstants.MULA ||
					boystarNo==NakshatraConstants.MULA && girlstarNo==NakshatraConstants.ASHLESHA ||
					
					boystarNo==NakshatraConstants.MAGHA && girlstarNo==NakshatraConstants.REVATI ||
					boystarNo==NakshatraConstants.REVATI && girlstarNo==NakshatraConstants.MAGHA ||
					
					boystarNo==NakshatraConstants.POORVA_PALGHUNI && girlstarNo==NakshatraConstants.UTTRABHADRA ||
					boystarNo==NakshatraConstants.UTTRABHADRA && girlstarNo==NakshatraConstants.POORVA_PALGHUNI ||
					
					boystarNo==NakshatraConstants.UTTRA_PALGHUNI && girlstarNo==NakshatraConstants.POORVABHADRRA ||
					boystarNo==NakshatraConstants.POORVABHADRRA && girlstarNo==NakshatraConstants.UTTRA_PALGHUNI ||
					
					boystarNo==NakshatraConstants.HASTA && girlstarNo==NakshatraConstants.SHATBHIISHAJ ||
					boystarNo==NakshatraConstants.SHATBHIISHAJ && girlstarNo==NakshatraConstants.HASTA ||
					
					boystarNo==NakshatraConstants.MIRIGAHIRA && (girlstarNo==NakshatraConstants.DHANISHTHA || girlstarNo==NakshatraConstants.CHITRA)||
					boystarNo==NakshatraConstants.DHANISHTHA && (girlstarNo==NakshatraConstants.MIRIGAHIRA || girlstarNo==NakshatraConstants.CHITRA)||
					boystarNo==NakshatraConstants.CHITRA && (girlstarNo==NakshatraConstants.MIRIGAHIRA || girlstarNo==NakshatraConstants.DHANISHTHA)){
				
				match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
			}
			else{
				match.setMatch(NakshatraConstants.PORUTHAM_UTHAMAM);
			}
			
			match.setScore(calculateScore(match));
			return match;
		}
	
		// Porutham No 8
				public Match calculateVasya(){
					Match match = new Match();
					if((boyStar.getRasi()==Constants.GEMINI && girlStar.getRasi()==Constants.VIRGO )||
							(boyStar.getRasi()==Constants.VIRGO && girlStar.getRasi()==Constants.GEMINI )||
							(boyStar.getRasi()==Constants.CANCER && girlStar.getRasi()==Constants.SCORPIO )||
							(boyStar.getRasi()==Constants.SCORPIO && girlStar.getRasi()==Constants.CANCER )){
						
					}
					else if((boyStar.getRasi()==Constants.ARIES && ( girlStar.getRasi()==Constants.LEO || girlStar.getRasi()==Constants.SCORPIO))||
							(boyStar.getRasi()==Constants.TAURUS && ( girlStar.getRasi()==Constants.CANCER || girlStar.getRasi()==Constants.LIBRA))||
							(boyStar.getRasi()==Constants.GEMINI && girlStar.getRasi()==Constants.VIRGO)||
							(boyStar.getRasi()==Constants.CANCER && ( girlStar.getRasi()==Constants.SCORPIO || girlStar.getRasi()==Constants.SAGITTARIUS))||
							(boyStar.getRasi()==Constants.LEO && girlStar.getRasi()==Constants.LIBRA)||
							(boyStar.getRasi()==Constants.LIBRA && (girlStar.getRasi()==Constants.CAPRICORN || girlStar.getRasi()==Constants.VIRGO))||
							(boyStar.getRasi()==Constants.SCORPIO && girlStar.getRasi()==Constants.CANCER)||
							(boyStar.getRasi()==Constants.SAGITTARIUS && girlStar.getRasi()==Constants.PISCES)||
							(boyStar.getRasi()==Constants.CAPRICORN &&( girlStar.getRasi()==Constants.ARIES || girlStar.getRasi()==Constants.AQUARIUS))||
							(boyStar.getRasi()==Constants.AQUARIUS && girlStar.getRasi()==Constants.ARIES)||
							(boyStar.getRasi()==Constants.PISCES && girlStar.getRasi()==Constants.CAPRICORN))
							{
						match.setMatch(NakshatraConstants.PORUTHAM_MADHIYAMAM);
						match.setDescription("The groom shall dearly love the bride");
						
					}
					else if((girlStar.getRasi()==Constants.ARIES && ( boyStar.getRasi()==Constants.LEO || boyStar.getRasi()==Constants.SCORPIO))||
							(girlStar.getRasi()==Constants.TAURUS && ( boyStar.getRasi()==Constants.CANCER || boyStar.getRasi()==Constants.LIBRA))||
							(girlStar.getRasi()==Constants.GEMINI && boyStar.getRasi()==Constants.VIRGO)||
							(girlStar.getRasi()==Constants.CANCER && ( boyStar.getRasi()==Constants.SCORPIO || boyStar.getRasi()==Constants.SAGITTARIUS))||
							(girlStar.getRasi()==Constants.LEO && boyStar.getRasi()==Constants.LIBRA)||
							(girlStar.getRasi()==Constants.LIBRA && (boyStar.getRasi()==Constants.CAPRICORN || boyStar.getRasi()==Constants.VIRGO))||
							(girlStar.getRasi()==Constants.SCORPIO && boyStar.getRasi()==Constants.CANCER)||
							(girlStar.getRasi()==Constants.SAGITTARIUS && boyStar.getRasi()==Constants.PISCES)||
							(girlStar.getRasi()==Constants.CAPRICORN &&( boyStar.getRasi()==Constants.ARIES || boyStar.getRasi()==Constants.AQUARIUS))||
							(girlStar.getRasi()==Constants.AQUARIUS && boyStar.getRasi()==Constants.ARIES)||
							(girlStar.getRasi()==Constants.PISCES && boyStar.getRasi()==Constants.CAPRICORN))
							{
						match.setMatch(NakshatraConstants.PORUTHAM_MADHIYAMAM);
						match.setDescription("The bride shall dearly love the groom");
						
					}
					else{
						match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
						match.setDescription("highly not recomended");
					}
					return match;
				}
				
	// Porutham No 
	public Match calculateMahendram(){
		Match match = new Match();
		if(starDiff==4 || starDiff==7 || starDiff==10 || starDiff==13 || starDiff==16 || starDiff==22 || starDiff==25){
			match.setMatch(NakshatraConstants.PORUTHAM_UTHAMAM);
		}
		else{
			match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
		}
		return match;
	}
	// Porutham No 10
		public Match calculateSreeDeergam(){
			Match match = new Match();
			if(starDiff>13 || starDiff==7){
				match.setMatch(NakshatraConstants.PORUTHAM_UTHAMAM);
			}
			else{
				match.setMatch(NakshatraConstants.PORUTHAM_ATHAMAM);
			}
			return match;
		}
	
	private String calculatePorutham(Match match) {
		if(match.getScore()==0){
			return NakshatraConstants.PORUTHAM_ATHAMAM;
		}
		else if(match.getScore()==1 || match.getScore()==2){
			return NakshatraConstants.PORUTHAM_MADHIYAMAM;
		}
		else if(match.getScore()==3 || match.getScore()==4){
			return NakshatraConstants.PORUTHAM_UTHAMAM;
		}
		else return "Not Set";
	}
	private int calculateScore(Match match) {
		if(match.getMatch()==NakshatraConstants.PORUTHAM_ATHAMAM){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	
	
}
