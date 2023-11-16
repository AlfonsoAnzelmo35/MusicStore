<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrello</title>
    <link rel="stylesheet" href="css/carrello.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel ="stylesheet" href="css/modal.css">
</head>
<body>
    <%@include file="header.jsp" %>

    <div class="modal">
        <div>
            <span onclick="chiudiModal()" class="material-symbols-outlined">
                close
            </span>
            <h4>Sei sicuro di voler eliminare il prodotto</h4>
            <a href="RimuoviStrumentoCarrello">SI</a>
            <a onclick="chiudiModal()" >NO</a>
        </div>
    </div>
    <div class ="tiTroviIn">
    <span class="material-symbols-outlined">
        arrow_right_alt
    </span>
        <span>Ti trovi in > <a href="home.jsp">home</a> > Carrello </span>

    </div>

    <c:choose>
        <c:when test="${carrello.getStrumenti().isEmpty()}">
            <p><b>carrello vuoto è vuoto</b></p>
            <p>Per aggiungere articoli al carrello naviga sul sito, quando trovi l'articolo che ti interessa, clicca su
                "Aggiungi".<br/>
                Continua a fare acquisti sul sito </p>
        </c:when>
        <c:otherwise>

            <div class="contenitore-carrello">
                <table >
                    <tr><th></th><th>ARTICOLO</th><th>QUANTITÀ </th><th>PREZZO</th><th>TOTALE</th><th></th></tr>
                    <c:forEach var="strumento" items="${carrello.getStrumenti()}" varStatus="loop">
                    <tr>
                        <td class="immagineCarrello"><img src="${strumento.percorsoImmagini}"/></td>
                        <td class="nomeImmagineCarrello">${strumento.nomeStrumento}</td>
                        <td class="quantitaCarrello">${carrello.getQuantitaStrumento(strumento.idStrumento)}</td>
                        <td class="prezzoCarrello">${strumento.prezzo} €</td>
                        <td class="totaleCarrello">
                            <fmt:formatNumber type="number"  value="${carrello.getPrezzoPerQuantitaStrumento(strumento.idStrumento) }" maxFractionDigits="2"/>
                        </td>
                        <td class="deleteItemCarrello"><span onclick="apriModal(${strumento.idStrumento}, ${loop.index})" class="material-symbols-outlined">delete</span></td>
                    </tr>


                    </c:forEach>
                </table>

                <div class="prosegui">
                    <h2 id="totale"> Totale ${carrello.getTotale()} €</h2>
                    <a href="EffettuaOrdine">PROSEGUI</a>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
    <script src = "js/modal.js"></script>
    <%@include file="footer.jsp" %>
</body>
</html>
