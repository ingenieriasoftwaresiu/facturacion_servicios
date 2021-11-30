<%-- 
    Document   : cerrar
    Created on : 18/12/2014, 11:20:17 AM
    Author     : Jorge.correa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try{
            if (session != null){          
                session.invalidate();
            }
    }catch(IllegalStateException ise){
        response.sendRedirect("index.jsp?txtCedula=null");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="SHORTCUT ICON" href="Images/favicon.ico" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='Styles/forms.css'/> 
        <script type="text/javascript" src="Scripts/jquery-1.11.1.min.js"></script>
        <title>Sesión finalizada</title>
        <script language="javascript">
                function redirect(){
                    location.href = "index.jsp";
                }
                
                document.onkeydown= function(evt) {         
                    if (!evt){
                        evt = event;
                    }

                    if ((evt.keyCode == 116) || (evt.which == 8) || (evt.ctrlKey && evt.keyCode == 116)){   
                        evt.preventDefault();
                    }                                
                }

               $(function(){
                    var rx = /INPUT|SELECT|TEXTAREA/i;

                    $(document).bind("keydown keypress", function(e){
                        if(e.which == 8){ // 8 == backspace
                            if(!rx.test(e.target.tagName) || e.target.disabled || e.target.readOnly ){
                                e.preventDefault();
                            }
                        }
                    });
                });
        </script>      
    </head>
    <body>
        <header>
            <jsp:include page="header.jsp" />  
       </header>
       <section>
           <article>
               <div align="center">
                   <div class='TEXTOCIERRE'>
                        ¡Ha finalizado la sesión!. Para cerrar esta ventana, utiliza el botón "X" ubicado en la esquina superior derecha de tu navegador.<br /><br />
                        <input type="button" value="Regresar al Inicio de Sesión" class="BOTONFORM" onClick="redirect();" style="width: 150px;">            
                    </div>
                    <br><br><br><br><br><br><br>
               </div>
           </article>
       </section>
       <footer>
           <div id="dFooter" class="FOOTER">
                <jsp:include page="footer.jsp" />          
            </div>
       </footer>
    </body>
</html>
