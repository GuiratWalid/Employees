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
        <title></title>
        <link rel="stylesheet" href="../css/list.css" />
        <link rel="stylesheet" href="../css/menu.css" />
    </head>
    <body style="display: flex;">
        <div style="width:25%; margin:0 10% 0 0;">
            <table id="customers" style="height:17.5cm;">
                <%
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
                                rs = st.executeQuery("select * from employe where login = '"+cookies[i].getValue().toString()+"'");
                            }
                                if(cookies[i].getValue() == null){
                                    break;
                                }
                                
                                
                        } 
                        while(rs.next()){
                    
                %>
                        <tr>
                            <th>Nom</th>
                            <td><%=rs.getString(1)%></td>
                        </tr>
                        <tr>
                            <th>Pr??nom</th>
                            <td><%=rs.getString(2)%></td>
                        </tr>
                        <tr>
                            <th>Adresse</th>
                            <td><%=rs.getString(3)%></td>
                        </tr>
                        <tr>
                            <th>T??l??phone</th>
                            <td><%=rs.getString(4)%></td>
                        </tr>
                        <tr>
                            <th>Email</th>
                            <td><%=rs.getString(5)%></td>
                        </tr>
                        <tr>
                            <th>Service</th>
                            <td><%=rs.getString(6)%></td>
                        </tr>
                        <tr>
                            <th>Login</th>
                            <td><%=rs.getString(7)%></td>
                        </tr>
                        <tr>
                            <th>Date de naissance</th>
                            <td><%=rs.getString(11)%></td>
                        </tr>
            </table>
        </div>
                        <%}%>
        <div>
            <h1>Profil de l'administrateur</h1>
            <div class="vertical-menu">
                <a href='./modifiermonprofil.jsp'>Modifier mon profil</a>
                <a href='./listEmploye.jsp'>Liste des employ??s</a>
                <a href='./listEmployeNonConfirme.jsp'>Liste des employ??s non confirm??s</a>
                <a href='./listDemande.jsp'>Liste des demandes</a>
                <a href='./listDemandeNonConfirme.jsp'>Liste des demandes non confirm??es</a>
            </div>
            <div style="position:absolute; bottom:2cm;right:7.8cm;width:300px;">
                <form action="/TP8-war/Logout" method="POST">
                    <input type="submit" value="Se d??connecter" />
                </form>
            </div>
        </div>
    </body>
</html>
