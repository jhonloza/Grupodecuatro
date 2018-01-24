package ec.edu.unach.sicoa.rnegocio.dao;

import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.util.*;

public interface IMateria {

    public int insertar(Materia materia) throws Exception;

    public int modificar(Materia materia) throws Exception;

    public int eliminar(Materia materia) throws Exception;

    public Materia obtener(int codigo) throws Exception;

    public ArrayList<Materia> obtener() throws Exception;
}
