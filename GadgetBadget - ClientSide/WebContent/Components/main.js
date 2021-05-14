$(document).ready(function(){
	if($("#alertSuccess").text().trim()==""){
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});

//Validation 
function validateFundForm(){
	//code
	if($("#cartID").val().trim() == ""){
		return "Insert the cart id";
	}
	
	//researcher name
	if($("#rName").val().trim() == ""){
		return "Insert the Researcher Name";
	}
	
	//Invest amount
	if($("#iAmount").val().trim() == ""){
		return "Insert the invest amount";
	}
	
	//description
	if($("#description").val().trim() == ""){
		return "Insert the description";
	}
	
	return true;
	
}

//save === 
$(document).on("click", "#btnSave", function(){
	//clear alerts
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	//form validation
	var status = validateFundForm();
	if(status != true){
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	
	//if valid
	var type = ($("#hidFundIDSave").val()=="") ? "post" : "put";
	$.ajax({
		url : "FundAPI",
		type : type,
		data : $("#formFund").serialize(),
		dataType : "text",
		complete : function(response, status){
			onFundSaveComplete(response.responseText, status)
		}
	});
});

function onFundSaveComplete(response, status){
	if(status == "success"){
		var resultSet = JSON.parse(response);
		
		if(resultSet.status.trim() == "success"){
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			
			$("#colFund").html(resultSet.data);
		}else if(resultSet.status.trim() == "error"){
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}else if(status == "error" ){
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	}else{
		$("#alertError").text("Unknown Error while saving.");
		$("#alertError").show();
	}
	$("#hidFundIDSave").val("");
	$("#formFund")[0].reset();
	
} 

$(document).on("click", ".btnUpdate", function(event){
	$("#hidFundIDSave").val($(this).data("funid"));
	$("#cartID").val($(this).closest("tr").find('td:eq(1)').text());
	$("#rName").val($(this).closest("tr").find('td:eq(2)').text());
	$("#iAmount").val($(this).closest("tr").find('td:eq(3)').text());
	$("#description").val($(this).closest("tr").find('td:eq(4)').text());
});

