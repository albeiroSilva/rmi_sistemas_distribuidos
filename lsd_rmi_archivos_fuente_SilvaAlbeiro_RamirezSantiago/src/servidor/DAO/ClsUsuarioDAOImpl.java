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
public class ClsUsuarioDAOImpl implements IntUsuarioDAO{

    private IntFicheroDAO objFichero;
    private String archivoUsuarios = "servidor\\accesoDatos\\usuarios";
    private String archivoUsuariosIngresados = "servidor\\accesoDatos\\usuariosIngresados";
    public ClsUsuarioDAOImpl() {
        objFichero = new ClsFicheroDAOImpl();
    }
    
    

    @Override
    public boolean registrarUsuario(UsuarioDTO objUsuario) {

        boolean bandera = false;
        ArrayList<UsuarioDTO> listaUsuarios = listarUsuarios();
        String cadena = generarCadenaUsuario(objUsuario);
        int estado = 0;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (objUsuario.getIdentificacion() == listaUsuarios.get(i).getIdentificacion()) {
                bandera = false;
            } else {
                estado = 1;
            }
        }
        if (estado == 1) {
            if (objFichero.AgregarFila(cadena, archivoUsuarios)) {
                    bandera = true;
                }
        }

        return bandera;
    }
    
    public String generarCadenaUsuario(UsuarioDTO objUsuario){
        
        String nombres = objUsuario.getNombreApellidos();
        String identificacion = Integer.toString(objUsuario.getIdentificacion());
        String usuarioUnicauca = objUsuario.getUsuarioUnicauca();
        String contrasenia = objUsuario.getContrasenia();
        String tipoUsuario = objUsuario.getTipoUsuario();
        
        String nombreA = "";
        String [] datos = nombres.split(" ");
        for (int i = 0; i < datos.length; i++) {
            nombreA = nombreA+""+datos[i]+"_";
        }
        
        String cadena = ""+nombreA+" "+identificacion+" "+usuarioUnicauca+" "+contrasenia+" "+tipoUsuario+""; 
        return cadena;
    }

    @Override
    public boolean guardarCredencialesUsuario(String usuario, String contrasenia)  {
        
        boolean bandera = false;

        String cadena = ""+usuario+" "+contrasenia+"";
        if (objFichero.AgregarFila(cadena, archivoUsuariosIngresados)) {
            bandera = true;
        }
        return  bandera;
    }

    @Override
    public ArrayList<UsuarioDTO> listarUsuarios()  {

        ArrayList usuarios = new ArrayList();
        
        ArrayList<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();
        usuarios = objFichero.cargarDatos(archivoUsuarios);
        
        UsuarioDTO objUsuario = null;
        for (int i = 0; i < usuarios.size(); i++) {
            String dato = (String) usuarios.get(i);
            String [] datos = dato.split(" ");
            objUsuario = new UsuarioDTO(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3],datos[4]);
            listaUsuarios.add(objUsuario);
        }
        
        return listaUsuarios;
    }

    @Override
    public ArrayList<UsuariosIngresadosDTO> listarUsuariosIngresados()  {

        ArrayList usuariosIngresados = new ArrayList();
        
        ArrayList<UsuariosIngresadosDTO> listaUsuariosIngresados = new ArrayList<UsuariosIngresadosDTO>();
        usuariosIngresados = objFichero.cargarDatos(archivoUsuariosIngresados);
        
        UsuariosIngresadosDTO objUsuario = null;
        for (int i = 0; i < usuariosIngresados.size(); i++) {
            String dato = (String) usuariosIngresados.get(i);
            String [] datos = dato.split(" ");
            objUsuario = new UsuariosIngresadosDTO(datos[0],datos[1]);
            listaUsuariosIngresados.add(objUsuario);
        }
        
        return listaUsuariosIngresados;
    }

    @Override
    public UsuariosIngresadosDTO recuperarUsuario() {
        ArrayList<UsuariosIngresadosDTO> listaUsuariosIngresados = listarUsuariosIngresados();
        int tamanio = listaUsuariosIngresados.size();
        UsuariosIngresadosDTO objUsuario = listaUsuariosIngresados.get(tamanio-1);
        return  objUsuario;
    }
    
}
