<%@page import="java.sql.Date"%>
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
        <link rel="stylesheet" href="../css/form.css" />
    </head>
    <body>
        <h1>Modifier mon profil</h1>
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
                        if(rs.next()){
                            String datnais = rs.getString(11);
                %>
        <br/><br/>
        <form method="post" action="/TP8-war/ModifierProfilEmploye">
            <label for="nom">Nom</label>
            <input type="text" name="nom" id="nom" value="<%=rs.getString(1)%>" required/>
            <label for="prenom">Prenom</label>
            <input type="text" name="prenom" id="prenom" value="<%=rs.getString(2)%>" required/>
            <label for="adresse">Adresse</label>
            <input type="text" name="adresse" id="adresse" value="<%=rs.getString(3)%>" required/>
            <label for="datenais">Date de Naissance</label>
            <input type="date" name="datenais" id="datenais" value="<%=datnais%>" required/>
            <label for="telephone">Téléphone</label>
            <input type="text" name="telephone" id="telephone" value="<%=rs.getString(4)%>" required/>
            <label for="email">Email</label>
            <input type="email" name="email" id="email" value="<%=rs.getString(5)%>" required/>
            <label for="service">Service d'attachement</label>
            <input type="text" name="service" id="service" value="<%=rs.getString(6)%>" required/>
            <label for="login">Login</label>
            <input type="text" name="login" id="login" value="<%=rs.getString(7)%>" readonly/>
            <label for="motdepasse">Mot de passe</label>
            <input type="text" name="motdepasse" id="motdepasse" value="<%=rs.getString(8)%>" required/>
            <input type="submit" value="Enregistrer les modifications" />
        </form>
        <br/><br/>
        <p><a href="./profil.jsp">Retour au profil</a></p>
        <%}%>
    </body>
</html>

