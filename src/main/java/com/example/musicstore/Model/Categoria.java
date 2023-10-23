package com.example.musicstore.Model;

public class Categoria {
    public Categoria() {
    }

    public Categoria(String descrizione, String nomeCategoria) {
        this.descrizione = descrizione;
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria(int idCategoria, String descrizione, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.descrizione = descrizione;
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria(String percorso_immagine, boolean principale, String descrizione, String nomeCategoria) {
        this.percorso_immagine = percorso_immagine;
        this.principale = principale;
        this.descrizione = descrizione;
        this.nomeCategoria = nomeCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria(boolean principale, String descrizione, String nomeCategoria) {
        this.principale = principale;
        this.descrizione = descrizione;
        this.nomeCategoria = nomeCategoria;
    }

    public boolean isPrincipale() {
        return principale;
    }

    public void setPrincipale(boolean principale) {
        this.principale = principale;
    }

    public String getPercorso_immagine() {
        return percorso_immagine;
    }

    public void setPercorso_immagine(String percorso_immagine) {
        this.percorso_immagine = percorso_immagine;
    }

    private String percorso_immagine;
    private boolean principale ;
    private int idCategoria;
    private String descrizione, nomeCategoria;
}
