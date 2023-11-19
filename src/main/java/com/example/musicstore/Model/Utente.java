package com.example.musicstore.Model;

import java.util.GregorianCalendar;

public class Utente {
    public Utente (){}

    public Utente(int CF, String nome, String cognome, String ruolo, GregorianCalendar dataNascita, String via, String citta, String nazione) {
        this.CF = CF;
        Nome = nome;
        Cognome = cognome;
        Ruolo = ruolo;
        DataNascita = dataNascita;
        this.via = via;
        this.citta = citta;
        this.nazione = nazione;
    }

    public Utente(String email, String password, String nome, String cognome, String ruolo, GregorianCalendar dataNascita, String via, String citta, String nazione) {
        this.email = email;
        this.password = password;
        Nome = nome;
        Cognome = cognome;
        Ruolo = ruolo;
        DataNascita = dataNascita;
        this.via = via;
        this.citta = citta;
        this.nazione = nazione;
    }

    public Utente(String email, String password, String nome, String cognome, String via) {
        this.email = email;
        this.password = password;
        this.Nome = nome ;
        this.Cognome = cognome ;
        this.via = via ;
    }

    public int getCF() {
        return CF;
    }

    public void setCF(int CF) {
        this.CF = CF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getRuolo() {
        return Ruolo;
    }

    public void setRuolo(String ruolo) {
        Ruolo = ruolo;
    }

    public GregorianCalendar getDataNascita() {
        return DataNascita;
    }

    public void setDataNascita(GregorianCalendar dataNascita) {
        DataNascita = dataNascita;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "CF=" + CF +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", Ruolo='" + Ruolo + '\'' +
                ", DataNascita=" + DataNascita +
                ", via='" + via + '\'' +
                ", citta='" + citta + '\'' +
                ", nazione='" + nazione + '\'' +
                '}';
    }

    private int CF;
    private String email, password;
    private String Nome, Cognome, Ruolo;
    private GregorianCalendar DataNascita;
    private String via, citta, nazione;
}
