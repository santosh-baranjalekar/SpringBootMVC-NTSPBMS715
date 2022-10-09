<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${!empty empListInfo}">
<table border="1" bgcolor="cyan" align="center">
<tr><th>eno</th><th>ename</th><th>salary</th><th>vaccinated</th>

<c:forEach var="emp" items="${empListInfo}">
<tr>
<td>${emp.eno}</td>
<td>${emp.ename}</td>
<td>${emp.salary}</td>
<td>${emp.vaccinated}</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center">Employee Not Found</h1>
</c:otherwise>
</c:choose>