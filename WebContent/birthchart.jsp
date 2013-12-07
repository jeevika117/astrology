<%@page import="jyotish.main.calc.PanchangBasics"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="jyotish.main.*" %> 
<%@ page import="java.util.Hashtable" %> 
<!DOCTYPE html>
<!--[if IE 8]> 				 <html class="no-js lt-ie9" lang="en" > <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en" > <!--<![endif]-->
<%@ page import="org.joda.time.DateTime" %> 
<head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>Vedic Astrology</title>

  
  <link rel="stylesheet" href="css/foundation.css">
  

  <script src="js/vendor/custom.modernizr.js"></script>

</head>
<body>
	 <%
	 	
		String date = request.getParameter("date");
	 	String time = request.getParameter("time");
		String[] dateVal = date.split("-");
	 	String[] timeVal = time.split(":");
		
		BirthData birthdata = new BirthData();
		
		birthdata.setBirthDate(Integer.parseInt(dateVal[2]));
		birthdata.setBirthMonth(Integer.parseInt(dateVal[1]));
		birthdata.setBirthYear(Integer.parseInt(dateVal[0]));
		birthdata.setBirthHour(Integer.parseInt(timeVal[0]));
		birthdata.setBirthMinute(Integer.parseInt(timeVal[1]));
		birthdata.setBirthSecond(0);
		birthdata.setIsEast(true);
		birthdata.setIsNorth(true);
		birthdata.setLongitude_Deg(Integer.parseInt(request.getParameter("lonDegree")));
		birthdata.setLongitude_Min(Integer.parseInt(request.getParameter("lonMinute")));
		birthdata.setLongitude_Sec(0);
		birthdata.setLatitude_Deg(Integer.parseInt(request.getParameter("latDegree")));
		birthdata.setLatitude_Min(Integer.parseInt(request.getParameter("latMinute")));
		birthdata.setLongitude_Sec(0);
		birthdata.setTimeZoneOffset(5.5);
		int chartType = Integer.parseInt(request.getParameter("chart"));
		InputPreference inputpref= new InputPreference();
		inputpref.setType(chartType);
		ChartBuilder chartbuilder = new ChartBuilder();
		
		chartbuilder.setCalculationPreferences();
		Chart chart = chartbuilder.calculateChart(birthdata,inputpref);
		if(chartType<20){
			System.out.println(chart.getVargaData().getVargaData()[0][0]);
			int[][] vargaData = chart.getVargaData().getVargaData();
			PlanetHouseMap housemap = new PlanetHouseMap();
			for(int i=0;i<12;i++){
				housemap.put(vargaData[chartType][i], housemap.get(vargaData[0][i])+"  "+Constants.planetLongNames[i]);
				}
			housemap.put(vargaData[chartType][13], "Lagna");
			 %>
			<div class="row" id="chart">
				<div class="large-8 columns large-centered" >
					<div align="center">
						<table border="1px" cellspacing="0" cellpadding="0">
							<tr>
								<td id="house12" class="house-box"><%=housemap.get(12) %></td>
								<td id="house1" class="house-box"><%=housemap.get(1) %></td>
								<td id="house2" class="house-box"><%=housemap.get(2) %></td>
								<td id="house3" class="house-box"><%=housemap.get(3) %></td>
							</tr>
							<tr>
								<td id="house11" class="house-box" ><%=housemap.get(11) %></td>
								<td id="center" class="house-box" colspan="2" rowspan="2">
								<h2>South Indian Birth Chart</h2></td>
								
								<td id="house4" class="house-box"><%=housemap.get(4) %></td>
							</tr>
							<tr>
								<td id="house10" class="house-box"><%=housemap.get(10) %></td>
											
								<td id="house5" class="house-box"><%=housemap.get(5) %></td>
							</tr>
							<tr>
								<td id="house9" class="house-box"><%=housemap.get(9) %></td>
								<td id="house8" class="house-box"><%=housemap.get(8) %></td>
								<td id="house7" class="house-box"><%=housemap.get(7) %></td>
								<td id="house6" class="house-box"><%=housemap.get(6) %></td>
							</tr>
								
						</table>
					
					</div>
				</div>
			</div>
		<%}
	else if(chartType==20){
			PanchangBasics panchang =chart.getPanchangBasics();
		%>
<div class="row">
	<div class="column-8 columns">
		<h2> Panchang for <%=date %> & <%=time %></h2>
	</div>
</div>
<div class="row">
	<div class="large-2 columns text-right">
		Sunrise
	</div>
	<div class="large-2 columns">
		<%=panchang.getSunriseString() %>
	</div>
	<div class="large-2 columns text-right">
		Sunset
	</div>
	<div class="large-2 columns">
		<%=panchang.getSunsetString() %>
	</div>
	<div class="large-2 columns text-right">
		Day
	</div>
	<div class="large-2 columns">
		<%=panchang.getDay() %>
	</div>
</div>
<div class="row">
	<div class="large-2 columns text-right">
		Nakshatra
	</div>
	<div class="large-2 columns">
		<%=panchang.getNakshathra() %>
	</div>
	<div class="large-2 columns text-right">
		Pada
	</div>
	<div class="large-2 columns">
		<%=panchang.getPada() %>
	</div>
	<div class="large-2 columns text-right">
		
	</div>
	<div class="large-2 columns">
		
	</div>
</div>
<div class="row">
	<div class="large-2 columns text-right">
		Rahukal
	</div>
	<div class="large-2 columns">
		<%=panchang.getRahukal() %>
	</div>
	<div class="large-2 columns text-right">
		Yamagandam
	</div>
	<div class="large-2 columns">
		<%=panchang.getYamaganda() %>
	</div>
	<div class="large-2 columns text-right">
		Gulika
	</div>
	<div class="large-2 columns">
		<%=panchang.getGulika() %>
	</div>
</div>
<div class="row">
	<div class="large-2 columns text-right">
		Tithi
	</div>
	<div class="large-2 columns">
		<%=panchang.getTithi() %>
	</div>
	<div class="large-2 columns text-right">
		Karana
	</div>
	<div class="large-2 columns">
		<%=panchang.getKarana() %>
	</div>
	<div class="large-2 columns text-right">
		Yoga
	</div>
	<div class="large-2 columns">
		<%=panchang.getYoga() %>
	</div>
</div>
		
		<%} %>
	
		
		
	
  <script src='js/vendor/jquery.js'></script>
  
  <script src="js/foundation/foundation.js"></script>
 
  
  
  <script>
    $(document).foundation();
  </script>
</body>
</html>
