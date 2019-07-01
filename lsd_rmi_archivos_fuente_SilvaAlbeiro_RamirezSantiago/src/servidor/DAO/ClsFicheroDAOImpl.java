/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USERPC
 */
public class ClsFicheroDAOImpl implements IntFicheroDAO{

    public ClsFicheroDAOImpl() {
        
    }
    
    public boolean ExisteArchivo(String parNombre){
        File archivo = new File(parNombre+".txt");
        if (archivo.exists()) {
            
            return true;
        }else{
           
            return false;
        }
    }
    public boolean AgregarFila(String parFila, String archivo) {
        boolean bandera = false;
        if (ExisteArchivo(archivo)) {
            try {
                
                FileWriter fw = new FileWriter(archivo + ".txt", true);
                PrintWriter pr = new PrintWriter(fw);
                pr.println(parFila);
                pr.close();
                fw.close();
                bandera = true;
            } catch (IOException e) {
                bandera = false;
            }
        } else {
            bandera = false;
        }
        return bandera;
    }

    

    @Override
    public ArrayList<String> cargarDatos( String archivo) {
        ArrayList<String> varTuplas = new ArrayList<String>();
        try{
            if (ExisteArchivo(archivo)) {
               
                FileReader fr = new FileReader(archivo+".txt");
                BufferedReader br = new BufferedReader(fr);
                String varLinea;
                while((varLinea = br.readLine())!=null){
                    varTuplas.add(varLinea);
                }
                br.close();
                fr.close();
                return varTuplas;
            }else{
                return null;
            }
            
        }catch(IOException e){
            return null;
        }
    }

    @Override
    public String buscarFila(int numeroFila, String archivo) {
        try{
            
              if (ExisteArchivo(archivo)) {
                FileReader fr = new FileReader(archivo+".txt");
                BufferedReader br = new BufferedReader(fr);
                String varLinea;
                int varPos = 1;
                while((varLinea = br.readLine())!=null){
                    if (varPos==numeroFila-99) {
                        break;
                    }
                    varPos++;
                }
                br.close();
                fr.close();
                return varLinea;
            }else{
                  return null;
              }
            
        }catch(Exception e){
            return null;
         }
    }

    @Override
    public long contarFilas(String archivo) {
         try{
            
            FileReader fr = new FileReader(archivo+".txt");
            BufferedReader br = new BufferedReader(fr);
            long varNumLineas = br.lines().count();
            br.close();
            fr.close();
            return varNumLineas;
        }catch(Exception e){
            return 0;
        }
    }

    @Override
    public boolean reemplazarFila(String fila, String filaNueva, String archivo) {
        boolean bandera = false;
        
        return bandera;
    }

    @Override
    public void borrarArchivo(String archivo) {
        FileOutputStream fso = null; 
        try {
            fso = new FileOutputStream(archivo+".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClsFicheroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            fso.close();
        } catch (IOException ex) {
            Logger.getLogger(ClsFicheroDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
