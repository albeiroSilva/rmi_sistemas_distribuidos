/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.DTO.AnteproyectoDTO;
import servidor.DTO.EvaluadoresDTO;

/**
 *
 * @author USERPC
 */
public class ClsAnteproyectoDAOImpl implements IntAnteproyectoDAO{

    
    private IntFicheroDAO objFichero;
    private IntEvaluadorDAO objEvaluadorDAO;
    private String archivoAnteproyecto = "servidor\\accesoDatos\\anteproyectos";
    public ClsAnteproyectoDAOImpl() {
        objFichero = new ClsFicheroDAOImpl();
        objEvaluadorDAO = new ClsEvaluadorDAOImpl();
    }
    
    

    @Override
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
        
        String tituloA = "";
        String [] datos = titulo.split(" ");
        for (int i = 0; i < datos.length; i++) {
            tituloA = tituloA+""+datos[i]+"_";
        }
        String estudiante1 = "";
        String [] datos1 = estudiante_1.split(" ");
        for (int i = 0; i < datos1.length; i++) {
            estudiante1 = estudiante1+""+datos1[i]+"_";
        }
        
        String estudiante2 = "";
        String [] datos2 = estudiante_2.split(" ");
        for (int i = 0; i < datos2.length; i++) {
            estudiante2 = estudiante2+""+datos2[i]+"_";
        }
        
        String directorA = "";
        String [] datos3 = director.split(" ");
        for (int i = 0; i < datos3.length; i++) {
            directorA = directorA+""+datos3[i]+"_";
        }
        
        String codirectorA = "";
        String [] datos4 = co_director.split(" ");
        for (int i = 0; i < datos3.length; i++) {
            codirectorA = codirectorA+""+datos4[i]+"_";
        }
        
        String cadena = ""+codigo+" "+tituloA+" "+modalidad+" "+estudiante1+" "+estudiante2+" "+directorA+" "+codirectorA+" "+fechaIngreso+" "+fechaAprobacion+" "+concepto+" "+estado+" "+numeroRevision+""; 
        return cadena;
    }
    
    
    @Override
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
    public AnteproyectoDTO buscarAnteproyecto(int codigo)  {
        

        String anteproyecto = objFichero.buscarFila(codigo, archivoAnteproyecto);
        AnteproyectoDTO objAnteproyecto = null;
        if (anteproyecto == null) {
            objAnteproyecto = null;
        }else{
            String [] datos = anteproyecto.split(" ");
            objAnteproyecto = new AnteproyectoDTO(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3],datos[4],datos[5],datos[6], datos[7],datos[8],Integer.parseInt(datos[9]),Integer.parseInt(datos[10]),Integer.parseInt(datos[11]));
        }
        
        return objAnteproyecto;
    }

    @Override
    public long numeroFilas() {
     
        long numeroDeFilas = objFichero.contarFilas(archivoAnteproyecto);
        return numeroDeFilas;
    }

    @Override
    public boolean cambiarConceptoAnteproyecto(int codigo ) {
        
        boolean bandera = false;
       
        ArrayList<EvaluadoresDTO> listaEvaluadores = objEvaluadorDAO.listarEvaluadores();
        ArrayList<AnteproyectoDTO> listaAnteproyectos = listarAnteproyectos();
       
            for (int i = 0; i < listaEvaluadores.size(); i++) {
                if (listaEvaluadores.get(i).getCodigo() == codigo) {
                  
                    String concepto1 = listaEvaluadores.get(i).getConceptoEvaluador_1();
                    String concepto2 = listaEvaluadores.get(i).getConceptoEvaluador_2();
                    for (int j = 0; j < listaAnteproyectos.size(); j++) {
                        if (listaAnteproyectos.get(j).getCodigo() == codigo) {
                         
                            if (concepto1.equals(Integer.toString(1)) && concepto2.equals(Integer.toString(1))) {
                                listaAnteproyectos.get(j).setConcepto(1);
                               
                                bandera = true;
                            }else if (concepto1.equals(Integer.toString(2)) && concepto2.equals(Integer.toString(2))) {
                                listaAnteproyectos.get(j).setConcepto(2);
                               
                                bandera = true;
                            }else if (concepto1.equals(Integer.toString(1)) && concepto2.equals(Integer.toString(2))) {
                                listaAnteproyectos.get(j).setConcepto(2);
                                bandera = true;
                            }else if (concepto1.equals(Integer.toString(2)) && concepto2.equals(Integer.toString(1))) {
                                listaAnteproyectos.get(j).setConcepto(2);
                                bandera = true;
                                
                            }
                        }
                    }
                }
            }
        
        
        objFichero.borrarArchivo(archivoAnteproyecto);

        for (int i = 0; i < listaAnteproyectos.size(); i++) {
            registrarAnteproyecto(listaAnteproyectos.get(i));
        }     

        
        return bandera;
    }

  

}
