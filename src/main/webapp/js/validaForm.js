function validazione(){
    var errore = document.querySelector(".errore");
    var erroreP = document.querySelector(".errore p");

    if (document.forms[1].elements[1].value == "") {//cognome
        document.forms[1].elements[1].focus();
        errore.style.display="block";
        erroreP.innerText = "campo cognome errato!" ;
        return false;
    }
    if (document.forms[1].elements[2].value == "") {//nome
        document.forms[1].elements[2].focus();
        errore.style.display="block";
        erroreP.innerText = "campo nome errato!" ;
        return false;
    }
    if (document.forms[1].elements[3].value == "") {//dataNascita
        document.forms[1].elements[3].focus();
        errore.style.display="block";
        erroreP.innerText = "campo dataNascita errato!" ;
        return false;
    }
    if (document.forms[1].elements[4].value == "") {//via
        document.forms[1].elements[4].focus();
        errore.style.display="block";
        erroreP.innerText = "campo via errato!" ;
        return false;
    }
    if (document.forms[1].elements[5].value == "") {//citta
        document.forms[1].elements[5].focus();
        errore.style.display="block";
        erroreP.innerText = "campo citta errato!" ;
        return false;
    }
    if (document.forms[1].elements[6].value == "") {//email
        document.forms[1].elements[6].focus();
        errore.style.display="block";
        erroreP.innerText = "campo email errato!" ;
        return false;
    }
    if (document.forms[1].elements[7].value == "") {//password
        document.forms[1].elements[7].focus();
        errore.style.display="block";
        erroreP.innerText = "campo password errato!" ;
        return false;
    }
}

function validazioneLogin(){
    var errore = document.querySelector(".errore");
    var erroreP = document.querySelector(".errore p");

    if (document.forms[1].elements[1].value == "") {//email
        document.forms[1].elements[1].focus();
        errore.style.display="block";
        erroreP.innerText = "campo email errato!" ;
        return false;
    }
    if (document.forms[1].elements[2].value == "") {//password
        document.forms[1].elements[2].focus();
        errore.style.display="block";
        erroreP.innerText = "campo password errato!" ;
        return false;
    }
}

function validazioneModficaDati(){
    var errore = document.querySelector(".errore");
    var erroreP = document.querySelector(".errore p");

    if (document.forms[1].elements[0].value == "") {//nome
        document.forms[1].elements[0].focus();
        errore.style.display="block";
        erroreP.innerText = "campo nome errato!" ;
        return false;
    }
    if (document.forms[1].elements[1].value == "") {//cognome
        document.forms[1].elements[1].focus();
        errore.style.display="block";
        erroreP.innerText = "campo cognome errato!" ;
        return false;
    }

    if (document.forms[1].elements[2].value == "") {//via
        document.forms[1].elements[2].focus();
        errore.style.display="block";
        erroreP.innerText = "campo via errato!" ;
        return false;
    }
    if (document.forms[1].elements[3].value == "") {//email
        document.forms[1].elements[3].focus();
        errore.style.display="block";
        erroreP.innerText = "campo email errato!" ;
        return false;
    }
    if (document.forms[1].elements[4].value == "") {//password
        document.forms[1].elements[4].focus();
        errore.style.display="block";
        erroreP.innerText = "campo password errato!" ;
        return false;
    }

}

