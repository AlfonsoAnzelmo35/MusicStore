<%--
  Created by IntelliJ IDEA.
  User: anzel
  Date: 18/11/2023
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MetodoPagamento</title>
  <link rel="stylesheet" href="../css/header.css">
  <link rel="stylesheet" href="../css/footer.css">
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>

</head>
<body>
  <%@include file="../header.jsp"%>

  <div class ="tiTroviIn">
    <span class="material-symbols-outlined">
        arrow_right_alt
    </span>
    <span>Ti trovi in > <a href="../home.jsp">home</a> > Metodi Pagamento </span>

  </div>


  Le <b>modalità</b> di pagamento valide sul nostro sito sono le seguenti:
  <ul>
    <li>Carta di Credito: sono accettate tutte le carte dei circuiti Visa, Visa Electron, Mastercard, Postepay, mentre per pagamenti con American Express ti preghiamo di utilizzare la modalità PayPal.
    Tutte le transazioni sono sicure e le informazioni relative ai dati della carta di credito verranno inviate attraverso una connessione sicura SSL.
    </li>
    <li>
    Bonifico Bancario, un metodo sicuro ormai molto utilizzato, grazie anche alla possibilità di effettuare il pagamento attraverso il proprio home banking o recandosi presso il proprio istituto bancario o postale.
    Qui di seguito le due possibilità di coordinate per effettuare il pagamento. Nota bene, in questo caso l'ordine verrà evaso solo dopo la ricezione del pagamento (occorrono da 1 a 4 giorni lavorativi dall'esecuzione):
    Intestatario bonifico: Cappellani Dr. Santi srl
    </li>
    <li>
    - Banca Agricola Popolare di Ragusa - Viale XX Settembre, 47 - 95128 Catania (CT)
    IBAN: IT52C0503616900CC0450182062
    Swift Code: POPRIT31045
    - Unicredit - Filiale ex D'Annunzio, Catania
    Via G. D'Annunzio 162/B, Catania
    IBAN: IT32W0200816938000500010384
    </li>
  </ul>
  <%@include file="../footer.jsp"%>
</body>
</html>
