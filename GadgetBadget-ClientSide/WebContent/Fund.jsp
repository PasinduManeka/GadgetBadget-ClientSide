<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.Fund" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Item Form</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="Components/item.js"></script>
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
			<form id="formItem" name="formItem" method="post" >
				Item Code:
				<input type="text" name="code" id="code" class="form-control border border-primary form-control-sm"><br>
				Item Name:
				<input type="text" name="name" id="name" class="form-control border border-primary form-control-sm"><br>
				Item Price:
				<input type="text" name="price" id="price" class="form-control border border-primary form-control-sm"><br>
				Item Description:
				<input type="text" name="description" id="description" class="form-control border border-primary form-control-sm"><br>
				
				<div id="alertSuccess" class="alert alert-success"></div><br>
				<div id="alertDanger" class="alert alert-danger"></div><br>
				
				<input type="button" id="bntSave" name="bntSave" value="Save" class="btn btn-outline-success"><br>
				
				<input type="hidden" id="hidIDItemIDSave" name="hidIDItemIDSave" value="">
			</form><br>
			<!-- end the form -->
			<!--  Display the HTML table -->
			<div class="row container ">
				<div class="col-12" id="colItem">
					<%
						Fund it  = new Fund();
								out.print(it.readItems());
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