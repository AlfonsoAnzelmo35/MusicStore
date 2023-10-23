package com.example.musicstore.Controller;

import com.example.musicstore.Model.Carrello;
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

@WebServlet("/EffettuaOrdine")
public class EffettuaOrdine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("idStrumento")) ;
        Integer quantita = Integer.parseInt(req.getParameter("list_quantita")) ;

        HttpSession session ;
        List<Integer> strumentoList;
        Carrello carrello;
        try{
            session = req.getSession(false) ;
        }catch (Exception e){
            session = req.getSession(true) ;
        }

        strumentoList = (List<Integer>) session.getAttribute("listaStrumenti");
        carrello =  (Carrello) session.getAttribute("carrello");

        if(strumentoList == null) {
            session.setAttribute("listaStrumenti", new ArrayList<Integer>());
            strumentoList = (List<Integer>) session.getAttribute("listaStrumenti");
        }
        if(carrello == null) {
            session.setAttribute("carrello", new Carrello());
            carrello = (Carrello) session.getAttribute("carrello");
        }

        //per il momento tieni solo una lista di interi(gli id dei strumenti) poi solo quando l'utente
        //vuole effettivamente guaradare il carrello allora effettuiamo le query
        strumentoList.add(id);
        carrello.getQuantita().add(quantita) ;

        String addr= "" ;
        if(req.getParameter("nomePagina") != null)
            addr = "strumentoPerCategoria.jsp";
        else addr = "home.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(addr) ;
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
