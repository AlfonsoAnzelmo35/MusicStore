prinpalis = document.querySelectorAll(".principale");
sub_menus = document.querySelectorAll(".sub-menu-sottocategoria");

/**
 * usa l'indice del liCliccato per rimuovere/aggiungere il sub_menu corrispondente
 * (hanno lo stesso indice)
 * */
function show(liCliccato){
    liCliccato.style.backgroundColor = "#ededed";
    liCliccato.children[0].style.color = "#000000";
    prinpalis.forEach((corrente,indice)=> showHide(corrente, liCliccato,indice))

}
function showHide(corrente, liCliccato,indice){

    if(corrente == liCliccato){
        if(sub_menus[indice].style.display != "none"){
            sub_menus[indice].style.display = "none"
        }else {
            sub_menus[indice].style.display = "block"
        }
    }
}
