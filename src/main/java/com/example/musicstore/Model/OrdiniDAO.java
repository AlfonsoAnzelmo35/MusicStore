package com.example.musicstore.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;


public class OrdiniDAO {



    public List<Ordini> doGetOrdiniPerIdUtente(int idUtente) {
        List<Ordini> ordiniList = new ArrayList<>() ;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT UTENTE, STRUMENTO, TotaleOrdine, sconto, quantita, dataOrdine" +
                    " FROM musicstoredb.ordine o " +
                    " WHERE o.UTENTE = ? ");

            ps.setInt(1, idUtente);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                rs.getInt(1);
                Ordini ordini = new Ordini();
                ordini.setUtenteCF(rs.getInt(1));
                ordini.setStrumento(rs.getInt(2));
                ordini.setTotaleOrdine(rs.getFloat(3));
                ordini.setSconto(rs.getFloat(4));
                ordini.setQuantita(rs.getInt(5));


                GregorianCalendar gregorianCalendar = new GregorianCalendar() ;
                gregorianCalendar.setTime(rs.getDate(6));
                ordini.setDataOrdine(gregorianCalendar);

                ordiniList.add(ordini) ;
            }

            return ordiniList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public void doSave(Ordini ordini) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO musicstoredb.ordine (UTENTE, STRUMENTO, dataOrdine, quantita, sconto, TotaleOrdine)" +
                            "  VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, ordini.getUtenteCF());
            ps.setInt(2, ordini.getStrumento());
            ps.setDate(3, new Date(ordini.getDataOrdine().getTimeInMillis()));
            ps.setInt(4, ordini.getQuantita());
            ps.setFloat(5, ordini.getSconto());
            ps.setFloat(6, ordini.getTotaleOrdine());

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
