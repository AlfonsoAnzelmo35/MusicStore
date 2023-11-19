<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MusicStore modifica info</title>
  <link rel="stylesheet" href="css/areaUtente.css">
  <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/modificaInforPersonali.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
    <link rel="stylesheet" href="css/register-login.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>



  <%@ include file="header.jsp"%>

  <c:if test="${logged == null}">
      <jsp:forward page="WEB-INF/erroreNonAccesso.jsp"/>

  </c:if>

  <div class ="tiTroviIn">
          <span class="material-symbols-outlined">
              arrow_right_alt
          </span>
    <span>Ti trovi in > <a href="home.jsp">home</a> > Modifica Info personali </span>
  </div>
  <div class="contenitore-modificaInfoPersonali">
      <div class="errore">
          <h3>Si è verificato un errore</h3>
          <p></p>
      </div>
      <form action="ModificaInformazioniPersonali" method="post" onsubmit="return validazioneModficaDati()">

          <table>
              <tr>
                  <td>
                      <h4>Nome</h4>
                      ${nomeUtente}
                  </td>
                  <td>
                      <input type="text" name="nuovoNome" placeholder="nuovoNome">
                  </td>
              </tr>
              <tr>
                  <td>
                      <h4>Cognome</h4>
                      ${cognomeUtente}
                  </td>
                  <td>
                      <input type="text" name="nuovoCognome" placeholder="nuovoCognome">
                  </td>
              </tr>
              <tr>
                  <td>
                      <h4>via</h4>
                      ${indirizzoUtente}
                  </td>
                  <td>
                      <input type="text" name="nuovoIndirizzo" placeholder="nuovoIndirizzo">
                  </td>
              </tr>
              <tr>
                  <td>
                      <h4>E-mail</h4>
                      ${emailUtente}
                  </td>
                  <td>
                      <input type="email" name="nuovaEmail" placeholder="nuovaEmail">
                  </td>
              </tr>
              <tr>
                  <td>
                      <h4>Password</h4>
                      *****
                  </td>
                  <td>
                      <input type="password" name="nuovaPassword" placeholder="nuovaPassword">
                  </td>
              </tr>
              <tr>
                  <td></td>
                  <td>
                      <input id="effettuaModifiche" type="submit" value="Modifica">
                  </td>
              </tr>
          </table>
      </form>
</div>


  <%@ include file="footer.jsp"%>

<script src="js/validaForm.js"></script>
</body>
</html>
