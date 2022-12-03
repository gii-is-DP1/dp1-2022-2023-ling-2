<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ attribute name="side" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Cards per side" %>
<%@ attribute name="puzzleCards" required="false" rtexprvalue="true" type="java.util.List"
              description="Cards in the board from the puzzle" %>
<%@ attribute name="gameCards" required="true" rtexprvalue="true" type="java.util.List"
              description="Cards in the board from the game" %>


<div class="board">
    <c:forEach var="col" begin="0" end="${side - 1}">
        <div class="row">
            <c:forEach var="row" begin="0" end="${side - 1}">
                <c:choose>
                    <c:when test="${puzzleCards != null && puzzleCards.stream().filter(c -> c.getX() == row && c.getY() == col).findFirst().orElse(null) != null}">
                        <endofline:card puzzleCard="${puzzleCards.stream().filter(c -> c.getX() == row && c.getY() == col).findFirst().orElse(null)}"/>
                    </c:when>
                    <c:when test="${gameCards != null && gameCards.stream().filter(c -> c.getX() == row && c.getY() == col).findFirst().orElse(null) != null}">
                        <endofline:card gameCard="${gameCards.stream().filter(c -> c.getX() == row && c.getY() == col).findFirst().orElse(null)}"/>
                    </c:when>
                    <c:otherwise>
                        <endofline:card col="${col}" row="${row}"/>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </c:forEach>
</div>
<script>
    function getExitPositions(lastPlacedCard, boardDimensions) {
        // Calculates the necessary entry position and coordinates for the next card based on the card's exits
        let res = {};
        let sidesRotated = getRotatedSides(lastPlacedCard, lastPlacedCard["rotation"]);
        for(let i=0; i<sidesRotated.length; i++){
            let side = sidesRotated.at(i);
            if(side==="EXIT"){
                switch (i){
                    case 0:
                        res.down = [parseInt(lastPlacedCard["x"]), (parseInt(lastPlacedCard["y"])-1+boardDimensions)%boardDimensions];
                        break;
                    case 1:
                        res.left = [(parseInt(lastPlacedCard["x"])+1+boardDimensions)%boardDimensions, parseInt(lastPlacedCard["y"])];
                        break;
                    case 2:
                        res.up = [parseInt(lastPlacedCard["x"]), (parseInt(lastPlacedCard["y"])+1+boardDimensions)%boardDimensions];
                        break;
                    case 3:
                        res.right = [(parseInt(lastPlacedCard["x"])-1+boardDimensions)%boardDimensions, parseInt(lastPlacedCard["y"])];
                        break;
                }
            }
        }
        return res;
    }

    function getRotatedSides(card, rotation) {
        let sidesRotated;
        rotation = parseInt(rotation)
        switch (rotation){
            case 0:
                sidesRotated = [card["up"], card["right"], card["down"], card["left"]];
                break;
            case 1:
                sidesRotated = [card["left"], card["up"], card["right"], card["down"]];
                break;
            case 2:
                sidesRotated = [card["down"], card["left"], card["up"], card["right"]];
                break;
            case 3:
                sidesRotated = [card["right"], card["down"], card["left"], card["up"]];
                break;
        }
        return sidesRotated;
    }

    function updateHighlightedCardSlots(){
        let requiredEntryForExit = getExitPositions(lastPlacedCard, 5)
        let lastCardExitPositions = [];
        for (let key in requiredEntryForExit){
            lastCardExitPositions.push(requiredEntryForExit[key])
        }

        let occupiedPositions = [];
        for(let gameCard in cardsOnBoard){
            occupiedPositions.push([gameCard["x"], gameCard["y"]])
        }
        for(let puzzleCard in puzzleCards){
            occupiedPositions.push([puzzleCard["x"], puzzleCard["y"]])
        }

        let availablePositions = [];
        for(let i in lastCardExitPositions){
            let position = lastCardExitPositions.at(i)
            if(!occupiedPositions.includes([position.at(0), position.at(1)])){
                availablePositions.push([position.at(0), position.at(1)])
            }
        }

        let cardToMoveSides = getRotatedSides(selectedHandCard, selectedHandCard["rotation"])

        let validPositions = cleanAvailablePositionsUsingCardToMove(requiredEntryForExit, availablePositions, cardToMoveSides)

        highlightPositions(validPositions)

    }

    function cleanAvailablePositionsUsingCardToMove(requiredEntryForExit, availablePositions, cardToMoveSides){
        let res = [];
        let stringAvailablePositions = JSON.stringify(availablePositions)
        for(let i = 0; i< cardToMoveSides.length; i++){
            let side = cardToMoveSides.at(i);
            if(side==="ENTRY"){
                switch (i){
                    case 0:
                        if (stringAvailablePositions.includes(JSON.stringify(requiredEntryForExit["up"])))
                            res.push(requiredEntryForExit["up"]);
                        break;
                    case 1:
                        if (stringAvailablePositions.includes(JSON.stringify(requiredEntryForExit["right"])))
                            res.push(requiredEntryForExit["right"]);
                        break;
                    case 2:
                        if (stringAvailablePositions.includes(JSON.stringify(requiredEntryForExit["down"])))
                            res.push(requiredEntryForExit["down"]);
                        break;
                    case 3:
                        if (stringAvailablePositions.includes(JSON.stringify(requiredEntryForExit["left"])))
                            res.push(requiredEntryForExit["left"]);
                        break;
                }
            }
        }
        return res;
    }

    function cleanHighLightedCardSlots(){
        for(let row=0; row<5; row++){
            for(let col=0; col<5; col++){
                if(document.getElementById("cardslot-"+row+"-"+col)!==null)
                    document.getElementById("cardslot-"+row+"-"+col).setAttribute("class", "btn card-slot disabled-card-slot")
            }
        }
    }

    function highlightPositions(validPositions) {
        cleanHighLightedCardSlots()
        for(let i in validPositions){
            let position = validPositions.at(i)
            let row = position.at(0)
            let col = position.at(1)
            document.getElementById("cardslot-"+row+"-"+col).setAttribute("class", "btn card-slot enabled-card-slot")
        }
    }
</script>
