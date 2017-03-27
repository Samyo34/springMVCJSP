<%@ include file="./init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="user">
		ID : <form:input path="id" /><form:errors path="id" />
		firstName : <form:input path="firstName" /><form:errors path="firstName" />
		lastName : <form:input path="lastName" /><form:errors path="lastName" />
		email : <form:input path="email" /><form:errors path="email" />
		login : <form:input path="login" /><form:errors path="login" />
		password : <form:input path="password" /><form:errors path="password" />
		<input type="submit" value="Enregistrer" />
	</form:form>
<%-- 	<s:message code="greeting"/>
	<s:message code="farwall"/> --%>
	<ul>
		<c:forEach var="u" items="${users}">
			<li>${u}</li>
		</c:forEach>
	</ul>
</body>
</html>