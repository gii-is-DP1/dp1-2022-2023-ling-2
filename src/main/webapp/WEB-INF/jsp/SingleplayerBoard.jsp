<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"  href="/webjars/bootstrap/css/bootstrap.min.css" />
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h2>Game:</h2>
    <div>
        <c:out value="${game}"></c:out>
    </div>
    <div class="row">
        <div class="center-horizontal">
            <endofline:board board="${board}">
                <c:forEach items="${board.cards}" var="card">
                    <endofline:card size="100" card="${card}"/>
                </c:forEach>
            </endofline:board>
        </div>
        <div>
            <endofline:handCard id="5" ></endofline:handCard>
        </div>
        <button onclick="javascript:highlightBoard();">Display</button>
    </div>
</body>
</html>
<script>
    let selectedCardId;

    function updateSelectedCard(id){

    }


</script>
