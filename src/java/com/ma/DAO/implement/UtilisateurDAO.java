package com.ma.DAO.implement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.ma.DAO.DAO;
import com.ma.modele.Utilisateur;
import com.ma.servlet.Login;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilisateurDAO extends DAO<Utilisateur> {

    public UtilisateurDAO(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Utilisateur x) {
        String req = "INSERT INTO utilisateur (nom, prenom, anneeNaissance, courriel, mdp) "
                + "VALUES('" + x.getNom() + "','" + x.getPrenom() + "','" + x.getDdn() + "','" + x.getCourriel() + "','" + x.getMdp() + "')";
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }

        } catch (SQLException exp) {

        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public Utilisateur findID(int id) {

        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM utilisateur WHERE passeport = '" + id + "'");
            if (r.next()) {
                Utilisateur c = new Utilisateur(
                        //`idUtilisateur``nom``prenom``anneNaissance``passport``courriel``mdp``nTel1``nTel2``nTel3``AdressPostale``isAdmin``ParentAdmin`                                                   
                        r.getInt("idUtilisateur"),
                        r.getString("nom"),
                        r.getString("prenom"),
                        r.getString("courriel"),
                        r.getString("adressePostale"),
                        r.getString("mdp"),
                        r.getString("nTel1"),
                        r.getString("nTel2"),
                        r.getString("nTel3"),
                        r.getInt("anneeNaissance"),
                        r.getInt("passeport"),
                        r.getInt("isAdmin"),
                        r.getInt("ParentAdmin")
                );
                {
                    r.close();
                    stm.close();
                    return c;
                }
            }
        } catch (SQLException exp) {

        }
        return null;
    }

    @Override
    public boolean update(Utilisateur x) {
        Statement stm = null;
        try {
            String req = "UPDATE utilisateur SET nTel1 = '" + x.getNtelephone1() + "', nTel2 = '" + x.getNtelephone2() + "', nTel3 = '" + x.getNtelephone3() + "', courriel = '" + x.getCourriel() + "', adressPostale = '" + x.getAdressPostale() + "'"
                    + " WHERE idUtilisateur = '" + x.getIdUtilisateur() + "'";
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(Utilisateur x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isLogin(int un, String pass) throws SQLException {
        ResultSet resultats = null;
        Statement stm = cnx.createStatement();
        try {
            String req = "SELECT * FROM utilisateur WHERE passeport ='" + un + "' AND mdp='" + pass + "'";
            resultats = stm.executeQuery(req);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultats.next();
    }

    public boolean isEmailUsed(String email) {
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM utilisateur WHERE courriel = '" + email + "'");
            return r.next();

        } catch (SQLException exp) {

        }
        return true;
    }

}
