package com.example.musicstore.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class UtenteDAO {
    public Utente doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT CF, Nome, Cognome, Ruolo, DataNascita, via, citta, nazione" +
                            "  FROM musicstoredb.UTENTE u  " +
                            " WHERE u.CF=?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                rs.getInt(1);
                Utente utente = new Utente();
                utente.setCF(rs.getInt(1));
                utente.setNome(rs.getString(2));
                utente.setCognome(rs.getString(3));
                utente.setRuolo(rs.getString(4));

                Date data_Nascita = rs.getDate(5);
                GregorianCalendar dataNascita = new GregorianCalendar();
                dataNascita.setTime(data_Nascita);
                utente.setDataNascita(dataNascita);

                utente.setVia(rs.getString(6));
                utente.setCitta(rs.getString(7));
                utente.setNazione(rs.getString(8));

                return utente;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utente doRetrieveByLogin(String email, String password) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT CF, Nome, Cognome, Ruolo, DataNascita, via, citta, nazione,email" +
                            "  FROM musicstoredb.UTENTE u  " +
                            " WHERE u.email=? AND u.password=?");

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                rs.getInt(1);
                Utente utente = new Utente();
                utente.setCF(rs.getInt(1));
                utente.setNome(rs.getString(2));
                utente.setCognome(rs.getString(3));
                utente.setRuolo(rs.getString(4));

                Date data_Nascita = rs.getDate(5);
                GregorianCalendar dataNascita = new GregorianCalendar();
                dataNascita.setTime(data_Nascita);
                utente.setDataNascita(dataNascita);

                utente.setVia(rs.getString(6));
                utente.setCitta(rs.getString(7));
                utente.setNazione(rs.getString(8));
                utente.setEmail(rs.getString(9));
                return utente;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Utente doRetrieveByEmail(String email) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT CF, Nome, Cognome, Ruolo, DataNascita, via, citta, nazione" +
                            "  FROM musicstoredb.UTENTE u  " +
                            " WHERE u.email=? ");

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                rs.getInt(1);
                Utente utente = new Utente();
                utente.setCF(rs.getInt(1));
                utente.setNome(rs.getString(2));
                utente.setCognome(rs.getString(3));
                utente.setRuolo(rs.getString(4));

                Date data_Nascita = rs.getDate(5);
                GregorianCalendar dataNascita = new GregorianCalendar();
                dataNascita.setTime(data_Nascita);
                utente.setDataNascita(dataNascita);

                utente.setVia(rs.getString(6));
                utente.setCitta(rs.getString(7));
                utente.setNazione(rs.getString(8));
                return utente ;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doUpdate(Utente utente, int idUtente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    " UPDATE musicstoredb.UTENTE "+
                            " SET Nome = ?, Cognome = ? , via = ? ,email = ?, password = ? " +
                            "  WHERE CF=? ");

            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getCognome());
            ps.setString(3, utente.getVia());
            ps.setString(4, utente.getEmail());
            ps.setString(5, utente.getPassword());
            ps.setInt(6, idUtente);

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doSave(Utente utente) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
           "INSERT INTO musicstoredb.UTENTE (Nome, Cognome, Ruolo, DataNascita, via, citta, nazione,email,password)" +
             "  VALUES(?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getCognome());
            ps.setString(3, utente.getRuolo());
            ps.setDate(4, new Date(utente.getDataNascita().getTimeInMillis()));
            ps.setString(5, utente.getVia());
            ps.setString(6, utente.getCitta());
            ps.setString(7, utente.getNazione());
            ps.setString(8, utente.getEmail());
            ps.setString(9, utente.getPassword());

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
/*

    // la funzione seguente � inutile perch� il DB � riempito tramite tool esterno
    // sarebbe utile se l'applicazione fornisse un form per riempirlo. IDEA! aggiungi questa feature all'applicazione
    // � un buon modo per verificare la sua correttezza


    public ElencoCustomers doRetrieveALL()
    {
        ElencoCustomers elencoCustomers = new ElencoCustomers() ;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM customer");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer p = new Customer();
                p.setId(rs.getInt(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                p.setBalance(rs.getDouble(4));
                elencoCustomers.add(p);
            }
            return elencoCustomers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doEdit(Customer customer) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE customer  " +
                            "SET firstName = ? , lastName = ? , balance = ? " +
                            "WHERE id = ?;") ;
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setDouble(3, customer.getBalance());
            ps.setInt(4, customer.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


*/
}


