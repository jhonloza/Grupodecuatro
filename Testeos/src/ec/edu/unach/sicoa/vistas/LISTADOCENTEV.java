package ec.edu.unach.sicoa.vistas;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.util.*;

public class LISTADOCENTEV extends JInternalFrame {

    JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane sr;

    public LISTADOCENTEV() {

        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE DOCENTES");
        tabla = new JTable();
        sr = new JScrollPane(tabla);
        this.add(titulo, BorderLayout.NORTH);
        this.add(sr, BorderLayout.CENTER);

        cargarTabla();

    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("codigo");

        modelo.addColumn("NUMERO CEDULA");

        modelo.addColumn("NOMBRE");

        modelo.addColumn("APELLIDO");

        modelo.addColumn("telefono");
        modelo.addColumn("direccion");
        modelo.addColumn("categoria");

        List<Docente> lista = new ArrayList<>();
        try {
            IDocente docDao = new DocenteImpl();
            lista = docDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Docente doc : lista) {
            modelo.addRow(new Object[]{doc.getCodigo(), doc.getCedula(), doc.getNombres(), doc.getApellidos(), doc.getTelefono(), doc.getDireccion(), doc.getCategoria()});
        }
        tabla.setModel(modelo);
    }

}
