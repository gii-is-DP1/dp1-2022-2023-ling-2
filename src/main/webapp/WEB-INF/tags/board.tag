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
    let boardSize = parseInt("${side}");

    function getExitPositions(lastPlacedCard) {
        // Calculates the necessary entry position and coordinates for the next card based on the card's exits
        let res = {};
        console.log(lastPlacedCard)
        let sidesRotated = getRotatedSides(lastPlacedCard, lastPlacedCard["rotation"]);
        for(let i=0; i<sidesRotated.length; i++){
            let side = sidesRotated.at(i);
            if(side==="EXIT"){
                switch (i){
                    case 0:
                        res.down = [parseInt(lastPlacedCard["x"]), (parseInt(lastPlacedCard["y"])-1+boardSize)%boardSize];
                        break;
                    case 1:
                        res.left = [(parseInt(lastPlacedCard["x"])+1+boardSize)%boardSize, parseInt(lastPlacedCard["y"])];
                        break;
                    case 2:
                        res.up = [parseInt(lastPlacedCard["x"]), (parseInt(lastPlacedCard["y"])+1+boardSize)%boardSize];
                        break;
                    case 3:
                        res.right = [(parseInt(lastPlacedCard["x"])-1+boardSize)%boardSize, parseInt(lastPlacedCard["y"])];
                        break;
                }
            }
        }
        return res;
    }

    function getRotatedSides(card, rotation) {
        let sidesRotated;
        rotation = parseInt(rotation)
        console.log(rotation)
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

    function calculateEntriesForExits() {
        let requiredEntriesForExit = {};
        let cardEntryForExitMap = {};

        if(!usingEnergy) {
            cardEntryForExitMap = getExitPositions(lastPlacedCard);
            for(let [key, value] of Object.entries(cardEntryForExitMap)){
                requiredEntriesForExit[key] = [value];
            }
        }
        else{
            for(let [key, card] of Object.entries(userCardsOnBoard)){
                cardEntryForExitMap = getExitPositions(card);
                for(let [key, value] of Object.entries(cardEntryForExitMap)){
                    if(requiredEntriesForExit[key]!==undefined)
                        requiredEntriesForExit[key].push(value);
                    else
                        requiredEntriesForExit[key] = [value];
                }
            }
        }
        return requiredEntriesForExit;
    }

    function updateHighlightedCardSlots(){
        let requiredEntryForExit = calculateEntriesForExits()
        let exitPositions = [];
        for(let [key, value] of Object.entries(requiredEntryForExit)){
            value.forEach(e => exitPositions.push(e));
        }

        let occupiedPositions = [];
        cardsOnBoard.forEach(gameCard => occupiedPositions.push([parseInt(gameCard["x"]), parseInt(gameCard["y"])]));
        let occupiedPositionsString = JSON.stringify(occupiedPositions)

        let availablePositions = [];
        exitPositions.forEach(position => {
            if(!occupiedPositionsString.includes(JSON.stringify([position.at(0), position.at(1)]))){
                availablePositions.push([position.at(0), position.at(1)])
            }
        })
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
                        if(requiredEntryForExit["up"]!==undefined)
                            requiredEntryForExit["up"].forEach(position => {
                                if (stringAvailablePositions.includes(JSON.stringify(position)))
                                    res.push(position);
                            })
                        break;
                    case 1:
                        if(requiredEntryForExit["right"]!==undefined)
                            requiredEntryForExit["right"].forEach(position => {
                                if (stringAvailablePositions.includes(JSON.stringify(position)))
                                    res.push(position);
                            })
                        break;
                    case 2:
                        if(requiredEntryForExit["down"]!==undefined)
                            requiredEntryForExit["down"].forEach(position => {
                                if (stringAvailablePositions.includes(JSON.stringify(position)))
                                    res.push(position);
                            })
                        break;
                    case 3:
                        if(requiredEntryForExit["left"]!==undefined)
                            requiredEntryForExit["left"].forEach(position => {
                                if (stringAvailablePositions.includes(JSON.stringify(position)))
                                    res.push(position);
                            })
                        break;
                }
            }
        }
        return res;
    }

    function cleanHighLightedCardSlots(){
        for(let row=0; row<boardSize; row++){
            for(let col=0; col<boardSize; col++){
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
