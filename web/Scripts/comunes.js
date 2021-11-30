/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function detectarNav(){

    if (navigator.userAgent.indexOf('MSIE') !=-1) {
      return "IE";
    } else if (navigator.userAgent.indexOf('Firefox') !=-1) {
      return "Firefox";
    } else if (navigator.userAgent.indexOf('Chrome') !=-1) {
      return "Chrome";
    } else if (navigator.userAgent.indexOf('Opera') !=-1) {
      return "Opera";
    } else {
      return "-1";
    }    
}

function setFocus(strNombreCampo){
    $("#" + strNombreCampo).focus();
}

function validarCampoVacio(campo,nombre){
	
    if (campo.value == ""){
            return nombre + "\n";
    }	
    return "";	
}

function validarCampoSelect(campo,nombre){
    if (campo.selectedIndex == 0){
        return nombre + "\n";
    }
    return "";
}

function cerrarSesion(){
    window.location = "cerrar.jsp";
}

function salir(){
    window.close();
}

function obtiene_fecha() {  
      
    var fecha_actual = new Date()  
  
    var dia = fecha_actual.getDate();  
    var mes = fecha_actual.getMonth() + 1;
    var anio = fecha_actual.getFullYear();  
  
    if (mes < 10)  
        mes = '0' + mes;  
  
    if (dia < 10)  
        dia = '0' + dia; 
  
    return (anio + "-" + mes + "-" + dia);
}

function sumarDiasFecha(fecha,nroDias){
    var sumarDias=parseInt(nroDias);  
    fecha=fecha.replace("-", "/").replace("-", "/");	  

    fecha= new Date(fecha);
    fecha.setDate(fecha.getDate()+sumarDias);

    var anio=fecha.getFullYear();
    var mes= fecha.getMonth()+1;
    var dia= fecha.getDate();

    if(mes.toString().length<2){
      mes="0".concat(mes);        
    }    

    if(dia.toString().length<2){
      dia="0".concat(dia);        
    }

    return (anio+"-"+mes+"-"+dia);
}

function setCalendario(campo,imagen){
    Calendar.setup({
        inputField: campo,
        ifFormat: "%Y-%m-%d",
        button: imagen,
        align: "TI",
        singleClick: true
    });
}

function deleteSpecialSigns(strCadena){   
    
    strCadena = strCadena.replace("#","Nro.");   
    
    return strCadena;
    
}

function trim(strCadena){
    
    return strCadena.replace(/^\s+/g,'').replace(/\s+$/g,'');
}


function validarSiNumero(numero){
    var numero = false;
    
    if (!/^([0-9])*$/.test(numero)){
        numero = false;
    }else{
        numero = true;
    }        
  }
  
  function validarNumero(numero){
      if( isNaN(numero) ) {
             return false;
      }else{
          return true;
      }
  }
  
  function replaceCadena(cadena, strIni, strFin){
      var rest = cadena.replace(strIni,strFin).replace(strIni,strFin); 
      return rest;
  }
  
 function replaceAll(find, replace, str) {
  return str.replace(new RegExp(find, 'g'), replace);
}
   
 function restaFechas(strFecha1,strFecha2) {
     
     // Convertir las fechas a dd/mm/aaaa.
    var f1 = cambiarFormatoFecha(strFecha1,"dd/mm/aaaa");
    var f2 = cambiarFormatoFecha(strFecha2,"dd/mm/aaaa");       
     
    var aFecha1 = f1.split('/'); 
    var aFecha2 = f2.split('/'); 
    var fFecha1 = Date.UTC(aFecha1[2],aFecha1[1]-1,aFecha1[0]); 
    var fFecha2 = Date.UTC(aFecha2[2],aFecha2[1]-1,aFecha2[0]); 
    var dif = fFecha2 - fFecha1;
    var dias = Math.floor(dif / (1000 * 60 * 60 * 24)); 
    return dias;
 }
 
 /*
  * Función que cambia una fecha en formato aaaa-mm-dd a otros formatos.  
  */
 
 function cambiarFormatoFecha(strFecha, strFormato){
              
     var arrDatos = strFecha.split("-");
     var anio = arrDatos[0];
     var mes = arrDatos[1];
     var dia = arrDatos[2];
     
     switch(strFormato){
        case 'dd/mm/aaaa': return dia+"/"+mes+"/"+anio ;break;
        case 'dd-mm-aaaa': return dia+"-"+mes+"-"+anio ;break;
     }
 }

/**
     * Funcion que devuelve true o false dependiendo de si la fecha es correcta.
     * Tiene que recibir el dia, mes y año
     */
    function isValidDate(day,month,year)
    {
        var dteDate;
        
        // En javascript, el mes empieza en la posicion 0 y termina en la 11
        // siendo 0 el mes de enero
        // Por esta razon, tenemos que restar 1 al mes
        month=month-1;
        // Establecemos un objeto Data con los valore recibidos
        // Los parametros son: año, mes, dia, hora, minuto y segundos
        // getDate(); devuelve el dia como un entero entre 1 y 31
        // getDay(); devuelve un num del 0 al 6 indicando siel dia es lunes, 
        // martes, miercoles ...
        // getHours(); Devuelve la hora
        // getMinutes(); Devuelve los minutos
        // getMonth(); devuelve el mes como un numero de 0 a 11
        // getTime(); Devuelve el tiempo transcurrido en milisegundos desde el
        // 1 de enero de 1970 hasta 
        // el momento definido en el objeto date
        // setTime(); Establece una fecha pasandole en milisegundos el valor de esta.
        // getYear(); devuelve el año
        // getFullYear(); devuelve el año
        dteDate=new Date(year,month,day);
        
        //Devuelva true o false...
        return ((day==dteDate.getDate()) && (month==dteDate.getMonth()) && (year==dteDate.getFullYear()));
    }
    
function popupCentrado(url,nombre,ancho,alto) {
    var posicion_x; 
    var posicion_y; 
    posicion_x=(screen.width/2)-(ancho/2); 
    posicion_y=(screen.height/2)-(alto/2); 
    window.open(url, nombre, "width="+ancho+",height="+alto+",menubar=0,toolbar=0,directories=0,scrollbars=yes,resizable=no,left="+posicion_x+",top="+posicion_y+"");
}
   

