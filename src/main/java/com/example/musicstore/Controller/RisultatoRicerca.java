package com.example.musicstore.Controller;

import com.example.musicstore.Model.Categoria;
import com.example.musicstore.Model.CategoriaDAO;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.List;

@WebServlet("/RisultatoRicerca")
public class RisultatoRicerca extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cercato = req.getParameter("cercato") ;

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categoriaList = categoriaDAO.doRetriveByName(cercato);

        for(Categoria categoria:categoriaList){
            System.out.println(categoria.getNomeCategoria());

        }

        Gson gson = new Gson();
        String categorialistJSON = gson.toJson(categoriaList) ;

        resp.getWriter().write(categorialistJSON) ;

    }


}
