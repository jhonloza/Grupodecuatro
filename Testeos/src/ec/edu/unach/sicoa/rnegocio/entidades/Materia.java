
package ec.edu.unach.sicoa.rnegocio.entidades;

public class Materia {
    private int codigo;
    private String nombre;

    public Materia() {
    }

    public Materia(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
