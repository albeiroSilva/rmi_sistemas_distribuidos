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
public interface IntRecursosCompartidos {
    public void cambiarNumeroDeRevision(int codigo);
    public void cambiarEstadoAnteproyecto(int codigo);
    public boolean registrarAnteproyecto(AnteproyectoDTO objAnteproyecto) ;
    public ArrayList<AnteproyectoDTO> listarAnteproyectos() ;
    public void cambiarEstadoAnteproyectoDos(int codigo);
}
