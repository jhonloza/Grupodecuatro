package ec.edu.unach.sicoa.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CURSOVISTA extends JInternalFrame {

    JLabel titulo0;
    JLabel codigo_c;
    JLabel descripcion;

    JTextField txtTitulo1;
    JTextField txtTitulo2;

    JComboBox cmbGenero;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public CURSOVISTA() {
        this.setSize(400, 200);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo0 = new JLabel("DATOS CURSO");

        codigo_c = new JLabel("CODIGO CURSO");

        descripcion = new JLabel("DESCRIPCION CURSO");
        txtTitulo1 = new JTextField();
        txtTitulo2 = new JTextField();
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo0, BorderLayout.NORTH);
        pnlcentral.add(codigo_c);
        pnlcentral.add(txtTitulo1);
        pnlcentral.add(descripcion);
        pnlcentral.add(txtTitulo2);

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
    }

    public static void main(String[] args) {

        CURSOVISTA frmMenu = new CURSOVISTA();
        frmMenu.setVisible(true);
    }

    public void btnAceptarActionListener(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
    }

}
