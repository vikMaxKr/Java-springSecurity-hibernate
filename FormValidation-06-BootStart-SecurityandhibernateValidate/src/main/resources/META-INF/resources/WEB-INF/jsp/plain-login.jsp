<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${param.error !=null}">

<i>Sorry ! access denied</i>
</c:if>



<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

User Name:<input type="text" name="username"/>

<br><br>

Password:<input type="password" name="password"/> 

<br><br>

<input type="submit" value="SUBMIT"/>

</form:form>
