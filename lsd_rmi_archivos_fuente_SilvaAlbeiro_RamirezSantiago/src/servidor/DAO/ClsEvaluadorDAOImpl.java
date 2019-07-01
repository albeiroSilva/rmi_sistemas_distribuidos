/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.DTO.EvaluadoresDTO;
import servidor.DTO.UsuarioDTO;
import servidor.DTO.UsuariosIngresadosDTO;

/**
 *
 * @author USERPC
 */
public class ClsEvaluadorDAOImpl implements IntEvaluadorDAO {

    private IntFicheroDAO objFichero;
    private IntUsuarioDAO objUsuario;
    private IntRecursosCompartidos ObjRecursos;
    private String archivoEvaluador = "servidor\\accesoDatos\\evaluadores";
    private String archivoAnteproyecto = "servidor\\accesoDatos\\anteproyectos";
    public ClsEvaluadorDAOImpl() {
        objFichero = new ClsFicheroDAOImpl();
        objUsuario = new ClsUsuarioDAOImpl();
        ObjRecursos = new ClsRecursosCompartidos();
    }

    @Override
    public boolean asignarEvaluador(int codigo, EvaluadoresDTO objEvaluador) {
        boolean bandera = false;

        int estado1 = 1;
        ArrayList<EvaluadoresDTO> listaEvaluadores = listarEvaluadores();

            for (int i = 0; i < listaEvaluadores.size(); i++) {
                if (codigo == listaEvaluadores.get(i).getCodigo()) {
                    estado1 = 0;
                   
                }
            }

            String cadena = generarCadenaEvaluador(objEvaluador);

            if (estado1 == 1) {
                if (objFichero.AgregarFila(cadena, archivoEvaluador)) {

                    bandera = true;

                }
            } else {
                bandera = false;
            }
        
        if (bandera) {
            ObjRecursos.cambiarEstadoAnteproyecto(codigo);
        }
        return bandera;
    }

    public String generarCadenaEvaluador(EvaluadoresDTO objEvaluador) {

        String codigo = Integer.toString(objEvaluador.getCodigo());
        String evaluador_1 = objEvaluador.getEvaluador_1();
        String conceptoEvaluador_1 = objEvaluador.getConceptoEvaluador_1();
        String fechaRevision_1 = objEvaluador.getFechaRevision_1();
        String evaluador_2 = objEvaluador.getEvaluador_2();
        String conceptoEvaluador_2 = objEvaluador.getConceptoEvaluador_2();
        String fechaRevision_2 = objEvaluador.getFechaRevision_2();

        String cadena = "" + codigo + " " + evaluador_1 + " " + conceptoEvaluador_1 + " " + fechaRevision_1 + " " + evaluador_2 + " " + conceptoEvaluador_2 + " " + fechaRevision_2 + " ";
        return cadena;
    }

    @Override
    public EvaluadoresDTO buscarEvaluador(int codigo)  {

        String parCodigo = Integer.toString(codigo);
        EvaluadoresDTO objEvaluador = null;
        ArrayList<String> filas  = objFichero.cargarDatos(archivoEvaluador);
        for (int i = 0; i < filas.size(); i++) {
            String dato = (String) filas.get(i);
            String[] datos = dato.split(" ");
            if (parCodigo.equals(datos[0])) {

                objEvaluador = new EvaluadoresDTO(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
            }
        }
        return objEvaluador;
    }

    @Override
    public ArrayList<EvaluadoresDTO> listarEvaluadores()  {

        ArrayList evaluadores = new ArrayList();

        ArrayList<EvaluadoresDTO> listaEvaluadores = new ArrayList<EvaluadoresDTO>();
        evaluadores = objFichero.cargarDatos(archivoEvaluador);

        EvaluadoresDTO objAnteproyecto = null;
        for (int i = 0; i < evaluadores.size(); i++) {
            String dato = (String) evaluadores.get(i);
            String[] datos = dato.split(" ");
            objAnteproyecto = new EvaluadoresDTO(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
            listaEvaluadores.add(objAnteproyecto);
        }

        return listaEvaluadores;
    }
    public long numeroFilas()  {
        long numeroDeFilas = objFichero.contarFilas(archivoAnteproyecto);
        return numeroDeFilas;
    }
    @Override
    public boolean aniadirConceptoEvaluador(int codigo, int concepto) {
        
        //realizar validación para que el evaluador sea evaluador de ese anteproyecto
        boolean bandera = false;

        ArrayList<EvaluadoresDTO> listaEvaluadores = listarEvaluadores();
        ArrayList<UsuarioDTO> listaUsuarios = objUsuario.listarUsuarios();
        ArrayList<UsuariosIngresadosDTO> listaUsuariosIngresados = objUsuario.listarUsuariosIngresados();

            
            for (int i = 0; i < listaEvaluadores.size(); i++) {
                if (listaEvaluadores.get(i).getCodigo() == codigo) {

                    String evaluador1 = listaEvaluadores.get(i).getEvaluador_1();
                    String evaluador2 = listaEvaluadores.get(i).getEvaluador_2();

                    String usuarioUnicaiuca1 = "";
                    String usuarioUnicaiuca2 = "";
                    String contrasenia1 = "";
                    String contrasenia2 = "";

                    
                    for (int j = 0; j < listaUsuarios.size(); j++) {
                        if (listaUsuarios.get(j).getNombreApellidos().equals(evaluador1)) {

                            usuarioUnicaiuca1 = listaUsuarios.get(j).getUsuarioUnicauca();
                            contrasenia1 = listaUsuarios.get(j).getContrasenia();
                            
                        }
                        if (listaUsuarios.get(j).getNombreApellidos().equals(evaluador2)) {
                            
                            usuarioUnicaiuca2 = listaUsuarios.get(j).getUsuarioUnicauca();
                            contrasenia2 = listaUsuarios.get(j).getContrasenia();
                        }
                    }
                    int tamanio = listaUsuariosIngresados.size();
                    if (usuarioUnicaiuca1.equals(listaUsuariosIngresados.get(tamanio - 1).getUsuario()) && contrasenia1.equals(listaUsuariosIngresados.get(tamanio - 1).getContrasenia())) {
                        listaEvaluadores.get(i).setConceptoEvaluador_1(Integer.toString(concepto));
                        ObjRecursos.cambiarEstadoAnteproyectoDos(codigo);
                        bandera = true;
                    }
                    if (usuarioUnicaiuca2.equals(listaUsuariosIngresados.get(tamanio - 1).getUsuario()) && contrasenia2.equals(listaUsuariosIngresados.get(tamanio - 1).getContrasenia())) {
                        listaEvaluadores.get(i).setConceptoEvaluador_2(Integer.toString(concepto));
                        ObjRecursos.cambiarEstadoAnteproyectoDos(codigo);
                        bandera = true;
                    }              
                    
                }
            }
        
        objFichero.borrarArchivo(archivoEvaluador);

        for (int i = 0; i < listaEvaluadores.size(); i++) {
            registrarEvaluador(listaEvaluadores.get(i));
        }
        
        ObjRecursos.cambiarNumeroDeRevision(codigo);
        
        return bandera;

    }

    @Override
    public boolean registrarEvaluador(EvaluadoresDTO objEvaluador)  {
        boolean bandera = false;

        String cadena = generarCadenaEvaluador(objEvaluador);
        if (objFichero.AgregarFila(cadena, archivoEvaluador)) {
            bandera = true;
        }

        return bandera;
    }

}
