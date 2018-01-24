package ec.edu.unach.sicoa.rnegocio.dao;

import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.util.*;

public interface IEvaluacion {

    public int insertar(Evaluacion evaluacion) throws Exception;

    public int modificar(Evaluacion evaluacion) throws Exception;

    public int eliminar(Evaluacion evaluacion) throws Exception;

    public Evaluacion obtener(int codigoEstudiante, int codigoMateria) throws Exception;

    public ArrayList<Evaluacion> obtener() throws Exception;
}
