<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/header.css">
    </head>
<body >

<div class="contenitore-header">
    <div class="header">
        <div class="site-name">
            <span><a href="home.jsp"> MusicStore</a></span>
        </div>
        <div>
            <div class="div_ricerca">
                <form>
                    <div>
                        <input type="text" id="inputCerca" placeholder="cerca"/>
                        <span class="material-symbols-outlined">search</span>
                    </div>
                </form>
                <div class="risultatoRicerca">

                </div>
            </div>
        </div>
        <div class="links">

            <c:choose>
                <c:when test="${logged}">

                    <a href="areaUtente.jsp" id="area-utente-span" >area Utente</a>
                </c:when>
                <c:otherwise>
                    <a href="login.jsp">
                            <span class="material-symbols-outlined">
                            person
                            </span>
                        <span id="accedi-registrati">Accedi/Registrati</span>
                    </a>
                </c:otherwise>
            </c:choose>

            <a href="MostraCarrello">
                    <span class="material-symbols-outlined">
                    shopping_cart
                    </span>
                <span id="totaleCarrello">${carrello.getTotale()} €</span>
            </a>

        </div>
    </div>

    <div class="header-menu">
        <ul>
            <c:forEach var="categoria" items="${categoriePrincipali}" varStatus="loop">
                <li>
                    <a href="MostraCategoria?idCategoria=${categoria.idCategoria}&nomeCategoria=${categoria.nomeCategoria}">
                            ${categoria.nomeCategoria}
                    </a>

                    <ul class="sottomenu-sottocategoria">
                        <c:forEach var="sottoCategoria" items="${sottoCategorie[loop.index]}" varStatus="loopInterno">
                            <li>
                                <a href="StrumentoPerCategoria?idCategoria=${sottoCategoria.idCategoria}">
                                    <h2>${sottoCategoria.nomeCategoria}</h2>
                                    <%--<img src="${sottoCategoria.percorso_immagine}"/>--%>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ul>
    </div>

</div>

<script src="js/mostraInputRicerca.js"></script>
<script src="js/richiestaAJAX.js"></script>
</body>
</html>
