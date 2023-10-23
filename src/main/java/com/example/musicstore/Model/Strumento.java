package com.example.musicstore.Model;

public class Strumento {

    public Strumento() {
    }

    public Strumento(String nomeStrumento, String percorsoImmagini, float prezzo, float offerta, int idCategoria) {
        this.nomeStrumento = nomeStrumento;
        this.percorsoImmagini = percorsoImmagini;
        this.prezzo = prezzo;
        this.offerta = offerta;
        this.idCategoria = idCategoria;
    }

    public Strumento(int idStrumento, String nomeStrumento, String percorsoImmagini, float prezzo, float offerta, int idCategoria) {
        this.idStrumento = idStrumento;
        this.nomeStrumento = nomeStrumento;
        this.percorsoImmagini = percorsoImmagini;
        this.prezzo = prezzo;
        this.offerta = offerta;
        this.idCategoria = idCategoria;
    }

    public int getIdStrumento() {
        return idStrumento;
    }

    public void setIdStrumento(int idStrumento) {
        this.idStrumento = idStrumento;
    }

    public String getNomeStrumento() {
        return nomeStrumento;
    }

    public void setNomeStrumento(String nomeStrumento) {
        this.nomeStrumento = nomeStrumento;
    }

    public String getPercorsoImmagini() {
        return percorsoImmagini;
    }

    public void setPercorsoImmagini(String percorsoImmagini) {
        this.percorsoImmagini = percorsoImmagini;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public float getOfferta() {
        return offerta;
    }

    public void setOfferta(float offerta) {
        this.offerta = offerta;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    int idStrumento;
    String nomeStrumento, percorsoImmagini;
    float prezzo, offerta;
    int idCategoria;
}
