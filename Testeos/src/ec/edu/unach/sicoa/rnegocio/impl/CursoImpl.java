package ec.edu.unach.sicoa.rnegocio.impl;

import ec.edu.unach.sicoa.accesoadatos.*;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.util.*;
import java.sql.*;

public class CursoImpl implements ICurso {

    @Override
    public int insertar(Curso curso) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into \"Curso\" (codigo, descripcion) values (?,?)";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, curso.getCodigo()));
        listParametro.add(new Parametro(2, curso.getDescripcion()!=null?curso.getDescripcion():null));
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
    public int modificar(Curso curso) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE \"Curso\" SET codigo=?, descripcion=? WHERE codigo=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, curso.getCodigo()));
        listParametro.add(new Parametro(2, curso.getDescripcion()));
        listParametro.add(new Parametro(1, curso.getCodigo()));
        Conexion conec=null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas=conec.ejecutarComando(sql, listParametro);
        } catch (Exception e) {
        }finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Curso curso) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM \"Curso\" WHERE codigo=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, curso.getCodigo()));
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
    public Curso obtener(int codigo) throws Exception {
        Curso curso = null;
        String sql = "SELECT codigo, descripcion FROM \"Curso\" where codigo=?";
        ArrayList<Parametro> listadoParametros = new ArrayList<>();
        listadoParametros.add(new Parametro(1, codigo));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, null);
            while (resultado.next()) {
                curso = new Curso();
                curso.setCodigo(resultado.getInt(1));
                curso.setDescripcion(resultado.getString(2));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return curso;
    }

    @Override
    public ArrayList<Curso> obtener() throws Exception {
        ArrayList<Curso> lista = new ArrayList<>();
        String sql = "SELECT codigo, descripcion FROM Curso";
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, null);
            Curso curso = null;
            while (resultado.next()) {
                curso.setCodigo(resultado.getInt(1));
                curso.setDescripcion(resultado.getString(2));
                lista.add(curso);
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
