<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ attribute name="num" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Number of cards in the hand" %>
<%@ attribute name="handCards" required="false" rtexprvalue="true" type="java.util.List"
              description="Cards in the hand of the player" %>
<%@ attribute name="cards_left" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Cards in the hand of the player" %>
<%@ attribute name="energyLeft" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Energy left from the player" %>
<%@ attribute name="playerNo" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Player id for coloring their cards" %>

<div class="hand">
    <endofline:energy energyLeft="${energyLeft}" playerNo="${playerNo}"/>
    <endofline:deck left="${cards_left}"/>
    <c:forEach var="n" begin="0" end="${num - 1}">
        <c:choose>
            <c:when test="${handCards != null && handCards.size() > n}">
                <endofline:card handCard="${handCards.get(n)}" playerNo="${playerNo}"/>
            </c:when>
            <c:otherwise>
                <endofline:card/>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>
<script>
    let cardRotation = {};
    let selectedHandCardId = null;
    let selectedHandCard = null;

    function isCardSelected(handCardId){
        return selectedHandCardId==handCardId
    }

    function clicked(handCardId) {
        if(isPlayerActive){
            if (selectedHandCardId==null){
                document.getElementById("handcard" + handCardId).setAttribute("class", "hand-card rotated-card-"+getCardRotation(handCardId, 0)+" player-${playerNo}-selected");
                selectedHandCardId=handCardId;
            } else if(selectedHandCardId==handCardId) {
                document.getElementById("handcard" + handCardId).setAttribute("class", "hand-card rotated-card-"+getCardRotation(handCardId, 0)+" player-${playerNo}");
                selectedHandCardId=null;
            } else {
                document.getElementById("handcard" + handCardId).setAttribute("class", "hand-card rotated-card-"+getCardRotation(handCardId, 0)+" player-${playerNo}-selected");
                document.getElementById("handcard" + selectedHandCardId).setAttribute("class", "hand-card rotated-card-"+getCardRotation(selectedHandCardId, 0)+" player-${playerNo}");
                selectedHandCardId=handCardId;
            }
            updateSelectedCard();
        }
    }

    function updateSelectedCard() {
        if (selectedHandCardId !== null) {
            selectedHandCard = cardsInHand.find(e => e.id == selectedHandCardId);
            updateHighlightedCardSlots();
        } else {
            selectedHandCard = null;
            cleanHighLightedCardSlots();
        }
    }
</script>
