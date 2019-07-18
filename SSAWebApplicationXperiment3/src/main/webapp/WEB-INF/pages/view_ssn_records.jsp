<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<link rel="stylesheet"
	href=https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<style type="text/css">
.a {
	text-decoration: none;
	color: #0325AC;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	align: center
}

.a:hover {
	color: red;
	text-decoration: none;
	cursor: pointer;
}
</style>
</head>
<body>

	<h2>HTML Table</h2>
	${ssnno}
	<table border="1" id="example" class="display" style="width:100%">
		<thead>
			<tr>
				<th>ssnNo</th>
				<th>firstName</th>
				<th>lastName</th>
				<th>dateofbirth</th>
				<th>gender</th>
				<th>phno</th>
				<th>state</th>
				<th>EDIT</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					<td><c:out value="${item.ssnNo}"></c:out></td>
					<td><c:out value="${item.firstName}" ></c:out></td>
					<td><c:out value="${item.lastName}" ></c:out></td>
					<td><c:out value="${item.dateofbirth}" ></c:out></td>
					<td><c:out value="${item.gender}" ></c:out></td>
					<td><c:out value="${item.phno}"></c:out></td>
					<td><c:out value="${item.state}" ></c:out></td>
					<td><a href="editssnrecord/${item.ssnNo}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
 

<br>
	<br>
	<div align="center">
		<button>
			<a href="/" class="a">SsnEnrollForm</a>
		</button>
	</div> 
</html>