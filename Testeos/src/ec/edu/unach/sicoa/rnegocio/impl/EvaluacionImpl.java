
package ec.edu.unach.sicoa.rnegocio.impl;
import ec.edu.unach.sicoa.accesoadatos.*;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.util.*;
import java.sql.*;
public class EvaluacionImpl implements IEvaluacion{

    @Override
    public int insertar(Evaluacion evaluacion) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO Evaluacion(Aporte1, Aporte2, Total, Asistencia, Equivalencia, Codigo_estudiante, Codigo_materia, Codigo_docente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, evaluacion.getNota1()));
        listParametro.add(new Parametro(2, evaluacion.getNota2()));
        listParametro.add(new Parametro(3, evaluacion.getTotal()));
        listParametro.add(new Parametro(4, evaluacion.getAsistencia()));
        listParametro.add(new Parametro(5, evaluacion.getEquivalencia()));
        listParametro.add(new Parametro(6, evaluacion.getEstudiante().getCodigo()));
        listParametro.add(new Parametro(7, evaluacion.getMateria().getCodigo()));
        listParametro.add(new Parametro(8, evaluacion.getDocente().getCodigo()));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutarComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Evaluacion evaluacion) throws Exception {
int numFilasAfectadas = 0;
        String sql = "UPDATE Evaluacion SET Aporte1=?, Aporte2=?, Total=?, Asistencia=?, Equivalencia=?, Codigo_estudiante=?, Codigo_materia=?, Codigo_docente=? WHERE Codigo_estudiante=?, Codigo_materia=?, Codigo_docente=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, evaluacion.getNota1()));
        listParametro.add(new Parametro(2, evaluacion.getNota2()));
        listParametro.add(new Parametro(3, evaluacion.getTotal()));
        listParametro.add(new Parametro(4, evaluacion.getAsistencia()));
        listParametro.add(new Parametro(5, evaluacion.getEquivalencia()));
        listParametro.add(new Parametro(6, evaluacion.getEstudiante().getCodigo()));
        listParametro.add(new Parametro(7, evaluacion.getMateria().getCodigo()));
        listParametro.add(new Parametro(8, evaluacion.getDocente().getCodigo()));
        Conexion conec=null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas=conec.ejecutarComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec !=null){
            conec.desconectar();}
        }
        return numFilasAfectadas;    
    }

    @Override
    public int eliminar(Evaluacion evaluacion) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Evaluacion WHERE Codigo_estudiante=?, Codigo_materia=?, Codigo_docente=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, evaluacion.getEstudiante().getCodigo()));
        listParametro.add(new Parametro(1, evaluacion.getMateria().getCodigo()));
        listParametro.add(new Parametro(1, evaluacion.getDocente().getCodigo()));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutarComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return numFilasAfectadas;
    }

    @Override
    public Evaluacion obtener(int codigoEstudiante, int codigoMateria, int codigoDocente) throws Exception {
        Evaluacion evaluacion = null;
        Estudiante nEstudiante=null;
        IEstudiante estDao=new EstudianteImpl();
        Materia nMateria=null;
        IMateria mateDao=new MateriaImpl();
        Docente nDocente=null;
        IDocente doceDao=new DocenteImpl();
        String sql = "SELECT Aporte1, Aporte2, Total, Asistencia, Equivalencia, Codigo_estudiante, Codigo_materia, Codigo_docente FROM Evaluacion where Codigo_estudiante=?, Codigo_materia=?, Codigo_docente=?";
        ArrayList<Parametro> listadoParametros = new ArrayList<>();
        listadoParametros.add(new Parametro(1, codigoEstudiante));
        listadoParametros.add(new Parametro(1, codigoMateria));
        listadoParametros.add(new Parametro(1, codigoDocente));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, listadoParametros);
            while (resultado.next()) {
                evaluacion = new Evaluacion();
                evaluacion.setNota1(resultado.getDouble(1));
                evaluacion.setNota2(resultado.getDouble(2));
                evaluacion.setTotal(resultado.getInt(3));
                evaluacion.setAsistencia(resultado.getInt(4));
                evaluacion.setEquivalencia(resultado.getString(5));
                nEstudiante=new Estudiante();
                nEstudiante=estDao.obtener(resultado.getInt(6));
                evaluacion.setEstudiante(nEstudiante);
                nMateria=new Materia();
                nMateria=mateDao.obtener(resultado.getInt(7));
                evaluacion.setMateria(nMateria);
                nDocente=new Docente();
                nDocente=doceDao.obtener(resultado.getInt(8));
                evaluacion.setDocente(nDocente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return evaluacion;
    }

    @Override
    public ArrayList<Evaluacion> obtener() throws Exception {
        ArrayList<Evaluacion> lista = new ArrayList<>();
        Estudiante nEstudiante=null;
        IEstudiante estDao=new EstudianteImpl();
        Materia nMateria=null;
        IMateria mateDao=new MateriaImpl();
        Docente nDocente=null;
        IDocente doceDao=new DocenteImpl();
        String sql = "SELECT Aporte1, Aporte2, Total, Asistencia, Equivalencia, Codigo_estudiante, Codigo_materia, Codigo_docente FROM Evaluacion";
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, null);
            Evaluacion evaluacion=null;
            while (resultado.next()) {
                evaluacion = new Evaluacion();
                evaluacion.setNota1(resultado.getDouble(1));
                evaluacion.setNota2(resultado.getDouble(2));
                evaluacion.setTotal(resultado.getInt(3));
                evaluacion.setAsistencia(resultado.getInt(4));
                evaluacion.setEquivalencia(resultado.getString(5));
                nEstudiante=new Estudiante();
                nEstudiante=estDao.obtener(resultado.getInt(6));
                evaluacion.setEstudiante(nEstudiante);
                nMateria=new Materia();
                nMateria=mateDao.obtener(resultado.getInt(7));
                evaluacion.setMateria(nMateria);
                nDocente=new Docente();
                nDocente=doceDao.obtener(resultado.getInt(8));
                evaluacion.setDocente(nDocente);
                lista.add(evaluacion);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return lista;
    }
    
}
