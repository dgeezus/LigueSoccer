<%@page import="com.ma.modele.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>      
 <div id="vue"> 
     <h3>Informations personnelles</h3>
 <%
    Utilisateur user = ((Utilisateur)request.getSession().getAttribute("usagerCourant"));    
 %>                      
        <form name="modifierPerso" action="ctrl.do" method="POST">
            <table>
                <tr>
                    <td>Téléphone 1:</td>
                    <td><input type="text" minlength="10" maxlength="10" name="Telephone1" value=<%=(user.getNtelephone1() == null || user.getNtelephone1().equals("")) ? "''" : user.getNtelephone1()%> /></td>
                </tr>
                <tr>
                    <td>Téléphone 2:</td>
            <td><input type="text" minlength="10" maxlength="10" name="Telephone2" value=<%=(user.getNtelephone2() == null || user.getNtelephone2().equals("")) ? "''" : user.getNtelephone2() %> /></td>
                </tr>
                <tr>
            <td>Téléphone 3:</td>
            <td><input type="text" minlength="10" maxlength="10" name="Telephone3" value=<%=(user.getNtelephone3() == null || user.getNtelephone3().equals("")) ? "''" : user.getNtelephone3()  %> /></td>
                </tr>
                <tr>
                    <td>Courriel:</td>
                    <td><input type="email" name="Courriel" required value=<%=user.getCourriel()%> /></td>
                </tr>
                <tr>
                    <td>Adresse:</td>
                    <td> <input type="text" name="Adresse" value=<%=user.getAdressPostale()%> /></td>  
            </table>
                <input type="submit" value="modifier" name="modifier" />
             <input type="hidden" name="action" value="modifierInfoUser" />
             <input type="hidden" name="modifierUser" value="modifier" />
            
        </form>
            <p>
            <form name="back" action="main.jsp" method="POST">
            <input type="submit" value="Retour" name="back" />
            </form>
            </p>
 </div>
