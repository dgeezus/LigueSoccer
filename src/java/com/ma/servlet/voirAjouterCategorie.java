package com.ma.servlet;

import com.ma.DAO.implement.CategorieDAO;
import com.ma.modele.Categorie;
import com.ma.util.Connexion;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alain
 */
public class voirAjouterCategorie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connexion.setUrl(this.getServletContext().getInitParameter("URLbaseDonnees"));
            if (request.getParameter("ajoute") != null) {
                int adulte = Integer.parseInt(request.getParameter("adulte"));
                int age;
                int genre = Integer.parseInt(request.getParameter("sexe"));
                String niveau = request.getParameter("niveau");

                if (adulte == 0) {
                    age = Integer.parseInt(request.getParameter("ageEnfant"));
                } else {
                    age = Integer.parseInt(request.getParameter("ageAdulte"));
                }

                Categorie c = new Categorie(age, niveau, genre, adulte);
                CategorieDAO cDAO = new CategorieDAO(Connexion.getInstance());

                String message;
                if (cDAO.create(c)) {
                    message = "Catégorie ajoutée avec succès!";
                } else {
                    message = "Impossible de créer la catégorie.";
                }
                request.setAttribute("message", message);

            }
            CategorieDAO cDAO = new CategorieDAO(Connexion.getInstance());
            List<Categorie> categories = cDAO.findAll();
            request.setAttribute("categories", categories);
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?afficherPage=voirAjouterCategorie");
            r.forward(request, response);
        } catch (Exception e) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
