<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="id" required="true" rtexprvalue="true"
              description="Card to show" %>

<div>
    <img id="testcard${id}" src="<spring:url value="/resources/images/highlightedTile.png" htmlEscape="true"/>" onclick="clicked(event,${id})">
</div>
<script>
    let selected = false;

    function clicked(ev, clickedId) {
        console.log("selected");
        selected = !selected;
        let h = document.getElementById("testcard"+clickedId).offsetHeight;
        console.log(h)

        if(selected){
            document.getElementById("testcard"+clickedId).style.height = (h*1.1).toString()+"px";
            updateSelectedCard(clickedId);
            highlightBoard(true)
        }else{
            document.getElementById("testcard"+clickedId).style.height = (h*0.9090909).toString()+"px";
            updateSelectedCard(-1);
            highlightBoard(false)
        }
    }
</script>
