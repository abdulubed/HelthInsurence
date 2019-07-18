<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  ${msg}

	<form:form action="register" method="post" modelAttribute="user">

		<table>
			<tr>
				<td>FirstName:</td>
				<td><form:input path="firstName" /></td>
			</tr>

			<tr>
				<td>LastName:</td>
				<td><form:input path="lastName" /></td>
			</tr>

			<tr>
				<td>UserName:</td>
				<td><form:input path="userName" /></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td>Gender:</td>
				<td><form:radiobuttons path="gender"  items="${genders}"/></td>
			</tr>

			<tr>
				<td>Role:</td>
				<td><form:checkboxes path="role" items="${roles}"/></td>
			</tr>
			
			<tr>
			<td><input type="reset" value="Reset">
			<td><input type="submit" value="Submit"></td>

		</table>



	</form:form>

</body>
</html>