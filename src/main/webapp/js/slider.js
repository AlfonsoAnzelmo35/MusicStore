

var slides = document.querySelectorAll(".slide");
slides.forEach((element,indice) => {
    element.style.transform = `translate(${indice * 100}%,0)`
});

var i = 0;

var buttoneIndietro = document.getElementById("indietro");
buttoneIndietro.addEventListener("click",()=>{

    i = (i + 1)%slides.length
    if(i > 0)
        i = -(slides.length - 1)

    spostaTutteLeSlide()

});


var buttoneAvanti = document.getElementById("avanti") ;
buttoneAvanti.addEventListener("click",()=>{
    i = (i - 1)%slides.length

    spostaTutteLeSlide() ;

});


function spostaTutteLeSlide(){
    slides.forEach((element,indice) => {
        element.style.transform = `translate(${(indice + i)* 100}%,0%)`
    })
}
