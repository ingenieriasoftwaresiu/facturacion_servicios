/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function cargaInicial(){       
    $(".IMGERROR").hide();
    $("#rdAcuerdo").focus();
    $("#dDatosFacturacion").hide();           
}

function limpiarForm(){
    $(".IMGERROR").hide();    
    $("#rdAcuerdo").focus();
    $("#dDatosFacturacion").slideUp();
}

function validarDatos(){
    
    var strAcuerdo = $("input[name='rdAcuerdo']:checked").val();                                 
                  
        if ((strAcuerdo == "") || (strAcuerdo == null)){
           $("#imgAcuerdo").slideDown();
           $("#rdAcuerdo").focus();
           return false;
        }else{
            $("#imgAcuerdo").slideUp();
        }

       if (strAcuerdo == "S"){
           var strDependenciaB = $.trim($("#txtDependenciaB").val());

           if (strDependenciaB == ""){
               $("#imgDependenciaB").slideDown();
               $("#txtDependenciaB").focus();
               $("#txtDependenciaB").val("");
               return false;
           }else{
               $("#imgDependenciaB").slideUp();
           }

           var strCentroCostosB = $.trim($("#txtCentroCostosB").val());

           if (strCentroCostosB == ""){
               $("#imgCentroCostosB").slideDown();
               $("#txtCentroCostosB").focus();
               $("#txtCentroCostosB").val("");
               return false;
           }else{
               $("#imgCentroCostosB").slideUp();
           }

           var strDependenciaP = $.trim($("#txtDependenciaP").val());

           if (strDependenciaP == ""){
               $("#imgDependenciaP").slideDown();
               $("#txtDependenciaP").focus();
               $("#txtDependenciaP").val("");
               return false;
           }else{
               $("#imgDependenciaP").slideUp();
           }

           var strCentroCostosP = $.trim($("#txtCentroCostosP").val());

           if (strCentroCostosP == ""){
               $("#imgCentroCostosP").slideDown();
               $("#txtCentroCostosP").focus();
               $("#txtCentroCostosP").val("");
               return false;
           }else{
               $("#imgCentroCostosP").slideUp();
           }

           var strOrdenadorGasto = $.trim($("#txtOrdenadorGasto").val());

           if (strOrdenadorGasto == ""){
               $("#imgOrdenadorGasto").slideDown();
               $("#txtOrdenadorGasto").focus();
               $("#txtOrdenadorGasto").val("");
               return false;
           }else{
               $("#imgOrdenadorGasto").slideUp();
           }

           var strCargoOrdenadorGasto = $.trim($("#txtCargoOrdenadorGasto").val());

           if (strCargoOrdenadorGasto == ""){
               $("#imgCargoOrdenadorGasto").slideDown();
               $("#txtCargoOrdenadorGasto").focus();
               $("#txtCargoOrdenadorGasto").val("");
               return false;
           }else{
               $("#imgCargoOrdenadorGasto").slideUp();
           }
       }                            
}

$(document).ready(function(){    
    
    // Instrucciones ejecutadas cuando el formulario esté listo.
    
    cargaInicial();
});

$(function() { 
    $("#btnSalir").on("click",function(){
        location.href = "cerrar.jsp";
    });
    
    $("#btnImprimir").on("click",function(){
        
        if (!(confirm("¿Desea incluir en la impresión los datos de facturación?"))){
            document.all.item("noprint").style.display = "none";      
            document.all.item("noprint2").style.display = "none";
            window.print();   
            document.all.item("noprint").style.display = "block";
            document.all.item("noprint2").style.display = "block";
        }else{
            document.all.item("noprint").style.display = "none";           
            window.print();   
            document.all.item("noprint").style.display = "block";
        }
    });
    
    $("#btnLimpiar").on("click",function(){
        limpiarForm();
    });
         
    $("#rdSi").on("click",function(){
        $("#dDatosFacturacion").slideDown();
        $("#txtDependenciaB").focus();
    });
    
    $("#rdNo").on("click",function(){
        $("#dDatosFacturacion").slideUp();
    });
    
});

