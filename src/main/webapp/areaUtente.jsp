<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Area Utente</title>
    <link rel="stylesheet" href="css/areaUtente.css">
    <link rel="stylesheet" href="css/home.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

    <c:if test="${logged == null}">

        <jsp:forward page="/WEB-INF/errore.jsp"/>
    </c:if>

    <%@ include file="header.jsp"%>

    <div class ="tiTroviIn">
        <span class="material-symbols-outlined">
            arrow_right_alt
        </span>
        <span>Ti trovi in > <a href="home.jsp">home</a> > area utente </span>
        <b id="salutoUtente">Ciao  ${nomeUtente}</b>
    </div>

    <div class="contenitore-flex">
        <%@ include file="CategorieMenu.jsp"%>


        <div class="area_utente">

            <div class="card">
                <div class="card_image">
                    <img src="images/areaUtente/ordinazionePacco.png" alt="ordina"/>
                </div>
                <div class="card_info">
                    <a href="MostraOrdini">
                        <h3 class="titolo_card"> I miei ordini</h3>
                        <p class="descrizione_card">ordini passati e correnti</p>
                    </a>
                </div>
            </div>

            <!-- PROSSIMAMENTE PIANI PRIME
            <div class="card">
                <div class="card_image">
                    <img src="images/areaUtente/dollaro.png" alt="piano Prime"/>
                </div>

                <div class="card_info">
                    <h3 class="titolo_card"> Prime</h3>
                    <p class="descrizione_card"> Piano prime</p>
                </div>
            </div>
            -->
            <div class="card">
                <div class="card_image">
                    <img src="images/areaUtente/indirizzo.png" alt="sicurezza"/>
                </div>
                <a href="ModificaInformazioniPersonali.jsp">
                    <div class="card_info">
                        <h3 class="titolo_card"> Indirizzi</h3>
                        <p class="descrizione_card"> Modifica gli indizzi e le informazioni personali</p>
                    </div>
                </a>
            </div>
            <div class="card">
                <div class="card_image">
                    <img src="images/areaUtente/logout.webp" alt="logout"/>
                </div>
                <div class="card_info">
                    <a href="Logout" >
                        <h3 class="titolo_card"> Log out</h3>
                        <p class="descrizione_card"> Disconnettiti </p>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>
