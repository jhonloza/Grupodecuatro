
package ec.edu.unach.sicoa.vistas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
public class FrmMenuPrincipal extends JFrame{
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
    JDesktopPane escritorio;

    public FrmMenuPrincipal() {
        escritorio=new JDesktopPane();
        escritorio.setBackground(new Color(50, 30, 70));
        
        menuBarraPrincipal=new JMenuBar();
        //menu Inicio
        menuInicio=new JMenu("Inicio");
        menuItemLogin=new JMenuItem("Iniciar Sesion");
        menuItemSalir=new JMenuItem("Salir");
        menuItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    menuSalirActionPerformed(e);
                } catch (Exception ex) {
                    System.out.println("error: "+ex.getMessage());
                }
            }
        });
        menuBarraPrincipal.add(menuInicio);
        menuInicio.add(menuItemLogin);
        menuInicio.add(menuItemSalir);
        //Menu Estudiante
        menuEstudiante=new JMenu("Estudiante");
        nuevoEstudiante=new JMenuItem("Nuevo Estudiante");
        modificarEstudiante=new JMenuItem("Modificar Estudiante");
        eliminarEstudiante=new JMenuItem("Eliminar Estudiante");
        buscarEstudiante=new JMenuItem("Buscar Estudiante");
        listEstudiante=new JMenuItem("Listar Estudiantes");
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
        
        this.setLayout(new BorderLayout());
        //this.setSize(360,240);
        this.add(menuBarraPrincipal, BorderLayout.NORTH);
        this.add(escritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //PARA MAXIMIZAR LA VENTANA
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//terminar proceso de la ventana ejecutada
        
    }
    public static void main(String[] args) {
        FrmMenuPrincipal ventana=new FrmMenuPrincipal();
        ventana.setVisible(true);
    }
    public void menuSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }
    public void nuevoEstudianteActionPerformed(ActionEvent e){
        FormEstudiante nuevo=new FormEstudiante();
        
        escritorio.add(nuevo);
        nuevo.setVisible(true);
    }
}
