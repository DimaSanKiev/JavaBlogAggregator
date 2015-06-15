<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 11.06.2015
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../layout/taglib.jsp" %>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>user name</th>
        <th>operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>
                <a href="<spring:url value="/users/${user.id}.html" />">
                    <c:out value="${user.name}"/>
                </a>
            </td>
            <td>
                <a href="<spring:url value="/users/remove/${user.id}.html" />" class="btn btn-danger">remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>