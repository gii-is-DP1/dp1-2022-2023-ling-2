<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %-->

<endofline:layout pageName="home">
    <div class="center">
        <img src="<spring:url value="/resources/images/eol.png" htmlEscape="true"/>" width="40px" alt="End of Line logo">
        <h2 class="title">Welcome to End Of Line</h2>
        <form:form action="/multiplayer/create" method="POST">
            <input type="submit" class="btn margins-small" value="Create Multiplayer Game"/>
        </form:form>
        <form:form action="/singleplayer/create" method="POST">
            <input type="submit" class="btn margins-small" value="Create Singleplayer Game"/>
        </form:form>
    </div>
</endofline:layout>
