<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ attribute name="side" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Cards per side" %>
<%@ attribute name="cards" required="true" rtexprvalue="true" type="java.util.List"
              description="Cards in the board" %>


<div class="board">
    <c:forEach var="row" begin="0" end="${side - 1}">
        <div class="row">
            <c:forEach var="col" begin="0" end="${side - 1}">
                <c:forEach var="card" items="${cards}">
                    <c:choose>
                        <c:when test="${card.getX() == row && card.getY() == col}">
                            <endofline:card gameCard="${card}"/>
                        </c:when>
                        <c:otherwise>
                            <endofline:card/>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:forEach>
        </div>
    </c:forEach>
</div>
