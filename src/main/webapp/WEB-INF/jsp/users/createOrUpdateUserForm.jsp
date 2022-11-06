<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>

<endofline:layout pageName="users">
    <jsp:body>
        <h2>
            <c:if test="${user['new']}">New </c:if> user
        </h2>
        <form:form modelAttribute="user" class="form-horizontal" id="add-user-form">
            <input type="hidden" name="id" value="${user.id}"/>
            <div class="form-group has-feedback">
                <endofline:inputField label="Username" name="username"/>
                <endofline:inputField label="Mail" name="email"/>
                <endofline:passwordInputField label="Password" name="password"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${user['new']}">
                            <button class="btn btn-default" type="submit">Add user</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-default" type="submit">Update user</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
        <c:if test="${!user['new']}">
        </c:if>
    </jsp:body>
</endofline:layout>
