package org.apache.jsp.employe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ajouterdemande_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Demande | Entreprise Java</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/form.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Envoyer une demande</h1>\n");
      out.write("        <br/><br/>\n");
      out.write("        <form method=\"post\" action=\"/TP8-war/AjouterDemande\">\n");
      out.write("            <label for=\"titre\">Titre</label>\n");
      out.write("            <input type=\"text\" name=\"titre\" id=\"titre\" placeholder=\"Taper votre titre de demande ...\" required/>\n");
      out.write("            <label for=\"type\">Type</label>\n");
      out.write("            <select id=\"type\" name=\"type\">\n");
      out.write("                <option value=\"Cong??\">Cong??</option>\n");
      out.write("                <option value=\"Attestation de travail\">Attestation de travail</option>\n");
      out.write("                <option value=\"Autre\">Autre</option>\n");
      out.write("            </select>\n");
      out.write("            <label for=\"contenu\">Details</label>\n");
      out.write("            <textarea name=\"contenu\" id=\"contenu\" placeholder=\"Taper les details de la demande ...\"></textarea>\n");
      out.write("            <input type=\"submit\" value=\"Envoyer une demande\" />\n");
      out.write("        </form>\n");
      out.write("        <br/><br/>\n");
      out.write("        <p><a href=\"./profil.jsp\">Retour au profil</a></p>\n");
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
