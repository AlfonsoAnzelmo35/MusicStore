package com.example.musicstore.Controller;

import com.example.musicstore.Model.Strumento;
import com.example.musicstore.Model.StrumentoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RimuoviArticolo")
public class RimuoviArticolo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer idStrumento = Integer.parseInt(req.getParameter("idStrumento")) ;
            StrumentoDAO strumentoDAO = new StrumentoDAO() ;
            if(strumentoDAO.deleteById(idStrumento) <= 0)
                throw new Exception("idStrumento non trovato") ;

            req.getRequestDispatcher("home.jsp").forward(req,resp) ;

        }catch (Exception e){
            req.getRequestDispatcher("WEB-INF/errore.jsp").forward(req,resp) ;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }


}
