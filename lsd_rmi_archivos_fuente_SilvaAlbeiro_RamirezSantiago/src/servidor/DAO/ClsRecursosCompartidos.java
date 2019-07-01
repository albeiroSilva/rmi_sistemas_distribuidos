/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.util.ArrayList;
import servidor.DTO.AnteproyectoDTO;

/**
 *
 * @author USERPC
 */
public class ClsRecursosCompartidos implements IntRecursosCompartidos{

    private IntFicheroDAO objFichero;
    private String archivoAnteproyecto = "servidor\\accesoDatos\\anteproyectos";
    public ClsRecursosCompartidos() {
        objFichero = new ClsFicheroDAOImpl();
    }
    

    @Override
    public void cambiarNumeroDeRevision(int codigo) {

       int numeroRevision = 0;
        ArrayList<AnteproyectoDTO> listaAnteproyectos = listarAnteproyectos();
        for (int i = 0; i < listaAnteproyectos.size(); i++) {
            if (listaAnteproyectos.get(i).getCodigo() == codigo) {
                listaAnteproyectos.get(i).setNumeroRevision(numeroRevision +1);
            }
        }

        objFichero.borrarArchivo(archivoAnteproyecto);

        for (int i = 0; i < listaAnteproyectos.size(); i++) {
            registrarAnteproyecto(listaAnteproyectos.get(i));
        }
     
    }
    
  
    @Override
    public void cambiarEstadoAnteproyecto(int codigo) {
        
        ArrayList<AnteproyectoDTO> listaAnteproyectos = listarAnteproyectos();
        for (int i = 0; i < listaAnteproyectos.size(); i++) {
            if (listaAnteproyectos.get(i).getCodigo() == codigo) {
                listaAnteproyectos.get(i).setEstado(2);
            }
        }

        objFichero.borrarArchivo(archivoAnteproyecto);

        for (int i = 0; i < listaAnteproyectos.size(); i++) {
            registrarAnteproyecto(listaAnteproyectos.get(i));
        }
     
    }

     public boolean registrarAnteproyecto(AnteproyectoDTO objAnteproyecto) {
        
        
        boolean bandera = false;
        String cadena = generarCadenaAnteproyecto(objAnteproyecto);
        
        
        if(objFichero.AgregarFila(cadena, archivoAnteproyecto)){
            bandera = true;
        }
        return bandera;
    }
    public String generarCadenaAnteproyecto(AnteproyectoDTO objAnteproyecto){
       
        String codigo = Integer.toString(objAnteproyecto.getCodigo());
        String titulo = objAnteproyecto.getTitulo();
        String modalidad = objAnteproyecto.getModalidad();
        String estudiante_1 = objAnteproyecto.getEstudiante_1();
        String estudiante_2 = objAnteproyecto.getEstudiante_2();
        String director = objAnteproyecto.getDirector();
        String co_director = objAnteproyecto.getCo_director();
        String fechaIngreso = objAnteproyecto.getFechaIngreso();
        String fechaAprobacion = objAnteproyecto.getFechaAprobacion();
        String concepto = Integer.toString(objAnteproyecto.getConcepto());
        String estado = Integer.toString(objAnteproyecto.getEstado());
        String numeroRevision = Integer.toString(objAnteproyecto.getNumeroRevision());
        
        String cadena = ""+codigo+" "+titulo+" "+modalidad+" "+estudiante_1+" "+estudiante_2+" "+director+" "+co_director+" "+fechaIngreso+" "+fechaAprobacion+" "+concepto+" "+estado+" "+numeroRevision+""; 
        return cadena;
    }
    public ArrayList<AnteproyectoDTO> listarAnteproyectos()  {

        ArrayList anteproyectos = new ArrayList();
        
        ArrayList<AnteproyectoDTO> listaAnteproyectos = new ArrayList<AnteproyectoDTO>();
        anteproyectos = objFichero.cargarDatos(archivoAnteproyecto);
        
        AnteproyectoDTO objAnteproyecto = null;
        for (int i = 0; i < anteproyectos.size(); i++) {
            String dato = (String) anteproyectos.get(i);
            String [] datos = dato.split(" ");
            objAnteproyecto = new AnteproyectoDTO(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3],datos[4],datos[5],datos[6], datos[7],datos[8],Integer.parseInt(datos[9]),Integer.parseInt(datos[10]),Integer.parseInt(datos[11]));
            listaAnteproyectos.add(objAnteproyecto);
        }
        
        return listaAnteproyectos;
    }

    @Override
    public void cambiarEstadoAnteproyectoDos(int codigo) {

        ArrayList<AnteproyectoDTO> listaAnteproyectos = listarAnteproyectos();
        for (int i = 0; i < listaAnteproyectos.size(); i++) {
            if (listaAnteproyectos.get(i).getCodigo() == codigo) {
                if (listaAnteproyectos.get(i).getEstado() == 2) {
                    listaAnteproyectos.get(i).setEstado(3);
                    listaAnteproyectos.get(i).setNumeroRevision(1);
                }else if (listaAnteproyectos.get(i).getEstado() == 3) {
                    listaAnteproyectos.get(i).setEstado(4);
                    listaAnteproyectos.get(i).setNumeroRevision(2);
                }
            }
        }

        objFichero.borrarArchivo(archivoAnteproyecto);

        for (int i = 0; i < listaAnteproyectos.size(); i++) {
            registrarAnteproyecto(listaAnteproyectos.get(i));
        }
    }
    
}
