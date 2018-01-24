package ec.edu.unach.sicoa.test;

import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.util.*;
import java.sql.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CursoTest {
    
    public CursoTest() {
    }
    @Test
    public void TestGeneral(){
        ICurso cursoDao = new CursoImpl();

// TEST INSERTAR
        int filas = 0;
        Curso cur = new Curso(13, "Ahsdfasd");
        try {
            filas = cursoDao.insertar(cur);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);
//
//            //TEST OBTENER POR CODIGO
////        
        Curso ncurso = new Curso();
        try {
            ncurso = cursoDao.obtener(13);
            System.out.println("            " + ncurso.getCodigo()+ "    " + ncurso.getDescripcion());
        } catch (Exception e) {
        }
        assertEquals(ncurso!=null, true);

//            //TEST LISTADO
        ArrayList<Curso> cursos = new ArrayList<>();
        try {
            cursos = cursoDao.obtener();
            System.out.println("Codigo de Curso \t" + "Nombre \t" + " \t Descripcion\t");

            for (Curso curso : cursos) {
                System.out.println(curso.getCodigo()+ "\t\t" + curso.getDescripcion()+ "\t\t");
            }
        } catch (Exception e) {
        }
        assertTrue(cursos.size()>0);
    }
    
}
