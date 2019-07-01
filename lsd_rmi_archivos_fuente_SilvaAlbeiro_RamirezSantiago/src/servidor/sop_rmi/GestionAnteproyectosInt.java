


package servidor.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import servidor.DTO.AnteproyectoDTO;
import servidor.DTO.EvaluadoresDTO;
import servidor.DTO.UsuarioDTO;
import servidor.DTO.UsuariosIngresadosDTO;

//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface GestionAnteproyectosInt extends Remote
{
    public UsuarioDTO verificarCredenciales(String usuario, String contrasenia)throws RemoteException;
    public boolean registrarAnteproyecto(AnteproyectoDTO objAnteproyecto) throws RemoteException;
    public boolean registrarUsuario(UsuarioDTO objUsuario) throws RemoteException;
    public ArrayList<AnteproyectoDTO> listarAnteproyectos() throws RemoteException;
    public AnteproyectoDTO buscarAnteproyecto(int codigo) throws RemoteException;
    public boolean asignarEvaluador(int codigo, EvaluadoresDTO objEvaluador) throws RemoteException;
    public long numeroFilas()throws RemoteException;
    public EvaluadoresDTO buscarEvaluador(int codigo) throws RemoteException;
    public boolean cambiarConceptoAnteproyecto( int codigo) throws RemoteException;
    public boolean guardarCredencialesUsuario(String usuario, String contrasenia) throws RemoteException;
    public boolean aniadirConceptoEvaluador(int codigo, int concepto)throws RemoteException;
    public UsuariosIngresadosDTO recuperarUsuario()throws RemoteException;
    public ArrayList<UsuarioDTO> listarUsuarios() throws RemoteException;
    public void registrarReferenciaRemota(UsuarioCllbckInt objUsuarioCallback)throws RemoteException;
    public ArrayList<EvaluadoresDTO> listarEvaluadores() throws RemoteException;
   
}

