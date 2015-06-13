<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 11.06.2015
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
                    <a href="<spring:url value="/users/${user.id}.html" />">
                        ${user.name}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>