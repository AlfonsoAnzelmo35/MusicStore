<%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 22/10/2023
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>

  <title>register</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/home.css" />
  <link rel="stylesheet" href="css/register-login.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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

    <form action="Register" name="formName" method="post" onsubmit="return validazione()">

      <table>
        <tr>
          <th>
            <label for="nazione">Nazione:</label>
          </th>
          <td>
            <select id="nazione"  name="nazione">
            <option>Portugal</option>
          </select>
          </td>
        </tr>
        <tr>
          <th><label for="cognome">Cognome:</label></th>
          <td><input id="cognome" type="text" name="cognome"></td>
        </tr>
      <tr>
        <th><label for="nome">Nome:</label></th>
        <td><input id="nome" type="text" name="nome"></td>
      </tr>
        <tr>
        <th><label for="dataNascita">DataNascita:</label></th>
          <td><input id="dataNascita" type="date" name="dataNascita"></td>
        </tr>

      <tr>
        <th><label for="via">Via:</label></th>
        <td><input id="via" type="text" name="via"></td>
      </tr>
        <tr>
          <th><label for="citta">Citta:</label></th>
          <td><input id="citta" type="text" name="citta"></td>
        </tr>
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
          <td><input type="submit" value="INVIA REGISTRAZIONE"></td>
        </tr>
      </table>
    </form>
    <a href="login.jsp"> sei registrato? </a>
  </div>
</div>
<%@ include file="footer.jsp"%>

<script src="js/richiestaAJAXNations.js"></script>
<script src="js/validaForm.js"></script>
</body>
</html>
