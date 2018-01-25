package ec.edu.unach.sicoa.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class ESTUDIANTEV extends JInternalFrame {

    List<Curso> lstCurso;
    JComboBox<Curso> cmbCurso;
    JLabel titulo0;
    JLabel codigo;

    JLabel cedula;

    JLabel nombres;

    JLabel apellidos;

    JLabel fechaNacimiento;

    JLabel fechaInreso;

    JLabel telefono;

    JLabel sexo;

    JLabel direccion;

    JLabel curso;
    JTextField txtTitulo1;
    JTextField txtTitulo2;
    JTextField txtTitulo3;
    JTextField txtTitulo4;
    JTextField txtTitulo5;
    JTextField txtTitulo6;
    JTextField txtTitulo7;
    JTextField txtTitulo8;
    JTextField txtTitulo9;
    JTextField txtTitulo10;

    JComboBox cmbGenero;

    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public ESTUDIANTEV() {
        this.setSize(640, 400);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo0 = new JLabel("DATOS ESTUDIANTILES");

        codigo = new JLabel("CODIGO ESTUDIANTE");

        cedula = new JLabel("NUMERO CEDULA");

        nombres = new JLabel("NOMBRE");

        apellidos = new JLabel("APELLIDO");

        fechaNacimiento = new JLabel("FECHA NACIMIENTO");

        fechaInreso = new JLabel("FECHA INGRESO");

        telefono = new JLabel("NUMERO TELEFONO");

        sexo = new JLabel("GENERO");

        direccion = new JLabel("DIRECCION");

        curso = new JLabel("CURSO");

        txtTitulo1 = new JTextField();
        txtTitulo2 = new JTextField();
        txtTitulo3 = new JTextField();
        txtTitulo4 = new JTextField();
        txtTitulo5 = new JTextField();
        txtTitulo6 = new JTextField();
        txtTitulo7 = new JTextField();
        txtTitulo8 = new JTextField();
        txtTitulo9 = new JTextField();
        txtTitulo10 = new JTextField();
        cmbGenero = new JComboBox(new String[]{"masculino", "femenino"});
        CargarCursos();
        cmbCurso = new JComboBox(lstCurso.toArray());
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
        pnlcentral.add(fechaNacimiento);
        pnlcentral.add(txtTitulo5);
        pnlcentral.add(fechaInreso);
        pnlcentral.add(txtTitulo6);
        pnlcentral.add(telefono);
        pnlcentral.add(txtTitulo7);
        pnlcentral.add(direccion);
        pnlcentral.add(txtTitulo8);
        pnlcentral.add(sexo);
        pnlcentral.add(cmbGenero);
        //pnlcentral.add(txtTitulo8);

        pnlcentral.add(curso);
        pnlcentral.add(cmbCurso);

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

        ESTUDIANTEV frmMenu = new ESTUDIANTEV();
        frmMenu.setVisible(true);

    }

    public void CargarCursos() {

        ICurso curDao = new CursoImpl();
        try {
            lstCurso = curDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CURSOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void btnAceptarActionListener(ActionEvent e) {
        IEstudiante estDao = new EstudianteImpl();

        try {

            Estudiante est = new Estudiante();
            est.setCodigo(Integer.parseInt(txtTitulo1.getText()));
            est.setCedula(txtTitulo2.getText());
            est.setNombres(txtTitulo3.getText());
            est.setApellidos(txtTitulo4.getText());
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                try {
                 est.setFechaNacimiento(formatoFecha.parse(txtTitulo5.getText()));
          est.setFechaInreso(formatoFecha.parse(txtTitulo6.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "FECHA INCORRECTA", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            est.setTelefono(txtTitulo7.getText());
            est.setDireccion(txtTitulo8.getText());
            est.setSexo(cmbGenero.getSelectedIndex()== 0 ? "masculino" : "femenino");         
            est.setCurso((Curso)cmbCurso.getSelectedItem());
            try {
                if (estDao.insertar(est)>0) {
                    JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "ERROR DESCONOCIDO", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
