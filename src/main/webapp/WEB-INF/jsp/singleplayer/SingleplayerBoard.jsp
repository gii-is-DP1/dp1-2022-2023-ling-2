<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<endofline:layout pageName="singleplayer_game">
    <div class="center">
            <h1 id="title" style="position: relative"><i class="glyphicon glyphicon-question-sign help-icon" onclick="showRules()"></i> Singleplayer</h1>
        <!-- Modal -->
        <div id="rules" class="modal">
            <div class="modal-content">
                <div class="modal-header">
                    <h1>End of Line - Singleplayer Rules</h1>
                </div>
                <div class="modal-body">
                    <p>In singleplayer mode, your objective is to lay down all 25 line cards on the board.</p>
                    <p>If your line reaches the edge of the board, it will continue through the opposite side.</p>
                    <p>Cards can be rotated by clicking the <i class="glyphicon glyphicon-repeat"></i> button in the corner.
                    The places where a card can be placed will be highlighted. </p>
                    <p>Some cards have more than one exit point. If you click on the <b>Energy Card</b> (the one leftmost in your hand)
                    you will be able to "go back" to an exit point further up the line.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" onclick="hideRules()">Close</button>
                </div>
            </div>
        </div>
        <c:if test="${game.gameStatus.toString().equals('FINISHED')}">
            <script>
                document.getElementById("title").setAttribute("style", "display: none !important;");
                document.getElementById("hand").setAttribute("style", "display: none !important;");
            </script>
            <c:choose>
                <c:when test="${game.winner!=null}">
                    <div class="center text-success">
                        <h1>You won!</h1>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="center text-danger">
                        <h1>You lost</h1>
                    </div>
                </c:otherwise>
            </c:choose>
            <div class="center-horizontal">
                <a href="/singleplayer/create" class="btn btn-primary margins-small">Play again</a>
                <a href="/" class="btn btn-primary margins-small">Go back</a>
            </div>
        </c:if>
        <endofline:board side="5" gameCards="${gameCards}" puzzleCards="${puzzleCards}" player1Id="${game.user.id}"/>
        <c:if test="${!game.gameStatus.toString().equals('FINISHED')}">
            <div id="hand" class="center">
                <endofline:hand handCards="${handCards}" num="5" cards_left="${cards_left}" energyLeft="${game.energy}" playerNo="1"/>
            </div>
        </c:if>
    </div>
</endofline:layout>
<script>
    function hideRules() {
        document.getElementById('rules').style.display = "none"
}

function showRules() {
        document.getElementById('rules').style.display = "block"
}

let lastPlacedCard = {
        "x": "2",
        "y": "2",
        "rotation": "0",
        "status": "0",
        "up" : "EXIT",
        "down" : "EMPTY",
        "left" : "EMPTY",
        "right" : "EMPTY"
    };
    if("${game.lastPlacedCard}"!==""){
        lastPlacedCard =
        {
            "x": "${game.lastPlacedCard.x}",
            "y": "${game.lastPlacedCard.y}",
            "rotation": "${game.lastPlacedCard.rotation}",
            "status": "${game.lastPlacedCard.status}",
            "up" : "${game.lastPlacedCard.card.up}",
            "down" : "${game.lastPlacedCard.card.down}",
            "left" : "${game.lastPlacedCard.card.left}",
            "right" : "${game.lastPlacedCard.card.right}"
        };
    }

    let userCardsOnBoard = [
        <c:forEach items="${gameCards}" var="card">
            {
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

    let puzzleCards = [
        <c:forEach items="${puzzleCards}" var="card">
            {
                "x": "${card.x}",
                "y": "${card.y}"
            },
        </c:forEach>
    ];

    let cardsOnBoard = [
        <c:forEach items="${gameCards}" var="card">
        {
            "x": "${card.x}",
            "y": "${card.y}"
        },
        </c:forEach>
    ];

    cardsOnBoard = cardsOnBoard.concat(puzzleCards);

    let energyLeft = ${game.energy};

    let isPlayerActive=true

    let gameType="singleplayer"
</script>
