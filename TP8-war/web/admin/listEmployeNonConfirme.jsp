<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="modeles.Employe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des employés non confirmés | Entreprise Java</title>
        <link rel="stylesheet" href="../css/list.css" />
    </head>
    <body>
        <h1>Liste des employés non confirmés</h1>
        <table id="customers">
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Adresse</th>
                <th>Téléphone</th>
                <th>Email</th>
                <th>Service</th>
                <th>Login</th>
                <th>Mot de passe</th>
                <th>Date de naissance</th>
                <th>Confirmation</th>
            </tr>
           <%
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                String url = "jdbc:derby://localhost:1527/entreprise";
                String user = "root";
                String password = "0000";

                Connection cn = (Connection) DriverManager.getConnection(url, user, password);
                System.out.print("connexion etablie \n");
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("select * from employe where verifier = false and role = 'user'"); 
                while(rs.next()){%>
                <tr>
                        <td><%=rs.getString(1)%></td>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getString(3)%></td>
                        <td><%=rs.getString(4)%></td>
                        <td><%=rs.getString(5)%></td>
                        <td><%=rs.getString(6)%></td>
                        <td><%=rs.getString(7)%></td>
                        <td><%=rs.getString(8)%></td>
                        <td><%=rs.getString(11)%></td>
                            <td>
                                <form action="/TP8-war/ConfirmerEmploye" method="POST">
                                    <input type="text" name="login" id="login" value="<%=rs.getString(7)%>" style="visibility:hidden;width:1px;"/>
                                    <input type="submit" style="margin:0;width:100px;" value="Confimer"/>
                                </form>
                            </td>
                        </tr>
            <%}
            }
            catch(Exception exp){
                exp.printStackTrace();
            }
            %>
        </table>
        <br/><br/>
        <p><a href="./profil.jsp">Retour au profil</a></p>
    </body>
</html>
