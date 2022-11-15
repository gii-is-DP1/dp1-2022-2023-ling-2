<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>

<endofline:layout pageName="statistics">
    <jsp:body>
        <div>
            <h2 align="center">Your Statistics</h2>
            <div style="margin: auto; width: 60%">
                <table class="table table-striped">
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
                    <c:forEach items="${personal}" var="statistic">
                        <tr>
                            <td>
                                <a href="/u/${statistic.numberGames}">${statistic.numberGames}</>
                            </td>
                            <td>
                                <a href="/u/${statistic.numberSinglePlayerWins}">${statistic.numberSinglePlayerWins}</>
                            </td>
                            <td>
                                <a href="/u/${statistic.numberSinglePlayerLosses}">${statistic.numberSinglePlayerLosses}</>
                            </td>
                            <td>
                                <a href="/u/${statistic.numberMultiPlayerWins}">${statistic.numberMultiPlayerWins}</>
                            </td>
                            <td>
                                <a href="/u/${statistic.numberMultiPlayerLosses}">${statistic.numberMultiPlayerLosses}</>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <h2>Leaderboards</h2>
            <div style="height:500px; overflow:auto; float: left; width: 40%">
                <table class="table table-striped">
                    <caption>Leaderboard Singleplayer Wins</caption>
                    <thead>
                    <tr>
                        <th>Username</th>
                        <th>Number Singleplayer Wins</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${single}" var="statistic">
                        <tr>
                            <td>
                                <a href="/u/${statistic.user.username}">${statistic.user.username}</>
                            </td>
                            <td>
                                <a href="/u/${statistic.numberSinglePlayerWins}">${statistic.numberSinglePlayerWins}</>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div style="height:500px; overflow:auto; float: right; width: 40%">
                <table class="table table-striped">
                    <caption>Leaderboard Multiplayer Wins</caption>
                    <thead>
                    <tr>
                        <th>Username</th>
                        <th>Number Multiplayer Wins</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${multi}" var="statistic">
                        <tr>
                            <td>
                                <a href="/u/${statistic.user.username}">${statistic.user.username}</>
                            </td>
                            <td>
                                <a href="/u/${statistic.numberMultiPlayerWins}">${statistic.numberMultiPlayerWins}</>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</endofline:layout>
