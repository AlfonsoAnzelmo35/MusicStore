<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="css/ListaCategoria.css">
    <link rel="stylesheet" href="css/prodottiInEvidenza.css">
    <link rel="stylesheet" href="css/stumentoPerCategoria.css">
</head>
<body>
<%@ include file="header.jsp"%>


<div class="div_prodottiInEvidenza ">
    <p id ="range-prezzo">prezzo 50 € </p>
    <input type="range" min="1" max="10000" value="50" class="range-slider">

    <div class="listaCategoria">


        <c:forEach var="strumento" items="${strumentoListPerCategoria}">

            <div class="strumentoInEvidenza">
                <img src="${strumento.percorsoImmagini}"/>
                <h3>${strumento.nomeStrumento.substring(0, strumento.nomeStrumento.length() - 4)}</h3>
                <h3>${strumento.prezzo} €</h3>

                <div>
                    <div class="contenitore-quantita">

                        <form action="AggiungiStrumentoCarrello" id="form">
                            <input type="hidden" value="strumentoPerCategoria.jsp" name="nomePagina">
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
                    <c:if test="${ruolo.equals('Amministratore')}">
                        <a id="rimuoviArticolo" href="RimuoviArticolo?idStrumento=${strumento.idStrumento}"> 🗑️</a>
                    </c:if>
                </div>

            </div>
        </c:forEach>

    </div>
</div>

<script src="js/carrello.js"></script>
<script src="js/range_prezzo.js"></script>
<%@ include file="footer.jsp"%>

</body>
</html>
