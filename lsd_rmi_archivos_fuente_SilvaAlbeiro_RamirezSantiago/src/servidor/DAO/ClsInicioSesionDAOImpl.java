/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.DTO.UsuarioDTO;

/**
 *
 * @author USERPC
 */
public class ClsInicioSesionDAOImpl implements IntInicioDeSesionDAO {

    private IntFicheroDAO objFichero;

    public ClsInicioSesionDAOImpl() {
        objFichero = new ClsFicheroDAOImpl();
    }

    @Override
    public UsuarioDTO verificarCredenciales(String usuario, String contrasenia) {
        String archivo = "servidor\\accesoDatos\\usuarios";
        UsuarioDTO objUsuario = null;
        ArrayList filas = new ArrayList();
        filas = objFichero.cargarDatos(archivo);
        for (int i = 0; i < filas.size(); i++) {
            String dato = (String) filas.get(i);
            String[] datos = dato.split(" ");
            if (usuario.equals(datos[2]) && contrasenia.equals(datos[3])) {

                objUsuario = new UsuarioDTO(datos[0], Integer.parseInt(datos[1]), datos[2], datos[3], datos[4]);
            }
        }
        return objUsuario;
    }

    
}

