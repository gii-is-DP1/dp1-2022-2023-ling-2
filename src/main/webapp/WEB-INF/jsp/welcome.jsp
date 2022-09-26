<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %-->  

<petclinic:layout pageName="home">
    <h2><fmt:message key="welcome"/></h2>
    <div class="row">
        <h2>Project ${title}</h2>
        <p>
        <h2> Group ${group}</h2> </p>
        <p><ul>
        <c:forEach items="${persons}" var="person">
            <li>${person.firstName} &nbsp; ${person.lastName}</li>
        </c:forEach>
    </ul></p>
    </div>
    <div class="row">
        <div class="col-md-12">
            <spring:url value="/resources/images/harmony.gif" htmlEscape="true" var="teamImage"/>
            <img class="img-responsive" src="${teamImage}"  width="500" height="500"/>
            <spring:url value="/resources/images/logoPNG_3.png" htmlEscape="true" var="usImage"/>
            <img class="img-responsive" src="${usImage}"/>
        </div>
    </div>
</petclinic:layout>
