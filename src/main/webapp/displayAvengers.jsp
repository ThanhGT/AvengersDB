<%-- 
    Document   : displayAvengers
    Created on : Nov 10, 2019, 10:46:10 PM
    Author     : Thanh Tran
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Avengers</title>
    </head>
    <body>
        <h1>Here are the Avengers</h1>
       
        <!-- if there is an error -->
        <c:if test="${!empty error}">
            <h2>${error}</h2>
        </c:if>
               
        <!-- display avenger -->
        <c:forEach var="avenger" items="${avengers}">
            <ul>
                <li>Hero: ${avenger.heroName}</li>
                <li>Description: ${avenger.desc}</li>
                <li>Super Power: ${avenger.superpower.desc}</li>
            </ul>
        </c:forEach>
           
        <a href="index.html">Back to Index</a>
    </body>
</html>
