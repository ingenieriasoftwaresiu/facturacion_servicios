/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cargarCalendariosBusqueda(){
    setCalendario("txtFechaInicio","imgFechaInicio");
    setCalendario("txtFechaFin","imgFechaFin");
}

function actualizarDatos(strAccion){    
    AJAXC("POST","Visualizacion","txtAccion=" + strAccion+"&txtEvento=","dMostrar");
}

function abrirDetalleConsumo(strCodigo, strTipoConsumo){
    
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('detalleConsumo.jsp?txtConsecutivo='+strCodigo+'&txtTipoConsumo='+strTipoConsumo,'Detalle_Consumo','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
    }

    if (nav == "Firefox"){        
        window.open('detalleConsumo.jsp?txtConsecutivo='+strCodigo+'&txtTipoConsumo='+strTipoConsumo,'Detalle_Consumo','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){        
        window.open('detalleConsumo.jsp?txtConsecutivo='+strCodigo+'&txtTipoConsumo='+strTipoConsumo,'Detalle_Consumo','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
    }    
    
}

function abrirDetalleCuentaCobro(strCodigo){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('detalleCuentaCobro.jsp?keyCC='+strCodigo,'Detalle_Cuenta_Cobro','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
    }

    if (nav == "Firefox"){        
        window.open('detalleCuentaCobro.jsp?keyCC='+strCodigo,'Detalle_Cuenta_Cobro','toolbar=yes,location=no,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){        
        window.open('detalleCuentaCobro.jsp?keyCC='+strCodigo,'Detalle_Cuenta_Cobro','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
    }
}

function abrirUnidadMedida(strCodigo){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('unidadMedida.jsp?txtAccion=V&keyCC='+strCodigo,'Unidad_Medida','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
    }

    if (nav == "Firefox"){        
        window.open('unidadMedida.jsp?txtAccion=V&keyCC='+strCodigo,'Unidad_Medida','toolbar=yes,location=no,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){        
        window.open('unidadMedida.jsp?txtAccion=V&keyCC='+strCodigo,'Unidad_Medida','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
    }
}

function abrirTipoUsuario(strCodigo){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('tipoUsuario.jsp?txtAccion=V&keyCC='+strCodigo,'Tipo_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
    }

    if (nav == "Firefox"){        
        window.open('tipoUsuario.jsp?txtAccion=V&keyCC='+strCodigo,'Tipo_Usuario','toolbar=yes,location=no,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){        
        window.open('tipoUsuario.jsp?txtAccion=V&keyCC='+strCodigo,'Tipo_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
    }
}

function abrirTipoFacturacion(strCodigo){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('tipoFacturacion.jsp?txtAccion=V&keyCC='+strCodigo,'Tipo_Facturacion','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
    }

    if (nav == "Firefox"){        
        window.open('tipoFacturacion.jsp?txtAccion=V&keyCC='+strCodigo,'Tipo_Facturacion','toolbar=yes,location=no,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){        
        window.open('tipoFacturacion.jsp?txtAccion=V&keyCC='+strCodigo,'Tipo_Facturacion','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');
    }
}

function abrirItemAdicional(strCodigo){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('itemAdicional.jsp?txtAccion=V&keyCC='+strCodigo,'Item_Adicional','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
    }

    if (nav == "Firefox"){
        window.open('itemAdicional.jsp?txtAccion=V&keyCC='+strCodigo,'Item_Adicional','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){
        window.open('itemAdicional.jsp?txtAccion=V&keyCC='+strCodigo,'Item_Adicional','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
    }
}

function abrirInsumoServicio(strCodigo){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('insumoServicio.jsp?txtAccion=V&keyCC='+strCodigo,'Insumo_Servicio','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
    }

    if (nav == "Firefox"){
        window.open('insumoServicio.jsp?txtAccion=V&keyCC='+strCodigo,'Insumo_Servicio','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){
        window.open('insumoServicio.jsp?txtAccion=V&keyCC='+strCodigo,'Insumo_Servicio','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
    }
}

function abrirRolUsuario(strCodigo){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('rolUsuario.jsp?txtAccion=V&keyCC='+strCodigo,'Rol_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
    }

    if (nav == "Firefox"){
        window.open('rolUsuario.jsp?txtAccion=V&keyCC='+strCodigo,'Rol_Usuario','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){
        window.open('rolUsuario.jsp?txtAccion=V&keyCC='+strCodigo,'Rol_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
    }
}

function abrirRolXUsuario(strIdRol, strIdUsuario){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('rolPorUsuario.jsp?txtAccion=V&keyCC='+strIdRol+'&keyCC2='+strIdUsuario,'Rol_X_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
    }

    if (nav == "Firefox"){
        window.open('rolPorUsuario.jsp?txtAccion=V&keyCC='+strIdRol+'&keyCC2='+strIdUsuario,'Rol_X_Usuario','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){
        window.open('rolPorUsuario.jsp?txtAccion=V&keyCC='+strIdRol+'&keyCC2='+strIdUsuario,'Rol_X_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
    }
}

function abrirSubservicio(strCodigo){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('subservicio.jsp?txtAccion=V&keyCC='+strCodigo,'Subservicio','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
    }

    if (nav == "Firefox"){
        window.open('subservicio.jsp?txtAccion=V&keyCC='+strCodigo,'Subservicio','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){
        window.open('subservicio.jsp?txtAccion=V&keyCC='+strCodigo,'Subservicio','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
    }
}

function abrirServicioXUnidad(strCodigo){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('servicioPorUnidad.jsp?txtAccion=V&keyCC='+strCodigo,'Servicio_X_Unidad','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
    }

    if (nav == "Firefox"){
        window.open('servicioPorUnidad.jsp?txtAccion=V&keyCC='+strCodigo,'Servicio_X_Unidad','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){
        window.open('servicioPorUnidad.jsp?txtAccion=V&keyCC='+strCodigo,'Servicio_X_Unidad','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
    }
}

function abrirServicioXTipoUsuario(strCodigo){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('servicioPorTipoUsuario.jsp?txtAccion=V&keyCC='+strCodigo,'Servicio_X_TipoUsuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
    }

    if (nav == "Firefox"){
        window.open('servicioPorTipoUsuario.jsp?txtAccion=V&keyCC='+strCodigo,'Servicio_X_TipoUsuario','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){
        window.open('servicioPorTipoUsuario.jsp?txtAccion=V&keyCC='+strCodigo,'Servicio_X_TipoUsuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
    }
}

function abrirServicioXInsumo(strCodigo){
    var nav = detectarNav();
         
    if ((nav == "IE") || (nav == "-1")){
        window.open('servicioPorInsumo.jsp?txtAccion=V&keyCC='+strCodigo,'Servicio_X_Insumo','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
    }

    if (nav == "Firefox"){
        window.open('servicioPorInsumo.jsp?txtAccion=V&keyCC='+strCodigo,'Servicio_X_Insumo','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
    }

    if (nav == "Chrome"){
        window.open('servicioPorInsumo.jsp?txtAccion=V&keyCC='+strCodigo,'Servicio_X_Insumo','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
    }
}

function cargarSubservicio(){
    var strIdServicio = document.frmBusqueda.cbServicio.value;
               
    if (strIdServicio != "-1"){
        var dataString = "txtAccion=SUBSERVICIO&txtIdServicio="+strIdServicio;
        AJAX("POST","Acciones",dataString,"dSubservicio");
    }
}

function cargarUsuario(){
    var strIdTipoUsuario = document.frmBusqueda.cbTipoUsuario.value;
               
    if (strIdTipoUsuario != "-1"){
        var dataString = "txtAccion=USUARIO&txtIdTipoUsuario="+strIdTipoUsuario;
        AJAX("POST","Acciones",dataString,"dUsuario");
    }
}

function filtrarRegistros(strAccion){
    
    var strTipoUsuario = $("#cbTipoUsuario").val();
    var strUsuario = $("#cbUsuario").val();
    var strFechainicio = $("#txtFechaInicio").val();
    var strFechaFin = $("#txtFechaFin").val();    
    
    if ((strAccion == "consumos_insumos") || (strAccion == "consumos_tipos_usuario") || (strAccion == "consumos_unidades")){
        var strServicio = $("#cbServicio").val();
        var strSubservicio = $("#cbSubservicio").val();

        if(strServicio == "-1" && strSubservicio == "-1" && strTipoUsuario == "-1" && strUsuario == "-1" && strFechainicio == "" && strFechaFin == ""){
            alert("No se ha seleccionado ningún filtro. Por favor seleccione al menos un filtro para continuar.");
            return false;
        }else{

            if (strFechainicio != ""){
                if (strFechaFin == ""){
                    alert("Debe diligenciar también la fecha de fin del periodo.");
                    return false;
                }
            }

            if (strFechaFin != ""){
                if (strFechainicio == ""){
                    alert("Debe diligenciar también la fecha de inicio del periodo.");
                    return false;
                }
            }        

            var dataString = "txtAccion=" + strAccion + "&txtEvento=busqueda&txtServicio="+strServicio+"&txtSubservicio="+strSubservicio+"&txtTipoUsuario="+strTipoUsuario+"&txtUsuario="+strUsuario+"&txtFechaInicio="+strFechainicio+"&txtFechaFin="+strFechaFin;
            AJAX("POST","Visualizacion",dataString,"dMostrar");
        }    
    }
    
    if (strAccion == "cuentascobro"){
        var strConsecutivo = $("#txtConsecutivo").val();
        var strNumSoporte = $("#txtNumSoporte").val();
        
        if(strConsecutivo == "" && strNumSoporte == "" && strTipoUsuario == "-1" && strUsuario == "-1" && strFechainicio == "" && strFechaFin == ""){
            alert("No se ha seleccionado ningún filtro. Por favor seleccione al menos un filtro para continuar.");
            return false;
        }else{

            if (strFechainicio != ""){
                if (strFechaFin == ""){
                    alert("Debe diligenciar también la fecha de fin del periodo.");
                    return false;
                }
            }

            if (strFechaFin != ""){
                if (strFechainicio == ""){
                    alert("Debe diligenciar también la fecha de inicio del periodo.");
                    return false;
                }
            }        

            var dataString = "txtAccion=" + strAccion + "&txtEvento=busqueda&txtConsecutivo="+strConsecutivo+"&txtNumSoporte="+strNumSoporte+"&txtTipoUsuario="+strTipoUsuario+"&txtUsuario="+strUsuario+"&txtFechaInicio="+strFechainicio+"&txtFechaFin="+strFechaFin;
            AJAX("POST","Visualizacion",dataString,"dMostrar");
        } 
    }
}

function crearRegistro(strAccion){
        
    if (strAccion == "consumos_insumos"){
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
    }
    
    if (strAccion == "consumos_tipos_usuario"){
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
    }
    
    if (strAccion == "consumos_unidades"){
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
    }
    
    if (strAccion == "cuentascobro"){
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
    }
    
    if (strAccion == "unidad_medida"){
        var nav = detectarNav();
         
        if ((nav == "IE") || (nav == "-1")){
            window.open('unidadMedida.jsp?txtAccion=C','Unidad_Medida','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('unidadMedida.jsp?txtAccion=C','Unidad_Medida','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('unidadMedida.jsp?txtAccion=C','Unidad_Medida','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    }   
    
    if (strAccion == "tipo_usuario"){
        var nav = detectarNav();
         
        if ((nav == "IE") || (nav == "-1")){
            window.open('tipoUsuario.jsp?txtAccion=C','Tipo_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('tipoUsuario.jsp?txtAccion=C','Tipo_Usuario','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('tipoUsuario.jsp?txtAccion=C','Tipo_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    }
    
    if (strAccion == "tipo_facturacion"){
        var nav = detectarNav();
         
        if ((nav == "IE") || (nav == "-1")){
            window.open('tipoFacturacion.jsp?txtAccion=C','Tipo_Facturacion','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('tipoFacturacion.jsp?txtAccion=C','Tipo_Facturacion','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('tipoFacturacion.jsp?txtAccion=C','Tipo_Facturacion','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    }
    
    if (strAccion == "item_adicional"){
        var nav = detectarNav();
         
        if ((nav == "IE") || (nav == "-1")){
            window.open('itemAdicional.jsp?txtAccion=C','Item_Adicional','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('itemAdicional.jsp?txtAccion=C','Item_Adicional','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('itemAdicional.jsp?txtAccion=C','Item_Adicional','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    }
    
    if (strAccion == "insumo_servicio"){
        var nav = detectarNav();
         
        if ((nav == "IE") || (nav == "-1")){
            window.open('insumoServicio.jsp?txtAccion=C','Insumo_Servicio','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('insumoServicio.jsp?txtAccion=C','Insumo_Servicio','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('insumoServicio.jsp?txtAccion=C','Insumo_Servicio','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    }
    
    if (strAccion == "rol_usuario"){
        var nav = detectarNav();
         
        if ((nav == "IE") || (nav == "-1")){
            window.open('rolUsuario.jsp?txtAccion=C','Rol_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('rolUsuario.jsp?txtAccion=C','Rol_Usuario','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('rolUsuario.jsp?txtAccion=C','Rol_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    }
    
    if (strAccion == "rol_por_usuario"){
        var nav = detectarNav();
         
        if ((nav == "IE") || (nav == "-1")){
            window.open('rolPorUsuario.jsp?txtAccion=C','Rol_X_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('rolPorUsuario.jsp?txtAccion=C','Rol_X_Usuario','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('rolPorUsuario.jsp?txtAccion=C','Rol_X_Usuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    }
    
    if (strAccion == "subservicio"){
        var nav = detectarNav();
         
        if ((nav == "IE") || (nav == "-1")){
            window.open('subservicio.jsp?txtAccion=C','Subservicio','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('subservicio.jsp?txtAccion=C','Subservicio','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('subservicio.jsp?txtAccion=C','Subservicio','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    }
    
    if (strAccion == "servicios_por_unidades"){
        var nav = detectarNav();

        if ((nav == "IE") || (nav == "-1")){
            window.open('servicioPorUnidad.jsp?txtAccion=C','Serv_X_Uni','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('servicioPorUnidad.jsp?txtAccion=C','Serv_X_Uni','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('servicioPorUnidad.jsp?txtAccion=C','Serv_X_Uni','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    }    
    
    if (strAccion == "servicios_por_tipos_usuario"){
        var nav = detectarNav();

        if ((nav == "IE") || (nav == "-1")){
            window.open('servicioPorTipoUsuario.jsp?txtAccion=C','Serv_X_TipoUsuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('servicioPorTipoUsuario.jsp?txtAccion=C','Serv_X_TipoUsuario','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('servicioPorTipoUsuario.jsp?txtAccion=C','Serv_X_TipoUsuario','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    }
    
    if (strAccion == "servicios_por_insumos"){
        var nav = detectarNav();

        if ((nav == "IE") || (nav == "-1")){
            window.open('servicioPorInsumo.jsp?txtAccion=C','Serv_X_Insumo','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');           
        }

        if (nav == "Firefox"){
            window.open('servicioPorInsumo.jsp?txtAccion=C','Serv_X_Insumo','toolbar=yes,location=yes,directories=no,status=no,menubar=no, resizable=yes, fullscreen=yes,scrollbars=yes');
        }

        if (nav == "Chrome"){
            window.open('servicioPorInsumo.jsp?txtAccion=C','Serv_X_Insumo','top=0,left=0,width='+(screen.availWidth)+',height ='+(screen.availHeight)+',scrollbars=yes');   
        }
    }
        
}

