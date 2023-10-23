<%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 22/10/2023
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
    <link rel="stylesheet" href="css/home.css" />
    <link rel="stylesheet" href="css/register-login.css">
    <title>Login</title>
</head>
<body>
    <%@include file="header.jsp"%>

    <div class="contenitore-flex">
        <%@ include file="CategorieMenu.jsp"%>

        <div class="register-login">
        <div class="errore">
            <h3>Si è verificato un errore</h3>
            <p></p>
        </div>


        <h2>Effettua il login</h2>
        <p>Per completare l'ordine inserisci il nome utente e la password e poi clicca sul pulsante "Accedi"</p>
        <form action="Login" method="post" onsubmit="return validazioneLogin()">

            <table>
            <tr>
                <th><label for="email">E-mail:</label></th>
                <td><input id="email" type="email" name="email"></td>
            </tr>
            <tr>
                <th><label for="password">Password:</label></th>
                <td><input id="password" type="password" name="password"></td>
            </tr>
            <tr>
                <th></th>
                <td><input type="submit" value="ACCEDI"></td>
            </tr>
            </table>
        </form>
        <a href="register.jsp"> non sei registrato? </a>
    </div>
    </div>
    <script src="js/validaForm.js"></script>
    <%@ include file="footer.jsp"%>
</body>
</html>
