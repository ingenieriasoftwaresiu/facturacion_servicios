/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function cargaInicial(){   
    AJAX('POST','Visualizacion','txtAccion=unidad_medida&txtEvento=','dMostrar');
}

$(document).ready(function(){    
    
    // Instrucciones ejecutadas cuando el formulario esté listo.
    
    cargaInicial();
});

$(function() { 
    
    $("#itUnidadesMedida").on("click",function(){   
        AJAX('POST','Visualizacion','txtAccion=unidad_medida&txtEvento=','dMostrar');
    });
    
    $("#itTiposUsuario").on("click",function(){   
        AJAX('POST','Visualizacion','txtAccion=tipo_usuario&txtEvento=','dMostrar');
    });
    
    $("#itTiposFacturacion").on("click",function(){   
        AJAX('POST','Visualizacion','txtAccion=tipo_facturacion&txtEvento=','dMostrar');
    });
    
    $("#itItemsAdicionales").on("click",function(){   
        AJAX('POST','Visualizacion','txtAccion=item_adicional&txtEvento=','dMostrar');
    });
    
    $("#itInsumosServicios").on("click",function(){   
        AJAX('POST','Visualizacion','txtAccion=insumo_servicio&txtEvento=','dMostrar');
    });
    
    $("#itSubservicios").on("click",function(){   
        AJAX('POST','Visualizacion','txtAccion=subservicio&txtEvento=','dMostrar');
    });
    
    $("#itServiciosXInsumos").on("click",function(){   
        AJAX('POST','Visualizacion','txtAccion=servicios_por_insumos&txtEvento=','dMostrar');
    });
    
    $("#itServiciosXTiposUsuario").on("click",function(){   
        AJAX('POST','Visualizacion','txtAccion=servicios_por_tipos_usuario&txtEvento=','dMostrar');
    });
    
    $("#itServiciosXUnidades").on("click",function(){   
        AJAX('POST','Visualizacion','txtAccion=servicios_por_unidades&txtEvento=','dMostrar');
    });
    
    $("#itRolesUsuario").on("click",function(){   
        AJAX('POST','Visualizacion','txtAccion=rol_usuario&txtEvento=','dMostrar');
    });
    
    $("#itRolesXUsuarios").on("click",function(){   
        AJAX('POST','Visualizacion','txtAccion=rol_por_usuario&txtEvento=','dMostrar');
    });
    
    $("#itCrearParametrosGenerales").on("click",function(){   
        var nav = detectarNav();
         
         if ((nav == "IE") || (nav == "-1")){
            window.open('parametroGeneral.jsp?txtAccion=C','Parametro_General','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('parametroGeneral.jsp?txtAccion=C','Parametro_General','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('parametroGeneral.jsp?txtAccion=C','Parametro_General','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    });
    
    $("#itVerParametrosGenerales").on("click",function(){   
        var nav = detectarNav();
         
         if ((nav == "IE") || (nav == "-1")){
            window.open('parametroGeneral.jsp?txtAccion=V','Parametro_General','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('parametroGeneral.jsp?txtAccion=V','Parametro_General','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('parametroGeneral.jsp?txtAccion=V','Parametro_General','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    });
    
});