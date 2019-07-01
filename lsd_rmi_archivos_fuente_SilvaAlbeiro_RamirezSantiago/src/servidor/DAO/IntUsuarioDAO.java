/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.DTO.UsuarioDTO;
import servidor.DTO.UsuariosIngresadosDTO;

/**
 *
 * @author USERPC
 */
public interface IntUsuarioDAO {
    
    public boolean registrarUsuario(UsuarioDTO objUsuario);
    public boolean guardarCredencialesUsuario(String usuario, String contrasenia) ;
    public ArrayList<UsuarioDTO> listarUsuarios() ;
    public ArrayList<UsuariosIngresadosDTO> listarUsuariosIngresados();
    public UsuariosIngresadosDTO recuperarUsuario();
}
