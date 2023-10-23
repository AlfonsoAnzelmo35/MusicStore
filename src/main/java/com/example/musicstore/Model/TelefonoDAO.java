package com.example.musicstore.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
public class TelefonoDAO {
    public Telefono doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT t.UTENTE_FK, t.numero" +
                            "  FROM musicstoredb.telefono t " +
                            " WHERE t.UTENTE_FK=?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                rs.getInt(1);
                Telefono telefono = new Telefono();
                telefono.setNumero(rs.getString(2));
                telefono.setNomeUtente(rs.getInt(1));

                return telefono;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Telefono telefono) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO musicstoredb.telefono (UTENTE_FK, numero)" +
                            "  VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, telefono.getNomeUtente());
            ps.setString(2, telefono.getNumero());

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


