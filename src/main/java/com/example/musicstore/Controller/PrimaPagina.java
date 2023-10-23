package com.example.musicstore.Controller;

import com.example.musicstore.Model.Categoria;
import com.example.musicstore.Model.CategoriaDAO;
import com.example.musicstore.Model.Strumento;
import com.example.musicstore.Model.StrumentoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
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

@WebServlet("/index.jsp")
public class PrimaPagina extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categoriaList = categoriaDAO.doRetrieveAll();
        StrumentoDAO strumentoDAO = new StrumentoDAO();
        List<Strumento> strumentoList = strumentoDAO.doGetMaggiorQuantitaAcquistate();


        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("listaCategorie",categoriaList);
        servletContext.setAttribute("strumentoList",strumentoList);


        getServletContext().setAttribute("listaCategorie",categoriaList);
        //mette nella request la lista categoriaPrincipali e sottoCategorie
        creaListe(req,categoriaList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void creaListe(HttpServletRequest request, List<Categoria> categoriaLista){

        List<List<Categoria>> sottoCategorie = new ArrayList<>();
        List<Categoria> categoriePrincipali = new ArrayList<>();
        List<Categoria> sottoCategoriaIesima = null;
        int x = 0, y = 0;
        for (x = 0; x < categoriaLista.size(); x++) {
            if (!categoriaLista.get(x).isPrincipale()) {
                sottoCategoriaIesima = new ArrayList<>();
                for (y = x; y < categoriaLista.size(); y++) {
                    if (categoriaLista.get(y).isPrincipale()) {
                        categoriePrincipali.add(categoriaLista.get(y));
                        break;
                    }
                    sottoCategoriaIesima.add(categoriaLista.get(y));
                }
                x = y;
                sottoCategorie.add(sottoCategoriaIesima);

            } else {
                categoriePrincipali.add(categoriaLista.get(x));
            }
        }

       getServletContext().setAttribute("categoriePrincipali", categoriePrincipali);
        getServletContext().setAttribute("sottoCategorie", sottoCategorie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
