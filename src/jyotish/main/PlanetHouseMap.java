package jyotish.main;

import java.util.HashMap;

public class PlanetHouseMap extends HashMap<Integer, String> {

	public String get(Integer key){
		String value = super.get(key);
		if(value == null) return "";
		else return value;
	}
}
