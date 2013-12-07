package jyotish.main;


import java.util.Iterator;

public interface IChartCenter
{
	
	public void createChart(BirthData nativeInfo2);
	public void addChart(Chart chart);
	public void deleteChart(String chartName);
	public Chart getChart(String chartName);
	public Chart getCurrentChart();
	public void setCurrentChart(Chart chart);
	
	public void addNative(BirthData nativeInfo2);
	public void deleteNative(String nativeName);
	public BirthData getNative(String nativeName);
	
	public Iterator getAllNatives();
	//public void saveChart(String name);
	
	//public void getCalculationPreferences();
	public void saveCalculationPreferences();
	
	public Iterator getAllCharts();
	public boolean hasNoCharts();
	public void addChartCenterEventListener(ChartCenterEventListener c);
	public void removeChartCenterEventListener(ChartCenterEventListener c);
	public void testFireChartCenterChanged();
	
	///TESTING ONLY

	



}
