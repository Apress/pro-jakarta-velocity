<%@ taglib uri="/WEB-INF/tlds/veltag.tld" prefix="vel" %>

<jsp:useBean id="foo1" class="com.apress.pjv.ch8.Foo"/>
<jsp:useBean id="foo2" class="com.apress.pjv.ch8.Foo" scope="request"/>
<jsp:useBean id="foo3" class="com.apress.pjv.ch8.Foo" scope="session"/>
<jsp:useBean id="foo4" class="com.apress.pjv.ch8.Foo" scope="application"/>

<jsp:setProperty name="foo1" property="value" value="I am a page scope bean"/>
<jsp:setProperty name="foo2" property="value" value="I am a request scope bean"/>
<jsp:setProperty name="foo3" property="value" value="I am a session scope bean"/>
<jsp:setProperty name="foo4" property="value" value="I am an application scope bean"/>

<html>
	<head>
		<title>Veltag Example</title>
	</head>
	<body>
		<vel:velocity>
			The value of foo1.getValue() is $foo1.value<br>
			The value of foo2.getValue() is $foo2.value<br>
			The value of foo3.getValue() is $foo3.value<br>
			The value of foo4.getValue() is $foo4.value<br>
			The value of servletFoo.getValue() is $servletFoo.value<br>
		</vel:velocity>
	</body>
</html>