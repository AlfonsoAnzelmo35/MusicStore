package com.example.musicstore.Controller;

import com.example.musicstore.Model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@WebServlet("/EffettuaOrdine")
public class EffettuaOrdine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false) ;
        if(session == null || session.getAttribute("logged") == null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/erroreNonAccesso.jsp") ;
            requestDispatcher.forward(req, resp);
        }

        Carrello carrello;
        carrello =  (Carrello) session.getAttribute("carrello") ;
        if(carrello == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/errore.jsp") ;
            requestDispatcher.forward(req, resp);
        }

        OrdiniDAO ordiniDAO = new OrdiniDAO() ;
        int utenteCF = (int)session.getAttribute("utenteCF") ;


        for(Strumento strumento: carrello.getStrumenti()) {
            Ordini ordine = new Ordini(utenteCF, strumento.getIdStrumento(), carrello.getPrezzoPerQuantitaStrumento(strumento.getIdStrumento()),
                    strumento.getOfferta(), carrello.getQuantitaStrumento(strumento.getIdStrumento()), new GregorianCalendar());

            ordiniDAO.doSave(ordine);
        }

        req.setAttribute("ordineEffetuato",true); //solo per la notifica
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp") ;
        requestDispatcher.forward(req, resp);
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
