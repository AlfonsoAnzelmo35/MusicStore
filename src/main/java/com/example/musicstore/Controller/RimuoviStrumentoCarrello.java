package com.example.musicstore.Controller;

import com.example.musicstore.Model.Carrello;
import com.example.musicstore.Model.Strumento;
import com.example.musicstore.Model.StrumentoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RimuoviStrumentoCarrello")
public class RimuoviStrumentoCarrello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idStrumento = null ;
        try{
            idStrumento = Integer.parseInt(req.getParameter("idStrumento")) ;
        }catch (NumberFormatException e){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/errore.jsp") ;
            requestDispatcher.forward(req, resp);
        }

        HttpSession session = req.getSession(false) ;
        Carrello carrello =  (Carrello) session.getAttribute("carrello") ;

        if(session == null || carrello == null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/errore.jsp") ;
            requestDispatcher.forward(req, resp);
        }

        carrello.rimuoviStrumento(idStrumento);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("carrello.jsp") ;
        requestDispatcher.forward(req, resp);
     }
}
