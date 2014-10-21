<%@page import="com.ma.util.Connexion"%>
<%@page import= " com.ma.modele.Utilisateur"%>
<%@page import= " com.ma.DAO.implement.UtilisateurDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>    
        <ul type="circle">
            <li><a href="ctrl.do?action=logout">Informations</a></li>
            <li><a href="ctrl.do?action=logout">Nouvelles</a></li>
            <li><a href="ctrl.do?action=logout">Communiqués</a></li>
            <li><a href="ctrl.do?action=listeEquipe">Équipes</a></li>
            <li><a href="ctrl.do?action=listeJoueur">Joueurs</a></li>
            <li><a href="ctrl.do?action=voirAjouterCategorie">Catégories</a></li>
            <%
                if(request.getAttribute("message") != null){
                    out.println(request.getAttribute("message"));                    
                }
                if(session.getAttribute("username")!= null)
            {
                Utilisateur user = ((Utilisateur)request.getSession().getAttribute("usagerCourant"));
               %>

          <p class="f-right">Usager: <%= user.getPrenom()%>       
           <li> <a href="ctrl.do?action=logout" id="logout">Déconnexion</a></li>
          <li> <a href="ctrl.do?action=informationPersonnel">Informations personnelles</a></li>
 <% 
               }  else { //Ici, on devrait rediriger vers l'index afin de faire afficher le tout comme une vue
 %>
                <li><a href="login.jsp">Connexion</a></li>
                <li><a href="index.jsp?afficherPage=creerCompte">Créer un compte</a></li>
                <%  }                
 %> 
        </ul>


       
       

    </body>
</html>
