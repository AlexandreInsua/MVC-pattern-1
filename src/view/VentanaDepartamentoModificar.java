package view;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.ControladorAlu;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDepartamentoModificar extends JDialog{
	
	private JFrame frame;
	private JTextField textCodigo;
	private JTextField textDepartamento;
	private JTextField textLocalidad;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	
	ControladorAlu controlador = new ControladorAlu();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDepartamentoModificar window = new VentanaDepartamentoModificar();
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
	public VentanaDepartamentoModificar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(153, 153, 153)));
		panel.setBounds(20, 25, 305, 120);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{106, 86, 46, 0};
		gbl_panel.rowHeights = new int[]{20, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCodigo = new JLabel("Codigo");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.anchor = GridBagConstraints.WEST;
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 0;
		panel.add(lblCodigo, gbc_lblCodigo);
		
		textCodigo = new JTextField();
		GridBagConstraints gbc_textCodigo = new GridBagConstraints();
		gbc_textCodigo.anchor = GridBagConstraints.NORTHWEST;
		gbc_textCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_textCodigo.gridx = 1;
		gbc_textCodigo.gridy = 0;
		panel.add(textCodigo, gbc_textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
		gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento.anchor = GridBagConstraints.WEST;
		gbc_lblDepartamento.gridx = 0;
		gbc_lblDepartamento.gridy = 1;
		panel.add(lblDepartamento, gbc_lblDepartamento);
		
		textDepartamento = new JTextField();
		textDepartamento.setEnabled(false);
		GridBagConstraints gbc_textDepartamento = new GridBagConstraints();
		gbc_textDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_textDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDepartamento.gridx = 1;
		gbc_textDepartamento.gridy = 1;
		panel.add(textDepartamento, gbc_textDepartamento);
		textDepartamento.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		GridBagConstraints gbc_lblLocalidad = new GridBagConstraints();
		gbc_lblLocalidad.insets = new Insets(0, 0, 0, 5);
		gbc_lblLocalidad.anchor = GridBagConstraints.WEST;
		gbc_lblLocalidad.gridx = 0;
		gbc_lblLocalidad.gridy = 2;
		panel.add(lblLocalidad, gbc_lblLocalidad);
		
		textLocalidad = new JTextField();
		textLocalidad.setEnabled(false);
		GridBagConstraints gbc_textLocalidad = new GridBagConstraints();
		gbc_textLocalidad.insets = new Insets(0, 0, 0, 5);
		gbc_textLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLocalidad.gridx = 1;
		gbc_textLocalidad.gridy = 2;
		panel.add(textLocalidad, gbc_textLocalidad);
		textLocalidad.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(335, 207, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(245, 207, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(157, 207, 89, 23);
		frame.getContentPane().add(btnSalir);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 if(textCodigo.getText().equals("")){
				 JOptionPane.showMessageDialog(null, "El código no puede estar vacío");
			 } else {
				 String codigo = textCodigo.getText();
				 boolean respuesta = controlador.validarCodigoDepar(codigo);
					 if (respuesta == false) {
						 textCodigo.setText("");
					 }
			 }
					 	
			}
		});
		btnModificar.setBounds(335, 64, 89, 23);
		frame.getContentPane().add(btnModificar);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Modificar Departamento");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	

	public void setControlador(ControladorAlu miControlador) {
		this.controlador = miControlador;
		
	}
}
