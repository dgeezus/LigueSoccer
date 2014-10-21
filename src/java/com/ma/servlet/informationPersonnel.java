/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.servlet;

import com.ma.DAO.implement.UtilisateurDAO;
import com.ma.modele.Utilisateur;
import com.ma.util.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author Casa Nova
 */
@WebServlet(name = "informationPersonnel", urlPatterns = {"/informationPersonnel"})
public class informationPersonnel extends HttpServlet {

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
            if (request.getParameter("modifierUser") != null) {
             UtilisateurDAO userDAO= new UtilisateurDAO(Connexion.getInstance());
             Utilisateur nouveauUser = ((Utilisateur)request.getSession().getAttribute("usagerCourant"));
             nouveauUser.setNtelephone1(((String)request.getParameter("Telephone1")));
             nouveauUser.setNtelephone2((String)request.getParameter("Telephone2"));
             nouveauUser.setNtelephone3((String)request.getParameter("Telephone3"));
             nouveauUser.setCourriel((String)request.getParameter("Courriel"));
             nouveauUser.setAdressPostale((String)request.getParameter("Adresse"));
             userDAO.update(nouveauUser);
             request.setAttribute("afficherPage", "infoPerso");
              RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?afficherPage=infoPerso");
                    r.forward(request, response);
            } else {
                if (null != request.getSession().getAttribute("username")) {
                    request.setAttribute("afficherPage", "infoPerso");
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp?afficherPage=infoPerso");
                    r.forward(request, response);

                } else {
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/null.jsp");
                    r.forward(request, response);
                }
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
