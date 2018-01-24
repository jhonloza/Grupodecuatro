package ec.edu.unach.sicoa.rnegocio.dao;

import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.util.*;

public interface ICurso {

    public int insertar(Curso curso) throws Exception;

    public int modificar(Curso curso) throws Exception;

    public int eliminar(Curso curso) throws Exception;

    public Curso obtener(int codigo) throws Exception;

    public ArrayList<Curso> obtener() throws Exception;
}
