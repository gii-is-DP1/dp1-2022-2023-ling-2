<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<endofline:layout pageName="Pregame Lobby">
    <div class="center">
        <c:choose>
            <c:when test="${!game.isPublic}">
                <p>Waiting for host ...</p>
                <h1>This is the pregame lobby for game ${gameId}</h1>
                <div style="height:500px; overflow:auto; float: left; margin-left: 2%; width: 32%;">

                    <!--TODO: add infos about game (host, other players/spectators-->
               <p>You'll be playing against <a href="/u/${player1Username}" target="_blank">${player1Username}</p>
                </div>
            </c:when>
            <c:otherwise>
                <p>Multiplayer public queue</p>
                <h1>Waiting for people to create game</h1>
                <div class="center-horizontal">
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</endofline:layout>


<script>

    function fetchQueueStarted() {
        const id = window.location.href.substring(window.location.href.lastIndexOf('/') + 1);
        fetch('http://localhost:8080/multiplayer/info/queueStarted/${gameId}?mediaType=json', {
            method: 'GET'
        })
            .then(response => response.text())
            .then(text => checkIfReady(text))
        setTimeout(fetchQueueStarted, 1000);
    }

    function checkIfReady(text) {
        if (text.toLowerCase() === "true") {
            location.reload();
        }
    }

    function fetchQueueStatus() {
        const id = window.location.href.substring(window.location.href.lastIndexOf('/') + 1);
        fetch('http://localhost:8080/multiplayer/info/queueStatus/${id}?mediaType=json', {
            method: 'GET'
        })
            .then(response => response.text())
            .then(text => checkIfReady(text))
        setTimeout(fetchQueueStatus, 1000);
    }

    function checkIfReady(text) {
        if (text.toLowerCase() === "true") {
            location.reload();
        }
    }


    fetchQueueStarted()
    fetchQueueStatus()


</script>
