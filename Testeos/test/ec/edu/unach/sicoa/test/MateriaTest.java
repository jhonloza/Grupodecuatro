package ec.edu.unach.sicoa.test;

import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.util.*;
import java.sql.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class MateriaTest {

    public MateriaTest() {
    }

    @Test
    public void TestGenetal() {
        IMateria materiaDao = new MateriaImpl();

// TEST INSERTAR
        int filas = 0;
        Materia mat = new Materia(1, "materia 1");
        try {
            filas = materiaDao.insertar(mat);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertTrue(filas > 0);
//
//            //TEST OBTENER POR CODIGO
////        
        Materia mater = new Materia();
        try {
            mater = materiaDao.obtener(5);
            System.out.println("            " + mater.getCodigo()+ "    " + mater.getNombre());
        } catch (Exception e) {
        }
        assertEquals(mater!=null, true);

//            //TEST LISTADO
        ArrayList<Materia> materias = new ArrayList<>();
        try {
            materias = materiaDao.obtener();
            System.out.println("Codigo de Materia \t" + "Nombre \t" + " \t Descripcion\t");

            for (Materia cate : materias) {
                System.out.println(cate.getCodigo()+ "\t\t" + cate.getNombre() + "\t\t");
            }
        } catch (Exception e) {
        }
        assertTrue(materias.size()>0);

    }

}
