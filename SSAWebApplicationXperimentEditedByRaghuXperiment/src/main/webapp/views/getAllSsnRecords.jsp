<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



 <table border="1">
 
 <thead>
 <tr>
 <th>Ssn Number</th>
 <th>First Name</th>
 <th>Last Name</th>
 <th>Date of birth</th>
 <th>Gender</th>
 <th>Phone Number</th>
 <th>State</th>
 <th>Photo</th>
 </tr>
 </thead>
    <c:forEach items="${ssnRecords}" var="ssnRecords">
    <tr>
    	<%-- <td><c:out value="${ssnNumberList.ssnNumberList}"></c:out> --%>
    	<td> <c:out value="${ssnRecords.ssnNumber}"/></td>
        <td> <c:out value="${ssnRecords.firstName}"/></td>
        <td> <c:out value="${ssnRecords.lastName}"/></td>  
        <td> <c:out value="${ssnRecords.dateOfBirth}"/></td>  
        <td> <c:out value="${ssnRecords.gender}"/></td>  
        <td> <c:out value="${ssnRecords.phoneNumber}"/></td>  
        <td> <c:out value="${ssnRecords.state}"/></td>  
        <%-- <td><img width="100" height="100" src="getPhoto/<c:out value='${ssnRecords.ssnNumber}'/>"></td> --%>
        <%-- <td><a href="getPhoto?id=${ssnRecords.ssnNumber}">Display Image</a> --%>
        <td><a href="<c:url value='/getPhoto/${ssnRecords.ssnNumber}' />" >Display Image</a></td> 
    </tr>
</c:forEach>
</table>


<table>
<thead>
<tr>
<td>Ssn Number</td>
</tr>
</thead>
<c:forEach items="${ssnNumberList}" var="ssnNumberList">
 <tr>
        <td> <c:out value="${ssnNumberList.ssnNumber}"/></td>
  </tr>
</c:forEach>
</table>

 
 
<a href="/displayForm">Ssn Registration Page</a>


</body>
</html>