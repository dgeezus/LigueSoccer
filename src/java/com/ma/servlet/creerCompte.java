package com.ma.servlet;

import com.ma.DAO.implement.UtilisateurDAO;
import com.ma.modele.Utilisateur;
import com.ma.util.Connexion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class creerCompte extends HttpServlet {

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
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String courriel = request.getParameter("courriel");
        String mdp1 = request.getParameter("mdp1");
        int annee = Integer.parseInt(request.getParameter("annee"));
    //    String annee = request.getParameter("annee");
        String message;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connexion.setUrl(this.getServletContext().getInitParameter("URLbaseDonnees"));
            UtilisateurDAO uDAO = new UtilisateurDAO(Connexion.getInstance());

            if (uDAO.isEmailUsed(courriel)) {
                message = "Ce courriel est déjà utilisé par un utilisateur. Veuillez en entrer un nouveau.";
                request.setAttribute("message", message);
                request.setAttribute("prenom", prenom);
                request.setAttribute("nom", nom);
                request.setAttribute("annee", annee);
                
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?afficherPage=creerCompte");
                r.forward(request, response);

            } else {

                Utilisateur user = new Utilisateur(nom, prenom, courriel, mdp1, annee);
                if (uDAO.create(user)) {
                    message = "Votre compte a été créé avec succès. Veuillez attendre qu'un administrateur vous attribue vos droits d'accès "
                            + "et vous recevrez par la suite votre numéro de passeport par courriel afin de vous connecter au site.";
                } else {

                    message = "Une erreur s'est produite et il a été impossible de créer le compte. Veuillez réessayer à nouveau.";
                }
                request.setAttribute("message", message);
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?afficherPage=main");
                r.forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
