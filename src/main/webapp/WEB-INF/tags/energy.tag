<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>



<img src="<spring:url value="/resources/images/energy.svg" />" alt="A card" />

<div class="energy">

</div>

<script>
    let usingEnergy=false;

    function toggleEnergyUsage(){
        usingEnergy = !usingEnergy;
    }
</script>
