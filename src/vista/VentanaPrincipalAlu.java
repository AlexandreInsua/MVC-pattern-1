package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorAlu;

public class VentanaPrincipalAlu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static VentanaPrincipalAlu frame = null;
	private JPanel contentPane;
	
//	private static VentanaDepartamentosNuevoAlu vtnDeparNuevo = null;
	
	ControladorAlu miControlador;

	
	public void setMiControlador(ControladorAlu miControlador) {
		this.miControlador = miControlador;
	}
	
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaPrincipalAlu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaPrincipalAlu() {
		
		setTitle("Gesti\u00F3n de Empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDepartamentos = new JMenu("Departamentos");
		menuBar.add(mnDepartamentos);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mnDepartamentos.add(mntmNuevo);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mnDepartamentos.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mnDepartamentos.add(mntmEliminar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnDepartamentos.add(mntmConsultar);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new BtnSalirActionListener());
		btnSalir.setBounds(386, 185, 97, 25);
		contentPane.add(btnSalir);
		
		JPanel panelDepartamentos = new JPanel();
		panelDepartamentos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Departamentos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelDepartamentos.setBounds(21, 11, 462, 69);
		contentPane.add(panelDepartamentos);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new BtnListadoActionListener());
		
		JButton btnNuevoDep = new JButton("Nuevo");
		btnNuevoDep.addActionListener(new BtnNuevoDepActionListener());
		panelDepartamentos.add(btnNuevoDep);
		
		JButton btnModifcar = new JButton("Modifcar");
		btnModifcar.addActionListener(new BtnModifcarActionListener());
		panelDepartamentos.add(btnModifcar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		panelDepartamentos.add(btnEliminar);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addActionListener(new BtnConsultasActionListener());
		panelDepartamentos.add(btnConsultas);
		panelDepartamentos.add(btnListado);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(21, 98, 462, 56);
		contentPane.add(panel);
		
		JButton btnNuevoEmp = new JButton("Nuevo");
		panel.add(btnNuevoEmp);
		
		JButton btnModificarEmp = new JButton("Modificar");
		panel.add(btnModificarEmp);
		
		JButton btnEliminarEmp = new JButton("Eliminar");
		panel.add(btnEliminarEmp);
		
		JButton btnConsultasEmp = new JButton("Consultas");
		panel.add(btnConsultasEmp);
		
		JButton btnListadoEmp = new JButton("Listado");
		btnListadoEmp.addActionListener(new BtnListadoEmpActionListener());
		panel.add(btnListadoEmp);
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}
	}
	private class BtnNuevoDepActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			miControlador.mostrarVentanaNuevoDepartamento();
			
		}
	}
	private class BtnModifcarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			miControlador.mostrarVentanaModificarDepartamento();
		}
	}
	private class BtnConsultasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			miControlador.mostraVentanaConsultas();
		}
	}
	private class BtnListadoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			miControlador.mostrarVentanaListadoDepartamentos();
		}
	}
	private class BtnListadoEmpActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			miControlador.mostrarVentanaEmpleadosDepartamento();
		}
	}
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			miControlador.mostrarVentanaEliminarDepartamento();
		}
	}
}
