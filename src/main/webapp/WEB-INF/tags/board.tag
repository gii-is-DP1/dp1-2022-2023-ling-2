<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ attribute name="side" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Cards per side" %>
<%@ attribute name="puzzleCards" required="false" rtexprvalue="true" type="java.util.List"
              description="Cards in the board from the puzzle" %>
<%@ attribute name="gameCards" required="true" rtexprvalue="true" type="java.util.List"
              description="Cards in the board from the game" %>


<div class="board">
    <c:forEach var="row" begin="0" end="${side - 1}">
        <div class="row">
            <c:forEach var="col" begin="0" end="${side - 1}">
                <c:if test="${puzzleCards != null}">
                    <c:choose>
                        <c:when test="${puzzleCards.stream().filter(c -> c.getX() == row && c.getY() == col).findFirst().orElse(null) != null}">
                            <endofline:card puzzleCard="${puzzleCards.stream().filter(c -> c.getX() == row && c.getY() == col).findFirst().orElse(null)}"/>
                        </c:when>
                        <c:otherwise>
                            <endofline:card/>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
</div>
