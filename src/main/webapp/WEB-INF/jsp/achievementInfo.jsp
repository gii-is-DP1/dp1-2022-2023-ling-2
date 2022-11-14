<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>

<endofline:layout pageName="userDetails">
<form:form modelAttribute="achievement" class="form-horizontal" id="add-user-form">
    <div class="form-group has-feedback">
        <input type="hidden" name="id" value="${achievement.id}"/>
        <endofline:inputField label="Name" name="name"/>
        <endofline:inputField label="Description" name="description"/>
        <endofline:inputField label="Amount" name="conditionAmounts"/>
        <div class="control-group">
            <endofline:selectField name="conditions" label="Conditions" names="${condition}" size="5"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <c:choose>
                <c:when test="${achievement['new']}">
                    <button class="btn btn-default" type="submit">Add Achievement</button>
                </c:when>
                <c:otherwise>
                    <button class="btn btn-default" type="submit">Update Achievement</button>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</form:form>

</endofline:layout>

