<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@ attribute name="board" required="false" rtexprvalue="true" type="org.harmony.endofline.board.Board"
 description="Board to be rendered" %>
<canvas id="canvas" width="${board.width}" height="${board.height}"></canvas>
<img id="source" src="<spring:url value="/resources/images/backgroundSingleplayer.png" htmlEscape="true"/>" style="display:none">
<img id="highlight" src="<spring:url value="/resources/images/highlightedTile.png" htmlEscape="true"/>" style="display:none">

<div style="display: flex;flex-direction: row;">
<c:forEach var = "i" begin = "0" end = "${board.width}">
    <div style="display: flex;flex-direction: column;">
        <c:forEach var = "j" begin = "0" end = "${board.height}">
            <div id="tile${i}${j}" class="tile" onclick="selectTile(${i},${j})">
            </div>
        </c:forEach>
    </div>
</c:forEach>
</div>
<script>

function selectTile(x,y){
      console.log(x +", " +y);
}

function highlightBoard(b){
    console.log("marked squares");
    const x1 = 3;
    const y1 = 3;
    if(b){
        let highlighted1 = document.getElementById(("tile"+x1)+y1);
        highlighted1.style.backgroundColor = "#000000"
    }else{
        let highlighted1 = document.getElementById(("tile"+x1)+y1);
        highlighted1.style.backgroundColor = "#03a9f4"
    }
}
</script>
<style>
    .tile{
        border: 5px solid black;
        border: black;
        height: 50px;
        width: 50px;
        border-radius: 15px;
        margin: 5px;
        background-color: #03a9f4;
    }
</style>
