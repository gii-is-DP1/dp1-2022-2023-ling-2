<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<endofline:layout pageName="multiplayer_game">
    <div class="center">
        <endofline:board side="7" gameCards="${gameCards}"/>
        <endofline:hand handCards="${handCards}" num="5" cards_left="${cards_left}" energyLeft="${game.energy}"/>
    </div>
</endofline:layout>
