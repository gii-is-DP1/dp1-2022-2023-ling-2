<%@ attribute name="size" required="true" rtexprvalue="true" 
 description="Size of the card to show" %>
 <%@ attribute name="card" required="true" rtexprvalue="true" type="org.harmony.endofline.board.BoardCard"
 description="Card to be rendered" %>
 
 image = document.getElementById('${piece.type}-${piece.color}');
 ctx.drawImage(image,${piece.getPositionXInPixels(size)},${piece.getPositionYInPixels(size)},${size},${size});
