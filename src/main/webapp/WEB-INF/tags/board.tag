<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ attribute name="side" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Cards per side" %>

<div class="board">
    <c:forEach var="row" begin="0" end="${side - 1}">
        <div class="row">
            <c:forEach var="col" begin="0" end="${side - 1}">
                <endofline:card/>
            </c:forEach>
        </div>
    </c:forEach>
</div>
