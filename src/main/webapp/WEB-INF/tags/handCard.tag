<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="id" required="true" rtexprvalue="true"
              description="Card to show" %>

<div>
    <img id="testcard${id}" src="<spring:url value="/resources/images/highlightedTile.png" htmlEscape="true"/>" onclick="clicked(event,${id})">
</div>
<script>
    let selected = {};

    function clicked(ev, clickedId) {
        console.log("selected");
        console.log(clickedId)
        if (selected[clickedId]==true){
            selected[clickedId] = false;
        } else {
            selected[clickedId] = true;
        }

        if(selected[clickedId]==true){
            for(let item in selected){
                let h = document.getElementById("testcard"+item).offsetHeight;

                if (item==clickedId) {
                    document.getElementById("testcard" + item).style.height = (h * 1.1).toString() + "px";
                    updateSelectedCard(clickedId);
                    highlightBoard(true);
                } else if(selected[item]==true) {
                    selected[item] = false;
                    document.getElementById("testcard"+item).style.height = (h*0.9090909).toString()+"px";
                }
            }
        }else{
            let h = document.getElementById("testcard"+clickedId).offsetHeight;

            document.getElementById("testcard"+clickedId).style.height = (h*0.9090909).toString()+"px";
            updateSelectedCard(-1);
            highlightBoard(false)
        }
    }
    function updateSelected(item, clickedId){
        console.log(clickedId)
        if (item===clickedId) {
            document.getElementById("testcard" + clickedId).style.height = (h * 1.1).toString() + "px";
            updateSelectedCard(clickedId);
            highlightBoard(true);
        } else {
            document.getElementById("testcard"+clickedId).style.height = (h*0.9090909).toString()+"px";
        }
    }
</script>
