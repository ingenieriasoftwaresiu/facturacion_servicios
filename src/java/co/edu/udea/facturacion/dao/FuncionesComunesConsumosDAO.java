/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao;

import co.edu.udea.facturacion.dto.ConsumoAdicional;
import co.edu.udea.facturacion.dto.DescuentoConsumo;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Jorge.correa
 */
public interface FuncionesComunesConsumosDAO {
    public String obtenerServicio(String strIdServicio);
    public String obtenerSubservicio(String strIdSubservicio);
    public String obtenerInsumo(String strIdInsumo);
    public String obtenerUnidadMedida(String strIdUnidad);
    public String obtenerTipoUsuario(String strIdTipoUsuario);
    public String obtenerTipoUsuarioConsumo(String strIdTipoUsuarioConsumo);
    public String obtenerUsuario(String strId, String strTipoUsuario);
    public String obtenerSiNo(String strId);    
    public String validarNulo(Object obj);
    public DescuentoConsumo obtenerDescuentoConsumo(Integer intCodigoConsumo, String strTipoConsumo);
    public List<ConsumoAdicional> obtenerConsumosAdicionales(Integer intCodigoConsumo, String strTipoConsumo);
    public BigDecimal validarUnidadCantidad(String strUnidadOrigen, String strUnidadConsumo, BigDecimal bdCantidadUnidad);
}
