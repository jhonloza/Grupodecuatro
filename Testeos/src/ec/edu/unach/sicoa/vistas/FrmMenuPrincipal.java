package ec.edu.unach.sicoa.vistas;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import ec.edu.unach.sicoa.rnegocio.dao.*;
import ec.edu.unach.sicoa.rnegocio.entidades.*;
import ec.edu.unach.sicoa.rnegocio.impl.*;



public class FrmMenuPrincipal extends JFrame {

    JMenuBar menuBarraPrincipal;
    JMenu menuInicio;
    JMenuItem menuItemLogin;
    JMenuItem menuItemSalir;
    JMenu menuEstudiante;
    JMenuItem nuevoEstudiante;
    JMenuItem modificarEstudiante;
    JMenuItem eliminarEstudiante;
    JMenuItem buscarEstudiante;
    JMenuItem listEstudiante;

    JMenu mniCurso;
    JMenuItem mniNuevoCurso;
    JMenuItem mniModificarCurso;
    JMenuItem mniEliminarCurso;
    JMenuItem mniBuscarCurso;
    JMenuItem mniListaCurso;
    JDesktopPane escritorio;
    
    JMenu mniDocente;
    JMenuItem mniNuevoDocente;
    JMenuItem mniModificarDocente;
    JMenuItem mniEliminarDocente;
    JMenuItem mniBuscarDocente;
    JMenuItem mniListaDocente;
   

    JMenu mniMateria;
    JMenuItem mniNuevoMateria;
    JMenuItem mniModificarMateria;
    JMenuItem mniEliminarMateria;
    JMenuItem mniBuscarMateria;
    JMenuItem mniListaMateria;

    public FrmMenuPrincipal() {
        escritorio = new JDesktopPane();
        escritorio.setBackground(new Color(50, 30, 70));

        menuBarraPrincipal = new JMenuBar();
        //menu Inicio
        menuInicio = new JMenu("Inicio");
        menuItemLogin = new JMenuItem("Iniciar Sesion");
        menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    menuSalirActionPerformed(e);
                } catch (Exception ex) {
                    System.out.println("error: " + ex.getMessage());
                }
            }
        });
        menuBarraPrincipal.add(menuInicio);
        menuInicio.add(menuItemLogin);
        menuInicio.add(menuItemSalir);
        //Menu Estudiante
        menuEstudiante = new JMenu("Estudiante");
        nuevoEstudiante = new JMenuItem("Nuevo Estudiante");
        modificarEstudiante = new JMenuItem("Modificar Estudiante");
        eliminarEstudiante = new JMenuItem("Eliminar Estudiante");
        buscarEstudiante = new JMenuItem("Buscar Estudiante");
        listEstudiante = new JMenuItem("Listar Estudiantes");
        menuEstudiante.add(nuevoEstudiante);
        menuEstudiante.add(modificarEstudiante);
        menuEstudiante.add(eliminarEstudiante);
        menuEstudiante.addSeparator();
        menuEstudiante.add(buscarEstudiante);
        menuEstudiante.add(listEstudiante);
        menuBarraPrincipal.add(menuEstudiante);

        nuevoEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevoEstudianteActionPerformed(e);
            }
        });
        mniCurso = new JMenu("CURSO");
        mniNuevoCurso = new JMenuItem("NUEVO");
        mniNuevoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoCursoActionPerformed(e);
            }
        });
        mniModificarCurso = new JMenuItem("MODICIFCAR");
        mniEliminarCurso = new JMenuItem("ELIMINAR");
        mniBuscarCurso = new JMenuItem("BUSCAR");
        mniListaCurso = new JMenuItem("LISTA");

        mniCurso.add(mniNuevoCurso);
        mniCurso.add(mniModificarCurso);
        mniCurso.add(mniEliminarCurso);
        mniCurso.addSeparator();
        mniCurso.add(mniBuscarCurso);
        mniCurso.add(mniListaCurso);
        menuBarraPrincipal.add(mniCurso);
        
        
        mniMateria = new JMenu("MATERIA");
        mniNuevoMateria = new JMenuItem("NUEVO");
        mniNuevoMateria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoMateriaActionPerformed(e);
            }
        });
        mniModificarMateria = new JMenuItem("MODICIFCAR");
        mniEliminarMateria = new JMenuItem("ELIMINAR");
        mniBuscarMateria = new JMenuItem("BUSCAR");
        mniListaMateria = new JMenuItem("LISTA");

        mniMateria.add(mniNuevoMateria);
        mniMateria.add(mniModificarMateria);
        mniMateria.add(mniEliminarMateria);
        mniMateria.addSeparator();
        mniMateria.add(mniBuscarMateria);
        mniMateria.add(mniListaMateria);
        menuBarraPrincipal.add(mniMateria);
        
        mniDocente = new JMenu("DOCENTE");
        mniNuevoDocente = new JMenuItem("NUEVO");
        mniNuevoDocente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoDocenteActionPerformed(e);
            }
        });
        mniModificarDocente = new JMenuItem("MODICIFCAR");
        mniEliminarDocente = new JMenuItem("ELIMINAR");
        mniBuscarDocente = new JMenuItem("BUSCAR");
        mniListaDocente = new JMenuItem("LISTA");

        mniDocente.add(mniNuevoDocente);
        mniDocente.add(mniModificarDocente);
        mniDocente.add(mniEliminarDocente);
        mniDocente.addSeparator();
        mniDocente.add(mniBuscarDocente);
        mniDocente.add(mniListaDocente);
        menuBarraPrincipal.add(mniDocente);

        this.setLayout(new BorderLayout());
        //this.setSize(360,240);
        this.add(menuBarraPrincipal, BorderLayout.NORTH);
        this.add(escritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //PARA MAXIMIZAR LA VENTANA
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//terminar proceso de la ventana ejecutada
        

    }

    public static void main(String[] args) {
        FrmMenuPrincipal ventana = new FrmMenuPrincipal();
        ventana.setVisible(true);
    }

    public void menuSalirActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public void nuevoEstudianteActionPerformed(ActionEvent e) {
        ESTUDIANTEV nuevo = new ESTUDIANTEV();

        escritorio.add(nuevo);
        nuevo.setVisible(true);
    }

    public void mniNuevoCursoActionPerformed(ActionEvent e) {
        CURSOVISTA frm = new CURSOVISTA();
        escritorio.add(frm);
        frm.setVisible(true);
    }
    
     public void mniNuevoMateriaActionPerformed(ActionEvent e) {
        MATERIAV frm = new MATERIAV();
        escritorio.add(frm);
        frm.setVisible(true);
    }
     
     public void mniNuevoDocenteActionPerformed(ActionEvent e) {
        DOCENTESV frm = new DOCENTESV();
        escritorio.add(frm);
        frm.setVisible(true);
    }
}
