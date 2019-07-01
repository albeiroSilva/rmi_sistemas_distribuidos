/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.DTO.AnteproyectoDTO;

/**
 *
 * @author USERPC
 */
public interface IntAnteproyectoDAO {
    
    public boolean registrarAnteproyecto(AnteproyectoDTO objAnteproyecto) ;
    public ArrayList<AnteproyectoDTO> listarAnteproyectos() ;
    public AnteproyectoDTO buscarAnteproyecto(int codigo) ;
    public long numeroFilas();
    public boolean cambiarConceptoAnteproyecto(int codigo);
    
}
