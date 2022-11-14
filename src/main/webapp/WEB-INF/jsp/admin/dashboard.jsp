<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>

<endofline:layout pageName="dashboard">
<jsp:body>
    <div>
        <div style="height:500px; overflow:auto; float: left; width: 49%">
            <table class="table table-striped">
                <caption>Multiplayer Games</caption>
                <thead>
                <tr>
                    <th>Start</th>
                    <th>Finish</th>
                    <th>Winner</th>
                    <th>Players</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${multi}" var="multi">
                    <tr>
                        <td>
                            <fmt:parseDate value="${multi.dateStarted}" pattern="yyyy-MM-dd'T'HH:mm" var="formatedDate" type="both"/>
                            <fmt:formatDate pattern="dd/MMM/yyyy HH:mm" value="${formatedDate}"/>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${multi.dateEnded == null}">
                                    <c:out value="Unfinished"/>
                                </c:when>
                                <c:otherwise>
                                    <fmt:parseDate value="${multi.dateEnded}" pattern="yyyy-MM-dd'T'HH:mm" var="formatedDate" type="both"/>
                                    <fmt:formatDate pattern="dd/MMM/yyyy HH:mm" value="${formatedDate}"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${multi.result == null}">
                                    <c:out value="Unfinished"/>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${multi.result}"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:forEach items="${multi.users}" var="userGame">
                                <a href="/u/${userGame.user.username}">${userGame.user.username}</>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="height:500px; overflow:auto; float: right; width: 49%">
            <table class="table table-striped">
                <caption>Singleplayer Games</caption>
                <thead>
                <tr>
                    <th>Start</th>
                    <th>Finish</th>
                    <th>Puzzle</th>
                    <th>Beaten</th>
                    <th>Player</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${single}" var="single">
                    <tr>
                        <td>
                            <fmt:parseDate value="${single.dateStarted}" pattern="yyyy-MM-dd'T'HH:mm" var="formatedDate" type="both"/>
                            <fmt:formatDate pattern="dd/MMM/yyyy HH:mm" value="${formatedDate}"/>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${single.dateEnded == null}">
                                    <c:out value="Unfinished"/>
                                </c:when>
                                <c:otherwise>
                                    <fmt:parseDate value="${single.dateEnded}" pattern="yyyy-MM-dd'T'HH:mm" var="formatedDate" type="both"/>
                                    <fmt:formatDate pattern="dd/MMM/yyyy HH:mm" value="${formatedDate}"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>

                        </td>
                        <td>

                        </td>
                        <td>
                            <a href="/u/${single.user.username}">${single.user.username}</>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div>
        <div style="height:500px; overflow:auto; float: left; width: 49%">
            <table class="table table-striped">
                <caption>Users</caption>
                <thead>
                <tr>
                    <th>Username</th>
                    <th>Email</th>
                    <th>isAdmim</th>
                    <th>enabled</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>

                                <a href="/u/${user.username}">${user.username}</>
                            </td>
                            <td>
                                <c:out value="${user.email}"/>
                            </td>
                            <td>
                                <c:out value="${user.isAdmin}"/>
                            </td>
                            <td>
                                <c:out value="${user.enabled}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="height:500px; overflow:auto; float: right; width: 49%">
            <table class="table table-striped">
                <caption>Achievements</caption>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th><a href="/achievement/new"><span class="glyphicon glyphicon-plus success" aria-hidden="true"/> New</a></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${achievements}" var="achievement">
                    <tr>
                        <td>
                            <c:out value="${achievement.name}"/>
                        </td>
                        <td>
                            <c:out value="${achievement.description}"/>
                        </td>
                        <td>
                            <a href="/achievement/${achievement.name}"><span class="glyphicon glyphicon-pencil warning" aria-hidden="true"/></a>
                            <a href="/achievement/delete/${achievement.name}"><span class="glyphicon glyphicon-trash warning" aria-hidden="true"/></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</jsp:body>
</endofline:layout>
