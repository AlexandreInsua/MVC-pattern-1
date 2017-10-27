package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class MainWindow {
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmDepartamentos = new JMenuItem("Departamentos");
		menuBar.add(mntmDepartamentos);
		
		JMenuItem mntmEmpleados = new JMenuItem("Empleados");
		menuBar.add(mntmEmpleados);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Departamentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 34, 500, 63);
		frame.getContentPane().add(panel);
		
		JButton btnNuevo = new JButton("Nuevo");
		panel.add(btnNuevo);
		
		JButton btnModificar = new JButton("Modificar");
		panel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);
		
		JButton btnConsultas = new JButton("Consultas");
		panel.add(btnConsultas);
		
		JButton btnListado = new JButton("Listado");
		panel.add(btnListado);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 108, 500, 63);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		frame.getContentPane().add(panel_1);
		
		JButton btnNuevoEmp = new JButton("Nuevo");
		panel_1.add(btnNuevoEmp);
		
		JButton btnModificarEmp = new JButton("Modificar");
		panel_1.add(btnModificarEmp);
		
		JButton btnEliminarEmp = new JButton("Eliminar");
		panel_1.add(btnEliminarEmp);
		
		JButton btnConsultasEmp = new JButton("Consultas");
		panel_1.add(btnConsultasEmp);
		
		JButton btnListadoEmp = new JButton("Listado");
		panel_1.add(btnListadoEmp);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalir.setBounds(298, 186, 78, 23);
		frame.getContentPane().add(btnSalir);
	}

}



