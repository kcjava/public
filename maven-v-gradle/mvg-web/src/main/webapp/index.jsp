<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Value to encode</th>
                <th>Base 64 encoded</th>
            </tr>
            <tr>
                <td align="center"><%=request.getParameter("value") != null ? request.getParameter("value") : "Hello World!" %></td>
                <td align="center"><%=request.getParameter("value") != null ? new org.kcjava.mvg.core.Base64Wrapper().encodeToBase64(request.getParameter("value")) : new org.kcjava.mvg.core.Base64Wrapper().encodeToBase64("Hello World!")%></td>
            </tr>
        </table>
    </body>
</html>
