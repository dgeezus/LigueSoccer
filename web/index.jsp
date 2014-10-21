<?xml version="1.0"?>

<%@page import="com.ma.util.Connexion"%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Ligue de soccer</title>
        <style type="text/css">
            .errorMessage {color : red;}
            .resultat {font-weight: bold;}
        </style>
    </head>
    <body>
        <h1><a href="index.jsp">Ligue de soccer</a></h1>
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
            }
            else if ("main".equals(afficherPage)) {
        %>
        <jsp:include page="main.jsp" />
        <%
            }
            else if ("listeEquipe".equals(afficherPage)) {
        %>
        <jsp:include page="listeEquipe.jsp" />
        <%
            }
            else if ("infoPerso".equals(afficherPage)) {
        %>
        <jsp:include page="infoPerso.jsp" />
        <%
            }
            else if ("uneEquipe".equals(afficherPage)) {
        %>
        <jsp:include page="uneEquipe.jsp" />
        <%
                }
         else if ("creerCompte".equals(afficherPage)) {
        %>
        <jsp:include page="creerCompte.jsp" />
        <%
            }   
         else if ("voirAjouterCategorie".equals(afficherPage)) {
        %>
        <jsp:include page="categorie.jsp" />
        <%
            } 
            }
        %>

    </form>
</body>
</html>
