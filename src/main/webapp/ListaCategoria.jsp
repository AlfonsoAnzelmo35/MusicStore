<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.musicstore.Model.Categoria" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/ListaCategoria.css">
</head>
<body>

    <div class="div_prodottiInEvidenza ">
        <h1>${nomeCategoriaMostra}</h1>
        <div class="listaCategoria">
            <c:forEach var="categoria" items="${sottoCategorieMostra}">
                <a href="StrumentoPerCategoria?idCategoria=${categoria.idCategoria}">
                    <h2>${categoria.nomeCategoria}</h2>
                    <img src="${categoria.percorso_immagine}"/>
                </a>

            </c:forEach>

        </div>
    </div>

</body>
</html>
