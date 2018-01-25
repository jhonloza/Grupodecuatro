
package ec.edu.unach.sicoa.rnegocio.impl;
import ec.edu.unach.sicoa.accesoadatos.*;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.sql.*;
import java.util.*;
public class DocenteImpl implements IDocente{
    @Override
    public int insertar(Docente docente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO Docente(codigo, cedula, nombres, apellidos, fecha_nac, fecha_ingreso, telefono, sexo, direccion, curso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, docente.getCodigo()));
        listParametro.add(new Parametro(2, docente.getCedula()));
        listParametro.add(new Parametro(3, docente.getNombres()));
        listParametro.add(new Parametro(4, docente.getApellidos()));
        listParametro.add(new Parametro(5, docente.getTelefono()));
        listParametro.add(new Parametro(6, docente.getDireccion()));
        listParametro.add(new Parametro(7, docente.getCategoria()));
        listParametro.add(new Parametro(8, docente.getSexo()));
        if (docente.getFechaNacimiento() instanceof java.util.Date) {
            listParametro.add(new Parametro(9, new java.sql.Date(((java.util.Date) docente.getFechaNacimiento()).getTime())));
        } else {
            listParametro.add(new Parametro(9, docente.getFechaNacimiento()));
        }
        if (docente.getFechaIngreso()instanceof java.util.Date) {
            listParametro.add(new Parametro(10, new java.sql.Date(((java.util.Date) docente.getFechaIngreso()).getTime())));
        } else {
            listParametro.add(new Parametro(10, docente.getFechaIngreso()));
        }
        listParametro.add(new Parametro(11, docente.getSalario()));
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
    public int modificar(Docente docente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE docente SET codigo=?, cedula=?, nombres=?, apellidos=?, fecha_nac=?, fecha_ingreso=?, telefono=?, sexo=?, direccion=?, curso=? WHERE codigo=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, docente.getCodigo()));
        listParametro.add(new Parametro(2, docente.getCedula()));
        listParametro.add(new Parametro(3, docente.getNombres()));
        listParametro.add(new Parametro(4, docente.getApellidos()));
        listParametro.add(new Parametro(5, docente.getTelefono()));
        listParametro.add(new Parametro(6, docente.getDireccion()));
        listParametro.add(new Parametro(7, docente.getCategoria()));
        listParametro.add(new Parametro(8, docente.getSexo()));
        if (docente.getFechaNacimiento() instanceof java.util.Date) {
            listParametro.add(new Parametro(9, new java.sql.Date(((java.util.Date) docente.getFechaNacimiento()).getTime())));
        } else {
            listParametro.add(new Parametro(9, docente.getFechaNacimiento()));
        }
        if (docente.getFechaIngreso()instanceof java.util.Date) {
            listParametro.add(new Parametro(10, new java.sql.Date(((java.util.Date) docente.getFechaIngreso()).getTime())));
        } else {
            listParametro.add(new Parametro(10, docente.getFechaIngreso()));
        }
        listParametro.add(new Parametro(11, docente.getSalario()));
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
    public int eliminar(Docente docente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM docente WHERE codigo=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, docente.getCodigo()));
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
    public Docente obtener(int codigo) throws Exception {
        Docente docente = null;
        String sql = "SELECT codigo, cedula, nombres, apellidos, fecha_nac, fecha_ingreso, telefono, sexo, direccion, curso FROM docente where codigo = ?";
        ArrayList<Parametro> listadoParametros = new ArrayList<>();
        listadoParametros.add(new Parametro(1, codigo));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, listadoParametros);
            while (resultado.next()) {
                docente = new Docente();
                docente.setCodigo(resultado.getInt(1));
                docente.setCedula(resultado.getString(2));
                docente.setNombres(resultado.getString(3));
                docente.setApellidos(resultado.getString(4));
                docente.setTelefono(resultado.getString(5));
                docente.setDireccion(resultado.getString(6));
                docente.setCategoria(resultado.getString(7));
                docente.setSexo(resultado.getString(8));
                docente.setFechaNacimiento(resultado.getDate(9));
                docente.setFechaIngreso(resultado.getDate(10));
                docente.setSalario(resultado.getDouble(11));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return docente;
    }

    @Override
    public ArrayList<Docente> obtener() throws Exception {
        ArrayList<Docente> lista = new ArrayList<>();
        String sql = "SELECT codigo, cedula, nombres, apellidos, fecha_nac, fecha_ingreso, telefono, sexo, direccion, curso FROM docente";
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, null);
            Docente docente=null;
            while (resultado.next()) {
                docente = new Docente();
                docente.setCodigo(resultado.getInt(1));
                docente.setCedula(resultado.getString(2));
                docente.setNombres(resultado.getString(3));
                docente.setApellidos(resultado.getString(4));
                docente.setTelefono(resultado.getString(5));
                docente.setDireccion(resultado.getString(6));
                docente.setCategoria(resultado.getString(7));
                docente.setSexo(resultado.getString(8));
                docente.setFechaNacimiento(resultado.getDate(9));
                docente.setFechaIngreso(resultado.getDate(10));
                docente.setSalario(resultado.getDouble(11));
                lista.add(docente);
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
