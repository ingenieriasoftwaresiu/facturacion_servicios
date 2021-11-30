/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarUnidadMedida(){
    var strCodigo = $("#txtCodigo").val();
    
    if (strCodigo == ""){
        $("#imgCodigo").slideDown();
        $("#txtCodigo").focus();
        return false;
    }else{
        $("#imgCodigo").slideUp();
    }
    
    var strNombre = $("#txtNombre").val();
    
    if (strNombre == ""){
        $("#imgNombre").slideDown();
        $("#txtNombre").focus();
        return false;
    }else{
        $("#imgNombre").slideUp();
    }
}

function validarTipoUsuario(){
    var strCodigo = $("#txtCodigo").val();
    
    if (strCodigo == ""){
        $("#imgCodigo").slideDown();
        $("#txtCodigo").focus();
        return false;
    }else{
        $("#imgCodigo").slideUp();
    }
    
    var strNombre = $("#txtNombre").val();
    
    if (strNombre == ""){
        $("#imgNombre").slideDown();
        $("#txtNombre").focus();
        return false;
    }else{
        $("#imgNombre").slideUp();
    }
}

function validarTipoFacturacion(){
    var strCodigo = $("#txtCodigo").val();
    
    if (strCodigo == ""){
        $("#imgCodigo").slideDown();
        $("#txtCodigo").focus();
        return false;
    }else{
        $("#imgCodigo").slideUp();
    }
    
    var strNombre = $("#txtNombre").val();
    
    if (strNombre == ""){
        $("#imgNombre").slideDown();
        $("#txtNombre").focus();
        return false;
    }else{
        $("#imgNombre").slideUp();
    }
}

function validarItemAdicional(){
    var strCodigo = $("#txtCodigo").val();
    
    if (strCodigo == ""){
        $("#imgCodigo").slideDown();
        $("#txtCodigo").focus();
        return false;
    }else{
        $("#imgCodigo").slideUp();
    }
    
    var strNombre = $("#txtNombre").val();
    
    if (strNombre == ""){
        $("#imgNombre").slideDown();
        $("#txtNombre").focus();
        return false;
    }else{
        $("#imgNombre").slideUp();
    }
}

function validarInsumoServicio(){
    var strCodigo = $("#txtCodigo").val();
    
    if (strCodigo == ""){
        $("#imgCodigo").slideDown();
        $("#txtCodigo").focus();
        return false;
    }else{
        $("#imgCodigo").slideUp();
    }
    
    var strNombre = $("#txtNombre").val();
    
    if (strNombre == ""){
        $("#imgNombre").slideDown();
        $("#txtNombre").focus();
        return false;
    }else{
        $("#imgNombre").slideUp();
    }
    
    var strUnidadMedida = $("#cbUnidadMedida").val();
    
    if (strUnidadMedida == "-1"){
        $("#imgUnidadMedida").slideDown();
        $("#cbUnidadMedida").focus();
        return false;
    }else{
        $("#imgUnidadMedida").slideUp();
    }
    
    var strPresentacion = $("#txtPresentacion").val();
    
    if (strPresentacion == ""){
        $("#imgPresentacion").slideDown();
        $("#txtPresentacion").focus();
        return false;
    }else{
        $("#imgPresentacion").slideUp();
    }
    
    var strCostoUnitario = $("#txtCostoUnitario").val();
    
    if (strCostoUnitario != ""){
        
        if (!(validarNumero(strCostoUnitario))){                      
            alert("El costo unitario debe ser un valor numérico.");
            $("#imgCostoUnitario").slideDown();
            return false;
        }        
    }
    
    var strCantidadDisponible = $("#txtCantidadDisponible").val();
    
    if (strCantidadDisponible != ""){        
        if (!(validarNumero(strCantidadDisponible))){                      
            alert("La cantidad disponible debe ser un valor numérico válido.");
            $("#imgCantidadDisponible").slideDown();
            return false;
        }        
    }
}

function validarRolUsuario(){
    var strCodigo = $("#txtCodigo").val();
    
    if (strCodigo == ""){
        $("#imgCodigo").slideDown();
        $("#txtCodigo").focus();
        return false;
    }else{
        $("#imgCodigo").slideUp();
    }
    
    var strNombre = $("#txtNombre").val();
    
    if (strNombre == ""){
        $("#imgNombre").slideDown();
        $("#txtNombre").focus();
        return false;
    }else{
        $("#imgNombre").slideUp();
    }
    
    var strSeAutentica = $("input[name='rdSeAutentica']:checked").val();                                              
   
    if ((strSeAutentica != "S") && (strSeAutentica != "N")) {
        $("#imgSeAutentica").slideDown("slow");                
        $("#rdSeAutentica").focus();    
        return false;
    }else{
        $("#imgSeAutentica").slideUp("slow");                
    }
}

function validarRolXUsuario(){
    var strRol = $("#cbRol").val();
    
    if (strRol == "-1"){
        $("#imgRol").slideDown();
        $("#cbRol").focus();
        return false;
    }else{
        $("#imgRol").slideUp();
    }
    
    var strUsuario = $("#cbUsuario").val();
    
    if (strUsuario == "-1"){
        $("#imgUsuario").slideDown();
        $("#cbUsuario").focus();
        return false;
    }else{
        $("#imgUsuario").slideUp();
    }     
}

function validarParametrosGenerales(){
    var strTituloApp = $("#txtTituloApp").val();
    
    if (strTituloApp == ""){
        $("#imgTituloApp").slideDown();
        $("#txtTituloApp").focus();
        return false;
    }else{
        $("#imgTituloApp").slideUp();
    }
    
    var strSubtituloApp = $("#txtSubtituloApp").val();
    
    if (strSubtituloApp == ""){
        $("#imgSubtituloApp").slideDown();
        $("#txtSubtituloApp").focus();
        return false;
    }else{
        $("#imgSubtituloApp").slideUp();
    }
    
    var strToken = $("#txtToken").val();
    
    if (strToken == ""){
        $("#imgToken").slideDown();
        $("#txtToken").focus();
        return false;
    }else{
        $("#imgToken").slideUp();
    }
    
    var strNroRegistrosMostrar = $("#txtNroRegistrosMostrar").val();
    
    if (strNroRegistrosMostrar == ""){
        $("#imgNroRegistrosMostrar").slideDown();
        $("#txtNroRegistrosMostrar").focus();
        return false;
    }else{
        $("#imgNroRegistrosMostrar").slideUp();
        
        if (!(validarNumero(strNroRegistrosMostrar))){                      
            alert("El número de registros a mostrar en vistas debe ser un valor numérico válido.");
            $("#imgNroRegistrosMostrar").slideDown();
            $("#txtNroRegistrosMostrar").focus();
            return false;
        }else{
            $("#imgNroRegistrosMostrar").slideUp();
        }        
    }
    
    var strNomServidor = $("#txtNomServidor").val();
    
    if (strNomServidor == ""){
        $("#imgNomServidor").slideDown();
        $("#txtNomServidor").focus();
        return false;
    }else{
        $("#imgNomServidor").slideUp();
    }
    
    var strNroPuerto = $("#txtNroPuerto").val();
    
    if (strNroPuerto == ""){
        $("#imgNroPuerto").slideDown();
        $("#txtNroPuerto").focus();
        return false;
    }else{
        $("#imgNroPuerto").slideUp();
        
        if (!(validarNumero(strNroPuerto))){                      
            alert("El número de puerto de conexión debe ser un valor numérico válido.");
            $("#imgNroPuerto").slideDown();
            $("#txtNroPuerto").focus();
            return false;
        }else{
            $("#imgNroPuerto").slideUp();
        }
    }
    
    var strNomUsuario = $("#txtNomUsuario").val();
    
    if (strNomUsuario == ""){
        $("#imgNomUsuario").slideDown();
        $("#txtNomUsuario").focus();
        return false;
    }else{
        $("#imgNomUsuario").slideUp();
    }
    
    var strContrasena = $("#txtContrasena").val();
    
    if (strContrasena == ""){
        $("#imgContrasena").slideDown();
        $("#txtContrasena").focus();
        return false;
    }else{
        $("#imgContrasena").slideUp();
    }
            
    var strNroDiasFechaLimite = $("#txtNroDiasFechaLimite").val();
    
    if (strNroDiasFechaLimite == ""){
        $("#imgNroDiasFechaLimite").slideDown();
        $("#txtNroDiasFechaLimite").focus();
        return false;
    }else{
        $("#imgNroDiasFechaLimite").slideUp();
        
        if (!(validarNumero(strNroDiasFechaLimite))){                      
            alert("El número de días para el cálculo de la fecha límite debe ser un valor numérico válido.");
            $("#imgNroDiasFechaLimite").slideDown();
            $("#txtNroDiasFechaLimite").focus();
            return false;
        }else{
            $("#imgNroDiasFechaLimite").slideUp();
        }
    }
    
    var strPorcSancionImpl = $("#txtPorcSancionImpl").val();
    
    if (strPorcSancionImpl == ""){
        $("#imgPorcSancionImpl").slideDown();
        $("#txtPorcSancionImpl").focus();
        return false;
    }else{
        $("#imgPorcSancionImpl").slideUp();
        
        if (!(validarNumero(strPorcSancionImpl))){                      
            alert("El porcentaje de sanción por incumplimiento debe ser un valor numérico válido. Ejm: 20 ó 30.5");
            $("#imgPorcSancionImpl").slideDown();
            $("#txtPorcSancionImpl").focus();
            return false;
        }else{
            $("#imgPorcSancionImpl").slideUp();
        }
    }    
}

function cargarSubservicio(){
    setFocus('txtCodigo');
    
    var strAplicaSubcantidad = $("input[name='rdAplicaSubcantidad']:checked").val();
    
    if ((strAplicaSubcantidad != "S") && (strAplicaSubcantidad != "N")) {
        $("#txtEtiquetaSubcantidad").addClass("CAMPOFORMREAD");
        $("#txtEtiquetaSubcantidad").attr("readOnly",true);
    }else{
        if (strAplicaSubcantidad == "S"){
            $("#txtEtiquetaSubcantidad").removeClass("CAMPOFORMREAD");
            $("#txtEtiquetaSubcantidad").attr("readOnly",false);
        }else{
            $("#txtEtiquetaSubcantidad").addClass("CAMPOFORMREAD");
            $("#txtEtiquetaSubcantidad").attr("readOnly",true);
        }        
    }
}

function validarSubservicio(){
    var strCodigo = $("#txtCodigo").val();
    
    if (strCodigo == ""){
        $("#imgCodigo").slideDown();
        $("#txtCodigo").focus();
        return false;
    }else{
        $("#imgCodigo").slideUp();
    }
    
    var strNombre = $("#txtNombre").val();
    
    if (strNombre == ""){
        $("#imgNombre").slideDown();
        $("#txtNombre").focus();
        return false;
    }else{
        $("#imgNombre").slideUp();
    }
    
    var strTipoFacturacion = $("#cbTipoFacturacion").val();
    
    if (strTipoFacturacion == "-1"){
        $("#imgTipoFacturacion").slideDown();
        $("#cbTipoFacturacion").focus();
        return false;
    }else{
        $("#imgTipoFacturacion").slideUp();
    }
    
    var strResponsable = $("#cbResponsable").val();
    
    if (strResponsable == "-1"){
        $("#imgResponsable").slideDown();
        $("#cbResponsable").focus();
        return false;
    }else{
        $("#imgResponsable").slideUp();
    }
    
    var strServicio = $("#cbServicio").val();
    
    if (strServicio == "-1"){
        $("#imgServicio").slideDown();
        $("#cbServicio").focus();
        return false;
    }else{
        $("#imgServicio").slideUp();
    }
    
    var strInsumosFijos = $("input[name='rdInsumosFijos']:checked").val();                                              
   
    if ((strInsumosFijos != "S") && (strInsumosFijos != "N")) {
        $("#imgInsumosFijos").slideDown("slow");                
        $("#rdInsumosFijos").focus();    
        return false;
    }else{
        $("#imgInsumosFijos").slideUp("slow");                
    }
    
    var strAplicaSubcantidad = $("input[name='rdAplicaSubcantidad']:checked").val();                                              
   
    if ((strAplicaSubcantidad != "S") && (strAplicaSubcantidad != "N")) {
        $("#imgAplicaSubcantidad").slideDown("slow");                
        $("#rdAplicaSubcantidad").focus();    
        return false;
    }else{
        $("#imgAplicaSubcantidad").slideUp("slow");                
    }
    
    if (strAplicaSubcantidad == "S"){
        var strEtiquetaSubcantidad = $("#txtEtiquetaSubcantidad").val();

        if (strEtiquetaSubcantidad == ""){
            $("#imgEtiquetaSubcantidad").slideDown();
            $("#txtEtiquetaSubcantidad").focus();
            return false;
        }else{
            $("#imgEtiquetaSubcantidad").slideUp();
        }
    }
    
    var strPorcSancion = $("input[name='rdPorcSancion']:checked").val();                                              
   
    if ((strPorcSancion != "S") && (strPorcSancion != "N")) {
        $("#imgPorcSancion").slideDown("slow");                
        $("#rdPorcSancion").focus();    
        return false;
    }else{
        $("#imgPorcSancion").slideUp("slow");                
    }    
}

function validarServicioXUnidad(){
    var strServicio = $("#cbServicio").val();
    
    if (strServicio == "-1"){
        $("#imgServicio").slideDown();
        $("#cbServicio").focus();
        return false;
    }else{
        $("#imgServicio").slideUp();
    }
    
    var strSubservicio = $("#cbSubservicio").val();
    
    if (strSubservicio == "-1"){
        $("#imgSubservicio").slideDown();
        $("#cbSubservicio").focus();
        return false;
    }else{
        $("#imgSubservicio").slideUp();
    }
    
    var strUnidadMedida = $("#cbUnidadMedida").val();
    
    if (strUnidadMedida == "-1"){
        $("#imgUnidadMedida").slideDown();
        $("#cbUnidadMedida").focus();
        return false;
    }else{
        $("#imgUnidadMedida").slideUp();
    }
    
    var strValorUnidad = $("#txtValorUnidad").val();
    
    if (strValorUnidad== ""){
        $("#imgValorUnidad").slideDown();
        $("#txtValorUnidad").focus();
        return false;
    }else{
        $("#imgValorUnidad").slideUp();
        
        if (strValorUnidad.indexOf(",") > -1){                         
            strValorUnidad = replaceAll(",","",strValorUnidad);     
            $("#txtValorUnidad").val(strValorUnidad);     
        }
                                       
        if (!(validarNumero(strValorUnidad))){                      
            alert("El valor de la unidad debe ser un valor numérico válido sin puntos ni comas.");
            $("#imgValorUnidad").slideDown();
            $("#txtValorUnidad").focus();
            return false;
        }else{
            $("#imgValorUnidad").slideUp();
        }
    }
}

function validarServicioXTipoUsuario(){
    var strServicio = $("#cbServicio").val();
    
    if (strServicio == "-1"){
        $("#imgServicio").slideDown();
        $("#cbServicio").focus();
        return false;
    }else{
        $("#imgServicio").slideUp();
    }
    
    var strSubservicio = $("#cbSubservicio").val();
    
    if (strSubservicio == "-1"){
        $("#imgSubservicio").slideDown();
        $("#cbSubservicio").focus();
        return false;
    }else{
        $("#imgSubservicio").slideUp();
    }
    
    var strTipoUsuario = $("#cbTipoUsuario").val();
    
    if (strTipoUsuario == "-1"){
        $("#imgTipoUsuario").slideDown();
        $("#cbTipoUsuario").focus();
        return false;
    }else{
        $("#imgTipoUsuario").slideUp();
    }
    
    var strUnidadMedida = $("#cbUnidadMedida").val();
    
    if (strUnidadMedida == "-1"){
        $("#imgUnidadMedida").slideDown();
        $("#cbUnidadMedida").focus();
        return false;
    }else{
        $("#imgUnidadMedida").slideUp();
    }
    
    var strValorUnidad = $("#txtValorUnidad").val();
    
    if (strValorUnidad== ""){
        $("#imgValorUnidad").slideDown();
        $("#txtValorUnidad").focus();
        return false;
    }else{
        $("#imgValorUnidad").slideUp();
        
        if (strValorUnidad.indexOf(",") > -1){                         
            strValorUnidad = replaceAll(",","",strValorUnidad);     
            $("#txtValorUnidad").val(strValorUnidad);     
        }
                                       
        if (!(validarNumero(strValorUnidad))){                      
            alert("El valor de la unidad debe ser un valor numérico válido sin puntos ni comas.");
            $("#imgValorUnidad").slideDown();
            $("#txtValorUnidad").focus();
            return false;
        }else{
            $("#imgValorUnidad").slideUp();
        }
    }
}

function cargarServicioXInsumo(){
    setFocus('cbServicio');
    
    var strCobroTransversal = $("input[name='rdCobroTransversal']:checked").val(); 
    
    if ((strCobroTransversal != "S") && (strCobroTransversal != "N")) {
        $("#txtCantidadCobroTransversal").addClass("CAMPOFORMREAD");
        $("#txtCantidadCobroTransversal").attr("readOnly",true);
    }else{
        if (strCobroTransversal == "S"){
            $("#txtCantidadCobroTransversal").removeClass("CAMPOFORMREAD");
            $("#txtCantidadCobroTransversal").attr("readOnly",false);
        }else{
            $("#txtCantidadCobroTransversal").addClass("CAMPOFORMREAD");
            $("#txtCantidadCobroTransversal").attr("readOnly",true);
        }        
    }
    
    var strCostoVariable = $("input[name='rdCostoVariable']:checked").val(); 
    
    if ((strCostoVariable != "S") && (strCostoVariable != "N")) {
        $("#txtCostoVariable").addClass("CAMPOFORMREAD");
        $("#txtCostoVariable").attr("readOnly",true);
    }else{
        if (strCostoVariable == "S"){
            $("#txtCostoVariable").removeClass("CAMPOFORMREAD");
            $("#txtCostoVariable").attr("readOnly",false);
        }else{
            $("#txtCostoVariable").addClass("CAMPOFORMREAD");
            $("#txtCostoVariable").attr("readOnly",true);
        }        
    }
    
    var strCantidadFija = $("#txtCantidadFija").val();
       
    if ((strCantidadFija != "") && (strCantidadFija != "0")){        
        $("#cbUnidadCantidadFija").attr("disabled",false);        
    }else{
        $("#cbUnidadCantidadFija").attr("disabled",true);
    }
}

function validarServicioXInsumo(){
    var strServicio = $("#cbServicio").val();
    
    if (strServicio == "-1"){
        $("#imgServicio").slideDown();
        $("#cbServicio").focus();
        return false;
    }else{
        $("#imgServicio").slideUp();
    }
    
    var strSubservicio = $("#cbSubservicio").val();
    
    if (strSubservicio == "-1"){
        $("#imgSubservicio").slideDown();
        $("#cbSubservicio").focus();
        return false;
    }else{
        $("#imgSubservicio").slideUp();
    }
    
    var strInsumo = $("#cbInsumo").val();
    
    if (strInsumo == "-1"){
        $("#imgInsumo").slideDown();
        $("#cbInsumo").focus();
        return false;
    }else{
        $("#imgInsumo").slideUp();
    }
    
    var strCobroTransversal = $("input[name='rdCobroTransversal']:checked").val();                                              
   
    if ((strCobroTransversal != "S") && (strCobroTransversal != "N")) {
        $("#imgCobroTransversal").slideDown("slow");                
        $("#rdCobroTransversal").focus();    
        return false;
    }else{
        $("#imgCobroTransversal").slideUp("slow");                
    }
    
    if (strCobroTransversal == "S"){
        var strCantidadCobroTransversal = $("#txtCantidadCobroTransversal").val();

        if (strCantidadCobroTransversal == ""){
            $("#imgCantidadCobroTransversal").slideDown();
            $("#txtCantidadCobroTransversal").focus();
            return false;
        }else{
            $("#imgCantidadCobroTransversal").slideUp();

            if (!(validarNumero(strCantidadCobroTransversal))){                      
                alert("La cantidad para el cobro transversal debe ser un valor numérico válido.");
                $("#imgCantidadCobroTransversal").slideDown();
                $("#txtCantidadCobroTransversal").focus();
                return false;
            }else{
                $("#imgCantidadCobroTransversal").slideUp();
            }
        }
    }
    
    var strCantidadFija = $("#txtCantidadFija").val();
    
    if ((strCantidadFija != "") && (strCantidadFija != "0")){           
        if (!(validarNumero(strCantidadFija))){                      
            alert("La cantidad fija debe ser un valor numérico válido.");
            $("#imgCantidadFija").slideDown();
            $("#txtCantidadFija").focus();
            return false;
        }else{
            $("#imgCantidadFija").slideUp();
        }
        
        var strUnidadCantidadFija= $("#cbUnidadCantidadFija").val();
    
        if (strUnidadCantidadFija == "-1"){
            $("#imgUnidadCantidadFija").slideDown();
            $("#cbUnidadCantidadFija").focus();
            return false;
        }else{
            $("#imgUnidadCantidadFija").slideUp();
        }
    }else{
        $("#imgCantidadFija").slideUp();
        $("#imgUnidadCantidadFija").slideUp();
        $("#cbUnidadCantidadFija").val("-1");
    }
            
    var strCostoVariable = $("input[name='rdCostoVariable']:checked").val();                                              
   
    if ((strCostoVariable != "S") && (strCostoVariable != "N")) {
        $("#imgCostoVariable").slideDown("slow");                
        $("#rdCostoVariable").focus();    
        return false;
    }else{
        $("#imgCostoVariable").slideUp("slow");                
    }
    
    if (strCostoVariable == "S"){
        var strCostoV = $("#txtCostoVariable").val();
    
        if (strCostoV == ""){
            $("#imgCostoV").slideDown();
            $("#txtCostoVariable").focus();
            return false;
        }else{
            $("#imgCostoV").slideUp();
            
            if (!(validarNumero(strCostoV))){                      
                alert("El costo variable debe ser un valor numérico válido.");
                $("#imgCostoV").slideDown();
                $("#txtCostoVariable").focus();
                return false;
            }else{
                $("#imgCostoV").slideUp();
            }
        }
    }
    
    var strSeCobraAlUsuario= $("input[name='rdSeCobraAlUsuario']:checked").val();                                              
   
    if ((strSeCobraAlUsuario != "S") && (strSeCobraAlUsuario != "N")) {
        $("#imgSeCobraAlUsuario").slideDown("slow");                
        $("#rdSeCobraAlUsuario").focus();    
        return false;
    }else{
        $("#imgSeCobraAlUsuario").slideUp("slow");                
    }
    
}

$(function() { 
    $("#btnLimpiar").on("click",function(){
        $(".IMGERROR").slideUp();
    });
    
    $("#rdSubcantidadNo").on("click",function(){
       $("#txtEtiquetaSubcantidad").addClass("CAMPOFORMREAD");
       $("#txtEtiquetaSubcantidad").attr("readOnly",true);
       $("#txtEtiquetaSubcantidad").val("-");
    });
    
    $("#rdSubcantidadSi").on("click",function(){
       $("#txtEtiquetaSubcantidad").removeClass("CAMPOFORMREAD");
       $("#txtEtiquetaSubcantidad").attr("readOnly",false);
       $("#txtEtiquetaSubcantidad").val("");
    });
    
    $("#rdCobroTransversalNo").on("click",function(){
       $("#txtCantidadCobroTransversal").addClass("CAMPOFORMREAD");
       $("#txtCantidadCobroTransversal").attr("readOnly",true);
       $("#txtCantidadCobroTransversal").val("-");
    });
    
    $("#rdCobroTransversalSi").on("click",function(){
       $("#txtCantidadCobroTransversal").removeClass("CAMPOFORMREAD");
       $("#txtCantidadCobroTransversal").attr("readOnly",false);
       $("#txtCantidadCobroTransversal").val("");
    });
    
    $("#rdCostoVariableNo").on("click",function(){
       $("#txtCostoVariable").addClass("CAMPOFORMREAD");
       $("#txtCostoVariable").attr("readOnly",true);
       $("#txtCostoVariable").val("-");
    });
    
    $("#rdCostoVariableSi").on("click",function(){
       $("#txtCostoVariable").removeClass("CAMPOFORMREAD");
       $("#txtCostoVariable").attr("readOnly",false);
       $("#txtCostoVariable").val("");
    });
    
    $("#txtCantidadFija").on("blur",function(){
        var strCantidadFija = $("#txtCantidadFija").val();
       
        if ((strCantidadFija != "") && (strCantidadFija != "0")){           
            if (!(validarNumero(strCantidadFija))){                      
                alert("La cantidad fija debe ser un valor numérico válido.");
                $("#imgCantidadFija").slideDown();
                $("#txtCantidadFija").focus();
                return false;
            }else{
                $("#imgCantidadFija").slideUp();
                $("#cbUnidadCantidadFija").attr("disabled",false);
            }
        }else{
            $("#cbUnidadCantidadFija").attr("disabled",true);
        }
       
    });
           
    $("#cbServicio").on("change",function(){
         var strIdServicio = $("#cbServicio").val();
        
        if (strIdServicio != "-1"){
                                   
            var dataString = "txtAccion=SUBSERVICIO_MAESTRO&txtIdServicio="+strIdServicio;
            AJAX("POST","Acciones",dataString,"dSubservicio");                        
           
        }
    });    
    
});
