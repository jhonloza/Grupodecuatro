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
    JTextField txCodi;
    JTextField txCedula;
    JTextField txNombre;
    JTextField txApellido;
    JTextField txFechaNac;
    JTextField txFechaIng;
    JTextField txTelf;
    JTextField txDir;
    JTextField txtTitulo9;
    JTextField txCodi0;

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

        txCodi = new JTextField();
        txCedula = new JTextField();
        txNombre = new JTextField();
        txApellido = new JTextField();
        txFechaNac = new JTextField();
        txFechaIng = new JTextField();
        txTelf = new JTextField();
        txDir = new JTextField();
        txtTitulo9 = new JTextField();
        txCodi0 = new JTextField();
        cmbGenero = new JComboBox(new String[]{"masculino", "femenino"});
        CargarCursos();
        cmbCurso = new JComboBox(lstCurso.toArray());
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo0, BorderLayout.NORTH);
        pnlcentral.add(codigo);
        pnlcentral.add(txCodi);
        pnlcentral.add(cedula);
        pnlcentral.add(txCedula);
        pnlcentral.add(nombres);
        pnlcentral.add(txNombre);
        pnlcentral.add(apellidos);
        pnlcentral.add(txApellido);
        pnlcentral.add(fechaNacimiento);
        pnlcentral.add(txFechaNac);
        pnlcentral.add(fechaInreso);
        pnlcentral.add(txFechaIng);
        pnlcentral.add(telefono);
        pnlcentral.add(txTelf);
        pnlcentral.add(direccion);
        pnlcentral.add(txDir);
        pnlcentral.add(sexo);
        pnlcentral.add(cmbGenero);

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
            est.setCodigo(Integer.parseInt(txCodi.getText()));
            est.setCedula(txCedula.getText());
            est.setNombres(txNombre.getText());
            est.setApellidos(txApellido.getText());
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                est.setFechaNacimiento(formatoFecha.parse(txFechaNac.getText()));
                est.setFechaInreso(formatoFecha.parse(txFechaIng.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "FECHA INCORRECTA", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            est.setTelefono(txTelf.getText());
            est.setDireccion(txDir.getText());
            est.setSexo(cmbGenero.getSelectedIndex() == 0 ? "masculino" : "femenino");
            est.setCurso((Curso) cmbCurso.getSelectedItem());
                if (estDao.insertar(est) > 0) {
                    JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR !! "+ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
