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

@WebServlet("/Login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!validazione(req))
            req.getRequestDispatcher("WEB-INF/errore.jsp").forward(req,resp);

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UtenteDAO utenteDAO = new UtenteDAO();
        Utente utente = utenteDAO.doRetrieveByLogin(email, password);
        if(utente == null)
            req.getRequestDispatcher("WEB-INF/errore.jsp").forward(req,resp);

        HttpSession session = req.getSession(false) ;
        if(session == null){
            session = req.getSession(true) ;
        }
        //salva nella sessione se l'utente e' loggato oppure no, e la sua e-mail
        session.setAttribute("logged", true);
        session.setAttribute("utenteCF", utente.getCF()) ;
        req.setAttribute("appenaLoggato", true); //solo per il messaggio di notifica
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    public boolean validazione(HttpServletRequest req) {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if(email.length() <= 0) return false;
        if(password.length() <= 0) return false;

        return true;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/errore.jsp").forward(req,resp);
    }
}
