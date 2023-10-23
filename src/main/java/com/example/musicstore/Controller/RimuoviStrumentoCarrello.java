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
        Integer id = Integer.parseInt(req.getParameter("idStrumento")) ;
        int indiceQuantita = Integer.parseInt(req.getParameter("indiceQuantita")) ;
        HttpSession session ;
        List<Integer> strumentoList ;
        Carrello carrello ;

        try{
            session = req.getSession(false) ;
        }catch (Exception e){
            session = req.getSession(true) ;
        }

        strumentoList = (List<Integer>) session.getAttribute("listaStrumenti");
        //se ha cliccato sul cestino il carrello è nella sessione!
        carrello = (Carrello) session.getAttribute("carrello");


        Strumento strumento = new StrumentoDAO().doRetrieveById(id);
        System.out.println(id);

        for(int i = 0 ; i < carrello.getStrumenti().size() ; i++)
            if(carrello.getStrumenti().get(i).getIdStrumento() == strumento.getIdStrumento())
                carrello.getStrumenti().remove(i);

        carrello.getQuantita().remove(indiceQuantita) ;
        strumentoList.remove(id);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("carrello.jsp") ;
        requestDispatcher.forward(req, resp);
    }
}
