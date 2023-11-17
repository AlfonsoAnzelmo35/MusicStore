<%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 23/10/2023
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h2>siamo dispiaciuti, c'è stato un errore </h2>
    errore : ${errore}
    <a href="${pageContext.request.getContextPath()}/home.jsp"> torna alla home</a>
</body>
</html>
