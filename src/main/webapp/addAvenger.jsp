<%-- 
    Document   : addAvenger
    Created on : Nov 10, 2019, 11:40:35 PM
    Author     : Thanh Tran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mylib" uri="/WEB-INF/tlds/newtag_library.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registers an Avenger</title>
    </head>
    <body>
        <form action="AddAvenger.do" method="POST">
            Hero Name:<input type=text name="heroName"><br>
            Description:<input type="text" name="desc"><br>
            Superpower:<mylib:PowerSourceHandler/><br>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
