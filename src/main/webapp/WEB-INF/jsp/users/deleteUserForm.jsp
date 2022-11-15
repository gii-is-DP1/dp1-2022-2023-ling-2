<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>

<endofline:layout pageName="deleteUser">
    <jsp:body>
        <div class="center">
            <h2>Delete user <strong>${user.username}</strong></h2>
            <p>You are about to delete the user <i>${user.username}</i>.</p>
            <p>All games, stats and achievements will be lost. Are you sure?</p>
            <div class="center-horizontal">
                <form:form action="/u/${user.username}/delete" method="POST">
                    <input type="submit" class="btn btn-danger margins-small" value="Delete"/>
                </form:form>
                <form:form action="/u/${user.username}" method="GET">
                    <input type="submit" class="btn margins-small" value="Cancel"/>
                </form:form>
            </div>
        </div>
    </jsp:body>
</endofline:layout>
