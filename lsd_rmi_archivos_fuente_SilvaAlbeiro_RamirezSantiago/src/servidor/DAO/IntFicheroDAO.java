/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.util.ArrayList;


/**
 *
 * @author USERPC
 */
public interface IntFicheroDAO {
    
    public boolean AgregarFila(String cadena, String archivo);
    public boolean ExisteArchivo(String nombreArchivo);
    public ArrayList cargarDatos(String archivo);
    public String buscarFila(int numeroFila, String archivo);
    public long contarFilas(String archivo);
    public boolean reemplazarFila(String fila, String filaNueva,String archivo);
    public void borrarArchivo(String archivo);
}
