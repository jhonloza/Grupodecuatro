
package ec.edu.unach.sicoa.test;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.util.*;
import java.sql.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class DocenteTest {
    
    public DocenteTest() {
    }
    @Test
    public void TestGenetal() {
        IDocente docenteDao = new DocenteImpl();

// TEST INSERTAR
        int filas = 0;
        Docente doc = new Docente(1, "321654987", "andres", "orozco", "321654987", "riobamba", "c", "M", new java.util.Date(), new java.util.Date(), 253);
        try {
            filas = docenteDao.insertar(doc);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);
//
//            //TEST OBTENER POR CODIGO
////        
        Docente docent = new Docente();
        try {
            docent = docenteDao.obtener(1);
            System.out.println(docent.getCodigo()+ "    " + docent.getCedula()+ "    " + docent.getNombres()+ "    " + docent.getApellidos()+ "    " + docent.getTelefono()+ "    " + docent.getDireccion()+ "    " + docent.getCategoria()+ "    " + docent.getSexo()+ "    " + docent.getFechaNacimiento()+ "    " + docent.getFechaIngreso()+ "    " + docent.getSalario());
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }
        assertEquals(docent!=null, true);

//            //TEST LISTADO
        ArrayList<Docente> docentes = new ArrayList<>();
        try {
            docentes = docenteDao.obtener();
            System.out.println("Docentes");

            for (Docente docente : docentes) {
                System.out.println(docente.getCodigo()+ "    " + docente.getCedula()+ "    " + docente.getNombres()+ "    " + docente.getApellidos()+ "    " + docente.getTelefono()+ "    " + docente.getDireccion()+ "    " + docente.getCategoria()+ "    " + docente.getSexo()+ "    " + docente.getFechaNacimiento()+ "    " + docente.getFechaIngreso()+ "    " + docente.getSalario());
            }
        } catch (Exception e) {
        }
        assertTrue(docentes.size()>0);

    }
}
