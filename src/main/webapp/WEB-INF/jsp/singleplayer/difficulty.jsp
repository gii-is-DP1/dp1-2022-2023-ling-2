<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %-->

<endofline:layout pageName="difficulty">
    <div class="center">
        <p>Singleplayer mode</p>
        <h1>Select the difficulty of the game</h1>
        <div class="center-horizontal">
            <form:form action="/singleplayer/create?difficulty=EASY" method="POST">
                <input type="submit" class="btn btn-info margins-small" value="Easy"/>
            </form:form>
            <form:form action="/singleplayer/create?difficulty=MEDIUM" method="POST">
                <input type="submit" class="btn btn-warning margins-small" value="Medium"/>
            </form:form>
            <form:form action="/singleplayer/create?difficulty=HARD" method="POST">
                <input type="submit" class="btn btn-danger margins-small" value="Hard"/>
            </form:form>
        </div>
    </div>
</endofline:layout>
