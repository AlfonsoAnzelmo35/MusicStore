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
        System.out.println("somma");
        for(Map.Entry<Strumento, Integer> entry: strumentoQuantita.entrySet()) {
            Strumento strumento = entry.getKey();
            Integer quantita = entry.getValue();
            somma += strumento.getPrezzo() * quantita;
        }
        System.out.println("somma " + somma);
        return somma;
    }

    public List<Strumento> getStrumenti(){
        return strumentoQuantita.keySet().stream().toList();

    }


    @Override
    public String toString() {
        return "Carrello{" +
                "strumentoQuantita=" + strumentoQuantita +
                '}';
    }

    private HashMap<Strumento, Integer> strumentoQuantita;

}
