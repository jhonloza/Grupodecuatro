
package ec.edu.unach.sicoa.test;

import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class EstudianteTest {
    
    public EstudianteTest() {
    }
    @Test
    public void testeGeneral(){
        IEstudiante estudianteDao = new EstudianteImpl();

// TEST INSERTAR
        int filas = 0;
        Curso nCurso=new Curso(1, "SOCIALES");
        Estudiante estudent = new Estudiante(1, "060460457-9","gwerfsad","unyawer",new Date(),new Date(),"123235","M","kaubfasd",nCurso);
        try {
            filas = estudianteDao.insertar(estudent);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);
//
//            //TEST OBTENER POR CODIGO
////        
        Estudiante nestudiante = new Estudiante();
        try {
            nestudiante = estudianteDao.obtener(13);
            System.out.println("            " + nestudiante.getCodigo()+ "    " + nestudiante.getCedula());
        } catch (Exception e) {
        }
        assertEquals(nestudiante!=null, true);

//            //TEST LISTADO
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            estudiantes = estudianteDao.obtener();
            System.out.println("Codigo de Estudiante \t" + "Nombre \t" + " \t Descripcion\t");

            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante.getCodigo()+ "\t\t" + estudiante.getCedula()+ "\t\t");
            }
        } catch (Exception e) {
        }
        assertTrue(estudiantes.size()>0);
    }
    
}
