package modeles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employe{

    private String nom;
    private String prenom;
    private String adresse;
    private String datenais;
    private String telephone;
    private String email;
    private String service;
    private String login;
    private String motdepasse;
    private boolean verifier;
    private String role;

    public Employe(String nom, String prenom, String adresse, String datenais, String telephone, String email, String service, String login, String motdepasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.datenais = datenais;
        this.telephone = telephone;
        this.email = email;
        this.service = service;
        this.login = login;
        this.motdepasse = motdepasse;
    }

    public boolean isVerifier() {
        return verifier;
    }

    public void setVerifier(boolean verifier) {
        this.verifier = verifier;
    }
    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Employe(String nom, String prenom, String adresse, String datenais, String telephone, String email, String service, String login, String motdepasse, boolean verifier, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.datenais = datenais;
        this.telephone = telephone;
        this.email = email;
        this.service = service;
        this.login = login;
        this.motdepasse = motdepasse;
        this.verifier = verifier;
        this.role = role;
    }
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDatenais() {
        return datenais;
    }

    public void setDatenais(String datenais) {
        this.datenais = datenais;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    @Override
    public String toString() {
        return "Employe{" + "nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", datenais=" + datenais + ", telephone=" + telephone + ", email=" + email + ", service=" + service + ", login=" + login + ", motdepasse=" + motdepasse + ", verifier=" + verifier + ", role=" + role + '}';
    }
    
    public Boolean ajouter() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection cn;
        boolean res = false;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            String url = "jdbc:derby://localhost:1527/entreprise";
            String user = "root";
            String password = "0000";
            
            cn = (Connection) DriverManager.getConnection(url, user, password);
            System.out.print("connexion etablie \n");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from employe");
            boolean verifier = true;
            String role = "admin";
            if(rs.next()){
                verifier = false;
                role = "user";
            }
            String query = "INSERT INTO employe VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1,this.nom);
            ps.setString(2,this.prenom);
            ps.setString(3,this.adresse);
            ps.setString(4,this.telephone);
            ps.setString(5,this.email);
            ps.setString(6,this.service);
            ps.setString(7,this.login);
            ps.setString(8,this.motdepasse);
            ps.setBoolean(9,verifier);
            ps.setString(10,role);
            ps.setString(11,this.datenais);
            res = ps.execute();
        } catch (SQLException e) {
            System.out.print("erreur de connexion : "+e.getMessage());
        }
        return res;
    }
     
    public static Employe connexion(String login,String motdepasse) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection cn;
        Employe res = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            String url = "jdbc:derby://localhost:1527/entreprise";
            String user = "root";
            String password = "0000";
            
            cn = (Connection) DriverManager.getConnection(url, user, password);
            System.out.print("connexion etablie \n");
            String query = "select * from employe where login = '"+login+"' and motdepasse = '"+motdepasse+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                res =  new Employe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(11), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getBoolean(9),rs.getString(10));
            }
        } catch (SQLException e) {
            System.out.print("erreur de connexion : "+e.getMessage());
        }
        return res;
    }
    
    public static Boolean confimer(String login) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection cn;
        Boolean res = false;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            String url = "jdbc:derby://localhost:1527/entreprise";
            String user = "root";
            String password = "0000";
            
            cn = (Connection) DriverManager.getConnection(url, user, password);
            System.out.print("connexion etablie \n");
            String query = "update employe set verifier=? where login = '"+login+"'";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setBoolean(1, true);
            res = ps.execute();
        } catch (SQLException e) {
            System.out.print("erreur de connexion : "+e.getMessage());
        }
        return res;
    }
    
    public static Boolean supprimer(String login) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection cn;
        Boolean res = false;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            String url = "jdbc:derby://localhost:1527/entreprise";
            String user = "root";
            String password = "0000";
            
            cn = (Connection) DriverManager.getConnection(url, user, password);
            System.out.print("connexion etablie \n");
            String query = "delete from employe where login = '"+login+"'";
            Statement st = cn.createStatement();
            res = st.execute(query);
        } catch (SQLException e) {
            System.out.print("erreur de connexion : "+e.getMessage());
        }
        return res;
    }
    
    public Boolean modifier() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection cn;
        Boolean res = false;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            String url = "jdbc:derby://localhost:1527/entreprise";
            String user = "root";
            String password = "0000";
            
            cn = (Connection) DriverManager.getConnection(url, user, password);
            System.out.print("connexion etablie \n");
            String query = "update employe set nom = ? , prenom = ? , adresse = ? , telephone = ? , email = ? , service = ? , motdepasse = ? ,datenais = ? where login = ?";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1,this.nom);
            ps.setString(2,this.prenom);
            ps.setString(3,this.adresse);
            ps.setString(4,this.telephone);
            ps.setString(5,this.email);
            ps.setString(6,this.service);
            ps.setString(7,this.motdepasse);
            ps.setString(8,this.datenais);
            ps.setString(9,this.login);
            res = ps.execute();
            res = ps.execute();
        } catch (SQLException e) {
            System.out.print("erreur de connexion : "+e.getMessage());
        }
        return res;
    }
    
}
