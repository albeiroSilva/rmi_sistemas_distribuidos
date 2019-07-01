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
public class AnteproyectoDTO implements Serializable{
    
    private int codigo;
    private String titulo;
    private String modalidad;
    private String estudiante_1;
    private String estudiante_2;
    private String director;
    private String co_director;
    private String fechaIngreso;
    private String fechaAprobacion;
    private int concepto;
    private int estado;
    private int numeroRevision;

    public AnteproyectoDTO(int codigo, String titulo, String modalidad, String estudiante_1, String estudiante_2, String director, String co_director, String fechaIngreso, String fechaAprobacion, int concepto, int estado, int numeroRevision) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.modalidad = modalidad;
        this.estudiante_1 = estudiante_1;
        this.estudiante_2 = estudiante_2;
        this.director = director;
        this.co_director = co_director;
        this.fechaIngreso = fechaIngreso;
        this.fechaAprobacion = fechaAprobacion;
        this.concepto = concepto;
        this.estado = estado;
        this.numeroRevision = numeroRevision;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getEstudiante_1() {
        return estudiante_1;
    }

    public void setEstudiante_1(String estudiante_1) {
        this.estudiante_1 = estudiante_1;
    }

    public String getEstudiante_2() {
        return estudiante_2;
    }

    public void setEstudiante_2(String estudiante_2) {
        this.estudiante_2 = estudiante_2;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCo_director() {
        return co_director;
    }

    public void setCo_director(String co_director) {
        this.co_director = co_director;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(String fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public int getConcepto() {
        return concepto;
    }

    public void setConcepto(int concepto) {
        this.concepto = concepto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getNumeroRevision() {
        return numeroRevision;
    }

    public void setNumeroRevision(int numeroRevision) {
        this.numeroRevision = numeroRevision;
    }
    
    
    
    
    
    
}
