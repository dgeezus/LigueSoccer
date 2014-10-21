/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControleurFrontal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/Login");
            r.forward(request, response);
        }
        else if ("main".equals(action)) {
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/main");
            r.forward(request, response);
        }
        else if ("logout".equals(action)) {
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/Logout");
            r.forward(request, response);
        }
        else if ("listeEquipe".equals(action)) {
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/ListeEquipe");
            r.forward(request, response);
        }
        else if ("listeJoueur".equals(action)) {
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/ListeJoueur");
            r.forward(request, response);
        }
        else if ("informationPersonnel".equals(action) || "modifierInfoUser".equals(action)) {
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/InformationPersonnel");
            r.forward(request, response);
        }
        else if ("consulterUneEquipe".equals(action)) {
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/consulterUneEquipe");
            r.forward(request, response);
        }
        else if ("creerCompte".equals(action)) {
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/creerCompte");
            r.forward(request, response);
        }        
        else if ("voirAjouterCategorie".equals(action)) {
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/voirAjouterCategorie");
            r.forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
