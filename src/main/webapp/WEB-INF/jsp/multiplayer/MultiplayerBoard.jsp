<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<endofline:layout pageName="multiplayer_game">
    <div class="center">
        <endofline:board side="7" gameCards="${gameCards}"/>
        <div id="hand" class="center">
            <endofline:hand handCards="${handCards}" num="5" cards_left="${cards_left}" energyLeft="${game.energy}"/>
        </div>
    </div>
</endofline:layout>
<script>
    let lastPlacedCard = "${lastPlacedCard}";

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

    let cardsOnBoard = [
        <c:forEach items="${cardsOnBoard}" var="card">
        {
            "x": "${card.x}",
            "y": "${card.y}"
        },
        </c:forEach>
    ];

    let energyLeft = ${userGameRelation.energy};
</script>
