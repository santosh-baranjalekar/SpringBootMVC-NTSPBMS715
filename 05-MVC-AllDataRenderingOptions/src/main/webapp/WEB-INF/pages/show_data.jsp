<%@page isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Model Attribute data is</h1>
<b>Favourite colors are::</b><br>
<c:forEach var="color" items="${favColours}">${color}</c:forEach><br>

<b>NickNames are::</b><br>
<c:forEach var="names" items="${nickNames}">${names}</c:forEach><br>

<b>Phone Numbers are::</b><br>
<c:forEach var="phone" items="${phoneNumbers}">${phone}</c:forEach><br>

<b>Id Details are::</b><br>
<c:forEach var="id" items="${idDetails}">${id.key},${id.value}<br></c:forEach>