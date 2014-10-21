package com.ma.DAO.implement;
import com.ma.DAO.DAO;
import com.ma.modele.Categorie;
import com.ma.modele.Equipe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alain
 */
public class CategorieDAO extends DAO<Categorie>{

    public CategorieDAO(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(Categorie x) {
        String req = "INSERT INTO categorie (age, niveau, genre, adulte) "
                + "VALUES('" + x.getAge()+ "','" + x.getNiveau()+ "','" + x.getGenre() + "','" + x.getAdulte()+ "')";
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
                }
            }
        }
        return false;
        
    }

    @Override
    public Categorie findID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Categorie x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Categorie x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categorie> findAll() {
        List<Categorie> liste = new LinkedList<Categorie>();
                try {
            Statement stm = cnx.createStatement();
            String query = "SELECT * FROM categorie";

            ResultSet r = stm.executeQuery(query);
            while (r.next()) {
                Categorie c = new Categorie(
                        r.getInt("idCategorie"),
                        r.getInt("age"),
                        r.getString("niveau"),
                        r.getInt("genre"),
                        r.getInt("adulte")
                );
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
    
}
