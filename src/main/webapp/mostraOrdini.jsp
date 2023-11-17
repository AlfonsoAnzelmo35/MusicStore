<%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 11/11/2023
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostra ordini</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/ordini.css">
</head>
<body>
    <%@ include file="header.jsp"%>

    <div class ="tiTroviIn">
        <span class="material-symbols-outlined">
            arrow_right_alt
        </span>
        <span>Ti trovi in > <a href="home.jsp">home</a> > area utente </span>
    </div>




    <div class="contenitore-flex">
        <%@ include file="CategorieMenu.jsp"%>

        <div class="contenitore-ordine">
            <c:forEach var="ordine" items="${ordiniList}" varStatus="loop">
                <div class="ordine">
                    <div class="info-ordini">
                        <div>ORDINE EFFETTUATO IL :<br/>
                            <span>${ordine.stampaCalendario()}</span></div>
                        <div>TOTALE :<br/>
                            <span>${ordine.totaleOrdine}</span></div>
                        <div>QUANTITA :<br/>
                            <span>${ordine.quantita}</span></div>
                    </div>
                    <div class="ordine-strumento">

                        <img src="${strumentoList[loop.index].percorsoImmagini}"/>
                        <span>${strumentoList[loop.index].nomeStrumento}</span>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
    <%@ include file="prodottoInEvidenza.jsp"%>



    <%@ include file="footer.jsp"%>
</body>
</html>
