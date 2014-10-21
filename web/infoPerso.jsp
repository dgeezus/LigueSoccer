<%@page import="com.ma.modele.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>      
 <div id="vue">   
 <%
    Utilisateur user = ((Utilisateur)request.getSession().getAttribute("usagerCourant"));    
 %>                      
        <form name="modifierPerso" action="ctrl.do" method="POST">
            Téléphone:<input type="text" name="Telephone1" value=<%=user.getNtelephone1()%> /><br/>
            Téléphone:<input type="text" name="Telephone2" value=<%=(user.getNtelephone2() == null) ? "''" : user.getNtelephone2() %> /><br/>
            Téléphone:<input type="text" name="Telephone3" value=<%=(user.getNtelephone3() == null) ? "''" : user.getNtelephone3()  %> /><br/>
            Courriel:<input type="text" name="Courriel" value=<%=user.getCourriel()%> /><br/>
            Adresse:<input type="text" name="Adresse" value=<%=user.getAdressPostale()%> /><br/>  
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
