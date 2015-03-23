<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
	<tr>
	<th>Contact ID</th>
	<th>Full Name</th>
	<th>Email ID</th>
	<th>Phone No.</th>
	<th>Address</th>
	<th>Actions</th>
	</tr>
	<c:forEach items="${contactList}" var="contact">
		<tr>
			<td>${contact.contactId}</td>
			<td>${contact.name}</td>
			<td>${contact.emailId}</td>
			<td>${contact.phoneNo}</td>
			<td>${contact.address}</td>
			<td><button  onclick="editContact(${contact.contactId})">Edit</button> 
			<button  onclick="deleteContact(${contact.contactId})">Delete</button></td>
		</tr>
	</c:forEach>
</table>