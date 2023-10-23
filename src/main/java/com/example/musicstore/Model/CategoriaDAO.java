package com.example.musicstore.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public Categoria doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT c.IDCategoria, c.NomeCateogoria,c.NomeCateogoria" +
                            "  FROM musicstoredb.categoria c  " +
                            " WHERE c.IDCategoria=?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                rs.getInt(1);
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(1));
                categoria.setNomeCategoria(rs.getString(2));
                categoria.setDescrizione(rs.getString(3));

                return categoria;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Categoria> doRetrieveAll() {
        List<Categoria> categoriaList = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT c.IDCategoria, c.NomeCateogoria,c.NomeCateogoria, c.principale , c.immagine_categoria" +
                            "  FROM musicstoredb.categoria c ");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(1));
                categoria.setNomeCategoria(rs.getString(2));
                categoria.setDescrizione(rs.getString(3));
                categoria.setPrincipale(rs.getBoolean(4));
                categoria.setPercorso_immagine(rs.getString(5));
                categoriaList.add(categoria);
            }
            return categoriaList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void doSave(Categoria categoria) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO musicstoredb.categoria (NomeCateogoria,descrizione,principale)" +
                            "  VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, categoria.getNomeCategoria());
            ps.setString(2, categoria.getDescrizione());
            ps.setBoolean(3, categoria.isPrincipale());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            /*ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            customer.setId(id);/
             */

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> doRetriveByName(String cercato) {

        String sqlQuery = "SELECT c.IDCategoria, c.NomeCateogoria,c.NomeCateogoria, c.principale , c.immagine_categoria" +
                "  FROM musicstoredb.categoria c " +
                "  WHERE c.NomeCateogoria LIKE ?" ;

        List<Categoria> categoriaList = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            ps.setString(1,cercato+"%");
            ResultSet rs = ps.executeQuery();


            while(rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(1));
                categoria.setNomeCategoria(rs.getString(2));
                categoria.setDescrizione(rs.getString(3));
                categoria.setPrincipale(rs.getBoolean(4));
                categoria.setPercorso_immagine(rs.getString(5));
                categoriaList.add(categoria);
            }
            return categoriaList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
