<%@ page import="com.example.musicstore.Model.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="css/categoriaMenu.css"/>

</head>
<body>

<div class="div_Categorie_menu">

    <h3>CATEGORIE</h3>
    <ul class="menu-categoria">

        <c:forEach var="categoria" items="${categoriePrincipali}" varStatus="loop">
            <li class ="principale" onclick="show(this)">
                <a href="MostraCategoria?idCategoria=${categoria.idCategoria}&nomeCategoria=${categoria.nomeCategoria}">
                        ${categoria.nomeCategoria}
                </a>
                <span class="material-symbols-outlined">expand_more</span>
            </li>

            <ul class="sub-menu-sottocategoria">
                <c:forEach var="sottoCategoria" items="${sottoCategorie[loop.index]}" varStatus="loopInterno">

                    <li>
                        <a href="MostraCategoria?idCategoria=${sottoCategoria.idCategoria}&nomeCategoria=${sottoCategoria.nomeCategoria}">
                                ${sottoCategoria.nomeCategoria}
                        </a>
                    </li>
                </c:forEach>
            </ul>

        </c:forEach>
        <p id ="range-prezzo">prezzo 50 € </p>
        <input type="range" min="1" max="10000" value="50" class="range-slider">
    </ul>

</div>

    <script src="js/show-hide-categorie.js"></script>
</body>
</html>


<!--in realtà la complessità è lineare perchè il for interno continua a iterare
sull'indice lasciato dal primo for e continua fino al raggiungimento della prossima
categoria principale-->
<%--
    List<Categoria> categoriaList = (List<Categoria>) request.getAttribute("listaCategorie");
    if(categoriaList!= null){%>
<div class="div_Categorie_menu">

    <h3>CATEGORIE</h3>

    <ul class="menu-categoria">
        <%
            for(int i = 0 ;i < categoriaList.size(); ){
                if(categoriaList.get(i).isPrincipale()){%>
                    <li class ="principale" onclick="show(this)">
                        <a href="MostraCategoria?idCategoria=<%=categoriaList.get(i).getIdCategoria()%>&nomeCategoria=<%=categoriaList.get(i).getNomeCategoria()%>">
                            <%= categoriaList.get(i).getNomeCategoria()%>
                        </a>
                        <span class="material-symbols-outlined">expand_more</span>
                    </li>
                <%i++;
                }else{
                %>
                    <ul class="sub-menu-sottocategoria">
                        <%for(; i < categoriaList.size();){
                            if(categoriaList.get(i).isPrincipale()) { break;}%>

                            <li>
                                <span>
                                    <%=categoriaList.get(i).getNomeCategoria()%>
                                </span>
                            </li>

                        <%i++;}%><!-- fine for interno-->
                    </ul>
                <%}%><!--fine else (categorie secondarie)-->

        <%}%><!--fine for principale-->
    </ul>
</div>
<%}--%>
