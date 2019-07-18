<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="#" method="post" modelAttribute="user">

<table>

<tr>
<td>FirstName:</td>
<td><form:input path="firstName"/>
</tr>

<tr>
<td>LastName:</td>
<td><form:input path="lastName"/>
</tr>

<tr>
<td>UserName:</td>
<td><form:input path="userName"/>
</tr>

<tr>
<td>password:</td>
<td><form:input path="password"/>
</tr>

<tr>
<td>email:</td>
<td><form:input path="email"/>
</tr>

<tr>
<td>role:</td>
<td><form:input path="role"/>
</tr>


</table>

</form:form>

</body>
</html>