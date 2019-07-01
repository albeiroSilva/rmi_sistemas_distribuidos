/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DAO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.DTO.EvaluadoresDTO;

/**
 *
 * @author USERPC
 */
public interface IntEvaluadorDAO {
    
    public boolean asignarEvaluador(int codigo, EvaluadoresDTO objEvaluador);
    public boolean registrarEvaluador(EvaluadoresDTO objEvaluador) ;
    public EvaluadoresDTO buscarEvaluador(int codigo) ;
    public ArrayList<EvaluadoresDTO> listarEvaluadores();
    public boolean aniadirConceptoEvaluador(int codigo, int concepto);
}
