/**
 * perchè keyup e non keydown o keyPress?
 * perchè quando si preme un tasto si susseguono:
 *
 * Keydown, Keypress, updateview, Keypress, updateview, keyup
 *
 * dove key e' ultimo col tasto aggiornato!!
 * */

var risultatoRicercaDiv = document.querySelector(".risultatoRicerca");

//rimuove il div div di ricerca se l'utente clicca ovunque, tranne il div di ricerca
document.addEventListener("click",(event)=>{
    if(event.target.id != "inputCerca")
        document.querySelector(".risultatoRicerca").style.display = "none";
})

//ripulisce il div di ricerca e esegue una nuova ricerca se l'utente scrive anche un solo carattere
document.getElementById("inputCerca")
    .addEventListener("keyup",(event)=>{
       risultatoRicercaDiv.innerHTML="";
       cerca(event.target.value) ;

})

function cerca(valoreCercato){

    var requestAjax = new XMLHttpRequest();

    requestAjax.onreadystatechange = ()=>{
        if(requestAjax.status == 200 && requestAjax.readyState == 4){
            jsonObj = JSON.parse(requestAjax.responseText);

            risultatoRicercaDiv.style.display = "block";

            if(jsonObj.length == 0) {
                risultatoRicercaDiv.innerText = "la ricerca non trovato nulla :'C" ;
            }
            for(i = 0; i < jsonObj.length; i++) {
                risultatoRicercaDiv.innerHTML += `
                    <a href="MostraCategoria?idCategoria=${jsonObj[i].idCategoria}&nomeCategoria=${jsonObj[i].nomeCategoria}">
                        ${jsonObj[i].nomeCategoria}
                    </a>`
            }
        }
    };

    requestAjax.open("GET","RisultatoRicerca?cercato="+valoreCercato,true);
    requestAjax.send();
}