<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="gameCard" required="false" rtexprvalue="true" type="org.harmony.endofline.gameCard.GameCard"
              description="Game card to be rendered" %>
<%@ attribute name="puzzleCard" required="false" rtexprvalue="true" type="org.harmony.endofline.puzzleCards.PuzzleCards"
              description="Puzzle card to be rendered" %>


<div class="card">
    <c:if test="${puzzleCard != null}">
        <img src="<spring:url value="/resources/images/cards/${puzzleCard.card.id}.svg" />" alt="A card" />
    </c:if>
    <c:if test="${gameCard != null}">
        <img src="<spring:url value="/resources/images/cards/${gameCard.card.id}.svg" />" alt="A card" />
    </c:if>
</div>

