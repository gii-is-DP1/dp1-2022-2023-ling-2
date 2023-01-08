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
        <c:if test="${show_fr_button}">
            <c:choose>
                <c:when test="${fr_status.equals('request')}">
                    <form:form action="/friendrequest/send/${user.username}" method="POST">
                        <input type="submit" class="btn margins-small" value="Send Friend Request"/>
                    </form:form>
                </c:when>
                <c:when test="${fr_status.equals('friend')}">
                    <form:form action="/removefriend/${user.username}" method="GET">
                        <input type="submit" class="btn btn-danger margins-small" value="Remove Friend"/>
                    </form:form>
                </c:when>
                <c:when test="${fr_status.equals('pending')}">
                    <h4>A friend request has been sent</h4>
                </c:when>
                <c:when test="${fr_status.equals('accept')}">
                    <div class="center-horizontal">
                        <form:form action="/friendrequest/${friend_request.id}/accept" method="GET">
                            <input type="submit" class="btn margins-small" value="Accept Friend Request"/>
                        </form:form>
                        <form:form action="/friendrequest/${friend_request.id}/reject" method="GET">
                            <input type="submit" class="btn btn-danger margins-small" value="Reject Friend Request"/>
                        </form:form>
                    </div>
                </c:when>
            </c:choose>
        </c:if>
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
        <div style="height:250px; overflow:auto; float: left; width: 49%">
            <table class="table table-striped">
                <caption>Multiplayer Games</caption>
                <thead>
                <tr>
                    <th>Start</th>
                    <th>Finish</th>
                    <th>Status</th>
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
                            <c:out value="${mult.gameStatus}"/>
                        </td>
                        <td>
                            <c:out value="${mult.winner.username}"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="height:250px; overflow:auto; float: right; width: 49%">
            <table class="table table-striped">
                <caption>Singleplayer Games</caption>
                <thead>
                <tr>
                    <th>Start</th>
                    <th>Finish</th>
                    <th>Difficulty</th>
                    <th>Status</th>
                    <th>Winner</th>
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
                            <c:out value="${singl.puzzle.difficulty}"/>
                        </td>
                        <td>
                            <c:out value="${singl.gameStatus}"/>
                        </td>
                        <td>
                            <c:out value="${singl.winner.username}"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
        <div style="height:250px; overflow:auto; float: left; width: 49%">
            <br>
            <table class="table table-striped">
                <caption>Statistics</caption>

                <thead>
                <tr>
                    <th>Total Games</th>
                    <th>Singleplayer Wins</th>
                    <th>Singleplayer Losses</th>
                    <th>Multiplayer Wins</th>
                    <th>Multiplayer Losses</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${statistic.numberGames}"/>
                        </td>
                        <td>
                            <c:out value="${statistic.numberSinglePlayerWins}"/>
                        </td>
                        <td>
                            <c:out value="${statistic.numberSinglePlayerLosses}"/>
                        </td>
                        <td>
                            <c:out value="${statistic.numberMultiPlayerWins}"/>
                        </td>
                        <td>
                            <c:out value="${statistic.numberMultiPlayerLosses}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div style="height:250px; overflow:auto; float: right; width: 49%">
            <br>
            <table class="table table-striped">
            <caption> Achievements </caption>
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
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

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</endofline:layout>
