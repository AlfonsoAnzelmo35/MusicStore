let range_slider = document.querySelector(".range-slider") ;
let range_prezzo = document.querySelector("#range-prezzo") ;


let listaCategoria = document.querySelector(".listaCategoria") ;
let prezzoStrumento = document.querySelector("#prezzoStrumento") ;

range_slider.addEventListener("change",()=>{
    range_prezzo.innerText = "prezzo " + range_slider.value +  " €";

    let prezzoLimite = parseInt(range_prezzo.innerText.substring(7)) ;
    let strumenti = Array.from(listaCategoria.children) ;

    strumenti.forEach((item, index, array)=> {
        let prezzoIesimoStrumento = parseInt(item.children[2].innerText);
        if (prezzoIesimoStrumento > prezzoLimite) {
            item.style.display = "none";
        }else{
            item.style.display = "block"

            console.log(item + " diventera' none")
        }
    });
});