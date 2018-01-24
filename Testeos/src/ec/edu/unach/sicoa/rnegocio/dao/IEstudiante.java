package ec.edu.unach.sicoa.rnegocio.dao;

import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.util.*;

public interface IEstudiante {

    public int insertar(Estudiante estudiante) throws Exception;

    public int modificar(Estudiante estudiante) throws Exception;

    public int eliminar(Estudiante estudiante) throws Exception;

    public Estudiante obtener(int codigo) throws Exception;

    public ArrayList<Estudiante> obtener() throws Exception;
}
