<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="left" required="true" rtexprvalue="true" type="java.lang.Integer"
              description="Cards left in the deck" %>

<div class="deck">
    <p>${left}</p>
</div>
