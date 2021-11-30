/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
function cargaInicial(){   
    AJAX('POST','Visualizacion','txtAccion=consumos_insumos&txtEvento=','dMostrar');    
}

function actualizarDatos(strAccion){        
    //AJAXC("POST","Visualizacion","txtAccion=" + strAccion,"dMostrar");
}

$(document).ready(function(){    
    
    // Instrucciones ejecutadas cuando el formulario esté listo.
    
    cargaInicial();
});

$(function() { 

    $("#itVerConsumosInsumos").on("click",function(){            
        AJAX('POST','Visualizacion','txtAccion=consumos_insumos&txtEvento=','dMostrar');
    });
    
    $("#itVerConsumosTiposUsuario").on("click",function(){
        AJAX('POST','Visualizacion','txtAccion=consumos_tipos_usuario&txtEvento=','dMostrar');
    });
    
    $("#itVerConsumosUnidades").on("click",function(){               
       AJAX('POST','Visualizacion','txtAccion=consumos_unidades&txtEvento=','dMostrar');
    });
    
    $("#itVerCuentasCobro").on("click",function(){  
       AJAX('POST','Visualizacion','txtAccion=cuentascobro&txtEvento=','dMostrar');
    });
            
    $("#itMenuAdministrativo").on("click",function(){
        var nav = detectarNav();
         
         if ((nav == "IE") || (nav == "-1")){
            window.open('administrativo.jsp','Administrativo','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('administrativo.jsp','Administrativo','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('administrativo.jsp','Administrativo','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    });
    
    $("#itMenuInformes").on("click",function(){
        var nav = detectarNav();
         
         if ((nav == "IE") || (nav == "-1")){
            window.open('informes.jsp','Informes','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('informes.jsp','Informes','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('informes.jsp','Informes','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    });
    
    $("#itMenuIndicadores").on("click",function(){
        var nav = detectarNav();
         
         if ((nav == "IE") || (nav == "-1")){
            window.open('indicadores.jsp','Indicadores','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('indicadores.jsp','Indicadores','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('indicadores.jsp','Indicadores','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    });
    
    $("#itRegistrarConsumo").on("click",function(){
        
        var nav = detectarNav();
         
        if ((nav == "IE") || (nav == "-1")){
            window.open('ingresoConsumo.jsp?txtAccion=C','Ingreso_Consumos','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('ingresoConsumo.jsp?txtAccion=C','Ingreso_Consumos','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('ingresoConsumo.jsp?txtAccion=C','Ingreso_Consumos','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
        
    });
    
    $("#itGenerarCuentaCobro").on("click",function(){
        
        var nav = detectarNav();
         
        if ((nav == "IE") || (nav == "-1")){
            window.open('generarCuentaCobro.jsp?txtAccion=C','Generar_Cuenta_Cobro','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('generarCuentaCobro.jsp?txtAccion=C','Generar_Cuenta_Cobro','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('generarCuentaCobro.jsp?txtAccion=C','Generar_Cuenta_Cobro','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
        
    });
});
