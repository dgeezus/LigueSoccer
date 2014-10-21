/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.DAO.implement;

import com.ma.DAO.DAO;
import com.ma.modele.Equipe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author CasaNova
 */
public class EquipeDAO extends DAO<Equipe> {

    public EquipeDAO(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(Equipe x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Equipe findID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Equipe x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Equipe x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Equipe> findAll() {
        List<Equipe> liste = new LinkedList<Equipe>();
        try {
            Statement stm = cnx.createStatement();
            String query = "SELECT * FROM equipe";

            ResultSet r = stm.executeQuery(query);
            while (r.next()) {
                Equipe d = new Equipe(
                        r.getInt("idEquipe"),
                        r.getString("nomEquipe"),
                        r.getInt("idCategorie"),
                        r.getInt("idCoach"),
                        r.getInt("assistant1"),
                        r.getInt("assistant2"),
                        r.getInt("assistant3"),
                        r.getInt("assistant4")
                );
                liste.add(d);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }

}
