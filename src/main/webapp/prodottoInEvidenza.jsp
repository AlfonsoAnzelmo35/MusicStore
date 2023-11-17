<%@ page import="com.example.musicstore.Model.Strumento" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.musicstore.Model.Carrello" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/ListaCategoria.css">
    <link rel="stylesheet" href="css/prodottiInEvidenza.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>


    <div class="div_prodottiInEvidenza ">
        <h1>prodotti in evidenza</h1>
        <div class="listaCategoria">
            <c:forEach var = "strumento" items="${strumentoList}">

                <div class="strumentoInEvidenza">
                    <img src = "${strumento.percorsoImmagini}"/>
                    <h3>${strumento.nomeStrumento}</h3>
                    <h3>${strumento.prezzo}</h3>
                    <div>
                        <div class="contenitore-quantita">

                                <form action="AggiungiStrumentoCarrello" id="form">
                                    <input type="hidden" value="${strumento.idStrumento}" name="idStrumento">
                                    <input type="text" list="list_quantita" name="list_quantita" value="1"/>
                                    <datalist id="list_quantita">
                                        <option>2</option>
                                        <option>5</option>
                                        <option>10</option>
                                    </datalist>
                                    <input type="submit" value="🛒">
                                </form>

                        </div>

                    </div>
                </div>

            </c:forEach>
        </div>
    </div>
    <script src ="js/carrello.js"></script>
    <%--<div class="div_prodottiInEvidenza">
        <h1>prodotti in evidenza</h1>
        <% List<Strumento> strumentoList = (List<Strumento>) application.getAttribute("strumentoList");
        if(strumentoList!= null)

        for(Strumento strumento: strumentoList){%>
            <img src = "<%=strumento.getPercorsoImmagini()%>"/>
            <h3><%=strumento.getNomeStrumento()%></h3>
            <h3><%=strumento.getPrezzo()%></h3>

        <%}%>
    </div>--%>
</body>
</html>
