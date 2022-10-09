<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${!empty empInfo}"><b>Employee Information::${empInfo.eno},${empInfo.ename},${empInfo.salary},${empInfo.vaccinated}</b></c:if>