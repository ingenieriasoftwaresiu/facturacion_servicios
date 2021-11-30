/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function cargaInicial(){       
    
    $(".IMGERROR").slideUp("fast");
    $("#dBotonesInicio").show();
    $("#dIngresoConsumos").hide();
    $("#dLoader").hide();    
    
    var strAccion = $("#txtAccion").val();
    
    if (strAccion == "C"){
        limpiarForm();
    }
       
}

function buscarExterno(){
    popupCentrado("busquedaExterno.jsp","Busqueda_Externo",800,400);
}

function buscarDependencia(){
    popupCentrado("busquedaDependencia.jsp","Busqueda_Externo",800,400);
}

function asignarUsuarioExterno(strNIT, strRazonSocial){
    opener.frmIngresoConsumo.txtIdExterno.value = strNIT;
    opener.frmIngresoConsumo.txtNombreExterno.value = strRazonSocial;    
    window.close();
}

function validarBusquedaDependencia(){
    var strDependencia = $.trim($("#cbDependencia").val());
     
    if (strDependencia == "-1"){
        alert("Debe seleccionar una dependencia para continuar.");
        return false;
    }else{
        if(confirm("¿Está seguro que desea seleccionar la dependencia actual?")){
            opener.frmIngresoConsumo.txtIdDependencia.value = $("#cbDependencia option:selected").val();
            opener.frmIngresoConsumo.txtNombreDependencia.value = $("#cbDependencia option:selected").text();
            window.close();
        }        
    }
}

function validarBusquedaTercero(){
    var strNIT = $.trim($("#txtNIT").val());
    var strRazonSocial =  $.trim($("#txtRazonSocial").val());
    
    if ((strNIT == "") && (strRazonSocial == "")){
        alert("Debe diligenciar al menos uno de los dos criterios para realizar la búsqueda correctamente!.");
        return false;
    }else{
        var dataString = "txtAccion=BUSCAREXTERNO&txtNIT=" + strNIT + "&txtRazonSocial=" + strRazonSocial;
        AJAX("POST","IngresoConsumos",dataString,"dResultado");
    }
}

function limpiarForm(){
    
    var strTipoUsuarioConsumo = $("#cbTipoUsuarioConsumo").val();
    
    if (strTipoUsuarioConsumo != "-1"){
        $("#cbUsuarioConsumo").val("-1");
    }
    
    $("#cbTipoUsuarioConsumo").val("-1");
    
    var strServicioConsumido = $("#cbServicioConsumido").val();
    
    if (strServicioConsumido != "-1"){
        $("#cbSubservicioConsumido").val("-1");
    }
    
    $("#cbServicioConsumido").val("-1");   
    $("#txtFechaIni").val("");
    $("#txtFechaFin").val("");
    
    $("#dUsuarioInterno").hide();
    $("#dUsuarioUdeANoSIU").hide();
    $("#dUsuarioExterno").hide();
    $("#dSubservicio").hide();
    $("#dFechaConsumo").hide();
    $(".IMGERROR").slideUp("fast");
    $("#dIngresoConsumos").empty();
    $("#dIngresoConsumos").hide();       
    $("#dBotonesInicio").show();
    $("#txtCamposDiligenciados").val("");
}

function cargarCalendarios(){
    setCalendario("txtFechaIni","imgFechaIni");
    setCalendario("txtFechaFin","imgFechaFin");
}

function validarConsumo(strIdCampo){
    var campo = document.getElementById(strIdCampo);
    var valor = campo.value;
    
    if (valor != ""){       
       if (valor.indexOf(",") > -1){                  
           valor = replaceAll(",",".",valor);
           $("#"+strIdCampo).val(valor);   
       }
       
        if (!(validarNumero(campo.value))){                      
            alert("El(Los) valor(es) ingresado(s) debe(n) ser número(s) válido(s).");          
            $("#"+strIdCampo).val("");      
            return false;
        }        
    }
}

function validarConsumos(){
    
    var form = document.frmIngresoConsumo;
    var strTipoValidacion = form.txtTipoValidacion.value;
               
    if (strTipoValidacion == "0"){        
        var strAplicaSubcantidad = $("#txtAplicaSubcantidad").val();
               
        if (strAplicaSubcantidad == "S"){
            var strSubcantidad = $("#txtSubcantidad").val();
                                    
            if ((strSubcantidad == "") || (strSubcantidad == "0")){
                $("#imgSubcantidad").show();
                $("#txtSubcantidad").focus();
                return false;
            }else{
                if (isNaN(strSubcantidad)){
                    $("#imgSubcantidad").show();
                    $("#txtSubcantidad").focus();
                    return false;
                }else{
                    $("#imgSubcantidad").hide();
                }                
            }
        }
    }
            
    if (strTipoValidacion == "1"){
        var strArregloInsumos = form.txtArregloInsumos.value;
        var arrInsumos = strArregloInsumos.split(">");
        var strFechaInicio = form.txtFechaIni.value;
        var strFechaFin = form.txtFechaFin.value;
        var nroDias = restaFechas(strFechaInicio,strFechaFin);
        var hayConsumo = false;
        var strCamposDiligenciados="";

        for(i=0;i<(arrInsumos.length-1);i++){
            var arrDatos = arrInsumos[i].split("<");
            var strIdSubservicio = arrDatos[0];
            var strIdInsumo = arrDatos[1];                     

            var strFechaBase = strFechaInicio;

            for (a=1;a<=(nroDias+1);a++){
                var strIdCampo = strIdSubservicio + "_" + strIdInsumo + "_" + strFechaBase;
                var campo = document.getElementById(strIdCampo);            

                if (campo.value.trim() != ""){           
                    strCamposDiligenciados = strCamposDiligenciados + strIdCampo + ">";
                    hayConsumo = true;                
                }

                strFechaBase = sumarDiasFecha(strFechaBase,"1");
                strIdCampo = null;
                campo = null;
            }

            arrDatos = null;
            strIdSubservicio = null;
            strIdInsumo = null;
            strFechaBase = null;
        }

        if (hayConsumo == false){
            alert("No hay ningún consumo ingresado para registrar en el sistema. Por lo tanto, la acción Guardar no se llevará a cabo.");          
            return false;  
        }else{
            $("#txtCamposDiligenciados").val(strCamposDiligenciados);
            return true;
        }    
    }                    
    
    if ((strTipoValidacion == "2") || (strTipoValidacion == "3")){
        
        if (strTipoValidacion == "2"){
            var strAplicaSubcantidad = $("#txtAplicaSubcantidad").val();
            var strTipoUsuario = $("#cbTipoUsuario").val();

            if (strTipoUsuario == "-1"){
                $("#imgTipoUsuario").slideDown("slow");
                return false;
            }else{
                $("#imgTipoUsuario").slideUp("slow");
            }                        
        }
        
        var strUnidadConsumo = $("#cbUnidadConsumo").val();
        
        if (strUnidadConsumo == "-1"){
            $("#imgUnidadConsumo").slideDown("slow");
            return false;
        }else{
            $("#imgUnidadConsumo").slideUp("slow");
        }
        
        var strCantidad = $("#txtCantidad").val();
        
        if (strCantidad == ""){
            $("#imgCantidad").slideDown("slow");
            return false;
        }else{
            if (strCantidad.indexOf(",") > -1){                         
                strCantidad = replaceAll(",",".",strCantidad);     
                $("#txtCantidad").val(strCantidad);     
            }

            if ((!(validarNumero(strCantidad))) || (strCantidad.indexOf(",") > -1)){                      
                alert("La cantidad del consumo debe ser un número válido sin comas.");          
                $("#imgCantidad").slideDown("slow");                
                $("#txtCantidad").focus();    
                return false;
            }else{
                $("#imgCantidad").slideUp("slow");
            }            
        }
        
        if (strTipoValidacion == "2"){
            if (strAplicaSubcantidad == "S"){
                var strSubcantidad = $("#txtSubcantidad").val();

                if (strSubcantidad == ""){
                    $("#imgSubcantidad").slideDown("slow");
                    return false;
                }else{
                    $("#imgSubcantidad").slideUp("slow");
                }
            }
            
            var strAplicaPorcentajeSancion = $("#txtAplicaPorcentajeSancion").val();
                        
            if (strAplicaPorcentajeSancion == "S"){
                var strPorcentajeSancion = $("input[name='rdAplicaSancion']:checked").val();
                                
                if ((strPorcentajeSancion == undefined) || (strPorcentajeSancion == "")){
                    $("#imgAplicaSancion").slideDown("slow");                
                    $("#rdAplicaSancion").focus(); 
                    return false;
                }else{
                    $("#imgAplicaSancion").slideUp("slow");                
                }
            }
        }
               
        var strDescuento = $("#txtDescuento").val();
        
        if (strDescuento != ""){
           if (strDescuento.indexOf(",") > -1){                  
                strDescuento = replaceAll(",",".",strDescuento);
                $("#txtDescuento").val(strDescuento);   
            }

             if (!(validarNumero(strDescuento))){                      
                 alert("El valor del descuento debe ser un número válido.");                           
                 $("#imgDescuento").slideDown("slow");
                 $("#txtDescuento").focus();    
                 return false;
             }else{
                 $("#imgDescuento").slideUp("slow");
             }
        }
        
        var strItemAdicional = $("#cbItemAdicional").val();
        
        if (strItemAdicional != "-1"){
        
            var strValorAdicional = $("#txtValorAdicional").val();

           if (strValorAdicional == ""){
               $("#imgValorAdicional").slideDown("slow");                
               $("#txtValorAdicional").focus();    
                return false;
            }else{
                
                $("#imgValorAdicional").slideUp("slow");
                
                if (strValorAdicional.indexOf(",") > -1){                         
                    strValorAdicional = replaceAll(",","",strValorAdicional);     
                    $("#txtValorAdicional").val(strValorAdicional);     
                }

                if ((!(validarNumero(strValorAdicional))) || (strValorAdicional.indexOf(".") > -1)){                      
                    alert("El valor del consumo adicional debe ser un número válido sin puntos ni comas.");          
                    $("#imgValorAdicional").slideDown("slow");                
                    $("#txtValorAdicional").focus();    
                    return false;
                }else{
                    $("#imgValorAdicional").slideUp("slow");
                }
           }                      
        }                
    }
       
    $("#loaderGuardar").show();
}

function obtenerCantidad(){
  
    var strIdTipoUsuario = $("#cbTipoUsuario").val();
    var strIdSubservicio = $("#cbSubservicioConsumido").val();
    var strIdServicio = $("#cbServicioConsumido").val();
    
    if (strIdTipoUsuario != "-1"){
        var dataString = "txtAccion=CANTIDAD&txtIdServicio="+strIdServicio + "&txtIdSubservicio=" + strIdSubservicio + "&txtIdTipoUsuario=" + strIdTipoUsuario;
        AJAX("POST","IngresoConsumos",dataString,"dCantidad");
    }else{
        $("#dCantidad").html("* Cantidad:");  
    }
}

$(document).ready(function(){    
    
    // Instrucciones ejecutadas cuando el formulario esté listo.
    
    cargaInicial();
});

$(function() { 
    
    $("#btnIngresarConsumos").on("click",function(){
        var strTipoUsuarioConsumo = $("#cbTipoUsuarioConsumo").val();
        
        if (strTipoUsuarioConsumo == "-1"){
            $("#imgTipoUsuarioConsumo").slideDown("fast");
            $("#cbTipoUsuarioConsumo").focus();
            return false;
        }else{
            $("#imgTipoUsuarioConsumo").slideUp("fast");
            var strUsuarioConsumo = $("#cbUsuarioConsumo").val();
              
            if (strTipoUsuarioConsumo == "UI"){
                if (strUsuarioConsumo == "-1"){
                    $("#imgUsuarioConsumoI").slideDown("fast");
                    $("#cbUsuarioConsumo").focus();
                    return false;
                }else{
                    $("#imgUsuarioConsumoI").slideUp("fast");
                }
            } 
            
            if (strTipoUsuarioConsumo == "UE"){
                if (strUsuarioConsumo == "-1"){
                    $("#imgUsuarioConsumoE").slideDown("fast");
                    $("#cbUsuarioConsumo").focus();
                    return false;
                }else{
                    $("#imgUsuarioConsumoE").slideUp("fast");
                }
            } 
            
            if (strTipoUsuarioConsumo == "UUNS"){
                if (strUsuarioConsumo == "-1"){
                    $("#imgUsuarioConsumoUNS").slideDown("fast");
                    $("#cbUsuarioConsumo").focus();
                    return false;
                }else{
                    $("#imgUsuarioConsumoUNS").slideUp("fast");
                }
            }                         
        }
        
        var strServicioConsumido = $("#cbServicioConsumido").val();
        
        if (strServicioConsumido == "-1"){
            $("#imgServicioConsumido").slideDown("fast");
            $("#cbServicioConsumido").focus();
            return false;
        }else{
            $("#imgServicioConsumido").slideUp("fast");
            
            var strSubservicio = $("#cbSubservicioConsumido").val();
            
            if (strSubservicio != "GRUPAL"){
                if (strSubservicio == "-1"){                    
                    $("#imgSubservicioConsumido").slideDown("fast");
                    $("#cbSubservicioConsumido").focus();
                    return false;
                }else{
                    $("#imgSubservicioConsumido").slideUp("fast");
                }
            }
        }
        
        var strFechaIni = $("#txtFechaIni").val();
        
        if (strFechaIni == ""){
            $("#imgFechaInicial").slideDown("fast");
            $("#txtFechaIni").focus();
            return false;
        }else{
            $("#imgFechaInicial").slideUp("fast");
        }
        
        var strFechaFin = $("#txtFechaFin").val();
                        
        if (strFechaFin == ""){
            $("#imgFechaFinal").slideDown("fast");
            $("#txtFechaFin").focus();
            return false;
        }else{
            $("#imgFechaFinal").slideUp("fast");
        }        
                  
        var dataString = "txtAccion=INGRESOCONSUMOS&txtIdServicio="+strServicioConsumido+"&txtSubservicio="+strSubservicio+"&txtFechaIni="+strFechaIni+"&txtFechaFin="+strFechaFin+"&txtUsuario="+strUsuarioConsumo+"&txtTipoUsuario="+strTipoUsuarioConsumo;
        AJAX("POST","IngresoConsumos",dataString,"dIngresoConsumos");
        $("#dBotonesInicio").hide();
        $("#dLoader").show();
        $("#dIngresoConsumos").show();
    }); 
    
    $("#cbTipoUsuarioConsumo").on("change",function(){
        var strIdTipoUsuarioConsumo = $("#cbTipoUsuarioConsumo").val();
                
        if (strIdTipoUsuarioConsumo == "-1"){
            $("#dUsuarioInterno").hide();
            $("#dUsuarioUdeANoSIU").hide();
            $("#dUsuarioExterno").hide();
        }
        
        if (strIdTipoUsuarioConsumo == "UI"){
            $("#dUsuarioInterno").show();
            $("#dUsuarioUdeANoSIU").hide();
            $("#dUsuarioExterno").hide();
            $("#cbUsuarioConsumo").val("-1");            
        }
        
        if (strIdTipoUsuarioConsumo == "UE"){
            $("#dUsuarioInterno").hide();
            $("#dUsuarioUdeANoSIU").hide();
            $("#dUsuarioExterno").show();
            $("#cbUsuarioConsumo").val("-1");            
        }
        
        if (strIdTipoUsuarioConsumo == "UUNS"){
            $("#dUsuarioInterno").hide();
            $("#dUsuarioUdeANoSIU").show();
            $("#dUsuarioExterno").hide();
            $("#cbUsuarioConsumo").val("-1");            
        }
        
        $("#imgUsuarioConsumoI").slideUp("fast");
        $("#imgUsuarioConsumoE").slideUp("fast");
        $("#imgUsuarioConsumoUNS").slideUp("fast");
    });
    
     $("#cbServicioConsumido").on("change",function(){
        var strIdServicioConsumo = $("#cbServicioConsumido").val();
        
        if (strIdServicioConsumo != "-1"){
                                   
            var dataString = "txtAccion=SUBSERVICIO&txtIdServicio="+strIdServicioConsumo;
            AJAX("POST","IngresoConsumos",dataString,"dSubservicio");
                        
            var dataString = "txtAccion=FECHA_CONSUMO&txtIdServicio="+strIdServicioConsumo;
            AJAX("POST","IngresoConsumos",dataString,"dFechaConsumo");
            
            $("#dIngresoConsumos").empty();
            $("#dIngresoConsumos").hide();
            $("#dBotonesInicio").show();
            
            setTimeout(function(){cargarCalendarios();}, 1500);
             
        }
    });      
    
    $("#btnLimpiar").on("click",function(){
        limpiarForm();
    });
    
    $("#btnLimpiarBusqueda").on("click",function(){
        $("#dResultado").empty();
        $("#dResultado").hide();
    });
    
});


