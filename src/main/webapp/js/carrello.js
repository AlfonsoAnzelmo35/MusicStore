function invio(){
    document.getElementById("form").submit();
}
function incrementaQuantita(){
    let quantita = document.querySelector(".quantita")
    i = parseInt(quantita.innerText);
    i++;
    quantita.innerText = i;
}
function decrementaQuantita(){
    let quantita = document.querySelector(".quantita")
    i = parseInt(quantita.innerText);
    if(i > 0)
        i--;
    quantita.innerText = i;
}