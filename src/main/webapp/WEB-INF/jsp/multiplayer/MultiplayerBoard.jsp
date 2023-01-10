<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<endofline:layout pageName="multiplayer_game">
    <div class="center">
        <h1 id="title">Multiplayer: <b><a href="/u/${player1Username}" target="_blank">${player1Username}</a></b> vs. <b><a href="/u/${player2Username}" target="_blank">${player2Username}</a></b></h1>
        <c:if test="${!game.gameStatus.toString().equals('FINISHED')}">
        <c:if test="${userGameRelation.role.toString().equals('PLAYER')}">
            <c:choose>
                <c:when test="${isPlayerActive==true}">
                    <div class="center text-success">
                        <h1>It is your turn</h1>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="center text-danger">
                        <h1>Your opponent's turn</h1>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:if>
        </c:if>
        <c:if test="${game.gameStatus.toString().equals('FINISHED')}">
            <script>
                document.getElementById("title").setAttribute("style", "display: none !important;");
                document.getElementById("hand").setAttribute("style", "display: none !important;");
            </script>
            <c:choose>
                <c:when test="${game.winner==null}">
                    <div class="center text-warning">
                        <h1>It's a Tie!</h1>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="center text-success">
                        <h1>The winner of the game is: <b><a href="/u/${game.winner.username}" target="_blank">${game.winner.username}</a></b></h1>
                    </div>
                </c:otherwise>
            </c:choose>
            <div class="center-horizontal">
                <a href="/multiplayer/create" class="btn btn-primary margins-small">Play again</a>
                <a href="/" class="btn btn-primary margins-small">Go back</a>
            </div>
        </c:if>
        <endofline:board side="7" gameCards="${cardsOnBoard}" player1Id="${player1Id}"/>
        <c:if test="${!game.gameStatus.toString().equals('FINISHED')}">
            <div id="hand" class="center">
                <endofline:hand handCards="${handCards}" num="5" cards_left="${cards_left}" energyLeft="${userGameRelation.energy}" playerNo="${handCards.get(0).user.id==player1Id ? 1 : 2}"/>
            </div>
        </c:if>
    </div>
</endofline:layout>
<script>
    let lastPlacedCard = {
        "x": "${lastPlacedCard.x}",
        "y": "${lastPlacedCard.y}",
        "rotation": "${lastPlacedCard.rotation}",
        "status": "${lastPlacedCard.status}",
        "up" : "${lastPlacedCard.card.up}",
        "down" : "${lastPlacedCard.card.down}",
        "left" : "${lastPlacedCard.card.left}",
        "right" : "${lastPlacedCard.card.right}"
    };

    let userCardsOnBoard = [
        <c:forEach items="${userCardsOnBoard}" var="card">
        {
            "x": "${card.x}",
            "y": "${card.y}",
            "rotation": "${card.rotation}",
            "status": "${card.status}",
            "up" : "${card.card.up}",
            "down" : "${card.card.down}",
            "left" : "${card.card.left}",
            "right" : "${card.card.right}",
            "round" : "${card.round}"
        },
        </c:forEach>
    ];

    let cardsInHand = [
        <c:forEach items="${handCards}" var="card">
        {
            "id": "${card.id}",
            "x": "${card.x}",
            "y": "${card.y}",
            "rotation": "${card.rotation}",
            "status": "${card.status}",
            "up" : "${card.card.up}",
            "down" : "${card.card.down}",
            "left" : "${card.card.left}",
            "right" : "${card.card.right}"
        },
        </c:forEach>
    ];

    let cardsOnBoard = [
        <c:forEach items="${cardsOnBoard}" var="card">
        {
            "x": "${card.x}",
            "y": "${card.y}"
        },
        </c:forEach>
    ];

    let energyLeft = ${userGameRelation.energy};

    let isPlayerActive = "${isPlayerActive}" === "true" ? true : false

    let gameType="multiplayer"

    let currentRound="${game.round}"

    function refreshPageIfPlayerInactive(){
        if(!isPlayerActive){
            setTimeout(() => {location.reload()}, 2000)
        }
    }

    refreshPageIfPlayerInactive()
</script>
