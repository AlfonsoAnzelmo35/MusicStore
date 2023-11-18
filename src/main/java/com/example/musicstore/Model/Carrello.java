package com.example.musicstore.Model;

import java.util.*;

public class Carrello {

    public Carrello(){
        this.strumentoQuantita = new HashMap<>();
    }
    public void aggiungiStrumento(Strumento strumento, int quantita) {
        this.strumentoQuantita.put(strumento,quantita);
    }

    public float getPrezzoPerQuantitaStrumento(Integer id){

        Optional<Strumento> strumentoOPT = getStrumento(id);

        if(strumentoOPT.isPresent())
            return strumentoQuantita.get(strumentoOPT.get()) * strumentoOPT.get().getPrezzo();//il primo get si riferisce alla mappa, il secondo si riferisce all'optional strumento

        return 0;

    }

    public void aggiornaQuantitaStrumento(int idStrumento, int newQuantita){
        Optional<Strumento> strumentoOPT = getStrumento(idStrumento) ;
        Strumento strumento = strumentoOPT.get() ;
        int oldQuantita = strumentoQuantita.get(strumento) ;
        strumentoQuantita.replace(strumento, oldQuantita + newQuantita) ;
    }


    public Integer getQuantitaStrumento(Integer id){
        Optional<Strumento> strumentoOPT = getStrumento(id);

        if(strumentoOPT.isPresent())
            return strumentoQuantita.get(strumentoOPT.get());//il primo get si riferisce alla mappa, il secondo si riferisce all'optional strumento

        return null;
    }

    public Optional<Strumento> getStrumento(Integer id){
        Optional<Strumento> strumentoOPT = strumentoQuantita.keySet()
                .stream()
                .filter(strum -> strum.getIdStrumento() == id)
                .findFirst();
        return strumentoOPT;
    }

     public float getTotale(){
        float somma =0 ;

        for(Map.Entry<Strumento, Integer> entry: strumentoQuantita.entrySet()) {
            Strumento strumento = entry.getKey();
            Integer quantita = entry.getValue();
            somma += strumento.getPrezzo() * quantita;
        }

        return somma;
    }

    public List<Strumento> getStrumenti(){
        return strumentoQuantita.keySet().stream().toList();

    }

    public void rimuoviStrumento(int idStrumento){
        Optional<Strumento> strumentoOPT = getStrumento(idStrumento) ;
        if(strumentoOPT.isPresent()) {
            strumentoQuantita.remove(strumentoOPT.get());
        }
    }

    public void rimuoviTuttiGliStrumenti(){
        strumentoQuantita.clear();
    }


    @Override
    public String toString() {
        return "Carrello{" +
                "strumentoQuantita=" + strumentoQuantita +
                '}';
    }

    private HashMap<Strumento, Integer> strumentoQuantita;

}
