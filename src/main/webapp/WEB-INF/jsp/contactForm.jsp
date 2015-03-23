<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form:form id = "contactFormId" action="${actionString}" method="POST" modelAttribute="contact">
	<table>
		<tr>
			<td>Contact ID</td>
			<td><form:input path="contactId" id = "contactId"/></td>
		</tr>
		<tr>
			<td>Full Name</td>
			<td><form:input path="name" id = "name" /></td>
		</tr>
		<tr>
			<td>Email ID</td>
			<td><form:input path="emailId" id = "emailId"/></td>
		</tr>
		<tr>
			<td>Phone No</td>
			<td><form:input path="phoneNo" id = "phoneNo"/></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><form:input path="address" id = "address"/></td>
		</tr>
		<tr>
		
			
		</tr>
	</table>
</form:form>