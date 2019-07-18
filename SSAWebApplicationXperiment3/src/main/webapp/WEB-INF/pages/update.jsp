<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<style>
.userform {
	width: 400px;
}

.userform p {
	width: 100%;
}

.userform label {
	width: 120px;
	color: #333;
	float: left;
}

input.error {
	border: 1px dotted red;
}

label.error {
	width: 100%;
	color: red;
	font-style: italic;
	margin-left: 120px;
	margin-bottom: 5px;
}

.userform input.submit {
	margin-left: 120px;
}
</style>
<title>SSN Registration page</title>
<!-- Latest compiled and minified BootStarp CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
	
</script>
<!-- jQuery Form Validation library -->
<script
	src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js">
	
</script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
	
</script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"></script>
<script
	src="https://cdn.datatables.net/buttons/1.5.6/css/buttons.dataTables.min.css"></script>


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>


<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>
<script type="text/javascript">
	(function($, W, D) {
		var JQUERY4U = {};
		JQUERY4U.UTIL = {
			setupFormValidation : function() {
				//form validation rules
				$("#myForm").validate({
					rules : {
						firstName : "required",
						lastName : {
							required : true,

						},
						dateofbirth : {
							required : true,

						},
						gender : {
							required : true,

						},
						phno : {
							required : true,

						},
						state : {
							required : true,

						},
						photo : {

							required : true,

						}
					},
					messages : {
						firstName : "Please Enter firstName",
						dateofbirth : "Please Enter dateofbirth",
						gender : "Please Enter gender",
						phno : "Please Enter phno",
						state : "Please Enter state",
						photo : "Please choose photo",
						lastName : "Please Enter lastName"
					},
					submitHandler : function(form) {
						form.submit();
					}
				});
			}
		}
		//when the dom has loaded setup form validation rules
		$(D).ready(function($) {
			JQUERY4U.UTIL.setupFormValidation();
		});
	})(jQuery, window, document);
</script>

</head>
<body>
	<div id="page-wrapper">
		<div class="container">
			<h1>
				SSN Update Page   ssnno is :${ssnno}
				<h2 style="color: #39BC09;">${msg}</h2>
			</h1>
			<form:form name="myForm"   modelAttribute="updateAtr"
				class="form-horizontal" id="myForm" action="/updateurl" method="POST">
				<div class="panel panel-info">
					<div class="panel-heading">SSN Update  </div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6">
								<div class="form-group">
										<label for="ssnNo" class="col-md-4">ssnNo</label>
										<div class="col-md-6">
											<form:input path="ssnNo" class="form-control" readonly="true"/>
										</div>
									</div>
									<div class="form-group">
										<label for="firstName" class="col-md-4">firstname *</label>
										<div class="col-md-6">
											<form:input path="firstName" class="form-control"
												placeholder="Enter firstName" />
										</div>
									</div>
									
									<div class="form-group">
										<label for="lastName" class="col-md-4">lastname *</label>
										<div class="col-md-6">
											<form:input path="lastName" class="form-control"
												placeholder="Enter lastName" />

										</div>
									</div>
									<div class="form-group  ">
										<label for="dateofbirth" class="col-md-4">dateofbirth
										</label>
										<div class="col-md-6">
											<form:input path="dateofbirth" id="datepicker"
												autocomplete="off" placeholder="Enter  dateofbirth"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label for="gender" class="col-md-4">gender </label>
										<div class="col-md-6">
											<form:radiobutton path="gender" value="Male" />
											Male
											<form:radiobutton path="gender" value="Female" />
											Female
											<%-- <form:radiobuttons path="gender" items="${gender}"/>
                      <%-- <form:input path="gender" class="form-control" placeholder="Enter gender" />
 --%>
										</div>
									</div>
									<div class="form-group">
										<label for="phno" class="col-md-4">phno </label>
										<div class="col-md-6">
											<form:input path="phno" placeholder="Enter phno"
												class="form-control" />

										</div>
									</div>
									<div class="form-group">
										<label for=state class="col-md-4">photo </label>
										<div class="col-md-6">
											<form:select path="state" items="${states}" />
											<%-- <form:input path="state" placeholder="Enter state" class="form-control"/> --%>

										</div>
									</div>
									<div class="form-group">
										<label for="photo" class="col-md-4">photo </label>
										<div class="col-md-6">
											<input type="file" name="photo" placeholder="Enter photo"
												class="form-control" />

										</div>
									</div>
								</div>
								<!-- end div -->
							</div>
							<!-- end div -->
						</div>
					</div>
				</div>
				<div class="col-md-4 col-md-offset-4" style="margin-bottom: 50px;">
					<div align="center">
					<input type="reset" class="btn btn-primary" value="reset" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="btn btn-primary" value="Submit" />&nbsp;&nbsp; &nbsp;&nbsp;<a href="getallSsnRecords">view all records</a>
					</div>
				</div>

			</form:form>
		</div>
	</div>

</body>
</html>
