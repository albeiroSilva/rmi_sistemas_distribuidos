/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DTO;

import java.io.Serializable;



/**
 *
 * @author USERPC
 */
public class UsuarioDTO implements Serializable{
    private String nombreApellidos;
    private int identificacion;
    private String usuarioUnicauca;
    private String contrasenia;
    private String tipoUsuario;

    public UsuarioDTO(String nombreApellidos, int identificacion, String usuarioUnicauca, String contrasenia, String tipoUsuario) {
        this.nombreApellidos = nombreApellidos;
        this.identificacion = identificacion;
        this.usuarioUnicauca = usuarioUnicauca;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getUsuarioUnicauca() {
        return usuarioUnicauca;
    }

    public void setUsuarioUnicauca(String usuarioUnicauca) {
        this.usuarioUnicauca = usuarioUnicauca;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
    
}
