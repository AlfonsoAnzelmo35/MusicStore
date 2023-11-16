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

@WebServlet("/MostraCarrello")
public class MostraCarrello extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null)
            session = req.getSession(true);

        Carrello carrello = (Carrello) session.getAttribute("carrello");
        if (carrello == null) {
            session.setAttribute("carrello", new Carrello());
            carrello = (Carrello) session.getAttribute("carrello");
        }

        /*
        boolean b = false;
        for (int j = 0;j < strumentoList.size() ; j++) {
            System.out.println("ricerca per " + strumentoList.get(j));
            for(int i = 0 ; i <  carrello.getStrumenti().size() ;i++ ){
                if(carrello.getStrumenti().get(i).getIdStrumento() == strumentoList.get(j)) {
                    b = true;

                    System.out.println(carrello.getStrumenti().get(i).getIdStrumento() + " già presente");
                }
            }

            System.out.println(Arrays.toString(carrello.getStrumenti().toArray()));
            System.out.println(Arrays.toString(carrello.getQuantita().toArray()));
            if(!b) {
                System.out.println("query per :" + strumentoList.get(j));
                Strumento newstrumento = new StrumentoDAO().doRetrieveById(strumentoList.get(j));
                carrello.getStrumenti().add(newstrumento);
            }
            System.out.println("rimetto la b a false");
            b = false;
        }*/



        RequestDispatcher requestDispatcher = req.getRequestDispatcher("carrello.jsp");
        requestDispatcher.forward(req, resp);
    }

}
