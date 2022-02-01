<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>List Customers</title>
<link href="<c:url value="/css/add-customer-style.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM -Customer RelationShip Model</h2>
		</div>
	</div>
	<div id="container">

		<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd';return false;"
			class="add-button" />

		<div id="contain">

			<table>

				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct an update link with customer id -->

					<c:url var="updateLink" value="/customer/showFormForUpdate">
					
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<!-- construct an delete link with customer id -->

					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!-- display update link --> 
							<a href="${updateLink}">Update</a>
						</td>

						<td>
						<a href="${deleteLink}"
	 onclick ="if (!confirm('Are you sure you want to delete?'))) return false "> Delete</a></td>
						
					</tr>
				</c:forEach>
			</table>

		</div>

	</div>
</body>
</html>