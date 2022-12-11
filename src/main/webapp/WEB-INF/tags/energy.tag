<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ attribute name="energyLeft" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Energy left for the player" %>


<div class="energy">
    <h2>Energy</h2>
    <img class="card energy-card rotated-card-${(4-(energyLeft+1))%4}" id="energy-card" src="<spring:url value="/resources/images/energy.svg" />" alt="Energy card" onclick="toggleEnergyUsage()"/>
</div>

<script>
    let usingEnergy=false;

    function toggleEnergyUsage(){
        if(energyLeft>0){
            usingEnergy = !usingEnergy;
            if(usingEnergy)
                document.getElementById("energy-card").setAttribute("class", "card energy-card rotated-energy-"+(4-(energyLeft+1))%4);
            else
                document.getElementById("energy-card").setAttribute("class", "card energy-card rotated-card-"+(4-(energyLeft+1))%4);
            if(selectedHandCard!=null)
                updateHighlightedCardSlots();
        }
    }
</script>
