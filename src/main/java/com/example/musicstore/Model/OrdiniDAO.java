package com.example.musicstore.Model;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class OrdiniDAO {

    public Ordini doRetrieveById(int idUtente, int idStrumento, GregorianCalendar dataOrdine) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ord_pass.UTENTE, ord_pass.STRUMENTO, ord_pass.dataOrdine, ord_pass.quantita, ord_pass.sconto, ord_pass.TotaleOrdine" +
                            "  FROM musicstoredb.ordine_passato ord_pass  " +
                            " WHERE ord_pass.UTENTE=? AND ord_pass.STRUMENTO =? AND ord_pass.dataOrdine = ?");

            ps.setInt(1, idUtente);
            ps.setInt(2, idStrumento);
            ps.setDate(3, new Date(dataOrdine.getTimeInMillis()));

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                rs.getInt(1);
                Ordini ordini = new Ordini();
                ordini.setUtenteCF(rs.getInt(1));
                ordini.setStrumento(rs.getInt(2));

                GregorianCalendar gregorianCalendar = new GregorianCalendar() ;
                gregorianCalendar.setTime(rs.getDate(3));
                ordini.setDataOrdine(gregorianCalendar);

                ordini.setQuantita(rs.getInt(4));

                ordini.setSconto(rs.getFloat(5));
                ordini.setTotaleOrdine(rs.getFloat(6));

                return ordini;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doGetOrdiniPerUtente() {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*)" +
                    " FROM musicstoredb.strumento, musicstoredb.ordine, musicstoredb.utente " +
                    " WHERE strumento.IDSTRUMENTO = musicstoredb.ordine.STRUMENTO AND" +
                    " UTENTE.CF = musicstoredb.ordine.UTENTE");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void doSave(OrdiniPassati ordiniPassati) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO musicstoredb.ordine (UTENTE, STRUMENTO, dataOrdine, quantita, sconto, TotaleOrdine)" +
                            "  VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ordiniPassati.getUtenteCF());
            ps.setInt(2, ordiniPassati.getStrumento());
            ps.setDate(3, new Date(ordiniPassati.getDataOrdine().getTimeInMillis()));
            ps.setInt(4, ordiniPassati.getQuantita());
            ps.setFloat(5, ordiniPassati.getSconto());
            ps.setFloat(6, ordiniPassati.getTotaleOrdine());

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
}
