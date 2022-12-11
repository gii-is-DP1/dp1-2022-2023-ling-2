<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<endofline:layout pageName="singleplayer_game">
    <div class="center">
        <h1>Singleplayer</h1>
        <endofline:board side="5" gameCards="${gameCards}" puzzleCards="${puzzleCards}"/>
        <endofline:hand handCards="${handCards}" num="5"/>
    </div>
    <div class="energy">
        <endofline:energy energyLeft="${game.energy}"/>
    </div>
    <c:if test="${result!=null}">
        <c:out value="${result}"></c:out>
    </c:if>
</endofline:layout>
<script>
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
        lastPlacedCard = {
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

    let cardsOnBoard = [
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

    let energyLeft = ${game.energy};
</script>
