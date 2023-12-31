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
import java.util.Arrays;
import java.util.List;

@WebServlet("/AggiungiStrumentoCarrello")
public class AggiungiStrumentoCarrello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id ;
        Integer quantita ;
        try{
            id = Integer.parseInt(req.getParameter("idStrumento")) ;
            quantita = Integer.parseInt(req.getParameter("list_quantita")) ;
            if(quantita <= 0) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/errore.jsp");
                req.setAttribute("errore","quantita negativa");
                requestDispatcher.forward(req, resp);
                return ;
            }
        }catch (NumberFormatException e){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/errore.jsp");
            req.setAttribute("errore","inserisci un numero");
            requestDispatcher.forward(req, resp);
            return ;
        }

        HttpSession session = req.getSession(false) ;
        if(session == null)
            session = req.getSession(true) ;

        Carrello carrello;
        carrello =  (Carrello) session.getAttribute("carrello");
        if(carrello == null) {
            session.setAttribute("carrello", new Carrello());
            carrello = (Carrello) session.getAttribute("carrello");
        }

        StrumentoDAO strumentoDAO = new StrumentoDAO() ;
        Strumento strumento = strumentoDAO.doRetrieveById(id);

        if(!strumentoPresente(carrello, strumento)){
            carrello.aggiungiStrumento(strumento, quantita) ;
        }else{
            System.out.println("era gia presente");
            carrello.aggiornaQuantitaStrumento(strumento.getIdStrumento(), quantita) ;
        }

        System.out.println(carrello);

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

    public boolean strumentoPresente(Carrello carrello, Strumento strumento){
        for (Strumento str :carrello.getStrumenti()){
            if(str.getIdStrumento() == strumento.getIdStrumento())
                return true;
        }
        return false ;
    }
}
