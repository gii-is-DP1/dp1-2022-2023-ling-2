<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<endofline:layout pageName="Pregame Lobby">
    <div class="center">
        <c:choose>
            <c:when test="${game.isPublic}">
                <h1>Waiting for players to start ...</h1>
            </c:when>
            <c:when test="${isHostOfPrivateGame}">
                <h1>Invite players to your game</h1>
            </c:when>
            <c:otherwise>
                <h1>Waiting for host to start</h1>
            </c:otherwise>
        </c:choose>
        <table class="table table-striped">
            <caption>Users in game</caption>
            <thead>
            <tr>
                <th>User</th>
                <th>Color</th>
                <th>Role</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${usersRelationToGame}" var="userGame">
                <tr>
                    <td>
                        <c:out value="${userGame.user.username}"/>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${userGame.player==1}">
                                <b style="color: lightblue">blue</b>
                            </c:when>
                            <c:when test="${userGame.player==2}">
                                <b style="color: pink">pink</b>
                            </c:when>
                            <c:otherwise>
                                <b style="color: black">black</b>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:out value="${userGame.role}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <!-- Tables to invite users in privates games -->
        <c:if test="${isHostOfPrivateGame}">
            <div style="height:500px; overflow:auto; float: left; margin-left: 2%; width: 32%;">
            <table class="table table-striped">
                <caption>Friends Not Invited</caption>
                <thead>
                <tr>
                    <th>User</th>
                    <th>Invite to Play</th>
                    <th>Invite to Spectate</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${friendsNotInvited}" var="friend">
                    <tr>
                        <td>
                            <a href="/u/${friend.username}">${friend.username}</>
                        </td>
                        <td>
                            <a href="/gameinvite/create?friend=${friend.username}&gameId=${game.id}&type=0"><span
                                    class="glyphicon glyphicon-ok" aria-hidden="true"/></a>
                        </td>
                        <td>
                            <a href="/gameinvite/create?friend=${friend.username}&gameId=${game.id}&type=1"><span
                                    class="glyphicon glyphicon-eye-open" aria-hidden="true"/></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <table class="table table-striped">
                <caption>Friends Invited</caption>
                <thead>
                <tr>
                    <th>User invited</th>
                    <th>Type</th>
                    <th>Cancel</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${friendsInvitedInvites}" var="invite">
                    <tr>
                        <td>
                            <span>${invite.receiver.username} </span>
                        </td>
                        <td>
                            <span>${invite.type} </span>
                        </td>
                        <td>
                            <a href="/gameinvite/delete/${invite.id}/${gameId}"><span
                                    class="glyphicon glyphicon-remove warning" aria-hidden="true"/></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <!-- Button to start game -->
            <c:if test="${usersRelationToGame.stream().filter(ug -> ug.role.toString().equals('PLAYER')).toList().size()>=2}">
                <form:form action="/multiplayer/startGame/${game.id}" method="GET">
                    <input id="btn" type="submit" value="Start Game" class="btn btn-warning margins-small"/>
                </form:form>
            </c:if>
        </c:if>
    </div>
</endofline:layout>

<script>

    setTimeout(() => {location.reload()}, 2000)

</script>
