<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>

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


<div class="card">
    <c:if test="${puzzleCard != null}">
        <img src="<spring:url value="/resources/images/cards/${puzzleCard.card.id}.svg" />" alt="A card" />
    </c:if>
    <c:if test="${gameCard != null}">
        <img class="rotated-card-${gameCard.rotation}" src="<spring:url value="/resources/images/cards/${gameCard.card.id}.svg" />" alt="A card" />
    </c:if>
    <c:if test="${handCard != null}">
        <img class="rotated-card-0 hand-card" id="handcard${handCard.id}" src="<spring:url value="/resources/images/cards/${handCard.card.id}.svg" />" alt="A card" onclick="clicked('${handCard.id}')">
        <span class="rotate-button glyphicon glyphicon-repeat" onclick="rotateHandCard('${handCard.id}', '${handCard.rotation}')"></span>
    </c:if>
    <c:if test="${col !=null && row!=null}">
        <span id="cardslot-${col}-${row}"/>
    </c:if>
</div>
<script>
    function rotateHandCard(handCardId, initialRotation){
        if(cardRotation[handCardId]){
            cardRotation[handCardId] = (cardRotation[handCardId]+1)%4;
        } else{
            cardRotation[handCardId] = (initialRotation+1)%4;
        }
        document.getElementById("handcard" + handCardId).setAttribute("class", "rotated-card-"+cardRotation[handCardId]);
    }
</script>
