<%@ include file="./init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="user">
	<form:input path="id" /><form:errors path="id" />
	<form:input path="firstName" /><form:errors path="firstName" />
	<form:input path="lastName" /><form:errors path="lastName" />
	<form:input path="email" /><form:errors path="email" />
	<form:input path="login" /><form:errors path="login" />
	<form:input path="password" /><form:errors path="password" />
	<input type="submit" value="Enregistrer" />
	</form:form>
</body>
</html>