<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ attribute name="num" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Number of cards in the hand" %>

<div class="hand">
    <endofline:deck left="16"/>
    <c:forEach var="n" begin="0" end="${num - 1}">
            <endofline:card />
    </c:forEach>
</div>
