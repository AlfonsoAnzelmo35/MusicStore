package com.example.musicstore.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StrumentoDAO {

    public Strumento doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT s.IDSTRUMENTO, s.Categoria, s.NomeStrumento, s.Offerta, s.Prezzo, s.PercorsoImmagine" +
                            "  FROM musicstoredb.strumento s  " +
                            " WHERE s.IDSTRUMENTO=?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                rs.getInt(1);
                Strumento strumento = new Strumento();
                strumento.setIdStrumento(rs.getInt(1));
                strumento.setIdCategoria(rs.getInt(2));
                strumento.setNomeStrumento(rs.getString(3));
                strumento.setOfferta(rs.getFloat(4));

                strumento.setPrezzo(rs.getFloat(5));
                strumento.setPercorsoImmagini(rs.getString(6));


                return strumento;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Strumento strumento) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO musicstoredb.strumento (Categoria, NomeStrumento, Offerta, Prezzo, PercorsoImmagine)" +
                            "  VALUES(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, strumento.getIdCategoria());
            ps.setString(2, strumento.getNomeStrumento());
            ps.setFloat(3, strumento.getOfferta());
            ps.setFloat(4, strumento.getPrezzo());
            ps.setString(5, strumento.getPercorsoImmagini());

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

    public List<Strumento> doRetrieveAllPerCategoria(int idCategoria) {
        List<Strumento> strumentoList = new ArrayList<Strumento>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT s.IDSTRUMENTO, s.Categoria, s.NomeStrumento, s.Offerta, s.Prezzo, s.PercorsoImmagine " +
                            "FROM musicstoredb.strumento s " +
                            "WHERE s.Categoria = ? " +
                            "LIMIT 10;");

            ps.setInt(1,idCategoria);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Strumento strumento = new Strumento();
                strumento.setIdStrumento(rs.getInt(1));
                strumento.setIdCategoria(rs.getInt(2));
                strumento.setNomeStrumento(rs.getString(3));
                strumento.setOfferta(rs.getFloat(4));
                strumento.setPrezzo(rs.getFloat(5));
                strumento.setPercorsoImmagini(rs.getString(6));
                strumentoList.add(strumento);
            }
            return strumentoList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Strumento> doGetMaggiorQuantitaAcquistate() {
        List<Strumento> strumentoList = new ArrayList<Strumento>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT idstrumento, nomestrumento, prezzo, offerta, categoria, percorsoimmagine " +
                            "FROM musicstoredb.strumento, musicstoredb.ordine, musicstoredb.utente " +
                            "WHERE strumento.IDSTRUMENTO = musicstoredb.ordine.STRUMENTO AND " +
                            "        UTENTE.CF = musicstoredb.ordine.UTENTE " +
                            "ORDER BY musicstoredb.ordine.quantita DESC " +
                            "LIMIT 9 ");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Strumento strumento = new Strumento();
                strumento.setIdStrumento(rs.getInt(1));
                strumento.setNomeStrumento(rs.getString(2));
                strumento.setPrezzo(rs.getFloat(3));
                strumento.setOfferta(rs.getFloat(4));
                strumento.setIdCategoria(rs.getInt(5));
                strumento.setPercorsoImmagini(rs.getString(6));
                strumentoList.add(strumento);
            }
            return strumentoList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
