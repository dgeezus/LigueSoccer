<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <script src="./js/jquery-1.11.1.min.js"></script>
        <script src="./js/jquery.validate.min.js"></script>
        <script src="./js/additional-methods.min.js"></script>
<div id="vue">
        <%
            if (request.getAttribute("message") != null) {
                out.println("<p>" + request.getAttribute("message") + "</p>");
            }
            String nom = (String) request.getAttribute("nom");
            String prenom = (String) request.getAttribute("prenom");
            int annee = 0;
            if (request.getAttribute("annee") != null) {
                annee = (Integer) request.getAttribute("annee");
            }
        %>
        <form id="creation" name="creationCompte" action="ctrl.do" method="POST">
            <table>
                <tr>
                    <td>Prénom:</td>
                    <td><input type="text" class="champ" name="prenom" maxlength="30" required value=<%=(prenom == null) ? "''" : prenom%>></td>	
                </tr>
                <tr>
                    <td>Nom:</td>
                    <td><input type="text" class="champ" name="nom" maxlength="30" required value=<%=(nom == null) ? "''" : nom%>></td>
                </tr>
                <tr>
                    <td>Adresse courriel:</td>
                    <td><input type="email" class="champ" name="courriel" required></td>
                </tr>
                <tr>
                    <td>Mot de passe:</td>
                    <td><input type="password" class="champ" name="mdp1" id="mdp1" required></td>
                </tr>
                <tr>
                    <td>Mot de passe:</td>
                    <td><input type="password" class="champ" name="mdp2" id="mdp2" required></td>
                </tr>
                <tr>
                    <td>Année de naissance:</td>
                    <td><select name="annee" class="champ" required>
                            <%
                                for (int i = 1940; i < 2009; i++) {
                                    if (i == annee) {
                                        out.println("<option selected value=" + i + ">" + i + "</option>");
                                    } else {
                                        out.println("<option value=" + i + ">" + i + "</option>");
                                    }
                                }
                            %>
                        </select></td>
                </tr>
                <tr>
                    <td><input type="submit" name="valider" value="OK"></td>   
                </tr>
            </table>  
            <input type="hidden" name="action" value="creerCompte" />
        </form>            
        <script>
            $("#creation").validate({
                rules: {
                    mdp1: {
                       minlength: 6
                    },
                    mdp2: {
                        equalTo: "#mdp1",
                        minlength: 6
                    }
                },
                messages : {
                    mdp1 : {
                        required : "Vous devez remplir ce champ.",
                        minlength: "Vous devez entrer au minimum six caractères."
                    },
                    mdp2 : {
                        required : "Vous devez remplir ce champ.",
                        minlength: "Vous devez entrer au minimum six caractères.",
                        equalTo: "Vous devez entrer le même mot de passe deux fois."
                    },
                    nom : {
                        required : "Vous devez remplir ce champ."
                    },
                    
                     prenom : {
                        required : "Vous devez remplir ce champ."
                    },
                    courriel : {
                        required : "Vous devez remplir ce champ.",
                        email : "Vous devez entrer une adresse courriel valide."
                    }
                } 
            });
        </script>
</div>
