package com.example.musicstore.Model;

public class Telefono {

    public Telefono(){}

    public Telefono(int nomeUtente, String numero) {
        this.nomeUtente = nomeUtente;
        this.numero = numero;
    }

    public int getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(int nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    int nomeUtente;
    String numero;
}