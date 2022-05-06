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
        <title>La liste de mes demandes | Entreprise Java</title>
        <link rel="stylesheet" href="../css/list.css" />
    </head>
    <body>
        <h1>La liste de mes demandes</h1>
        <table id="customers">
            <tr>
                <th>Id Demande</th>
                <th>Titre</th>
                <th>Type</th>
                <th>Contenu</th>
                <th>Date</th>
                <th>Etat</th>
                <th>Annuler</th>
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
                Cookie[] cookies = request.getCookies();
                ResultSet rs = null;
                for(int i=0;i<cookies.length;i++){
                    if(cookies[i].getName().equals(new String ("current_employe"))){
                        rs = st.executeQuery("select * from demande d where employe = '"+cookies[i].getValue().toString()+"'"); 
                    }
                }
                while(rs.next()){%>
                <tr>
                        <td><%=rs.getString(1)%></td>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getString(3)%></td>
                        <td><%=rs.getString(4)%></td>
                        <td><%=rs.getString(5)%></td>
                        <%
                            if(rs.getString(7).equals("sous")){
                            %>
                            <td>Demande Sous traitement</td>
                            <%
                            }else if(rs.getString(7).equals("accept")){
                            %>
                            <td>Demande acceptée</td>
                            <%
                            }else{
                            %>
                            <td>Demande réfusé</td>
                        
            <%}%>
                            <td>
                                <form action="/TP8-war/AnnulerDemande" method="POST">
                                    <input type="text" name="id" id="id" value="<%=rs.getString(1)%>" style="visibility:hidden;width:1px;"/>
                                    <input type="submit" style="margin:0;width:100px;" value="Annuler"/>
                                </form>
                            </td>
                </tr>
            <%         
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
