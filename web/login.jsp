<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="vue">
<h3>Connectez-vous</h3>
        <form name="login" action="ctrl.do" method="POST">
            <table><tr>
                    <td>Numéro de passeport:</td>
                    <td><input type="text" name="username" value="" /></td>
                </tr>
                <tr>
                    <td>Mot de passe:</td>
                    <td><input type="password" name="password" value="" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Connexion" name="loginButton" /></td>
                </tr>
            </table>
            <input type="hidden" name="action" value="login" />
        </form>
</div>
