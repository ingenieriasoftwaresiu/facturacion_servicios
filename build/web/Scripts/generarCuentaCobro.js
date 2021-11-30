/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cargaInicial(){       
            
    var strAccion = $("#txtAccion").val();
    
    if (strAccion == "C"){
        limpiarForm();
    }
       
}

function limpiarForm(){
    $(".IMGERROR").slideUp("fast");
    $("#dUsuarioInterno").hide();
    $("#dUsuarioUdeANoSIU").hide();
    $("#dUsuarioExterno").hide();
    
    document.getElementById("frmCuentaCobro").reset();
    $("#cbTipoUsuarioConsumo").focus();
}

function cargarCalendarios(){
    setCalendario("txtFechaIni","imgFechaIni");
    setCalendario("txtFechaFin","imgFechaFin");
}

function validarCuentaCobro(){
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
        
}

$(document).ready(function(){    
    
    // Instrucciones ejecutadas cuando el formulario esté listo.
    
    cargaInicial();
});

$(function() { 
    
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
    
    $("#btnLimpiar").on("click",function(){
        limpiarForm();
    });
});

