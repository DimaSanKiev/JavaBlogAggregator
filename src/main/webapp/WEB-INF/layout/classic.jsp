<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 12.06.2015
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>

<tiles:insertAttribute name="body"/>

<br><br>
<center>
    <tiles:insertAttribute name="footer"/>
</center>

</body>
</html>
