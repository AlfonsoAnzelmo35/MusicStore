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
        if(utenteDAO.doRetrieveByLogin(email, password) == null)
            req.getRequestDispatcher("WEB-INF/errore.jsp").forward(req,resp);

        req.getSession(true) ;
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
