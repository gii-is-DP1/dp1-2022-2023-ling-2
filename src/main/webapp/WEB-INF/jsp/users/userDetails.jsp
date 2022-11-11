<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<endofline:layout pageName="userDetails">
    <div class="center">
        <h2 class="title">${user.username}</h2>
        <p>${user.email}</p>
        <c:if test="${private_info}">
            <div class="center-horizontal">
                <form:form action="/u/${user.username}/edit" method="GET">
                    <input type="submit" class="btn margins-small" value="Edit"/>
                </form:form>
                <c:if test="${!admin}">
                    <form:form action="/u/${user.username}/delete" method="GET">
                        <input type="submit" class="btn btn-danger margins-small" value="Delete"/>
                    </form:form>
                </c:if>
            </div>
        </c:if>
    </div>
    <br>
    <br>
    <c:if test="${private_info}">
        <div>
            <table class="table table-striped" style="float: left; width: 49%">
                <caption>Multiplayer Games</caption>
                <thead>
                <tr>
                    <th>Start</th>
                    <th>Finish</th>
                    <th>Winner</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${multiplayerGames}" var="mult">
                    <tr>
                        <td>
                            <fmt:parseDate value="${mult.dateStarted}" pattern="yyyy-MM-dd'T'HH:mm" var="formatedDate" type="both"/>
                            <fmt:formatDate pattern="dd/MMM/yyyy HH:mm" value="${formatedDate}"/>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${mult.dateEnded == null}">
                                    <c:out value="Unfinished"/>
                                </c:when>
                                <c:otherwise>
                                    <fmt:parseDate value="${mult.dateEnded}" pattern="yyyy-MM-dd'T'HH:mm" var="formatedDate" type="both"/>
                                    <fmt:formatDate pattern="dd/MMM/yyyy HH:mm" value="${formatedDate}"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${mult.result == null}">
                                    <c:out value="Unfinished"/>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${mult.result}"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table class="table table-striped" style="float: right; width: 49%">
                <caption>Singleplayer Games</caption>
                <thead>
                <tr>
                    <th>Start</th>
                    <th>Finish</th>
                    <th>Puzzle</th>
                    <th>Beaten</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${singleplayerGames}" var="singl">
                    <tr>
                        <td>
                            <fmt:parseDate value="${singl.dateStarted}" pattern="yyyy-MM-dd'T'HH:mm" var="formatedDate" type="both"/>
                            <fmt:formatDate pattern="dd/MMM/yyyy HH:mm" value="${formatedDate}"/>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${singl.dateEnded == null}">
                                    <c:out value="Unfinished"/>
                                </c:when>
                                <c:otherwise>
                                    <fmt:parseDate value="${singl.dateEnded}" pattern="yyyy-MM-dd'T'HH:mm" var="formatedDate" type="both"/>
                                    <fmt:formatDate pattern="dd/MMM/yyyy HH:mm" value="${formatedDate}"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>

                        </td>
                        <td>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</endofline:layout>
