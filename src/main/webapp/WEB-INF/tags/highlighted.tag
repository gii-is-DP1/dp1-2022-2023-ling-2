<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="x" required="true" rtexprvalue="true"
              description="y-Coordinate" %>
<%@ attribute name="y" required="true" rtexprvalue="true"
              description="y-Coordinate" %>
<%@ attribute name="size" required="true" rtexprvalue="true"
              description="board Size" %>

<img src="<spring:url value="/resources/images/highlightedTile.png" htmlEscape="true"/>">

<script>
    function clicked(){
        console.log("clicked at" + ${x} +", " + ${y});
    }
    function activateHighlightTile(){

    }
</script>
<style>
    img.relative{
        position: relative;
        left: 30px;
        top: 30px
    }

</style>
