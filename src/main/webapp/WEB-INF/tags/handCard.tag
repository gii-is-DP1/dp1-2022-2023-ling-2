<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="id" required="true" rtexprvalue="true"
              description="Card to show" %>

<div>
    <img id="testcard" src="<spring:url value="/resources/images/highlightedTile.png" htmlEscape="true"/>" onclick="clicked(event)">

</div>
<script>
    let selected = false;

    function clicked(ev) {
        console.log("selected");
        selected = !selected;
        if(!selected){
            document.getElementById("testcard").style.height = "500px";
            highlightBoard(true)
        }else{
            document.getElementById("testcard").style.height = "50px";
            highlightBoard(false)

        }
    }
</script>
