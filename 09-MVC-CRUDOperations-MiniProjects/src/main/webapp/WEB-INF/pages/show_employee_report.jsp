<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<c:choose>
<c:when test="${!empty empList}">
<h1 style="color:red;text-align:center">Employees Report</h1>
<table  border="1" align="center" bgcolor="cyan">
<tr style="color:red"><th>eno</th><th>ename</th><th>job</th><th>sal</th><th>deptno</th></tr>
<c:forEach var="emp" items="${empList}">
<tr style="color:blue">
<td>${emp.eno}</td>
<td>${emp.ename}</td>
<td>${emp.job}</td>
<td>${emp.sal}</td>
<td>${emp.deptno}</td>
<td><a href="emp_edit?no=${emp.eno}"><img src="images/Edit.jpg" width="30px" height="30px"></a>
<a href="emp_delete?no=${emp.eno}" onclick="return confirm('Do you want to delete the Employee')"><img src="images/Delete.jpg" width="30px" height="30px"></a></td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center">Employees Not Found</h1>
</c:otherwise>
</c:choose>
<center>
<a href="emp_add"><img src="images/Add.jpg" width="40px" height="50px">Add Employee</a>&nbsp;&nbsp;&nbsp;
<a href="./"><img src="images/Home.jpg" width="40px" height="50px">Home</a>
</center>
<h2 style="color:green;text-align:center">${resultMsg}</h2>