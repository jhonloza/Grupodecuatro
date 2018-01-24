
package ec.edu.unach.sicoa.rnegocio.impl;

import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.accesoadatos.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.util.*;
import java.sql.*;

public class MateriaImpl implements IMateria{

    @Override
    public int insertar(Materia materia) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO Materia(Cod_Materia, Nombre) VALUES (?, ?)";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, materia.getCodigo()));
        listParametro.add(new Parametro(2, materia.getNombre()));
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
    public int modificar(Materia materia) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE Materia SET Cod_Materia=?, Nombre=? WHERE Cod_Materia=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, materia.getCodigo()));
        listParametro.add(new Parametro(2, materia.getNombre()));
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
    public int eliminar(Materia materia) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Materia WHERE Cod_Materia=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, materia.getCodigo()));
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
    public Materia obtener(int codigo) throws Exception {
        Materia materia = null;
        String sql = "SELECT Cod_Materia, Nombre FROM Materia where Cod_Materia = ?";
        ArrayList<Parametro> listadoParametros = new ArrayList<>();
        listadoParametros.add(new Parametro(1, codigo));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, listadoParametros);
            while (resultado.next()) {
                materia = new Materia();
                materia.setCodigo(resultado.getInt(1));
                materia.setNombre(resultado.getString(2));
                }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return materia;
    }

    @Override
    public ArrayList<Materia> obtener() throws Exception {
        ArrayList<Materia> lista = new ArrayList<>();
        String sql = "SELECT Cod_Materia, Nombre FROM Materia";
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, null);
            Materia materia=null;
            while (resultado.next()) {
                materia = new Materia();
                materia.setCodigo(resultado.getInt(1));
                materia.setNombre(resultado.getString(2));
                lista.add(materia);
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
