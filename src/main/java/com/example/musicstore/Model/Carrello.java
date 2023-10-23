package com.example.musicstore.Model;

import java.util.ArrayList;
import java.util.List;

public class Carrello {

    public Carrello() {
        this.quantita = new ArrayList<>();
        this.strumenti = new ArrayList<>();
    }

    public Carrello(List<Integer> quantita, List<Strumento> strumentiIds) {
        this.quantita = quantita;
        this.strumenti = strumentiIds;
    }

    public List<Integer> getQuantita() {
        return quantita;
    }

    public void setQuantita(List<Integer> quantita) {
        this.quantita = quantita;
    }

    public List<Strumento> getStrumenti() {
        return strumenti;
    }

    public void setStrumenti(List<Strumento> strumenti) {
        this.strumenti = strumenti;
    }
    public float getPrezzoPerQuantitaStrumento(int i){
        return strumenti.get(i).getPrezzo() * quantita.get(i);
    }
    public float getTotale(){
        float somma =0 ;
        for(int i = 0; i < strumenti.size();i++)
          somma += strumenti.get(i).getPrezzo() * quantita.get(i);

        return somma;
    }

    private List<Integer> quantita;
    private List<Strumento> strumenti;

}
