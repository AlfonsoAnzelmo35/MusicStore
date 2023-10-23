<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/mostraCategoria.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>



    <%@ include file="header.jsp"%>
    <div class ="tiTroviIn">
    <span class="material-symbols-outlined">
        arrow_right_alt
    </span>
        <span>Ti trovi in > <a href="home.jsp">home</a> > ${nomeCategoriaMostra} </span>

    </div>
    <div class="contenitore-flex mostra-categoria">

        <%@ include file="CategorieMenu.jsp"%>
        <%@ include file="ListaCategoria.jsp"%>

    </div>

    <%@ include file="footer.jsp"%>

</body>
</html>
