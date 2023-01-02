<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<endofline:layout pageName="gameSearch">
    <div class="center">
        <p>Multiplayer search mode</p>
        <h1>Select the way of searching for the game</h1>
        <div class="center-horizontal">
            <form:form action="/multiplayer/create?type=public" method="POST">
                <input type="submit" class="btn btn-info margins-small" value="Random Public"/>
            </form:form>
            <form:form action="/multiplayer/create?type=private" method="POST">
                <input type="submit" class="btn btn-warning margins-small" value="Private"/>
            </form:form>
        </div>
    </div>
</endofline:layout>
