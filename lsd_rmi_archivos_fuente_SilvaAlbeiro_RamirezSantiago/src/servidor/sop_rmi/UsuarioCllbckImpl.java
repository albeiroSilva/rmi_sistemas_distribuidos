/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.sop_rmi;

import cliente.vistas.ClsMenuEvaluador;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author USERPC
 */
public class UsuarioCllbckImpl extends UnicastRemoteObject implements UsuarioCllbckInt{

    private ClsMenuEvaluador objMenuE;
    
    public UsuarioCllbckImpl(ClsMenuEvaluador objMenuE) throws RemoteException{
        super();
        this.objMenuE = objMenuE;
    }

    @Override
    public void notificar(String mensaje, int cantidadUsuarios) throws RemoteException {
        System.out.println("mensaje enviado del servidor: "+ mensaje);
        this.objMenuE.mostraNnotificacion(mensaje);
    }
    
    
}
