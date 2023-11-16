package com.example.musicstore.Model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ordini {


    public Ordini(int strumento, float totaleOrdine, float sconto, int quantita,GregorianCalendar dataOrdine) {
        this.strumento = strumento;
        this.TotaleOrdine = totaleOrdine;
        this.sconto = sconto;
        this.quantita = quantita;
        this.dataOrdine = dataOrdine;
    }

    public Ordini(int utenteCF, int strumento, float totaleOrdine, float sconto, int quantita, GregorianCalendar dataOrdine) {
        this.utenteCF = utenteCF;
        this.strumento = strumento;
        TotaleOrdine = totaleOrdine;
        this.sconto = sconto;
        this.quantita = quantita;
        this.dataOrdine = dataOrdine;
    }

    public Ordini() {
    }

    public int getUtenteCF() {
        return utenteCF;
    }

    public void setUtenteCF(int utenteCF) {
        this.utenteCF = utenteCF;
    }

    public int getStrumento() {
        return strumento;
    }

    public void setStrumento(int strumento) {
        this.strumento = strumento;
    }

    public float getTotaleOrdine() {
        return TotaleOrdine;
    }

    public void setTotaleOrdine(float totaleOrdine) {
        TotaleOrdine = totaleOrdine;
    }

    public float getSconto() {
        return sconto;
    }

    public void setSconto(float sconto) {
        this.sconto = sconto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public GregorianCalendar getDataOrdine() {
        return dataOrdine;
    }

    public String stampaCalendario(){
        return dataOrdine.get(Calendar.YEAR) +"/"+ dataOrdine.get(Calendar.MONTH) +"/"+ dataOrdine.get(Calendar.DAY_OF_MONTH) ;
    }

    public void setDataOrdine(GregorianCalendar dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    private int utenteCF;
    private int strumento;
    private float TotaleOrdine, sconto;
    private int quantita;

    private GregorianCalendar dataOrdine;
}