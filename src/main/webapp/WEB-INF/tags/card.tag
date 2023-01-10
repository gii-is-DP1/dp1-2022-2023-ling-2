<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>

<%@ attribute name="gameCard" required="false" rtexprvalue="true" type="org.harmony.endofline.gameCard.GameCard"
              description="Game card to be rendered" %>
<%@ attribute name="handCard" required="false" rtexprvalue="true" type="org.harmony.endofline.gameCard.GameCard"
              description="Game card to be rendered in hand" %>
<%@ attribute name="puzzleCard" required="false" rtexprvalue="true" type="org.harmony.endofline.puzzleCards.PuzzleCards"
              description="Puzzle card to be rendered" %>
<%@ attribute name="col" required="false" rtexprvalue="true" type="java.lang.Integer"
              description="Column number of an empty card slot in the board" %>
<%@ attribute name="row" required="false" rtexprvalue="true" type="java.lang.Integer"
              description="Column number of an empty card slot in the board" %>
<%@ attribute name="playerNo" required="false" rtexprvalue="true" type="java.lang.Integer"
              description="Player id for coloring their cards" %>


<div class="card">
    <c:if test="${puzzleCard != null}">
        <img src="<spring:url value="/resources/images/cards/${puzzleCard.card.id}.svg" />" alt="A card" />
    </c:if>
    <c:if test="${gameCard != null}">
        <img class="rotated-card-${gameCard.rotation} player-${playerNo}"
             src="<spring:url value="/resources/images/cards/${gameCard.card.id}.svg" />" alt="A card" />
    </c:if>
    <c:if test="${handCard != null}">
        <img class="rotated-card-0 hand-card player-${playerNo}" id="handcard${handCard.id}" src="<spring:url value="/resources/images/cards/${handCard.card.id}.svg" />" alt="A card" onclick="clicked('${handCard.id}')">
        <span class="rotate-button glyphicon glyphicon-repeat" onclick="rotateHandCard('${handCard.id}', '${handCard.rotation}', '${playerNo}')"></span>
    </c:if>
    <c:if test="${col !=null && row!=null}">
        <span class="btn card-slot disabled-card-slot" id="cardslot-${row}-${col}" onclick="getPlaceCardURI('${row}', '${col}')"></span>
        <form:form id="place-card" method="POST">
        </form:form>
    </c:if>
</div>
<script>
    function getPlaceCardURI(x, y) {
        let selectedRotation;
        if (cardRotation[selectedHandCardId]) {
            selectedRotation = cardRotation[selectedHandCardId];
        } else {
            selectedRotation = 0;
        }

        let uri
        switch (gameType){
            case "singleplayer": uri = window.location.href+"/place?gcid="+selectedHandCardId+"&rotation="+selectedRotation+"&x="+x+"&y="+y+"&energy="+usingEnergy;
            case "multiplayer": uri = window.location.href+"/place?gcid="+selectedHandCardId+"&rotation="+selectedRotation+"&x="+x+"&y="+y+"&energy="+usingEnergy+"&ability="+abilityUsed;
        }

        document.getElementById("place-card").setAttribute("action", uri);
        document.getElementById("place-card").submit();
    }

    function getCardRotation(handCardId, initialRotation){
        if(cardRotation[handCardId]){
            return cardRotation[handCardId];
        } else{
            return initialRotation;
        }
    }

    function rotateHandCard(handCardId, initialRotation, playerNo){
        if(isPlayerActive){
            cardRotation[handCardId] = (getCardRotation(handCardId, initialRotation)+1)%4;
            cardsInHand.find(e => e.id==handCardId).rotation=cardRotation[handCardId]
            updateSelectedCard()
            let colorClass = isCardSelected(handCardId) ? "player-"+playerNo+"-selected" : "player-"+playerNo
            document.getElementById("handcard" + handCardId).setAttribute("class", "hand-card rotated-card-"+cardRotation[handCardId]+" "+colorClass);
        }
    }
</script>
