package ec.edu.unach.sicoa.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.util.*;

public class LISTAESTUDIANTEV extends JInternalFrame {

    JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;

    public LISTAESTUDIANTEV() {

        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE ESTUDIANTES");
        tabla = new JTable();

        this.add(titulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);

        cargarTabla();

    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("codigo");

        modelo.addColumn("NUMERO CEDULA");

        modelo.addColumn("NOMBRE");

        modelo.addColumn("APELLIDO");

        modelo.addColumn("FECHA NACIMIENTO");

        List<Estudiante> lista = new ArrayList<>();
        try {
            IEstudiante estDao = new EstudianteImpl();
            lista = estDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Estudiante est : lista) {
            modelo.addRow(new Object[]{est.getCodigo(), est.getCedula(), est.getNombres(), est.getApellidos(), est.getFechaNacimiento(), est.getFechaInreso(), est.getTelefono(), est.getSexo(), est.getDireccion(), est.getCurso().getCodigo()});
        }
        tabla.setModel(modelo);
    }

}
