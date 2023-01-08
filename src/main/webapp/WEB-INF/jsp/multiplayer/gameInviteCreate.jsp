<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<endofline:layout pageName="Invite Friend">
    <div class="center">
        <p>Multiplayer private</p>
        <h1>Select Player to invite to game</h1>
            <div style="height:500px; overflow:auto; float: left; margin-left: 2%; width: 32%;">
                <table class="table table-striped">
                    <caption>Friends</caption>
                    <thead>
                    <tr>
                        <th>User</th>
                        <th>Invite to Play</th>
                        <th>Invite to Spectate</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${friends}" var="friend">
                        <tr>
                            <td>
                                <a href="/u/${friend.username}">${friend.username}</>
                            </td>
                            <td>
                                <a href="/gameinvite/${gameId}?friend=${friend.username}"><span class="glyphicon glyphicon-ok" aria-hidden="true"/></a>
                            </td>
                            <td>
                                <a href="/spectateinvite/${gameId}?friend=${friend.username}"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"/></a>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


                <table class="table table-striped">
                    <caption>Friends</caption>
                    <thead>
                    <tr>
                        <th>User invited</th>
                        <th>Type</th>
                        <th>Cancle</th>
                        <th>Accepted</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${invites}" var="invite">
                        <tr>
                            <td>
                                <span >${invite.receiver.username} </span>
                            </td>
                            <td>
                                <span >${invite.type} </span>
                            </td>
                            <td>
                                <a href="/invite/delete/${invite.id}/${gameId}"><span class="glyphicon glyphicon-remove warning" aria-hidden="true"/></a>
                            </td>
                            <td>
                                <span >${invite.accepted}</span>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <!--TODO: only clickable when game is ready-->
                <form:form action="/multiplayer/startGame/${gameId}" method="GET">
                    <input type="submit" value="Start Game" class="btn btn-warning margins-small"/>
                </form:form>
        </div>
    </div>

</endofline:layout>

<script>

    function fetchQueueStatus(){
        const id = window.location.href.substring(window.location.href.lastIndexOf('/') + 1);
        fetch('http://localhost:8080/multiplayer/info/queueStatus/${id}?mediaType=json', {
            method: 'GET'
        })
            .then(response => response.text())
            .then(text => checkIfReady(text))
        setTimeout(fetchQueueStatus, 1000);
    }

    function checkIfReady(text){
        if(text.toLowerCase() === "true"){
            //location.reload();
        }
    }

    fetchQueueStatus()


</script>
