package com.example.musicstore.Controller;

import com.example.musicstore.Model.Ordini;
import com.example.musicstore.Model.OrdiniDAO;
import com.example.musicstore.Model.Strumento;
import com.example.musicstore.Model.StrumentoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/MostraOrdini")
public class MostraOrdini extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false) ;
        if(session == null)
            session = req.getSession(true) ;

        if(!(boolean) session.getAttribute("logged")) {
            req.getRequestDispatcher("WEB-INF/errore.jsp").forward(req, resp);
        }

        int idUtente = (int)session.getAttribute("utenteCF") ;
        OrdiniDAO ordiniDAO = new OrdiniDAO() ;
        StrumentoDAO strumentoDAO = new StrumentoDAO() ;

        List<Ordini> ordiniList = ordiniDAO.doGetOrdiniPerIdUtente(idUtente) ;
        List<Strumento> strumentoList = new ArrayList<>() ;
        for(Ordini o : ordiniList){
            Strumento s = strumentoDAO.doRetrieveById(o.getStrumento()) ;
            strumentoList.add(s) ;
        }

        req.setAttribute("ordiniList",ordiniList);
        req.setAttribute("strumentoList",strumentoList);

        req.getRequestDispatcher("mostraOrdini.jsp").forward(req,resp);
    }
}
