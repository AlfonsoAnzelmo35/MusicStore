package com.example.musicstore.Controller;

import com.example.musicstore.Model.Utente;
import com.example.musicstore.Model.UtenteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.GregorianCalendar;

@WebServlet("/Register")
public class Register extends HttpServlet {
    UtenteDAO utenteDAO = new UtenteDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Utente utente ;
        if((utente = validazione(req)) != null)
            utenteDAO.doSave(utente);
        else
            req.getRequestDispatcher("WEB-INF/errore.jsp").forward(req,resp);

        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    public Utente validazione(HttpServletRequest req) {
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");

        String dataNascita = req.getParameter("dataNascita");
        String[] nascita = dataNascita.split("-");
        int anno = Integer.parseInt(nascita[2]);
        int mese = Integer.parseInt(nascita[1]);
        int giorno = Integer.parseInt(nascita[0]);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(anno, mese, giorno);

        String via = req.getParameter("via");
        String citta = req.getParameter("citta");
        String nazione = req.getParameter("nazione");

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (nome.length() <= 0) return null;
        if (cognome.length() <= 0) return null;
        if (dataNascita.length() <= 0) return null;
        if(via.length() <= 0) return null;
        if(citta.length() <= 0) return null;
        if(nazione.length() <= 0) return null;
        if(email.length() <= 0) return null;
        if(password.length() <= 0) return null;

        if(utenteDAO.doRetrieveByEmail(email) != null)return null;
        Utente u = new Utente(email, password, nome, cognome, "Utente", gregorianCalendar, via, citta, nazione) ;

        return u ;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/errore.jsp").forward(req,resp);
    }
}
