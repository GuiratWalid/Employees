package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modeles.Employe;

public final class profil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title></title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/list.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/menu.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body style=\"display: flex;\">\n");
      out.write("        <div style=\"width:25%; margin:0 10% 0 0;\">\n");
      out.write("            <table id=\"customers\" style=\"height:17.5cm;\">\n");
      out.write("                ");

                    Employe e = (Employe) session.getAttribute("employe");
                
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Nom</th>\n");
      out.write("                            <td>");
      out.print(e.getNom());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Prénom</th>\n");
      out.write("                            <td>");
      out.print(e.getPrenom());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Adresse</th>\n");
      out.write("                            <td>");
      out.print(e.getAdresse());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Téléphone</th>\n");
      out.write("                            <td>");
      out.print(e.getTelephone());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Email</th>\n");
      out.write("                            <td>");
      out.print(e.getEmail());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Service</th>\n");
      out.write("                            <td>");
      out.print(e.getService());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Login</th>\n");
      out.write("                            <td>");
      out.print(e.getLogin());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Date de naissance</th>\n");
      out.write("                            <td>");
      out.print(e.getDatenais());
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            <h1>Profil de l'administrateur</h1>\n");
      out.write("            <div class=\"vertical-menu\">\n");
      out.write("                <a href='./modifierprofil.jsp'>Modifier mon profil</a>\n");
      out.write("                <a href='./listEmploye.jsp'>Liste des employés</a>\n");
      out.write("                <a href='./listEmployeNonConfirme.jsp'>Liste des employés non confirmés</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
