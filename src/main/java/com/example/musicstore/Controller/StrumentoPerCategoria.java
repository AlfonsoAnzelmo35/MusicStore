package com.example.musicstore.Controller;

import com.example.musicstore.Model.Strumento;
import com.example.musicstore.Model.StrumentoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/StrumentoPerCategoria")
public class StrumentoPerCategoria extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCategoria = Integer.parseInt(req.getParameter("idCategoria")) ;
        StrumentoDAO strumentoDAO = new StrumentoDAO();
        List<Strumento> strumentoList = strumentoDAO.doRetrieveAllPerCategoria(idCategoria) ;


        //perchè se lo mettessi nella richiesta, questa morirebbe con la risposta(vorrei ritornare a mostrare i prodotti
        //senza fare una nuova query quando l'utente clicca su aggiungi al carrello)
        getServletContext().setAttribute("strumentoListPerCategoria",strumentoList);

        req.getRequestDispatcher("strumentoPerCategoria.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
