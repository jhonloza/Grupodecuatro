package ec.edu.unach.sicoa.vistas;

import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.util.Date;

public class Estudiante {

    private int codigo;
    private String cedula;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private Date fechaInreso;
    private String telefono;
    private String sexo;
    private String direccion;
    private Curso curso;

    public Estudiante() {
    }

    public Estudiante(int codigo, String cedula, String nombres, String apellidos, Date fechaNacimiento, Date fechaInreso, String telefono, String sexo, String direccion, Curso curso) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInreso = fechaInreso;
        this.telefono = telefono;
        this.sexo = sexo;
        this.direccion = direccion;
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaInreso() {
        return fechaInreso;
    }

    public void setFechaInreso(Date fechaInreso) {
        this.fechaInreso = fechaInreso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
