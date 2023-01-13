<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!--  >%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%-->
<%@ attribute name="name" required="true" rtexprvalue="true"
              description="Name of the active menu: home, owners, vets or error"%>

<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="nav navbar-nav navbar-left">
            <endofline:menuitem active="${name eq 'home'}" url="/"
                                title="home page">
                <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                <span>Home</span>
            </endofline:menuitem>
            <sec:authorize access="hasAuthority('TRUE')">
                <endofline:menuitem active="${name eq 'dashboard'}" url="/dashboard"
                                    title="dashboard">
                    <span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span>
                    <span>Dashboard</span>
                </endofline:menuitem>
            </sec:authorize>
            <endofline:menuitem active="${name eq 'statistics'}" url="/statistics"
                                title="statistics">
                <span class="glyphicon glyphicon-stats" aria-hidden="true"></span>
                <span>Leaderboards</span>
            </endofline:menuitem>
        </div>
        <div class="navbar-collapse collapse" id="main-navbar">
            <ul class="nav navbar-nav">
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="<c:url value="/login" />">Login</a></li>
                    <li><a href="<c:url value="/u/new" />">Register</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="<c:url value="/logout" />">Logout</a></li>
                    <li><a href="/u/<sec:authentication property="name" />/friends">
                        <span class="glyphicon glyphicon-heart-empty"></span>
                        Friends
                    </a></li>
                    <li><a href="/u/<sec:authentication property="name" />/gameinvites">
                        <span class="glyphicon glyphicon-envelope"></span>
                        Invitations
                    </a></li>
                    <li><a href="/u/<sec:authentication property="name" />">
                        <span class="glyphicon glyphicon-user"></span>
                        <strong><sec:authentication property="name" /></strong>
                    </a></li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>
