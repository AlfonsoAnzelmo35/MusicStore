
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
        href="css/messaggioDiNotifica.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/home.css" />
    <title>JSP - Hello World</title>
</head>
    <body>


    <%@ include file="header.jsp"%>

    <div class="contenitore-flex">
        <%@ include file="CategorieMenu.jsp"%>
        <%@ include file="prodottoInEvidenza.jsp"%>
    </div>


    <c:if test="${appenaLoggato != null}">
        <div class="messaggio_di_notifica">
            ACCESSO AVVENUTO CON SUCCESSO
        </div>
    </c:if>
    <c:if test="${ordineEffetuato != null}">
        <div class="messaggio_di_notifica">
            ORDINE EFFETTUATO CON SUCCESSO
        </div>
    </c:if>

    <%@ include file="footer.jsp"%>

    </body>
</html>