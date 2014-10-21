<%@page import="com.ma.modele.Categorie"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="./js/jquery-1.11.1.min.js"></script>
<div id="vue">
    <h3>Liste des catégories</h3>
<%
    if(request.getAttribute("message")!= null){
        out.println("<p>"+request.getAttribute("message")+"</p>");
    }
    
    List<Categorie> listCat = (List) request.getAttribute("categories");
    String nom, niveau, genre;
    int age, adulte;

    out.println("<table id=\"listTab\" border=\"1\">");
    out.println("<tr><th>Nom</th><th>Âge</th><th>Genre</th><th>Niveau</th><th>Adulte</th></tr>");

    for (int i = 0; i < listCat.size(); i++) {
        Categorie c = listCat.get(i);
        age = c.getAge();
        niveau = c.getNiveau();
        if(c.getGenre() == 0){
        genre = "F";
        } else {
            genre = "M";
        }
        adulte = c.getAdulte();
        String ad;
        if (adulte == 1) {
            nom = "O";
            ad = "Oui";
        } else {
            nom = "U";
            ad = "Non";
        }
        nom = nom + age + genre + "-" + niveau;
        out.println("<tr><td>" + nom + "</td>"
                + "<td>" + c.getAge() + "</td>"
                + "<td>" + c.getGenre() + "</td>"
                + "<td>" + c.getNiveau() + "</td>"
                + "<td>" + ad + "</td></tr>");
    }
    out.println("</table>");
%>     
<h3 style="cursor:pointer" id="ajouterForm">Ajouter une catégorie</h3>              

<form style="display:none" id="formulaireCat" name="ajoutCategorie" action="ctrl.do" method="POST"> 
    <table id="formTab">
        <tr>        
            <td><input type="radio" class="adulteR" name="adulte" value="1" checked="checked"/>Adulte</td>

            <td> <input type="radio" class="adulteR" name="adulte" value="0" />Enfant</td>
        </tr>
        <tr>
            <td align="right">Âge:</td>
            <td id="adulte" align="left"><select name="ageAdulte">       
                    <option value="18">18</option>
                    <option value="35">35</option>
                    <option value="45">45</option>                       
                </select></td>
            <td id="enfant" style="display : none"><select name="ageEnfant"> 
                    <%
                        for (int i = 6; i < 21; i++) {
                            out.println("<option value=" + i + ">" + i + "</option>");
                        }
                    %>                     
                </select></td>
        </tr>
        <tr>
            <td align="right">Niveau:</td> 
            <td align="left">
                <select name="niveau">       
                    <option value="C">C</option>
                    <option value="B">B</option>
                    <option value="A">A</option>
                    <option value="CC">CC</option>
                    <option value="BB">BB</option>
                    <option value="AA">AA</option>
                    <option value="AAA">AAA</option>  
                </select>    
            </td>
        </tr>
        <tr>        
            <td><input type="radio"  name="sexe" value="1" checked="checked"/>Masculin</td>

            <td> <input type="radio"  name="sexe" value="0" />Féminin</td>
        </tr>
        <tr>
            <td colspan='3' align='center'>
                <input type="submit" name="valider" value="Ajouter">
            </td>
        </tr>
    </table>
   <input type="hidden" name="action" value="voirAjouterCategorie"/>
   <input type="hidden" name="ajoute" value="ajoute"/>  
</form>
 <script>
    $("#ajouterForm").click(function() {
        $("#formulaireCat").toggle();
    });
</script>               
<script>
    $(".adulteR").click(function() {
        $("#adulte").toggle();
        $("#enfant").toggle();
    });
</script>
</div>