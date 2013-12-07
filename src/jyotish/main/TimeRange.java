package jyotish.main;

import org.joda.time.DateTime;

public class TimeRange {
	
	DateTime fromtime;
	DateTime toTime;
	String from;
	String to;
	
	
	
	public TimeRange(DateTime fromTime, DateTime toTime) {
		from=fromTime.toString("HH:mm");
		to=toTime.toString("HH:mm");
	}
	
	@Override
	public String toString() {
		String range= from +" - "+to;
		return range;
	}
}
