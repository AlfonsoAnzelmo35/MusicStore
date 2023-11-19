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

@WebServlet("/ModificaInformazioniPersonali")
public class ModificaInformazioniPersonali extends HttpServlet {
    UtenteDAO utenteDAO = new UtenteDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int idUtente = Integer.parseInt(String.valueOf(session.getAttribute("utenteCF"))) ;

        if(!aggiornaUtente(req, idUtente)) {
            req.setAttribute("errore", " aggiornamento fallito");
            req.getRequestDispatcher("WEB-INF/errore.jsp").forward(req, resp);
        }else {
            req.setAttribute("aggiornamentoDati", true);
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }

    public boolean aggiornaUtente(HttpServletRequest req, int idUtente) {
        String nome = req.getParameter("nuovoNome");
        String cognome = req.getParameter("nuovoCognome");

        String via = req.getParameter("nuovoIndirizzo");
        String email = req.getParameter("nuovaEmail");
        String password = req.getParameter("nuovaPassword");

        if (nome.length() <= 0) return false;
        if (cognome.length() <= 0) return false;
        if(via.length() <= 0) return false;
        if(email.length() <= 0) return false;
        if(password.length() <= 0) return false;


        Utente u = new Utente(email, password, nome, cognome,via) ;
        utenteDAO.doUpdate(u, idUtente);

        return true ;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/errore.jsp").forward(req,resp);
    }
}
