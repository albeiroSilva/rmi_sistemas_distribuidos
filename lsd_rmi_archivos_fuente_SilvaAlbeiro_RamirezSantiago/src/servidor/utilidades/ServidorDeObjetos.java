/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.utilidades;


import java.rmi.RemoteException;
import servidor.sop_rmi.ClsGestionAnteproyectos;
import servidor.sop_rmi.ServidorCllbckImpl;


public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {
        
         
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
        
               
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
     
        ClsGestionAnteproyectos objRemoto = new ClsGestionAnteproyectos();
        
        try
        {
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoUsuarios");            
         //  UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoInicioSesion, direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoInicioSesion");            

        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
        
        
    }
}
