package ec.edu.unach.sicoa.vistas;

import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DOCENTESV extends JInternalFrame {

    JLabel titulo0;
    JLabel codigo;
    JLabel cedula;
    JLabel nombres;
    JLabel apellidos;
    JLabel telefono;
    JLabel direccion;
    JLabel categoria;
    JLabel sexo;
    JLabel fechaNacimiento;
    JLabel fechaInreso;
    JLabel salario;

    JTextField txtTitulo1;
    JTextField txtTitulo2;
    JTextField txtTitulo3;
    JTextField txtTitulo4;
    JTextField txtTitulo5;
    JTextField txtTitulo6;
    JComboBox<String> txtTitulo7;
    JTextField txtTitulo8;
    JTextField txtTitulo9;
    JTextField txtTitulo10;
    JTextField txtTitulo11;

    JComboBox cmbGenero;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public DOCENTESV() {

        this.setSize(640, 400);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(12, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo0 = new JLabel("DATOS DOCENTES");

        codigo = new JLabel("CODIGO ESTUDIANTE");

        cedula = new JLabel("NUMERO CEDULA");
        nombres = new JLabel("NOMBRE");
        apellidos = new JLabel("APELLIDO");
        telefono = new JLabel("NUMERO TELEFONO");
        direccion = new JLabel("DIRECCION");
        categoria = new JLabel("A");
        sexo = new JLabel("GENERO");
        fechaNacimiento = new JLabel("FECHA NACIMIENTO");
        fechaInreso = new JLabel("FECHA INGRESO");
        salario = new JLabel("salario");

        txtTitulo1 = new JTextField();
        txtTitulo2 = new JTextField();
        txtTitulo3 = new JTextField();
        txtTitulo4 = new JTextField();
        txtTitulo5 = new JTextField();
        txtTitulo6 = new JTextField();
        txtTitulo7 = new JComboBox<String>(new String[]{"C", "R"});
        txtTitulo8 = new JTextField();
        txtTitulo9 = new JTextField();
        txtTitulo10 = new JTextField();
        txtTitulo11 = new JTextField();
        cmbGenero = new JComboBox(new String[]{"masculino", "femenino"});
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo0, BorderLayout.NORTH);
        pnlcentral.add(codigo);
        pnlcentral.add(txtTitulo1);
        pnlcentral.add(cedula);
        pnlcentral.add(txtTitulo2);
        pnlcentral.add(nombres);
        pnlcentral.add(txtTitulo3);
        pnlcentral.add(apellidos);
        pnlcentral.add(txtTitulo4);
        pnlcentral.add(telefono);
        pnlcentral.add(txtTitulo5);
        pnlcentral.add(direccion);
        pnlcentral.add(txtTitulo6);
        pnlcentral.add(categoria);
        pnlcentral.add(txtTitulo7);
        pnlcentral.add(sexo);
        // pnlcentral.add(txtTitulo8);
        pnlcentral.add(cmbGenero);
        pnlcentral.add(fechaNacimiento);
        pnlcentral.add(txtTitulo9);
        pnlcentral.add(fechaInreso);
        pnlcentral.add(txtTitulo10);
        pnlcentral.add(salario);
        pnlcentral.add(txtTitulo11);

        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error " + ex.getMessage());
                }
            }
        });
        this.add(titulo0, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);
        this.setClosable(true);

    }

    public static void main(String[] args) {

        DOCENTESV frmMenu = new DOCENTESV();
        frmMenu.setVisible(true);

    }

    public void btnAceptarActionListener(ActionEvent e) {
        try {
            Docente nDocente = new Docente();
            nDocente.setCodigo(Integer.parseInt(txtTitulo1.getText()));
            nDocente.setCedula(txtTitulo2.getText());
            nDocente.setNombres(txtTitulo2.getText());
            nDocente.setApellidos(txtTitulo2.getText());
            nDocente.setTelefono(txtTitulo2.getText());
            nDocente.setDireccion(txtTitulo2.getText());
            nDocente.setCategoria(txtTitulo7.getToolTipText());
//            nDocente.setSexo(WIDTH);
//            nDocente.setFechaNacimiento(WIDTH);
//            nDocente.setFechaIngreso(WIDTH);
            nDocente.setSalario(Double.parseDouble(txtTitulo11.getText()));
            IDocente docDao = new DocenteImpl();
            if (docDao.insertar(nDocente) > 0) {
                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO Fallido!!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
