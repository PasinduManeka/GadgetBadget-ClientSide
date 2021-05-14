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
	
	
	
}