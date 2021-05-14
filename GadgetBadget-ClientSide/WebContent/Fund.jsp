<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.Fund" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Item Form</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="Components/main.js"></script>
<link rel="stylesheet" href="./Views/bootstrap.min.css">
<link rel="stylesheet" href="./Views/item.css">
</head>
<body>
	<!-- start the card  -->
	<div class="card">
		<!-- Headline of the card -->
		<h5 class="card-header border border-warning text-center ">
			<strong>Add Items</strong>
		</h5>
		<!-- start the card body -->
		<div class="card-body container border border-info">
			<!-- start the form -->
			<form id="formFund" name=""formFund"" method="post" >
				Cart id:
				<input type="text" name="cartid" id="code" class="form-control border border-primary form-control-sm"><br>
				Researcher Name:
				<input type="text" name="name" id="name" class="form-control border border-primary form-control-sm"><br>
				Invest Amount:
				<input type="text" name="amount" id="amount" class="form-control border border-primary form-control-sm"><br>
				Description:
				<input type="text" name="description" id="description" class="form-control border border-primary form-control-sm"><br>
				
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertDanger" class="alert alert-danger"></div><br>
				
				<input type="button" id="bntSave" name="bntSave" value="Save" class="btn btn-outline-success"><br>
				
				<input type="hidden" id="hidIDFundIDSave" name="hidIDItemIDSave" value="">
			</form><br>
			<!-- end the form -->
			<!--  Display the HTML table -->
			<div class="row container ">
				<div class="col-12" id="colItem">
					<%
						Fund it  = new Fund();
						out.print(it.readFunds());
					%>
				</div>
			</div>
			<!-- End display the HTML  -->
		</div>
		<!-- end the card body -->
		
	</div>
	<!-- end the card  -->
	
	
	
</body>
</html>