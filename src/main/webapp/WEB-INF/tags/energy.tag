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
<div id="choose-energy-ability" class="modal">
    <div class="modal-content">
        <div class="modal-header">
            <h1>Choose energy ability</h1>
        </div>
        <div class="modal-body">
            <input type="button" class="btn margins-small" onclick="chooseEnergyAbility(1)" value="Back In Time"/>
            <p>&ensp;&ensp; This ability will let you put a card in any exit available, and let you continue from there</p>
            <hr>
            <input type="button" class="btn margins-small" onclick="chooseEnergyAbility(2)" value="Boost"/>
            <p>&ensp;&ensp; This ability will allow you to place 3 cards instead of 2 during this turn</p>
            <hr>
            <input type="button" class="btn margins-small" onclick="chooseEnergyAbility(3)" value="Break"/>
            <p>&ensp;&ensp; This ability will limit the amount of cards you can place in this turn to 1</p>
            <button class="btn margins-small" onclick="toggleEnergyUsage('${playerNo}')">Cancel</button>
        </div>
    </div>
</div>

<script>
    let usingEnergy=false;
    let canUseEnergy=true
    let abilityUsed=0;

    function chooseEnergyAbility(abilityNumber) {
        document.getElementById('choose-energy-ability').style.display = "none"
        abilityUsed=abilityNumber
        if(selectedHandCard!=null)
            updateHighlightedCardSlots();
    }

    function toggleEnergyUsage(playerNo){
        if(gameType==="multiplayer"){canUseEnergy = (!!!userCardsOnBoard.find(card => card.round==currentRound)) && currentRound>=3 }

        if(energyLeft>0 && canUseEnergy){
            usingEnergy = !usingEnergy;
            let colorClass = usingEnergy ? "player-"+playerNo+"-selected" : "player-"+playerNo
            if(usingEnergy) {
                document.getElementById("energy-card").setAttribute("class", "card energy "+colorClass+" rotated-energy-"+(4-(energyLeft+1))%4)
                gameType==="multiplayer" ? document.getElementById('choose-energy-ability').style.display = "block" : abilityUsed=1
            }
            else {
                document.getElementById("energy-card").setAttribute("class", "card energy "+colorClass+" rotated-card-"+(4-(energyLeft+1))%4)
                gameType==="multiplayer" ? document.getElementById('choose-energy-ability').style.display = "none" : abilityUsed=1
                abilityUsed=0
                if(selectedHandCard!=null)
                    updateHighlightedCardSlots();
            }
        }
    }
</script>
