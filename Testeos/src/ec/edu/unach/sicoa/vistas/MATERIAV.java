package ec.edu.unach.sicoa.vistas;

import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MATERIAV extends JInternalFrame {

    JLabel titulo0;
    JLabel Cod_Materia;
    JLabel Nombre;

    JTextField txtTitulo1;
    JTextField txtTitulo2;

    JComboBox cmbGenero;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public MATERIAV() {

        this.setSize(400, 200);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo0 = new JLabel("DATOS MATERIA");

        Cod_Materia = new JLabel("CODIGO MATERIA");

        Nombre = new JLabel("Nombre Materia");
        txtTitulo1 = new JTextField();
        txtTitulo2 = new JTextField();
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo0, BorderLayout.NORTH);
        pnlcentral.add(Cod_Materia);
        pnlcentral.add(txtTitulo1);
        pnlcentral.add(Nombre);
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
        this.setClosable(true);
    }

    public static void main(String[] args) {

        MATERIAV frmMenu = new MATERIAV();
        frmMenu.setVisible(true);
    }

    public void btnAceptarActionListener(ActionEvent e) {

        try {

            Materia materia = new Materia();
            materia.setCodigo(Integer.parseInt(txtTitulo1.getText()));
            materia.setNombre(txtTitulo2.getText());
            IMateria maDao = new MateriaImpl();
            if (maDao.insertar(materia) > 0) {

                JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
