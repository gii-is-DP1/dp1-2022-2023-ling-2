<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="gameCard" required="false" rtexprvalue="true" type="org.harmony.endofline.gameCard.GameCard"
              description="Card to be rendered" %>


<div class="card">
    <c:if test="${gameCard != null}">
        <c:choose>
            <c:when test="${gameCard.card.id == 10}">

            </c:when>
            <c:otherwise>
                <img src="<spring:url value="/resources/images/cards/${gameCard.card.id}.svg" />" alt="A card" />
            </c:otherwise>
        </c:choose>
    </c:if>
</div>

