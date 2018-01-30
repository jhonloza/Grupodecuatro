package ec.edu.unach.sicoa.vistas;

import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    JLabel fechaIngreso;
    JLabel salario;

    JTextField txcod;
    JTextField txcedu;
    JTextField txNombre;
    JTextField txApellido;
    JTextField txTelf;
    JTextField txDir;
    JComboBox<String> cmdCateg;
    JTextField txtTitulo8;
    JTextField txFechaNac;
    JTextField txFechIng;
    JTextField txSalario;

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
        fechaIngreso = new JLabel("FECHA INGRESO");
        salario = new JLabel("salario");

        txcod = new JTextField();
        txcedu = new JTextField();
        txNombre = new JTextField();
        txApellido = new JTextField();
        txTelf = new JTextField();
        txDir = new JTextField();
        cmdCateg = new JComboBox<String>(new String[]{"Contrato", "Nombramiento"});
        txtTitulo8 = new JTextField();
        txFechaNac = new JTextField();
        txFechIng = new JTextField();
        txSalario = new JTextField();
        cmbGenero = new JComboBox(new String[]{"masculino", "femenino"});
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo0, BorderLayout.NORTH);
        pnlcentral.add(codigo);
        pnlcentral.add(txcod);
        pnlcentral.add(cedula);
        pnlcentral.add(txcedu);
        pnlcentral.add(nombres);
        pnlcentral.add(txNombre);
        pnlcentral.add(apellidos);
        pnlcentral.add(txApellido);
        pnlcentral.add(telefono);
        pnlcentral.add(txTelf);
        pnlcentral.add(direccion);
        pnlcentral.add(txDir);
        pnlcentral.add(categoria);
        pnlcentral.add(cmdCateg);
        pnlcentral.add(sexo);
        pnlcentral.add(cmbGenero);
        pnlcentral.add(fechaNacimiento);
        pnlcentral.add(txFechaNac);
        pnlcentral.add(fechaIngreso);
        pnlcentral.add(txFechIng);
        pnlcentral.add(salario);
        pnlcentral.add(txSalario);

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
            nDocente.setCodigo(Integer.parseInt(txcod.getText()));
            nDocente.setCedula(txcedu.getText());
            nDocente.setNombres(txNombre.getText());
            nDocente.setApellidos(txApellido.getText());
            nDocente.setTelefono(txTelf.getText());
            nDocente.setDireccion(txDir.getText());
            nDocente.setCategoria(cmdCateg.getSelectedIndex() == 0 ? "C" : "N");
            nDocente.setSexo(cmbGenero.getSelectedIndex() == 0 ? "M" : "F");
            DateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
            try {
                nDocente.setFechaNacimiento(formatoFecha.parse(txFechaNac.getText()));
                nDocente.setFechaIngreso(formatoFecha.parse(txFechIng.getText()));
            } catch (Exception er) {
                JOptionPane.showMessageDialog(this, "ERROR DE FECHA!!"+er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            nDocente.setSalario(Double.parseDouble(txSalario.getText()));
            IDocente docDao = new DocenteImpl();
            if (docDao.insertar(nDocente) > 0) {
                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO FALLIDO!!"+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
