/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dto;

/**
 *
 * @author George
 */
public class UsuarioConsumidor{
    private String tipoUsuario;
    private String usuario;

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        return result;

    }
 
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
                return true;

        if (obj == null)
                return false;

        if (getClass() != obj.getClass())
                return false;

        UsuarioConsumidor other = (UsuarioConsumidor) obj;

        if (usuario == null) {
                if (other.usuario != null)
                        return false;

        } else if (!usuario.equals(other.usuario))
                return false;

        return true;
    }      
}
