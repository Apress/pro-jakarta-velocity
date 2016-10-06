<%@ taglib uri="/WEB-INF/tlds/veltag.tld" prefix="vel" %>
<html>
<head>
	<title>Veltag - Hello World</title>
</head>
<body>
	<vel:velocity>
		#set($name = "World")
		Hello $name
	</vel:velocity>
</body>
</html>