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
public interface UsuarioCllbckInt extends Remote{
    
    public void notificar(String mensaje, int cantidadUsuarios) throws RemoteException;
}
