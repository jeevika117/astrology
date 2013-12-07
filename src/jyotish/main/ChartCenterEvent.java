package jyotish.main;

/**
 *  Description of the Class
 *
 *@author     Michael W. Taft
 *@created    May 15, 2002
 */
public class ChartCenterEvent extends java.util.EventObject
{

	/**
	 *  Constructor for the ChartCenterEvent object
	 *
	 *@param  center  Description of the Parameter
	 */
	public ChartCenterEvent(IChartCenter center)
	{
		super(center);
		//the source of the event
	}

}

