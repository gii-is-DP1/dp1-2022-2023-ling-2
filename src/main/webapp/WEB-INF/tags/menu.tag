<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>
<!--  >%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%-->
<%@ attribute name="name" required="true" rtexprvalue="true"
              description="Name of the active menu: home, owners, vets or error"%>

<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand"
               href="<spring:url value="/" htmlEscape="true" />"><span></span></a>
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#main-navbar">
                <span class="sr-only"><os-p>Toggle navigation</os-p></span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="main-navbar">
            <ul class="nav navbar-nav">
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="<c:url value="/login" />">Login</a></li>
                    <li><a href="<c:url value="/users/new" />">Register</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                <li><a href="<c:url value="/logout" />">Logout</a></li>
                <li><a href="<c:url value="/logout" />">
                    <span class="glyphicon glyphicon-user"></span>
                    <strong><sec:authentication property="name" /></strong>
                </a></li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>
