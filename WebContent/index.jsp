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
<form id="birthchartInput" action="birthchart.jsp" method="post" >
	<div class="row">
		<div class="large-12 columns">
			<h2>Vedic Astrology</h2>
			
			<hr />
		</div>
	</div>
	<%
		DateTime today = new DateTime();
		
	%>

	<div class="row">
		<div class="large-1 columns">Chart Type </div>
		<div class="large-3 columns">
			<select name="chart">
				<option value="0">Birth Chart</option>
				<option value="20">Panchang</option>
				<option value="1">Hora</option>
				<option value="2">Drekkanna</option>
				<option value="3">Chaturamsa</option>
				<option value="4">Panchamsa</option>
				<option value="5">Saptamsa</option>
				<option value="6">Ashtamsa</option>
				<option value="7">Navamsa</option>
				<option value="8">Dasamsa</option>
				<option value="9">Dwadasamsa</option>
				<option value="10">Shodasamsa</option>
				<option value="11">Vimshamsa</option>
				<option value="12">Siddhamsa</option>
				<option value="13">Bhamsa</option>
				<option value="14">Trimshamsa</option>
				<option value="15">Khavedamsa</option>
				<option value="16">Akshvedamsa</option>
				<option value="17">Shastiamsa</option>
			</select>
		</div>
		
		<div class="large-1 columns">DOB</div>
		<div class="large-3 columns">
			<div class="row">
				<div class="large-10 small-12 columns">
					<input type="date" id="date"  name="date"  value=<%=today.toString("yyyy-MM-dd") %> ></input>
				</div>
			</div>
		</div>
		
		<div class="large-1 columns">Time</div>
		<div class="large-3 columns">
			<div class="row">
				<div class="large-6 small-12 columns">
					<input type="time" id="time"  name="time"  value=<%=today.toString("HH:mm") %> />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="large-1 columns">Longitude</div>
		<div class="large-3 columns">
			<div class="row">
				<div class="large-6 small-12 columns">
					<input name="lonDegree" type="number"  value="80" />
				</div>
			
				<div class="large-6 small-12 columns">
					<input name="lonMinute" type="number"  value="17" />
				</div>
			</div>
		</div>
		
		<div class="large-1 columns">Lattitude</div>
		<div class="large-3 columns">
			<div class="row">
				<div class="large-6  columns">
					<input name="latDegree" type="number"  value="13" />
				</div>
			
				<div class="large-6  columns">
					<input name="latMinute" type="number"  value="5" />
				</div>
			</div>
		</div>
		
		<div class="large-4 columns"> <input type="submit" id="submitForm" value="Submit"></input></div>
		
	</div>
</form>

	<div class="row" id="chart">
		
		
	</div>
  <script src='js/vendor/jquery.js'></script>
  
  <script src="js/foundation/foundation.js"></script>
 
  
  
  <script>
    $(document).foundation();
  </script>
</body>
</html>
