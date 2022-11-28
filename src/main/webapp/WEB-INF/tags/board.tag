<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="board" required="false" rtexprvalue="true" type="org.harmony.endofline.board.Board"
 description="Board to be rendered" %>
<canvas id="canvas" width="${board.width}" height="${board.height}"></canvas>
<img id="source" src="<spring:url value="/resources/images/Background.png" htmlEscape="true"/>" style="display:none">
<img id="HORSE-BLACK" src="resources/images/HORSE-BLACK.png" style="display:none">
<img id="KING-BLACK" src="resources/images/KING-BLACK.png" style="display:none">
<img id="KING-WHITE" src="resources/images/KING-WHITE.png" style="display:none">
<script>
function drawBoard(){
    console.log("loaded Board");
    var canvas = document.getElementById("canvas");
    var ctx = canvas.getContext("2d");
    var image = document.getElementById('source');
    ctx.drawImage(image, 0, 0, ${board.width}, ${board.height});
    <jsp:doBody/>
}
window.onload =drawBoard();
</script>
