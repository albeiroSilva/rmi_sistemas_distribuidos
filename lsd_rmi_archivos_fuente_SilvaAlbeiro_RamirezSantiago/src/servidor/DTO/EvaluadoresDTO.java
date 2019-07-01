/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.DTO;

import java.io.Serializable;



/**
 *
 * @author USERPC
 */
public class EvaluadoresDTO implements Serializable{
    
    private int codigo;
    private String evaluador_1;
    private String conceptoEvaluador_1;
    private String fechaRevision_1;
    private String evaluador_2;
    private String conceptoEvaluador_2;
    private String fechaRevision_2;

    public EvaluadoresDTO(int codigo, String evaluador_1, String conceptoEvaluador_1, String fechaRevision_1, String evaluador_2, String conceptoEvaluador_2, String fechaRevision_2) {
        this.codigo = codigo;
        this.evaluador_1 = evaluador_1;
        this.conceptoEvaluador_1 = conceptoEvaluador_1;
        this.fechaRevision_1 = fechaRevision_1;
        this.evaluador_2 = evaluador_2;
        this.conceptoEvaluador_2 = conceptoEvaluador_2;
        this.fechaRevision_2 = fechaRevision_2;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEvaluador_1() {
        return evaluador_1;
    }

    public void setEvaluador_1(String evaluador_1) {
        this.evaluador_1 = evaluador_1;
    }

    public String getConceptoEvaluador_1() {
        return conceptoEvaluador_1;
    }

    public void setConceptoEvaluador_1(String conceptoEvaluador_1) {
        this.conceptoEvaluador_1 = conceptoEvaluador_1;
    }

    public String getFechaRevision_1() {
        return fechaRevision_1;
    }

    public void setFechaRevision_1(String fechaRevision_1) {
        this.fechaRevision_1 = fechaRevision_1;
    }

    public String getEvaluador_2() {
        return evaluador_2;
    }

    public void setEvaluador_2(String evaluador_2) {
        this.evaluador_2 = evaluador_2;
    }

    public String getConceptoEvaluador_2() {
        return conceptoEvaluador_2;
    }

    public void setConceptoEvaluador_2(String conceptoEvaluador_2) {
        this.conceptoEvaluador_2 = conceptoEvaluador_2;
    }

    public String getFechaRevision_2() {
        return fechaRevision_2;
    }

    public void setFechaRevision_2(String fechaRevision_2) {
        this.fechaRevision_2 = fechaRevision_2;
    }
    
    
}
