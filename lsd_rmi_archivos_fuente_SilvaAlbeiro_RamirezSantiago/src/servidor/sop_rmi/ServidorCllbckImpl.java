/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.sop_rmi;

import static java.rmi.Naming.list;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USERPC
 */
public class ServidorCllbckImpl extends UnicastRemoteObject implements ServidorCllbckInt{
    
    private List<UsuarioCllbckInt> usuarios;

    public ServidorCllbckImpl() throws RemoteException{
        super();
        usuarios = new ArrayList<UsuarioCllbckInt>();
    }
    

    @Override
    public boolean registrarUsuario(UsuarioCllbckInt usuario) throws RemoteException {
        System.out.println("invocando al método registrar usuario");
        boolean bandera = false;
        if (!usuarios.contains(usuario)) {
            bandera = usuarios.add(usuario);
        }
        return bandera;
    }


    public void notificarUsuarios(String mensaje) throws RemoteException {
        int tamanio = usuarios.size();
        for (UsuarioCllbckInt u : usuarios) {
            u.notificar(mensaje, tamanio);
        }
    }
    
}
