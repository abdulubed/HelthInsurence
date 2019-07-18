<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.error{
color:red;
}
</style>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
	<font color=green>${success}</font>

	<form:form action="registration" modelAttribute="userRegistraion"
		method="Post">
		<table>

			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error"></form:errors></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error"></form:errors></td>
			</tr>

			<tr>
				<td>User Name</td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="error" ></form:errors></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssClass="error"></form:errors></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Enroll"></td>
			</tr>


		</table>

	</form:form>



</body>
</html>