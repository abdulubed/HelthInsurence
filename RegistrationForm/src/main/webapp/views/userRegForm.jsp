<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="/js/plugin/jquery.js"></script>

<script type="text/javascript" src="/js/jquery.validate.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store</title>
</head>
<body>
${msg}

	<form:form action="/registerUser" method="POST" modelAttribute="user" name="myForm">
	
		<table>
			<tr>
				<td>FirstName :</td>
				<td><form:input path="fName" /></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><form:input path="lName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:radiobuttons path="gender" items="${genders}" /></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><form:checkboxes value="role" path="role" items="${roles}" /></td>
			</tr>
			
			
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="Submit" value="Submit" /></td>
			</tr>
		</table>
		
	

	</form:form>

<script>
   
   function submitForm() {
    var validator = $("userRegForm").validate({
        rules: {
            fName: "required",
            lName: "required",
      /*       email: "required",
            password: "required",
            gender: "required",
            role: "required"
       */  },
        errorElement: "span",
        messages: {
        	fName: " Enter Name",
        	lName: "Enter LastName",
            /* email: " Enter Email",
            password: " Enter Contact No",
            gender: " Enter City",
            role: " Enter Description" */
        }
    });
    if (validator.form()) { // validation perform
        $('form#myForm').attr({
            action: 'mycontroller'
        });
        $('form#myForm').submit();
    }
}
</script>

</body>
</html>