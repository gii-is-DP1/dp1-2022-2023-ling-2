<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ attribute name="messages" required="true" rtexprvalue="true" type="java.util.List"
              description="List of messages" %>
<%@ attribute name="player1Username" required="true" rtexprvalue="true" type="java.lang.String"
              description="Player 1 username" %>
<%@ attribute name="player2Username" required="true" rtexprvalue="true" type="java.lang.String"
              description="Player 2 username" %>

<div class="chat-box">
    <div id="message-box" class="messages-box">
        <c:forEach items="${messages}" var="message">
            <c:choose>
                <c:when test="${message.user.username==player1Username}">
                    <c:set var="nameColor" value="cornflowerblue"></c:set>
                </c:when>
                <c:when test="${message.user.username==player2Username}">
                    <c:set var="nameColor" value="deeppink"></c:set>
                </c:when>
                <c:otherwise>
                    <c:set var="nameColor" value="black"></c:set>
                </c:otherwise>
            </c:choose>
            <div class="msg">
                <span><b style="color: ${nameColor}">${message.user.username}:</b> ${message.content}</span>
            </div>
        </c:forEach>
    </div>
    <div class="input-holder">
        <form:form modelAttribute="message" class="control">
            <input type="hidden" name="id" value="">
            <input id="message-input" class="chat-input" type="text" placeholder="Write a message" name="content" onfocus="stopRefresh()" onblur="resumeRefresh()" onchange="updateSendButton()" }>
            <button id="send-msg-btn" class="chat-btn" type="submit" disabled="true">Send</button>
        </form:form>
    </div>
</div>
<script>
    function updateSendButton(){
        document.getElementById("send-msg-btn").disabled = document.getElementById('message-input').value===""
    }

    function stopRefresh(){
        canRefresh=false
    }

    function resumeRefresh(){
        canRefresh=true
    }

    function scrollToBottomOfChat(){
        document.getElementById("message-box").scrollTop = document.getElementById("message-box").scrollHeight;
    }
    scrollToBottomOfChat()
</script>
