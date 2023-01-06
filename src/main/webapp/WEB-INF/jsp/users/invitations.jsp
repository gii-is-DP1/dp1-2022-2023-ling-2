<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="endofline" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<endofline:layout pageName="invitations">
    <jsp:body>
        <div>
            <div style="height:500px; overflow:auto; float: left; width: 49%; align-items: center">
                <table class="table table-striped">
                    <caption>Sent Pending Requests</caption>
                    <thead>
                    <tr>
                        <th>User Sent To</th>
                        <th>Type</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pending_sent_invitations}" var="req">
                        <tr>
                            <td>
                                <a href="/u/${req.receiver.username}">${req.receiver.username}</>
                            </td>
                            <td>
                                <span> ${req.type}</span>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div style="height:500px; overflow:auto; float: right; width: 49%;">
                <table class="table table-striped">
                    <caption>Received Pending Requests</caption>
                    <thead>
                    <tr>
                        <th>User Received From</th>
                        <th>Type</th>
                        <th>Accept</th>
                        <th>Reject</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pending_received_invitations}" var="req">
                        <tr>
                            <td>
                                <a href="/u/${req.sender.username}">${req.sender.username}</>
                            </td>
                            <td>
                                ${req.type}
                            </td>
                            <td>
                                <a href="/gameinvites/${req.id}/accept"><span class="glyphicon glyphicon-ok warning" aria-hidden="true"/></a>
                            </td>
                            <td>
                                <a href="/gameinvites/${req.id}/reject"><span class="glyphicon glyphicon-remove warning" aria-hidden="true"/></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</endofline:layout>
