/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cargaInicial(){       
    
    $(".IMGERROR").slideUp("fast");
    cargarCalendarios();
    var strFacturado = $("#txtFacturado").val();
        
    if (strFacturado == "S"){
        $("form input:text").addClass("CAMPOFORMREAD");
        $("form input:text").attr("readonly",true);
        $("form select").addClass("CAMPOSELECTDISABLED");
        $("form select").attr("disabled","disabled");
        $(".IMGCALENDAR").hide();
        $("form input:radio").attr("disabled","disabled");
        $("#btnActualizar").hide();
    }           
}

function cargarCalendarios(){
    setCalendario("txtFechaConsumo","imgFechaConsumo");
    setCalendario("txtFechaFacturacion","imgFechaFacturacion");     
}

function validarActualizarConsumo(){
    
    var strTipoConsumo = $("#txtTipoConsumo").val();
        
    if (strTipoConsumo == "consumos_insumos"){
        var strAplicaSubcantidad = $("#txtAplicaSubcantidad").val();
                        
        if (strAplicaSubcantidad == "S"){
            var strSubcantidad = $("#txtSubcantidad").val();
            
            if ((strSubcantidad == "") || (strSubcantidad == "0")){
                 $("#imgSubcantidad").slideDown("slow");
                 $("#txtSubcantidad").focus();
                 return false;
            }else{
                $("#imgSubcantidad").slideUp("slow");
            }                    
        }
    }
    
    if (strTipoConsumo == "consumos_tipos_usuario"){
        var strTipoUsuario = $("#cbTipoUsuario").val();
        
        if (strTipoUsuario == "-1"){            
            $("#imgTipoUsuario").slideDown("slow");
            $("#cbTipoUsuario").focus();
            return false;
        }else{
            $("#imgTipoUsuario").slideUp("slow");
        }
        
        var strSubcantidad = $("#txtSubcantidad").val();
        var strEtiquetaSubcantidad = $("#txtEtiquetaSubcantidad").val();
        
        if (strSubcantidad == ""){            
            $("#imgSubcantidad").slideDown("slow");
            $("#txtSubcantidad").focus();
            return false;
        }else{
            $("#imgSubcantidad").slideUp("slow");
            if (strSubcantidad.indexOf(",") > -1){                         
                strSubcantidad = replaceAll(",","",strSubcantidad);     
                $("#txtSubcantidad").val(strSubcantidad);     
            }

            if ((!(validarNumero(strSubcantidad))) || (strSubcantidad.indexOf(".") > -1)){                      
                alert(strEtiquetaSubcantidad + " debe ser un número válido sin comas ni puntos.");          
                $("#imgSubcantidad").slideDown("slow");                
                $("#txtSubcantidad").focus();    
                return false;
            }else{
                $("#imgSubcantidad").slideUp("slow");
            }
        }
        
        var strAplicaPorcentajeSancion = $("#txtAplicaPorcentajeSancion").val();
        
        if (strAplicaPorcentajeSancion == "S"){
            var strAplicaSancion = $("input[name='rdAplicaSancion']:checked").val();                       
    
            if (strAplicaSancion == ""){
                $("#imgAplicaSancion").slideDown("slow");                
                $("#rdAplicaSancion").focus();    
            }else{
                $("#imgAplicaSancion").slideUp("slow");                
            }
        }
    }
    
    var strCantidadConsumida = $("#txtCantidadConsumida").val();
    
    if (strCantidadConsumida == ""){
        $("#imgCantidadConsumida").slideDown("slow");
        $("#txtCantidadConsumida").focus();
        return false;
    }else{
        $("#imgCantidadConsumida").slideUp("slow");
        if (strCantidadConsumida.indexOf(",") > -1){                         
                strCantidadConsumida = replaceAll(",",".",strCantidadConsumida);     
                $("#txtCantidadConsumida").val(strCantidadConsumida);     
            }

            if ((!(validarNumero(strCantidadConsumida))) || (strCantidadConsumida.indexOf(",") > -1)){                      
                alert("La cantidad consumida debe ser un número válido sin comas.");          
                $("#imgCantidadConsumida").slideDown("slow");                
                $("#txtCantidadConsumida").focus();    
                return false;
            }else{
                $("#imgCantidadConsumida").slideUp("slow");
            }
    }
    
    var strFacturado = $("input[name='rdFacturado']:checked").val();
    
    if (strFacturado == "S"){
        var strFechaFacturacion = $("#txtFechaFacturacion").val();
        
        if (strFechaFacturacion == ""){
            $("#imgVFechaFacturacion").slideDown("slow");                
            $("#txtFechaFacturacion").focus(); 
            return false;
        }else{
            $("#imgVFechaFacturacion").slideUp("slow");                
        }
        
        var strCuentaCobro = $("#txtCuentaCobro").val();
        
        if ((strCuentaCobro == "") || (strCuentaCobro == "0")){
            $("#imgCuentaCobro").slideDown("slow");                
            $("#txtCuentaCobro").focus(); 
            return false;
        }else{
            $("#imgCuentaCobro").slideUp("slow");      
        }
        
    }else{
        $("#imgVFechaFacturacion").slideUp("slow");               
        $("#imgCuentaCobro").slideUp("slow");      
    }
    
    // Validación de la información del descuento.
    
    var strTieneDescuento = $("#txtTieneDescuento").val();
    
    if (strTieneDescuento == "S"){
        var strValorDescuento = $("#txtValorDescuento").val();
    
        if (strValorDescuento == ""){
            $("#imgValorDescuento").slideDown("slow");
            $("#txtValorDescuento").focus();
            return false;
        }else{
            $("#imgValorDescuento").slideUp("slow");
            if (strValorDescuento.indexOf(",") > -1){                         
                    strValorDescuento = replaceAll(",",".",strValorDescuento);     
                    $("#txtValorDescuento").val(strValorDescuento);     
                }

                if ((!(validarNumero(strValorDescuento))) || (strValorDescuento.indexOf(",") > -1)){                      
                    alert("El valor del descuento debe ser un número válido sin comas.");          
                    $("#imgValorDescuento").slideDown("slow");                
                    $("#txtValorDescuento").focus();    
                    return false;
                }else{
                    $("#imgValorDescuento").slideUp("slow");
                }
        }
        
        var strFacturadoDescuento = $("input[name='rdFacturadoDescuento']:checked").val();
    
        if (strFacturadoDescuento == "S"){
            var strFechaFacturacionDescuento = $("#txtFechaFacturacionDescuento").val();

            if (strFechaFacturacionDescuento == ""){
                $("#imgVFechaFacturacionDescuento").slideDown("slow");                
                $("#txtFechaFacturacionDescuento").focus(); 
                return false;
            }else{
                $("#imgVFechaFacturacionDescuento").slideUp("slow");                
            }
        }else{
            $("#imgVFechaFacturacionDescuento").slideUp("slow");                
        }
    }
        
    // Validación de la información del consumo adicional.
    
    var strTieneConsumoAdicional = $("#txtTieneConsumoAdicional").val();
    
    if (strTieneConsumoAdicional == "S"){
        
        var strItemAdicional = $("#cbItemAdicional").val();
        
        if (strItemAdicional == "-1"){            
            $("#imgItemAdicional").slideDown("slow");
            $("#cbItemAdicional").focus();
            return false;
        }else{
            $("#imgItemAdicional").slideUp("slow");
        }
        
        var strValorConsumo = $("#txtValorConsumoAdicional").val();
        
        if (strValorConsumo == ""){            
            $("#imgValorConsumoAdicional").slideDown("slow");
            $("#txtValorConsumoAdicional").focus();
            return false;
        }else{
            $("#imgValorConsumoAdicional").slideUp("slow");
            if (strValorConsumo.indexOf(",") > -1){                         
                strValorConsumo = replaceAll(",","",strValorConsumo);     
                $("#txtValorConsumoAdicional").val(strValorConsumo);     
            }

            if ((!(validarNumero(strValorConsumo))) || (strValorConsumo.indexOf(".") > -1)){                      
                alert("El valor del consumo adicional debe ser un número válido sin comas ni puntos.");          
                $("#imgValorConsumoAdicional").slideDown("slow");                
                $("#txtValorConsumoAdicional").focus();    
                return false;
            }else{
                $("#imgValorConsumoAdicional").slideUp("slow");
            }
        }
        
        var strFacturadoConsumoA = $("input[name='rdFacturadoConsumoA']:checked").val();
    
        if (strFacturadoConsumoA == "S"){
            var strFechaFacturacionConsumoA = $("#txtFechaFacturacionConsumoA").val();

            if (strFechaFacturacionConsumoA == ""){
                $("#imgVFechaFacturacionConsumoA").slideDown("slow");                
                $("#txtFechaFacturacionConsumoA").focus(); 
                return false;
            }else{
                $("#imgVFechaFacturacionConsumoA").slideUp("slow");                
            }
        }else{
            $("#imgVFechaFacturacionConsumoA").slideUp("slow");                
        }
    }           
}

$(document).ready(function(){    
    
    // Instrucciones ejecutadas cuando el formulario esté listo.
    
    cargaInicial();
});

$(function() { 
    $( "#rdSeFacturaN" ).on( "click", function(){
        $("[name=rdFacturado]").filter("[value='N']").prop("checked",true);
        $("#txtFechaFacturacion").val("");
        $("#imgVFechaFacturacion").slideUp("slow");
        $("#txtCuentaCobro").val("0")
        $("#imgCuentaCobro").slideUp("slow");
    });
    
    $( "#rdFacturadoN" ).on( "click", function(){
        $("#txtFechaFacturacion").val("");
        $("#imgVFechaFacturacion").slideUp("slow");
        $("#txtCuentaCobro").val("0")
        $("#imgCuentaCobro").slideUp("slow");
    });
    
    $( "#rdFacturadoS" ).on( "click", function(){
        $("[name=rdSeFactura]").filter("[value='S']").prop("checked",true);
    });
    
    // Eventos del descuento.
    
    $( "#rdSeFacturaDescuentoN" ).on( "click", function(){
        $("[name=rdFacturadoDescuento]").filter("[value='N']").prop("checked",true);
        $("#txtFechaFacturacionDescuento").val("");
        $("#imgVFechaFacturacionDescuento").slideUp("slow");
    });
    
    $( "#rdFacturadoDescuentoN" ).on( "click", function(){
        $("#txtFechaFacturacionDescuento").val("");
        $("#imgVFechaFacturacionDescuento").slideUp("slow");
    });
    
    $( "#rdFacturadoDescuentoS" ).on( "click", function(){
        $("[name=rdSeFacturaDescuento]").filter("[value='S']").prop("checked",true);
    });
    
     // Eventos del consumo adicional.
     
     $( "#rdSeFacturaConsumoAN" ).on( "click", function(){
        $("[name=rdFacturadoConsumoA]").filter("[value='N']").prop("checked",true);
        $("#txtFechaFacturacionConsumoA").val("");
        $("#imgVFechaFacturacionConsumoA").slideUp("slow");
    });
    
    $( "#rdFacturadoConsumoAN" ).on( "click", function(){
        $("#txtFechaFacturacionConsumoA").val("");
        $("#imgVFechaFacturacionConsumoA").slideUp("slow");
    });
    
    $( "#rdFacturadoConsumoAS" ).on( "click", function(){
        $("[name=rdSeFacturaConsumoA]").filter("[value='S']").prop("checked",true);
    });
});
