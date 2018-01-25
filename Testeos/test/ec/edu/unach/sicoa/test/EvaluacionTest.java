
package ec.edu.unach.sicoa.test;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class EvaluacionTest {
    
    public EvaluacionTest() {
    }
    @Test
    public void testeGeneral(){
        IEvaluacion evaluacionDao = new EvaluacionImpl();

// TEST INSERTAR
//        int filas = 0;
//        Materia mat = new Materia(5, "materia 5");
//        Curso nCurso=new Curso(1, "SOCIALES");
//        Estudiante estudent = new Estudiante(1, "060460457-9","gwerfsad","unyawer",new Date(),new Date(),"123235","M","kaubfasd",nCurso);
//        Docente doc = new Docente(1, "321654987", "andres", "orozco", "321654987", "riobamba", "c", "M", new java.util.Date(), new java.util.Date(), 253);
//        Evaluacion eval = new Evaluacion(8, 8, 8, 80, "A", estudent, doc, mat);
//        try {
//            filas = evaluacionDao.insertar(eval);
//            System.out.println("Ingreso de " + filas + " Filas Correctas");
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        assertTrue(filas > 0);
//
//            //TEST OBTENER POR CODIGO
////        
        Evaluacion nEvalua = new Evaluacion();
        try {
            nEvalua = evaluacionDao.obtener(1, 5, 1);
            System.out.println(nEvalua.getNota1()+ "    " + nEvalua.getNota2()+ "    " + nEvalua.getTotal()+ "    " + nEvalua.getAsistencia()+ "    " + nEvalua.getEquivalencia()+ "    " + nEvalua.getEstudiante().getCodigo()+ "    " + nEvalua.getDocente().getCodigo()+ "    " + nEvalua.getMateria().getCodigo());
        } catch (Exception e) {
        }
        assertEquals(nEvalua!=null, true);

//            //TEST LISTADO
        ArrayList<Evaluacion> evaluaciones = new ArrayList<>();
        try {
            evaluaciones = evaluacionDao.obtener();
            System.out.println("Codigo de Estudiante \t" + "Nombre \t" + " \t Descripcion\t");

            for (Evaluacion evaluacion : evaluaciones) {
                System.out.println(nEvalua.getNota1()+ "    " + nEvalua.getNota2()+ "    " + nEvalua.getTotal()+ "    " + nEvalua.getAsistencia()+ "    " + nEvalua.getEquivalencia()+ "    " + nEvalua.getEstudiante().getCodigo()+ "    " + nEvalua.getDocente().getCodigo()+ "    " + nEvalua.getMateria().getCodigo());
            }
        } catch (Exception e) {
        }
        assertTrue(evaluaciones.size()>0);
    }
}
