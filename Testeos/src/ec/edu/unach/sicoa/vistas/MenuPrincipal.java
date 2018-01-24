package ec.edu.unach.sicoa.vistas;

import ec.edu.unach.sicoa.accesoadatos.*;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuPrincipal extends JFrame {

    JLabel lblTitulo1;
    JLabel lblTitulo2;
    JLabel lblTitulo3;
    JLabel lblgenero;

    JLabel titulocentro;

    JTextField cajaTexto1;
    JTextField cajaTexto2;
    JTextField cajaTexto3;

    JComboBox<Object> cbox;

    JButton boton1;
    JButton boton2;

    JPanel pnlCentral;
    JPanel pnlInferior;

    public MenuPrincipal() {
        this.setSize(400, 320);
        this.setLayout(new BorderLayout());

        pnlCentral=new JPanel();
        pnlInferior=new JPanel();
        pnlCentral.setLayout(new GridLayout(4, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1, 2, 5, 5));

        titulocentro = new JLabel("Titulo Central");

        lblTitulo1 = new JLabel("Hola Mundo 1");
        cajaTexto1 = new JTextField(2);
        lblTitulo2 = new JLabel("Hola Mundo 2");
        cajaTexto2 = new JTextField(2);
        lblTitulo3 = new JLabel("Hola Mundo 3");
        cajaTexto3 = new JTextField(2);
        lblgenero = new JLabel("genero:");
        cbox= new JComboBox<>(new String[] {"Masculino","femenino"});

        pnlCentral.add(lblTitulo1);
        pnlCentral.add(cajaTexto1);
        pnlCentral.add(lblTitulo2);
        pnlCentral.add(cajaTexto2);
        pnlCentral.add(lblTitulo3);
        pnlCentral.add(cajaTexto3);
        pnlCentral.add(lblgenero);
        pnlCentral.add(cbox);
                
        boton1=new JButton("aceptar");
        boton2=new JButton("cancelar");
        pnlInferior.add(boton1);
        pnlInferior.add(boton2);
        
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("error: "+ex.getMessage());
                }
            }
        });
        
        this.add(titulocentro, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlInferior, BorderLayout.SOUTH);
        
//        this.add(lblTitulo1);
//        this.add(cajaTexto1);
//        this.add(lblTitulo2);
//        this.add(cajaTexto2);
//        this.add(lblTitulo3);
//        this.add(cajaTexto3);
//        this.add(lblgenero);
//        this.add(cbox);
//        this.add(boton1);
//        this.add(boton2);
    }

    public static void main(String[] args) {
        MenuPrincipal nMenu = new MenuPrincipal();
        nMenu.setVisible(true);
    }

    public void btnAceptarActionListener(ActionEvent e){
        JOptionPane.showMessageDialog(this, "Proceso correcto","transaccion",JOptionPane.INFORMATION_MESSAGE);
    }
}
