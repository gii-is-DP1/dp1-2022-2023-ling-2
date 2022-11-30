<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@ attribute name="board" required="false" rtexprvalue="true" type="org.harmony.endofline.board.Board"
 description="Board to be rendered" %>
<canvas id="canvas" width="${board.width}" height="${board.height}"></canvas>
<img id="source" src="<spring:url value="/resources/images/backgroundSingleplayer.png" htmlEscape="true"/>" style="display:none">
<img id="highlight" src="<spring:url value="/resources/images/highlightedTile.png" htmlEscape="true"/>" style="display:none">
<script>
function drawBoard(){
    console.log("loaded Board");
    var canvas = document.getElementById("canvas");
    var ctx = canvas.getContext("2d");
    var image = document.getElementById('source');
    ctx.drawImage(image, 0, 0, ${board.width}, ${board.height});

    const highlight = document.createElement("img");
    highlight.src = "<spring:url value="/resources/images/highlightedTile.png" htmlEscape="true"/>";
    highlight.onclick = ""
    canvas.appendChild(highlight);
    <jsp:doBody/>
}
function highlightBoard(b){
    console.log("marked squares");
    const x1 = 3;
    const y1 = 3;

    const x2 = 1;
    const y2 = 4;

    const cardHeight = ${board.width}/5;
    console.log(cardHeight);

    const x1_pixelCoordinates = x1 * cardHeight;
    const y1_pixelCoordinates = y1 * cardHeight;
    const x2_pixelCoordinates = x2 * cardHeight;
    const y2_pixelCoordinates = y2 * cardHeight;
    console.log(x1_pixelCoordinates);



    const canvas = document.getElementById("canvas");
    const ctx = canvas.getContext("2d");
    const image = document.getElementById('highlight');
    if(b) {

        //ctx.drawImage(image, x1_pixelCoordinates, y1_pixelCoordinates, cardHeight, cardHeight);
        //ctx.drawImage(image, x2_pixelCoordinates, y2_pixelCoordinates, cardHeight, cardHeight);
    }else{
        var image1 = document.getElementById('source');
        ctx.drawImage(image1, 0, 0, ${board.width}, ${board.height});
        <jsp:doBody/>
    }

}
window.onload =drawBoard();
</script>
