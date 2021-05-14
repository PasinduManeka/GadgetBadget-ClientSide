//console.log("Hello World! bye!")

//hide the alerts
$(document).ready(function(){ 
	if ($("#alertSuccess").text().trim() == "") { 
		$("#alertSuccess").hide(); 
	} 
	$("#alertDanger").hide(); }
);
ss
//Form validation
function validationFundForm(){
	//code
	if($("#code").val().trim()==""){
		return "insert the item code.";
	}
	
	//name
	if($("#name").val().trim() == ""){
		return "Insert the item name";
	}
	
	//price
	if($("#price").val().trim()==""){
		return "Insert a numeric value for item price";
	}
	
	//description
	if($("#description").val().trim() == ""){
		return "Insert the item description";
	}
	
	return true;
}

//Save
$(document).on("click", "#bntSave", function(event){
	//clear alerts
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertDanger").text("");
	$("#alertDanger").hide();
	
	//form validation
	var status = validationFundForm();
	if(status != true){
		$("#alertDanger").text(status);
		$("#alertDanger").show();
		return;	
	}
	
	//if valid
	var type=($("#hidIDItemIDSave").val()=="") ? "post" : "put";
	$.ajax({
		url : "ItemApi",
		type : type,
		data : $("#formItem").serialize(),
		dataType : "text",
		complete : function(response, status){
			onItemSaveComplete(response.responseText, status);
		}
		
	});
	//$("#formItem").submit();
	/*var item = java();
	$("#colItem").append(item);*/
	//$("#formItem")[0].reset();
	
	
});

function onItemSaveComplete(response, status){
	
	if(status == "success"){
		var resultSet = JSON.parse(response);
		
		if(resultSet.status.trim() == "success"){
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			
			$("#colItem").html(resultSet.data);
		}else if(resultSet.status.trim() == "error"){
			$("#alertDanger").text(resultSet.data)
			$("#alertDanger").show();
		}
	}else if(status == "error"){
		$("#alertDanger").text("Error while saving.");
		$("#alertDanger").show();
	}else{
		$("#alertDanger").text("Unknown error while saving.");
		$("#alertDanger").show();
	}
	$("#hidIDItemIDSave").val("");
	$("#formItem")[0].reset();
}

//update
$(document).on("click",".btnUpdate", function(event){
	$("#hidIDItemIDSave").val($(this).data("itemid"));
	$("#code").val($(this).closest("tr").find('td:eq(1)').text());
	$("#name").val($(this).closest("tr").find('td:eq(2)').text());
	$("#price").val($(this).closest("tr").find('td:eq(3)').text());
	$("#description").val($(this).closest("tr").find('td:eq(4)').text());
	
});

//Delete
$(document).on("click", ".btnRemove", function(event){
	$.ajax({
		url : "ItemApi",
		type : "DELETE",
		data : "id="+$(this).data("itemid"),
		dataType : "text",
		complete : function(respnose, status){
			onItemDeleteComplete(respnose.responseText, status);
		}
			
	});
});



function onItemDeleteComplete(response, status){
	
	if(status == "success"){
		var resultSet = JSON.parse(response);
		
		if(resultSet.status.trim() == "success"){
			$("#alertSuccess").text("Successfully deletd.");
			$("#alertSuccess").show();
			
			$("#colItem").html(resultSet.data);
		}else if(resultSet.status.trim() == "error"){
			$("#alertDanger").text(resultSet.data)
			$("#alertDanger").show();
		}
	}else if(status == "error"){
		$("#alertDanger").text("Error while deleting.");
		$("#alertDanger").show();
	}else{
		$("#alertDanger").text("Unknown error while deleting.");
		$("#alertDanger").show();
	}
	//$("#hidIDItemIDSave").val("");
	$("#formItem")[0].reset();
}















