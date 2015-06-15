<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 12.06.2015
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>

    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- google CDN -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

    <script type="text/javascript"
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"/></title>
</head>
<body>

<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<tilesx:useAttribute name="current"/>

<div class="container">

    <!-- Static navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<spring:url value="/" />">JBA</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/" />'>Home</a></li>
                    <security:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="${current == 'users' ? 'active' : ''}"><a href="<spring:url value="/users.html"/>">Users</a>
                        </li>
                    </security:authorize>
                    <li class="${current == 'register' ? 'active' : ''}"><a href="<spring:url value="/register.html"/>">Register</a>
                    </li>
                    <security:authorize access="! isAuthenticated()">
                        <li class="${current == 'login' ? 'active' : ''}"><a href="<spring:url value="/login.html"/>">Login</a>
                        </li>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
                        <li class="${current == 'account' ? 'active' : ''}"><a
                                href="<spring:url value="/account.html"/>">My account</a></li>
                        <li><a href="<spring:url value="/logout"/>">Logout</a></li>
                    </security:authorize>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid -->
    </nav>

    <tiles:insertAttribute name="body"/>

    <br>
    <br>
    <center>
        <tiles:insertAttribute name="footer"/>
    </center>

</div>

</body>
</html>
