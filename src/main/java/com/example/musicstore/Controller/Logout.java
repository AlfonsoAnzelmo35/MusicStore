package com.example.musicstore.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false) ;

        //se questa servlet è invocata allora sicuramente l'utente ha la sessione, se non la possiede
        //vuol dire che l'ha invocata tramite URL
        if(session == null || session.getAttribute("utenteCF") == null)
            req.getRequestDispatcher("WEB-INF/errore.jsp").forward(req,resp) ;

        session.invalidate();
        req.getRequestDispatcher("home.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
