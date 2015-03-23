<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts App</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
</head>
<body>
<h1>Contacts</h1>

<button  onclick="addContact()">Add Book</button><br>

 <div id="formDialog" style="display: none;">
      <%@ include file="contactForm.jsp"%>
 </div>
 

<br>
 <div id="contactListDiv" >
      <%@ include file="contactList.jsp"%>
 </div>




<script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 
<script>

function addContact() {
    $('#formDialog').dialog("option", "title", 'Add New Contact');
    $('#formDialog').dialog('open');
}

function editContact(id) {

    $.get("get/" + id, function(result) {

           $("#formDialog").html(result);
           $('#formDialog').dialog("option", "title", 'Edit Contact');
           $("#formDialog").dialog('open');

          
    });
}

function deleteContact(id) {
	$.get("delete/" + id , function(result) {
    	alert(result);
    	$.get("getUpdatedList", function(result) {
        	$("#contactListDiv").html(result);
        });
    });
	
	
	
}



function resetDialog(form) {

    form.find("input").val("");
}


$(document).ready(function() {

	  $('#formDialog').dialog({

          autoOpen : false,
          position : 'center',
          modal : true,
          resizable : false,
          width : 440,
          buttons : {
                 "Save" : function() {
                	
					$.ajax({
					    data:$("#contactFormId").serialize(),
					    url : $("#contactFormId").attr("action"),
					    type : "POST",
					    success : function(response) {
						    alert(response);
						    resetDialog($('#contactFormId'));
						    
						    
						    $('#formDialog').dialog('close');
						    $.get("getUpdatedList", function(result) {
			                	$("#contactListDiv").html(result);
			                });
			                
			                
					    }
					
					});
					
					$.get("getNewForm", function(result) {
	                	$("#formDialog").html(result);
	                });
					
					
	                
                	 //$('#contactFormId').submit();
                 },
                 "Cancel" : function() {
                       $(this).dialog('close');
                 }
          },
          close : function() {

                 resetDialog($('#contactFormId'));
                 $(this).dialog('close');
          }
   });
    
});
</script>


</body>
</html>