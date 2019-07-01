
package servidor.sop_rmi;

import cliente.vistas.ClsCambiarConceptoJefeDD;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import servidor.DAO.ClsAnteproyectoDAOImpl;
import servidor.DAO.ClsEvaluadorDAOImpl;
import servidor.DAO.ClsInicioSesionDAOImpl;
import servidor.DAO.ClsUsuarioDAOImpl;
import servidor.DTO.AnteproyectoDTO;
import servidor.DTO.EvaluadoresDTO;
import servidor.DTO.UsuarioDTO;
import servidor.DTO.UsuariosIngresadosDTO;
import servidor.DAO.IntAnteproyectoDAO;
import servidor.DAO.IntEvaluadorDAO;
import servidor.DAO.IntFicheroDAO;
import servidor.DAO.IntInicioDeSesionDAO;
import servidor.DAO.IntUsuarioDAO;



public class ClsGestionAnteproyectos extends UnicastRemoteObject implements GestionAnteproyectosInt
{ 
    
    private IntAnteproyectoDAO objAnteproyectoDAO;
    private IntUsuarioDAO objUsuarioDAO;
    private IntInicioDeSesionDAO objInicioSesionDAO;
    private IntEvaluadorDAO objEvaluadorDAO;
    private ServidorCllbckInt objServer;
    
    private List<UsuarioCllbckInt> usuarios;
    
    public ClsGestionAnteproyectos() throws RemoteException{
        super();
        objAnteproyectoDAO = new ClsAnteproyectoDAOImpl();
        objUsuarioDAO = new ClsUsuarioDAOImpl();
        objInicioSesionDAO = new ClsInicioSesionDAOImpl();
        objEvaluadorDAO = new ClsEvaluadorDAOImpl();
        objServer = new ServidorCllbckImpl();
        usuarios = new ArrayList<UsuarioCllbckInt>();
    }

    @Override
    public boolean registrarAnteproyecto(AnteproyectoDTO objAnteproyecto) throws RemoteException{
        System.out.println("se está registrando un anteproyecto");
        return objAnteproyectoDAO.registrarAnteproyecto(objAnteproyecto);
         
    }
   
    @Override
    public ArrayList<AnteproyectoDTO> listarAnteproyectos() throws RemoteException {
        System.out.println("se está listando anteproyectos");
        return objAnteproyectoDAO.listarAnteproyectos();
    }

    @Override
    public AnteproyectoDTO buscarAnteproyecto(int codigo) throws RemoteException {
        System.out.println("se está buscando un anteproyecto");
        return objAnteproyectoDAO.buscarAnteproyecto(codigo);
    }

    @Override
    public boolean registrarUsuario(UsuarioDTO objUsuario) throws RemoteException {
        System.out.println("se está registrando un usuario");
        return objUsuarioDAO.registrarUsuario(objUsuario);
    }

    @Override
    public UsuarioDTO verificarCredenciales(String usuario, String contrasenia) throws RemoteException {
        System.out.println("se está verificando los credenciales");
       return objInicioSesionDAO.verificarCredenciales(usuario, contrasenia);
    }

    @Override
    public boolean asignarEvaluador(int codigo, EvaluadoresDTO objEvaluador) throws RemoteException {
        System.out.println("se está asignando un evaluador a un proyecto");
        boolean bandera = false;
        //objServer.notificarUsuarios("perrón");
        if (objEvaluadorDAO.asignarEvaluador(codigo, objEvaluador)) {
            for (int i = 0; i < usuarios.size(); i++) {
                usuarios.get(i).notificar("¡Se le acaba de asignar un proyecto!", codigo);

            }
            bandera = true;
        }

        return bandera;
    }


    @Override
    public long numeroFilas() throws RemoteException {
        
        return objAnteproyectoDAO.numeroFilas();
    }

    @Override
    public EvaluadoresDTO buscarEvaluador(int codigo) throws RemoteException {
        
        return objEvaluadorDAO.buscarEvaluador(codigo);
    }

    @Override
    public boolean cambiarConceptoAnteproyecto(int codigo) throws RemoteException {
        System.out.println("se está cambiando el concepto por parte del jefe de departamento");
        return objAnteproyectoDAO.cambiarConceptoAnteproyecto(codigo);
    }

    @Override
    public boolean guardarCredencialesUsuario(String usuario, String contrasenia) throws RemoteException {
       
        return  objUsuarioDAO.guardarCredencialesUsuario(usuario, contrasenia);
    }

    @Override
    public boolean aniadirConceptoEvaluador(int codigo, int concepto) throws RemoteException {
        System.out.println("se está añadiendo el concepto de un evaluador");
        return objEvaluadorDAO.aniadirConceptoEvaluador(codigo, concepto);
    }

    @Override
    public UsuariosIngresadosDTO recuperarUsuario() throws RemoteException {
        
        return objUsuarioDAO.recuperarUsuario();
    }

    @Override
    public ArrayList<UsuarioDTO> listarUsuarios() throws RemoteException {
        return objUsuarioDAO.listarUsuarios();
    }

    @Override
    public void registrarReferenciaRemota(UsuarioCllbckInt objUsuarioCallback) throws RemoteException {
        this.usuarios.add(objUsuarioCallback);
    }

    @Override
    public ArrayList<EvaluadoresDTO> listarEvaluadores() throws RemoteException {
        return objEvaluadorDAO.listarEvaluadores();
    }
    
}
