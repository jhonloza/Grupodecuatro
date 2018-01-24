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
        Materia mat = new Materia(13, "Ahsdfasd");
        try {
            filas = materiaDao.insertar(mat);
            System.out.println("Ingreso de " + filas + " Filas Correctas");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        assertEquals(filas > 0, true);
//
//            //TEST OBTENER POR CODIGO
////        
        Materia mater = new Materia();
        try {
            mater = materiaDao.obtener(13);
            System.out.println("            " + mater.getCodigo()+ "    " + mater.getNombre());
        } catch (Exception e) {
        }

//            //TEST LISTADO
        ArrayList<Materia> categ = new ArrayList<>();
        try {
            categ = materiaDao.obtener();
            System.out.println("Codigo de Materia \t" + "Nombre \t" + " \t Descripcion\t");

            for (Materia cate : categ) {
                System.out.println(cate.getCodigo()+ "\t\t" + cate.getNombre() + "\t\t");
            }
        } catch (Exception e) {
        }
        assertEquals(categ != null, true);

    }

}
