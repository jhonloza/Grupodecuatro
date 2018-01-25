package ec.edu.unach.sicoa.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;

public class ESTUDIANTEV extends JInternalFrame {

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
        pnlcentral.add(sexo);
        pnlcentral.add(cmbGenero);
        //pnlcentral.add(txtTitulo8);
        
        pnlcentral.add(curso);
        pnlcentral.add(txtTitulo9);
        
        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error "+ex.getMessage());
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
    public void btnAceptarActionListener(ActionEvent e){
        
        
        JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction",JOptionPane.INFORMATION_MESSAGE);
    }
}


