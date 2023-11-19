package com.example.musicstore.Controller;

import com.example.musicstore.Model.Categoria;
import com.example.musicstore.Model.CategoriaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet("/MostraCategoria")
public class MostraCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeCategoria = req.getParameter("nomeCategoria") ;//da CategorieMenu.jsp
        Integer idCategoria = Integer.parseInt(req.getParameter("idCategoria")) ;//da CategorieMenu.jsp

        List<Categoria> listaCategoria = (List<Categoria>) getServletContext().getAttribute("listaCategorie");
        List<Categoria> categoriaList = (List<Categoria>) getServletContext().getAttribute("categoriePrincipali");
        List<Categoria> sottoCategorie = new ArrayList<>();


        for(int i = 0 ; i < listaCategoria.size() ; i++){
            if(listaCategoria.get(i).getIdCategoria() == idCategoria){
                //trovata la categoria cliccata, aggiungo le sottocategorie che vengono subito dopo quella principale
                while(!listaCategoria.get(i+1).isPrincipale()) {//+1 perchè sto passando una categoria principale, quindi comincia dalla prossima che è non principale
                    if(i >= listaCategoria.size() - 2)
                        break;
                    sottoCategorie.add(listaCategoria.get(i + 1)) ;
                    i++;
                }
                break;
            }
        }



        req.setAttribute("listaCategorieMostra",listaCategoria);
        req.setAttribute("sottoCategorieMostra",sottoCategorie) ;
        req.setAttribute("nomeCategoriaMostra", nomeCategoria) ;
        req.setAttribute("idCategoriaMostra",idCategoria);
        req.getRequestDispatcher("MostraCategorie.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

/*List<Categoria>sottoCategoria= new ArrayList<>();
        CategoriaDAO categoriaDao = new CategoriaDAO() ;
        List<Categoria> categoriaList = categoriaDao.doRetrieveAll();
        Iterator<Categoria> categoriaIterator = categoriaList.iterator();*/


//muovo l'iteratore alla cateogoria cliccata
        /*while(categoriaIterator.hasNext()){
            Categoria categoria = categoriaIterator.next();
            if(categoria.getNomeCategoria().equalsIgnoreCase(nomeCategoria)){
                break;
            }
        }

        //muovo l'iteratore prendendo tutte le sottoCategorie, fino
        //a che non incontro una nuova Categoria
        while (categoriaIterator.hasNext()){
            Categoria categoria = categoriaIterator.next();
            if(categoria.isPrincipale()){
                break;
            }
            sottoCategoria.add(categoria);
        }*/

