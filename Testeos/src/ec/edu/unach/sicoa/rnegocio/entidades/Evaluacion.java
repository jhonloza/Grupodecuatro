package ec.edu.unach.sicoa.rnegocio.entidades;

import java.util.Date;

public class Evaluacion {

    private double nota1;
    private double nota2;
    private int total;
    private int asistencia;
    private String equivalencia;
    private Estudiante estudiante;
    private Docente docente;
    private Materia materia;

    public Evaluacion() {
    }

    public Evaluacion(double nota1, double nota2, int total, int asistencia, String equivalencia, Estudiante estudiante, Docente docente, Materia materia) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.total = total;
        this.asistencia = asistencia;
        this.equivalencia = equivalencia;
        this.estudiante = estudiante;
        this.docente = docente;
        this.materia = materia;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public String getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(String equivalencia) {
        this.equivalencia = equivalencia;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

}
