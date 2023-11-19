
$(document).ready(()=>{
    $("#nazione").click(()=>{
        $.get("nations.xml", (data, status)=>{
            var x = data.getElementsByTagName("nazione"); //XML
            console.log(x)
            $(x).each((indice)=>{
                var $option = $("<option>"); //crea un elemento, best-practice dichiarare una variabile jquery con il $
                $($option).text( x[indice].getElementsByTagName("nome")[0].childNodes[0].nodeValue) //prende tramite l'API di xml di javascript l'emento dell'i-esima nazione
                $("#nazione").append($option) ;
            });

        });
    });
});

//identico codice ma in javaScript vanilla

/*var nazioneSelect = document.getElementById("nazione");
nazioneSelect.addEventListener("click",()=>{
        var requestAjax = new XMLHttpRequest();

        requestAjax.onreadystatechange = ()=>{
            if(requestAjax.status == 200 && requestAjax.readyState == 4) {
                var responseXml = requestAjax.responseXML
                var x = responseXml.getElementsByTagName("nazione");
                for (i = 0; i < x.length; i++) {
                    var option = document.createElement("option")
                    option.innerText =
                        x[i].getElementsByTagName("nome")[0].childNodes[0].nodeValue;

                    nazioneSelect.appendChild(option) ;


                   // console.log(x[i].getElementsByTagName("sigla")[0].childNodes[0].nodeValue);
                }
            }
        };

    requestAjax.open("GET","nations.xml", true);
    requestAjax.send();
});*/