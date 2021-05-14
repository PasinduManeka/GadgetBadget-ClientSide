<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="Components/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="Components/main.js"></script>
<link rel="stylesheet" href="Views/bootstrap.min.css">
</head>
<body>
	<div class="card">
		<!-- Headline of the body -->
		<h5 class="card-header border border-warning text-center">
			<strong>Add Funds</strong>
		</h5><br>
		<div class="card-body container border border-dark">
			<form id="formFund" name="formFund" method="post" action="">
				<!-- Cart Id  -->
				Cart ID:
				<input type="text" class="border form-control form-control-sm border-info" id="cartID" name="cartID" ><br>
				<!-- Researcher Name -->
				Researcher Name:
				<input type="text" class="border form-control form-control-sm border-info" id="rName" name="rName"><br>
				<!-- Invest Amount -->
				Invest Amount:
				<input type="text" class="border form-control form-control-sm border-info" id="iAmount" name="iAmount"><br>
				<!-- Description -->
				Description:
				<input type="text" class="border form-control form-control-sm border-info" id="description" name="description"><br>
				
				<!-- Message alerts -->
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				
				<!-- Save Button -->
				<input type="button" id="btnSave" name="btnSave" value="Save" class="btn btn-outline-success">
				
				<!-- Hidden fund id -->
				<input type="hidden" id="hidFundIDSave" name="hidFundIDSave" value="">
				
			</form>
		</div><br>
		
		<div class="row container">
			<div class="col-12" id="colFund"></div>
		</div>
			
	</div>
</body>
</html>