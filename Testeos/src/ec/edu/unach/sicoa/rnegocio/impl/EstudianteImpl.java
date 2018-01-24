
package ec.edu.unach.sicoa.rnegocio.impl;

import ec.edu.unach.sicoa.accesoadatos.Conexion;
import ec.edu.unach.sicoa.accesoadatos.Parametro;
import ec.edu.unach.sicoa.rnegocio.dao.ICurso;
import ec.edu.unach.sicoa.rnegocio.dao.IEstudiante;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.sql.*;
import java.util.*;

public class EstudianteImpl implements IEstudiante{
    @Override
    public int insertar(Estudiante estudiante) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO Estudiante(Cod_estudiante, Cedula, Nombre, Apellido, Fecha_nacimiento, Fecha_ingreso, Telefono, Sexo, Direccion, cod_c) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, estudiante.getCodigo()));
        listParametro.add(new Parametro(2, estudiante.getCedula()));
        listParametro.add(new Parametro(3, estudiante.getNombres()));
        listParametro.add(new Parametro(4, estudiante.getApellidos()));
        if (estudiante.getFechaNacimiento() instanceof java.util.Date) {
            listParametro.add(new Parametro(5, new java.sql.Date(((java.util.Date) estudiante.getFechaNacimiento()).getTime())));
        } else {
            listParametro.add(new Parametro(5, estudiante.getFechaNacimiento()));
        }
        if (estudiante.getFechaInreso()instanceof java.util.Date) {
            listParametro.add(new Parametro(6, new java.sql.Date(((java.util.Date) estudiante.getFechaInreso()).getTime())));
        } else {
            listParametro.add(new Parametro(6, estudiante.getFechaInreso()));
        }
        listParametro.add(new Parametro(7, estudiante.getTelefono()));
        listParametro.add(new Parametro(8, estudiante.getSexo()));
        listParametro.add(new Parametro(9, estudiante.getDireccion()!=null?estudiante.getDireccion():null));
        listParametro.add(new Parametro(10, estudiante.getCurso().getCodigo()));
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
        String sql = "UPDATE Estudiante SET Cod_estudiante=?, Cedula=?, Nombre=?, Apellido=?, Fecha_nacimiento=?, Fecha_ingreso=?, Telefono=?, Sexo=?, Direccion=?, cod_c=? WHERE Cod_estudiante=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, estudiante.getCodigo()));
        listParametro.add(new Parametro(2, estudiante.getCedula()));
        listParametro.add(new Parametro(3, estudiante.getNombres()));
        listParametro.add(new Parametro(4, estudiante.getApellidos()));
        if (estudiante.getFechaNacimiento() instanceof java.util.Date) {
            listParametro.add(new Parametro(5, new java.sql.Date(((java.util.Date) estudiante.getFechaNacimiento()).getTime())));
        } else {
            listParametro.add(new Parametro(5, estudiante.getFechaNacimiento()));
        }
        if (estudiante.getFechaInreso()instanceof java.util.Date) {
            listParametro.add(new Parametro(6, new java.sql.Date(((java.util.Date) estudiante.getFechaInreso()).getTime())));
        } else {
            listParametro.add(new Parametro(6, estudiante.getFechaInreso()));
        }
        listParametro.add(new Parametro(7, estudiante.getTelefono()));
        listParametro.add(new Parametro(8, estudiante.getSexo()));
        listParametro.add(new Parametro(9, estudiante.getDireccion()));
        listParametro.add(new Parametro(10, estudiante.getCurso().getCodigo()));
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
        String sql = "DELETE FROM Estudiante WHERE codigo=?";
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
        String sql = "SELECT Cod_estudiante, Cedula, Nombre, Apellido, Fecha_nacimiento, Fecha_ingreso, Telefono, Sexo, Direccion, cod_c FROM Estudiante where Cod_estudiante = ?";
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
                estudiante.setDireccion(resultado.getString(9));
                //estudiante.setDireccion(resultado.getObject(9)!=null? resultado.getString(9):null);
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
        String sql = "SELECT Cod_estudiante, Cedula, Nombre, Apellido, Fecha_nacimiento, Fecha_ingreso, Telefono, Sexo, Direccion, cod_c FROM Estudiante";
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
                estudiante.setDireccion(resultado.getString(9));
                //estudiante.setDireccion(resultado.getObject(9)!=null? resultado.getString(9):null);
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
