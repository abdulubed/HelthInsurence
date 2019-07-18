<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarion page</title>
<link rel="stylesheet" href="https://jqueryvalidation.org/files/demo/site-demos.css">
</head>
<body>

  ${success}


	<form:form action="register" method="post" modelAttribute="user" id="myform">

		<table>
			<tr>
				<td>FirstName:</td>
				<td><form:input path="firstName"  /></td>
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
	
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script>
// just for the demos, avoids form submit
jQuery.validator.setDefaults({
  debug: true,
  success: "valid"
});
$( "#myform" ).validate({
  rules: {
	  firstName: {
      required: true
    }
  }
});
</script>

</body>
</html>