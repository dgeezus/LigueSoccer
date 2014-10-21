<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ligue de soccer</title>
    </head>
    <h1>Ligue de soccer</h1>
    <body>

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
    </body>
</html>
