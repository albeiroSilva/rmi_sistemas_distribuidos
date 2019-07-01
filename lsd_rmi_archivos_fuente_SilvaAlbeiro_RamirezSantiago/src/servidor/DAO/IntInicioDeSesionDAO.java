/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.rmi.RemoteException;
import servidor.DTO.UsuarioDTO;

/**
 *
 * @author USERPC
 */
public interface IntInicioDeSesionDAO {
    
    public UsuarioDTO verificarCredenciales(String usuario, String contrasenia) ;
}
