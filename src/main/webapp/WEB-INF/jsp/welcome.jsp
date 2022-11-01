<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %-->

<endofline:layout pageName="home">
    <div>
        <h2><img src="<spring:url value="/resources/images/eol.png" htmlEscape="true"/>" width="40px">    Welcome to End Of Line</h2>
    </div>
    <div>

    </div>
</endofline:layout>
