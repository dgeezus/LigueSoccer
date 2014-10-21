<%-- 
    Document   : listeEquipe
    Created on : 2014-10-13, 16:41:13
    Author     : Casa Nova
--%>

<%@page import="com.ma.modele.Utilisateur"%>
<%@page import="com.ma.modele.Equipe"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.ma.DAO.implement.EquipeDAO"%>
<%@page import="com.ma.util.Connexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des équipes</title>
    </head>
    <body>
        <%
            List<Equipe> equipes = (List<Equipe>)request.getAttribute("listeEquipe");
        out.println("<table id=\"ListeEquipe\" >");
            out.println("<tr class=\"t-center\"><th>Nom</th><th>Categorie</th></tr>");
            for (int i = 0; i < equipes.size(); i++) {
                  String url;      
             
               url = "?action=consulterUneEquipe&equipeId=" +equipes.get(i).getIdequipe();
                out.println("<tr><td><a href=\""+url+"\">" + equipes.get(i).getNomequipe() + 
                        "</a></td>"+
                        "<td>"+equipes.get(i).getIdCategorie() +"</td></tr>");
            }
            out.println("</table>"); 
            
           if(session.getAttribute("usagerCourant") != null){
               Utilisateur user = (Utilisateur) session.getAttribute("usagerCourant");
               if(user.getIsAdmin() == 1){
                   request.setAttribute("action", "ajouterEquipe");
                   out.println("<p><a href=ctrl.do>Ajouter une équipe</a>");
               }
           }
        %>
    </body>
</html>
