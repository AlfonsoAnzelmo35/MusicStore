function apriModal(idStrumento, indiceQuantita){

    let modal = document.querySelector(".modal");

    let divChild = document.querySelector(".modal").children[0]
    let aChildDivChild = divChild.children[2]
    aChildDivChild.href="RimuoviStrumentoCarrello?idStrumento="+idStrumento+"&indiceQuantita="+indiceQuantita;


    modal.style.top=window.scrollY;
    modal.style.left="0";

    modal.style.display = "block";
    document.body.style.overflow = "hidden";


}

function chiudiModal(){

    let modal = document.querySelector(".modal");

    modal.style.display = "none";
    document.body.style.overflow = "scroll";

}