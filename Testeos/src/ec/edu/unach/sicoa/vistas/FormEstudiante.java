package ec.edu.unach.sicoa.vistas;

import ec.edu.unach.sicoa.accesoadatos.*;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.*;

public class FormEstudiante extends JInternalFrame {

    JLabel lbTITULO;
    JLabel lbcodigo;
    JLabel lbcedula;
    JLabel lbnombre;
    JLabel lbapellido;
    JLabel lbfecha1;
    JLabel lbfecha2;
    JLabel lbtelefono;
    JLabel lbsexo;
    JLabel lbdireccion;
    JLabel lbidCurso;
    JLabel lbdesCruso;

    JTextField TITULO;
    JTextField codigo;
    JTextField cedula;
    JTextField nombre;
    JTextField apellido;
    JTextField fecha1;
    JTextField fecha2;
    JTextField telefono;
    JComboBox<Object> sexo;
    JTextField direccion;
    JComboBox<Object> idCurso;
    JTextField desCruso;

    JButton cerrar;
    JButton actualizar;
    JButton insertar;

    JPanel pnltitulo;
    JPanel pnlinfo;
    JPanel pnlSuperior;
    JPanel pnlEstudiante;
    JPanel pnlCurso;
    JPanel pnlCentral;
    JPanel pnlInferior;

    public FormEstudiante() {
        this.setSize(640, 480);
        this.setLayout(new BorderLayout());

        pnltitulo = new JPanel(new BorderLayout());
        lbTITULO = new JLabel("Informacion del Estudiante");
        pnltitulo.add(lbTITULO);

        pnlinfo = new JPanel(new GridLayout(2, 4, 5, 5));
        lbcodigo = new JLabel("Codigo: ");
        lbnombre = new JLabel("Nombre: ");
        lbapellido = new JLabel("Apellido: ");
        lbidCurso = new JLabel("Curso: ");
        codigo = new JTextField("");
        nombre = new JTextField("");
        apellido = new JTextField("");
        idCurso = new JComboBox<>(new String[]{"primero", "Segundo", "Tercero", "Cuarto", "Quinto"});
        pnlinfo.add(lbcodigo);
        pnlinfo.add(lbnombre);
        pnlinfo.add(lbapellido);
        pnlinfo.add(lbidCurso);
        pnlinfo.add(codigo);
        pnlinfo.add(nombre);
        pnlinfo.add(apellido);
        pnlinfo.add(idCurso);

        pnlSuperior = new JPanel(new GridLayout(2, 1, 5, 5));
        pnlSuperior.add(pnltitulo);
        pnlSuperior.add(pnlinfo);

        pnlEstudiante = new JPanel(new GridLayout(6, 2, 5, 5));
        lbcedula = new JLabel("Cedula: ");
        lbfecha1 = new JLabel("Fecha Nacimiento: ");
        lbfecha2 = new JLabel("Fecha Ingreso: ");
        lbtelefono = new JLabel("Telefono: ");
        lbsexo = new JLabel("Sexo: ");
        lbdireccion = new JLabel("Direccion: ");
        cedula = new JTextField("");
        fecha1 = new JTextField("1990-10-23");
        fecha2 = new JTextField("2015-05-18");
        telefono = new JTextField("");
        sexo = new JComboBox<>(new String[]{"M","F"});
        direccion = new JTextField("");
        pnlEstudiante.add(lbcedula);
        pnlEstudiante.add(cedula);
        pnlEstudiante.add(lbfecha1);
        pnlEstudiante.add(fecha1);
        pnlEstudiante.add(lbfecha2);
        pnlEstudiante.add(fecha2);
        pnlEstudiante.add(lbtelefono);
        pnlEstudiante.add(telefono);
        pnlEstudiante.add(lbsexo);
        pnlEstudiante.add(sexo);
        pnlEstudiante.add(lbdireccion);
        pnlEstudiante.add(direccion);
        
        pnlCurso = new JPanel(new GridLayout(2, 1, 5, 5));
        lbdesCruso = new JLabel("Descripcion Curso");
        desCruso = new JTextField("");
        pnlCurso.add(lbdesCruso);
        pnlCurso.add(desCruso);
        
        pnlCentral=new JPanel(new GridLayout(1,2,5,5));
        pnlCentral.add(pnlEstudiante);
        pnlCentral.add(pnlCurso);
        
        pnlInferior=new JPanel(new GridLayout(1,3,5,5));
        insertar=new JButton("Insertar");
        actualizar = new JButton("Actualizar");
        cerrar = new JButton("Cerrar");
        pnlInferior.add(insertar);
        pnlInferior.add(actualizar);
        pnlInferior.add(cerrar);
        
        this.add(pnlSuperior, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlInferior,BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        Curso curso = new Curso(234, "Cuarto Semestre sistemas y computacion");
        Estudiante estudiante = new Estudiante(123, "060214587-9", "Mishell", "Viteri", new Date(), new Date(), "0946532156", "F", "Cerca de la U", curso);
        FormEstudiante interEstudiante = new FormEstudiante();
        interEstudiante.setVisible(true);
    }
}
