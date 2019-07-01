/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.sop_rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author USERPC
 */
public interface ServidorCllbckInt extends Remote{
    
    public boolean registrarUsuario(UsuarioCllbckInt usuario) throws RemoteException;
    public void notificarUsuarios(String mensaje) throws RemoteException;
}
