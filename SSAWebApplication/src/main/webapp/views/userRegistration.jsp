<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registartion</title>

<!-- date picker -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
 -->
 <script>
  $(function() {
        $( "#datepicker" ).datepicker({
            dateFormat : 'mm/dd/yy',
            changeMonth : true,
            changeYear : true,
            yearRange: '-100y:c+nn',
            maxDate: '-1d'
        });
    });
 </script>  

</head>
<body>

<font color="green">${message}</font>

<form:form action="/insertUserData" modelAttribute="ssnModel" method="POST">

<table>
<tr>
<td>First Name</td>
<td><form:input path="firstName"/></td>
</tr>

<tr>
<td>Last Name</td>
<td><form:input path="lastName"/></td>
</tr>

<!-- <tr>
<td>Date Of Birth</td>
<td><input type="text" id="datepicker" name="dateOfBirth"></td>
</tr>
 -->
<tr>
<td>Date Of Birth</td>
<td> <input type="text" id="datepicker" name="dateOfBirth"></td>
</tr>

 
<tr>
<td>Gender</td>
<td><form:radiobuttons path="gender" items="${gendersList}"/></td>
</tr>

<tr>
<td>Phone Number</td>
<td><form:input path="phoneNumber"/></td>
</tr>

<tr>
<td>Select State</td>
<td><form:input path="state"/></td>
</tr>

<tr>
<td>Select Photo</td>
<td><input type="file" name="photo" placeholder="Select Photo"></td>
</tr>


<tr>
<td><input type="reset" value="Reset"></td>
<td><input type="submit" value="Enroll"/></td>
</tr>

</table>





</form:form>

</body>
</html>