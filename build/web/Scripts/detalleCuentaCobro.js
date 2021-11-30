/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cargaInicial(){       
        var strEsAuxProy = $("#txtEsAuxProy").val();
        var strAcuerdoCobro = $("#txtAcuerdoCobro").val();
        
        if (strEsAuxProy == "S"){
            if (strAcuerdoCobro == "S"){
                $("#txtNumeroSoporte").focus();
            }
        }
}

function verDetalladoConsumos(strCodigo){

         var nav = detectarNav();
         
        if ((nav == "IE") || (nav == "-1")){
            window.open('detalladoConsumos.jsp?keyCC='+strCodigo,'Detallado_Consumos','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
        }

        if (nav == "Firefox"){        
            window.open('detalladoConsumos.jsp?keyCC='+strCodigo,'Detallado_Consumos','toolbar=no,location=no,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){        
            window.open('detalladoConsumos.jsp?keyCC='+strCodigo,'Detallado_Consumos','toolbar=no,top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
        }
   }

function validarDatosSoporte(){
    var strNumeroSoporte = $("#txtNumeroSoporte").val();
    
    if (strNumeroSoporte == ""){
        $("#imgNumeroSoporte").slideDown();
        $("#txtNumeroSoporte").focus();
        return false;
    }else{
        $("#imgNumeroSoporte").slideUp();
    }
    
    var strFechaSoporte = $("#txtFechaSoporte").val();
    
    if (strFechaSoporte == ""){
        $("#imgFechaSoporteV").slideDown();
        $("#txtFechaSoporte").focus();
        return false;
    }else{
        $("#imgFechaSoporteV").slideUp();
    }
    
    var strValorSoporte = $("#txtValorSoporte").val();
    
    if (strValorSoporte == ""){
        $("#imgValorSoporte").slideDown();
        $("#txtValorSoporte").focus();
        return false;
    }else{
        $("#imgValorSoporte").slideUp();
        
          if (!(validarNumero(strValorSoporte))){
               alert("El valor debe ser un número válido.");
               $("#imgValorSoporte").slideDown();
               $("#txtValorSoporte").focus();
               return false;
          }else{
              $("#imgValorSoporte").slideUp();
          }  
    }    
}

function cargarCalendarios(){
    setCalendario("txtFechaSoporte","imgFechaSoporte");    
}

function imprimirDetalle(){
    document.all.item("noprint").style.display = "none";      
    window.print();   
    document.all.item("noprint").style.display = "block";
}

$(document).ready(function(){    
    
    // Instrucciones ejecutadas cuando el formulario esté listo.
    
    cargaInicial();
});

$(function() { 
          
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
    
});

