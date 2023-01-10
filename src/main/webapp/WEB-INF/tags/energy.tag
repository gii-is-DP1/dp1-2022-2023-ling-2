<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ attribute name="energyLeft" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Energy left for the player" %>
<%@ attribute name="playerNo" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Player id for coloring their cards" %>


<div id="energy-card" class="card energy rotated-card-${(4-(energyLeft+1))%4} player-${playerNo}">
    <img class="energy-card" src="<spring:url value="/resources/images/energy.svg" />" alt="Energy card" onclick="toggleEnergyUsage('${playerNo}')"/>
</div>

<script>
    let usingEnergy=false;
    let canUseEnergy=true

    function toggleEnergyUsage(playerNo){
        if(gameType==="multiplayer"){canUseEnergy = !!!userCardsOnBoard.find(card => card.round==currentRound)}

        if(energyLeft>0 && canUseEnergy){
            usingEnergy = !usingEnergy;
            let colorClass = usingEnergy ? "player-"+playerNo+"-selected" : "player-"+playerNo
            if(usingEnergy)
                document.getElementById("energy-card").setAttribute("class", "card energy "+colorClass+" rotated-energy-"+(4-(energyLeft+1))%4);
            else
                document.getElementById("energy-card").setAttribute("class", "card energy "+colorClass+" rotated-card-"+(4-(energyLeft+1))%4);
            if(selectedHandCard!=null)
                updateHighlightedCardSlots();
        }
    }
</script>
