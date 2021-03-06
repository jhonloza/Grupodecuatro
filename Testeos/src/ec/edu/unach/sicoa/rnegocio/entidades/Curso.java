package ec.edu.unach.sicoa.rnegocio.entidades;

public class Curso {

    private int codigo;
    private String descripcion;

    public Curso() {
    }

    public Curso(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion; 
    }
    
}
