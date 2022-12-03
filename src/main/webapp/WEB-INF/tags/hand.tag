<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ attribute name="num" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Number of cards in the hand" %>
<%@ attribute name="handCards" required="false" rtexprvalue="true" type="java.util.List"
              description="Cards in the hand of the player" %>

<div class="hand">
    <endofline:deck left="16"/>
    <c:forEach var="n" begin="0" end="${num - 1}">
        <c:choose>
            <c:when test="${handCards != null && handCards.size() > n}">
                <endofline:card handCard="${handCards.get(n)}"/>
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
    let selectedHandCard;

    function clicked(handCardId) {
        if (selectedHandCardId==null){
            document.getElementById("handcard" + handCardId).style.backgroundColor = "lightgrey";
            selectedHandCardId=handCardId;
        } else if(selectedHandCardId==handCardId) {
            document.getElementById("handcard" + handCardId).style.backgroundColor = "white";
            selectedHandCardId=null;
        } else {
            document.getElementById("handcard" + handCardId).style.backgroundColor = "lightgrey";
            document.getElementById("handcard" + selectedHandCardId).style.backgroundColor = "white";
            selectedHandCardId=handCardId;
        }
        updateSelectedCard();
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
