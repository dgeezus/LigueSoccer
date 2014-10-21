<%@page import="com.ma.modele.Utilisateur"%>
<?xml version="1.0"?>
<%@page import="com.ma.util.Connexion"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="./styles/style.css" type="text/css" />
        <title>Ligue de soccer</title>
    </head>
    <body>
        <div id="tout">
            <div id="banniere">
                <div id="banniereText">
                    <h1><a href="index.jsp">Ligue de soccer</a></h1>    
                </div>  
            </div>
            <div id="menu">
                <ul type="circle">
                    <li><a href="ctrl.do?action=logout">Informations</a></li>
                    <li><a href="ctrl.do?action=logout">Nouvelles</a></li>
                    <li><a href="ctrl.do?action=logout">Communiqués</a></li>
                    <li><a href="ctrl.do?action=listeEquipe">Équipes</a></li>
                    <li><a href="ctrl.do?action=listeJoueur">Joueurs</a></li>
                    <li><a href="ctrl.do?action=voirAjouterCategorie">Catégories</a></li>
                        <%
                            if (request.getAttribute("message") != null) {
                                out.println(request.getAttribute("message"));
                            }
                            if (session.getAttribute("username") != null) {
                                Utilisateur user = ((Utilisateur) request.getSession().getAttribute("usagerCourant"));
                        %>

                    <p class="f-right">Usager: <%= user.getPrenom()%>       
                    <li> <a href="ctrl.do?action=logout" id="logout">Déconnexion</a></li>
                    <li> <a href="ctrl.do?action=informationPersonnel">Informations personnelles</a></li>
                        <%
                        } else { //Ici, on devrait rediriger vers l'index afin de faire afficher le tout comme une vue
                        %>
                    <li><a href="index.jsp?afficherPage=login">Connexion</a></li>
                    <li><a href="index.jsp?afficherPage=creerCompte">Créer un compte</a></li>
                        <%  }
                        %> 
                </ul>
            </div>
            <%
                if (request.getParameter("afficherPage") == null) {
            %>
            <jsp:include page="main.jsp" />
            <%
            } else {
                String afficherPage = (String) request.getParameter("afficherPage");

                if ("login".equals(afficherPage)) {
            %>
            <jsp:include page="login.jsp" />
            <%
            } else if ("main".equals(afficherPage)) {
            %>
            <jsp:include page="main.jsp" />
            <%
            } else if ("listeEquipe".equals(afficherPage)) {
            %>
            <jsp:include page="listeEquipe.jsp" />
            <%
            } else if ("infoPerso".equals(afficherPage)) {
            %>
            <jsp:include page="infoPerso.jsp" />
            <%
            } else if ("uneEquipe".equals(afficherPage)) {
            %>
            <jsp:include page="uneEquipe.jsp" />
            <%
            } else if ("creerCompte".equals(afficherPage)) {
            %>
            <jsp:include page="creerCompte.jsp" />
            <%
            } else if ("voirAjouterCategorie".equals(afficherPage)) {
            %>
            <jsp:include page="categorie.jsp" />
            <%
            } else if ("login".equals(afficherPage)) {
            %>
            <jsp:include page="login.jsp" />
            <%
                    }
                }
            %>
            <hr id="fin"/>
        </div>  
    </body>
</html>
