
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
 
<form id="birthchartInput" action="birthchart.jsp" method="post">
Chart Type : <select name="chart">
				<option value="0">Birth Chart</option>
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
			<br/>

Date : 	<select name="day"><% for(int i = 1; i<=31; i+=1){ %><option value=<%=i%>><%=i%></option><% } %>	</select>
		<select name="month"><% for(int i = 1; i<=12; i+=1) { %><option value=<%=i%>><%=i%></option><% } %>	</select>
		<select name="year"><% for(int i = 1900; i<=2100; i+=1) { %><option value=<%=i%>><%=i%></option><% } %>	</select>
		<br/>
		
Time :  <select name="hour"><% for(int i = 0; i <= 24; i+=1) { %><option value=<%=i%>><%=i%></option><% } %>	</select>
		<select name="minute"><% for(int i = 0; i <= 60; i+=1) { %><option value=<%=i%>><%=i%></option><% } %>	</select>
		<br/>
		
Longitude :	<select name="lonDegree"><% for(int i = 0; i <= 360; i+=1) { %><option value=<%=i%>><%=i%></option><% } %>	</select>
			<select name="lonMinute"><% for(int i = 0; i <= 60; i+=1) { %><option value=<%=i%>><%=i%></option><% } %>	</select>
		<br/>	
Latitude : <select name="latDegree"><% for(int i = 0; i <= 360; i+=1) { %><option value=<%=i%>><%=i%></option><% } %>	</select>
			<select name="latMinute"><% for(int i = 0; i <= 60; i+=1) { %><option value=<%=i%>><%=i%></option><% } %>	</select>
			
<br/><br/>			
<input type="submit" name="submit"></input>			
</form>
</body>
</html>