package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cerrar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    try{
            if (session != null){          
                session.invalidate();
            }
    }catch(IllegalStateException ise){
        response.sendRedirect("index.jsp?txtCedula=null");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"SHORTCUT ICON\" href=\"Images/favicon.ico\" />\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel='stylesheet' type='text/css' href='Styles/forms.css'/> \n");
      out.write("        <script type=\"text/javascript\" src=\"Scripts/jquery-1.11.1.min.js\"></script>\n");
      out.write("        <title>Sesión finalizada</title>\n");
      out.write("        <script language=\"javascript\">\n");
      out.write("                function redirect(){\n");
      out.write("                    location.href = \"index.jsp\";\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                document.onkeydown= function(evt) {         \n");
      out.write("                    if (!evt){\n");
      out.write("                        evt = event;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    if ((evt.keyCode == 116) || (evt.which == 8) || (evt.ctrlKey && evt.keyCode == 116)){   \n");
      out.write("                        evt.preventDefault();\n");
      out.write("                    }                                \n");
      out.write("                }\n");
      out.write("\n");
      out.write("               $(function(){\n");
      out.write("                    var rx = /INPUT|SELECT|TEXTAREA/i;\n");
      out.write("\n");
      out.write("                    $(document).bind(\"keydown keypress\", function(e){\n");
      out.write("                        if(e.which == 8){ // 8 == backspace\n");
      out.write("                            if(!rx.test(e.target.tagName) || e.target.disabled || e.target.readOnly ){\n");
      out.write("                                e.preventDefault();\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("        </script>      \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("  \n");
      out.write("       </header>\n");
      out.write("       <section>\n");
      out.write("           <article>\n");
      out.write("               <div align=\"center\">\n");
      out.write("                   <div class='TEXTOCIERRE'>\n");
      out.write("                        ¡Ha finalizado la sesión!. Para cerrar esta ventana, utiliza el botón \"X\" ubicado en la esquina superior derecha de tu navegador.<br /><br />\n");
      out.write("                        <input type=\"button\" value=\"Regresar al Inicio de Sesión\" class=\"BOTONFORM\" onClick=\"redirect();\" style=\"width: 150px;\">            \n");
      out.write("                    </div>\n");
      out.write("                    <br><br><br><br><br><br><br>\n");
      out.write("               </div>\n");
      out.write("           </article>\n");
      out.write("       </section>\n");
      out.write("       <footer>\n");
      out.write("           <div id=\"dFooter\" class=\"FOOTER\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("          \n");
      out.write("            </div>\n");
      out.write("       </footer>\n");
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
