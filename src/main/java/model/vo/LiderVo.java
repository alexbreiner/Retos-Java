/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.vo;

/**
 *
 * @author Alex Delgado
 */
public class LiderVo {
    private int id;
    private String nombre, primerApellido, ciudadResidencia;
    
    public LiderVo() {}

    public LiderVo(int id, String nombre, String primerApellido, String ciudadResidencia) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.ciudadResidencia = ciudadResidencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    @Override
    public String toString() {
        return "Lider{" + "id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", ciudadResidencia=" + ciudadResidencia + '}';
    }
    
}
