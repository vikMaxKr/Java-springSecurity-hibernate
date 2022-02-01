<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Saving the customer</title>
<style type="text/css">
.error{
color:red;
}
</style>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM-Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<h3>Save Customer</h3>
		<i>(*)is required field</i>
        <br><br>
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
		
		<!-- need to associate this data with customer id (it is used when Upadting and loading data to db) -->
		
		<form:hidden path="id"/>
		
		
		<table>
		
		<tbody>
		
		<tr>
		<td><label>First Name(*):</label></td>
		<td><form:input path="firstName"/></td>
		<td><form:errors path="firstName" cssClass="error" /></td>
		</tr>
		
		<tr>
		<td><label>Last Name:</label></td>
		<td><form:input path="lastName"/></td>
		</tr>
		
		<tr>
		<td><label>Email:</label></td>
		<td><form:input path="email"/></td>
		</tr>
		
		<tr>
		<td><label></label></td>
		<td><input type="submit" value="Save" class ="save" /></td>
		</tr>
		</tbody>
		
		</table>
		
		</form:form>
			</div>

</body>

</html>