<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<endofline:layout pageName="gameSearch">
    <div class="center">
        <h1>Type of game</h1>
        <div class="center-horizontal">
            <form:form action="/multiplayer/create?isPublic=true" method="POST">
                <input type="submit" class="btn btn-info margins-small" value="Public"/>
            </form:form>
            <form:form action="/multiplayer/create?isPublic=false" method="POST">
                <input type="submit" class="btn btn-warning margins-small" value="Private"/>
            </form:form>
        </div>
    </div>
</endofline:layout>
