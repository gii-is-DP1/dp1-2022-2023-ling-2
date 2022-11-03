<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>

<%@ attribute name="pageName" required="true"  rtexprvalue="true"
              description="Name of the active menu"%>

<endofline:menu name="${pageName}"/>
