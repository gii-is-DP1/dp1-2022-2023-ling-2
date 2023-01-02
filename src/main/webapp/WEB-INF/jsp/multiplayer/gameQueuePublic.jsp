<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<endofline:layout pageName="queue">
    <div class="center">
        <p>Multiplayer public queue</p>
        <h1>Waiting for people to create game</h1>
        <div class="center-horizontal">
        </div>
    </div>
</endofline:layout>
<script>
    function fetchQueueStatus(){
        fetch('http://localhost:8080/multiplayerREST/queueStatus', {
            method: 'GET'
        })
            .then(response => response.text())
            .then(text => console.log(text))
        setTimeout(fetchQueueStatus, 5000);
    }

    fetchQueueStatus()


</script>
