
package ec.edu.unach.sicoa.rnegocio.impl;

import ec.edu.unach.sicoa.accesoadatos.Conexion;
import ec.edu.unach.sicoa.accesoadatos.Parametro;
import ec.edu.unach.sicoa.rnegocio.dao.ICurso;
import ec.edu.unach.sicoa.rnegocio.dao.IEstudiante;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EstudianteImpl implements IEstudiante{
    @Override
    public int insertar(Estudiante estudiante) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO estudiante(codigo, cedula, nombres, apellidos, fecha_nac, fecha_ingreso, telefono, sexo, direccion, curso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, estudiante.getCodigo()));
        listParametro.add(new Parametro(2, estudiante.getCedula()));
        listParametro.add(new Parametro(3, estudiante.getNombres()));
        listParametro.add(new Parametro(4, estudiante.getApellidos()));
        listParametro.add(new Parametro(5, estudiante.getFechaNacimiento()));
        listParametro.add(new Parametro(6, estudiante.getFechaInreso()));
        listParametro.add(new Parametro(7, estudiante.getTelefono()));
        listParametro.add(new Parametro(8, estudiante.getSexo()));
        listParametro.add(new Parametro(9, estudiante.getDireccion()!=null?estudiante.getDireccion():null));
        listParametro.add(new Parametro(10, estudiante.getCurso()));
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
    public int modificar(Estudiante estudiante) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE estudiante SET codigo=?, cedula=?, nombres=?, apellidos=?, fecha_nac=?, fecha_ingreso=?, telefono=?, sexo=?, direccion=?, curso=? WHERE codigo=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, estudiante.getCodigo()));
        listParametro.add(new Parametro(2, estudiante.getCedula()));
        listParametro.add(new Parametro(3, estudiante.getNombres()));
        listParametro.add(new Parametro(4, estudiante.getApellidos()));
        listParametro.add(new Parametro(5, estudiante.getFechaNacimiento()));
        listParametro.add(new Parametro(6, estudiante.getFechaInreso()));
        listParametro.add(new Parametro(7, estudiante.getTelefono()));
        listParametro.add(new Parametro(8, estudiante.getSexo()));
        listParametro.add(new Parametro(9, estudiante.getDireccion()));
        listParametro.add(new Parametro(10, estudiante.getCurso()));
        listParametro.add(new Parametro(11, estudiante.getCodigo()));
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
    public int eliminar(Estudiante estudiante) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM estudiante WHERE codigo=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, estudiante.getCodigo()));
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
    public Estudiante obtener(int codigo) throws Exception {
        Estudiante estudiante = null;
        String sql = "SELECT codigo, cedula, nombres, apellidos, fecha_nac, fecha_ingreso, telefono, sexo, direccion, curso FROM estudiante where codigo = ?";
        ArrayList<Parametro> listadoParametros = new ArrayList<>();
        listadoParametros.add(new Parametro(1, codigo));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, null);
            while (resultado.next()) {
                estudiante = new Estudiante();
                estudiante.setCodigo(resultado.getInt(1));
                estudiante.setCedula(resultado.getString(2));
                estudiante.setNombres(resultado.getString(3));
                estudiante.setApellidos(resultado.getString(4));
                estudiante.setFechaNacimiento(resultado.getDate(5));
                estudiante.setFechaInreso(resultado.getDate(6));
                estudiante.setTelefono(resultado.getString(7));
                estudiante.setSexo(resultado.getString(8));
                estudiante.setDireccion(resultado.getObject(9)!=null? resultado.getString(9):null);
                ICurso cursodao=new CursoImpl();
                Curso curso=cursodao.obtener(resultado.getInt(10));
                estudiante.setCurso(curso);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return estudiante;
    }

    @Override
    public ArrayList<Estudiante> obtener() throws Exception {
        ArrayList<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT codigo, cedula, nombres, apellidos, fecha_nac, fecha_ingreso, telefono, sexo, direccion, curso FROM estudiante";
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, null);
            Estudiante estudiante=null;
            while (resultado.next()) {
                estudiante = new Estudiante();
                estudiante.setCodigo(resultado.getInt(1));
                estudiante.setCedula(resultado.getString(2));
                estudiante.setNombres(resultado.getString(3));
                estudiante.setApellidos(resultado.getString(4));
                estudiante.setFechaNacimiento(resultado.getDate(5));
                estudiante.setFechaInreso(resultado.getDate(6));
                estudiante.setTelefono(resultado.getString(7));
                estudiante.setSexo(resultado.getString(8));
                estudiante.setDireccion(resultado.getObject(9)!=null? resultado.getString(9):null);
                ICurso cursodao=new CursoImpl();
                Curso curso=cursodao.obtener(resultado.getInt(10));
                estudiante.setCurso(curso);
                lista.add(estudiante);
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
