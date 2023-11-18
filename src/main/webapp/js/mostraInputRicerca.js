var spanRicerca = document.querySelector(".header div:nth-child(2) span"); //la lente
var inputRicerca = document.querySelector(".header div:nth-child(2) input");
var inputRicercaOldStyle = inputRicerca.style;

spanRicerca.addEventListener("click",()=>{
    if(inputRicerca.style.display == "block"){
        inputRicerca.style.display = "none";
    }else{
        inputRicerca.style.display = "block";
    }
});

window.addEventListener("resize",()=>{
    if(window.innerWidth >= 810) {

        inputRicerca.style = inputRicercaOldStyle ;

    }
    if(window.innerWidth < 810) {
        inputRicerca.style.display = "none"  ;

    }
})


