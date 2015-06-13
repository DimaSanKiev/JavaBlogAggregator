<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 11.06.2015
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>user name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                    <a href="<spring:url value="/users/${user.id}.html"/>">
                        <%--${user.name}--%>
                    <c:out value="${user.name}"/>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>