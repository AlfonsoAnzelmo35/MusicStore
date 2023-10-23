package com.example.musicstore.Model;

import java.util.GregorianCalendar;

public class OrdiniPassati {


    public OrdiniPassati(int strumento, float totaleOrdine, float sconto, int quantita,GregorianCalendar dataOrdine) {
        this.strumento = strumento;
        this.TotaleOrdine = totaleOrdine;
        this.sconto = sconto;
        this.quantita = quantita;
        this.dataOrdine = dataOrdine;
    }

    public OrdiniPassati() {
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

    public void setDataOrdine(GregorianCalendar dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    private int utenteCF;
    private int strumento;
    private float TotaleOrdine, sconto;
    private int quantita;

    private GregorianCalendar dataOrdine;
}