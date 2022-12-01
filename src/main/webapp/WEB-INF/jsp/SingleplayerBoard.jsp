<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>

<endofline:layout pageName="singleplayer_game">
    <div class="center">
        <h1>Singleplayer</h1>
        <endofline:board side="5" gameCards="${gameCards}" puzzleCards="${puzzleCards}"/>
        <endofline:hand handCards="${handCards}" num="4"/>
    </div>
</endofline:layout>
