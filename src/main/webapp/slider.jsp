<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/slider.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
    <body>
        <div class="slider">
            <button id="indietro">
                <span class="material-symbols-outlined">
                arrow_back_ios
                </span>
            </button>
            <button id="avanti">
                <span class="material-symbols-outlined">
                    arrow_forward_ios
                </span>
            </button>
            <div class="slide">
                <img src="images/chitarra4.jpg">
            </div>
            <div class="slide">
                <img src="images/chitarraClassica.jpg">
            </div>
            <div class="slide">
                <img src="images/pianoForte.png">
            </div>
            <div class="slide">
                <img src="images/tromba.jpg">
            </div>
            <%--<c:forEach var = "strumento" items="${strumentoList}">
                <div class="slide">
                    <img src="${strumento.percorsoImmagini}">
                </div>
            </c:forEach>--%>

        </div>
        <script src="js/slider.js"></script>
    </body>
</html>
