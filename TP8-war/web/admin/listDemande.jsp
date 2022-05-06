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
        <title>Liste des demandes| Entreprise Java</title>
        <link rel="stylesheet" href="../css/list.css" />
    </head>
    <body>
        <h1>Liste des demandes</h1>
        <table id="customers">
            <tr>
                <th>Titre</th>
                <th>Type</th>
                <th>Contenu</th>
                <th>Date</th>
                <th>Employé</th>
                <th>Etat</th>
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
                ResultSet rs = st.executeQuery("select e.nom,e.prenom,d.* from demande d, employe e where e.login = d.employe"); 
                while(rs.next()){%>
                <tr>
                        <td><%=rs.getString(4)%></td>
                        <td><%=rs.getString(5)%></td>
                        <td><%=rs.getString(6)%></td>
                        <td><%=rs.getString(7)%></td>
                        <td><%=rs.getString(2)+" "+rs.getString(1)%></td>
                        <%
                            if(rs.getString(9).equals("sous")){
                            %><td>Demande Sous traitement</td>
                            <%
                            }else if(rs.getString(9).equals("accept")){
                            %>
                            <td>Demande acceptée</td>
                            <%
                            }else{
                            %>
                            <td>Demande réfusé</td>
                        </tr>
            <%}
                }
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
