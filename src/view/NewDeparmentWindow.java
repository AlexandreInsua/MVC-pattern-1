package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.Controller;


public class NewDeparmentWindow {

	private JFrame frame;
	private JTextField textCodigo;
	private JTextField textDepartamento;
	private JTextField textLocalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewDeparmentWindow window = new NewDeparmentWindow();
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
	public NewDeparmentWindow() {
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
		panel.setBounds(24, 26, 279, 110);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{46, 86, 0};
		gbl_panel.rowHeights = new int[]{20, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.EAST;
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 0;
		panel.add(lblCodigo, gbc_lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo=textCodigo.getText();
				boolean respuesta= Controller.validarCodigoDepartamento(codigo);
				if(respuesta == false) {
					textCodigo.setText("");
					//Poner el cursor en el cuadro de texto
					textCodigo.requestFocus();
				}
				else
					textCodigo.requestFocus();
			}
		});
		GridBagConstraints gbc_textCodigo = new GridBagConstraints();
		gbc_textCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_textCodigo.anchor = GridBagConstraints.NORTHWEST;
		gbc_textCodigo.gridx = 1;
		gbc_textCodigo.gridy = 0;
		panel.add(textCodigo, gbc_textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
		gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento.anchor = GridBagConstraints.EAST;
		gbc_lblDepartamento.gridx = 0;
		gbc_lblDepartamento.gridy = 1;
		panel.add(lblDepartamento, gbc_lblDepartamento);
		
		textDepartamento = new JTextField();
		textDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String nombre=textDepartamento.getText();
			boolean respuesta = Controller.validarCodigoDepartamento(nombre,1);
			if(respuesta == false) {
				textDepartamento.setText("");
				//Pone el cursor en el cuadro de texto
				textDepartamento.requestFocus();
			}
			else
				textFielLocalidad.requestFocus();
		}});
		GridBagConstraints gbc_textDepartamento = new GridBagConstraints();
		gbc_textDepartamento.insets = new Insets(0, 0, 5, 0);
		gbc_textDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDepartamento.gridx = 1;
		gbc_textDepartamento.gridy = 1;
		panel.add(textDepartamento, gbc_textDepartamento);
		textDepartamento.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setVerticalAlignment(SwingConstants.TOP);
		lblLocalidad.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblLocalidad = new GridBagConstraints();
		gbc_lblLocalidad.insets = new Insets(0, 0, 0, 5);
		gbc_lblLocalidad.anchor = GridBagConstraints.EAST;
		gbc_lblLocalidad.gridx = 0;
		gbc_lblLocalidad.gridy = 2;
		panel.add(lblLocalidad, gbc_lblLocalidad);
		
		textLocalidad = new JTextField();
		GridBagConstraints gbc_textLocalidad = new GridBagConstraints();
		gbc_textLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLocalidad.gridx = 1;
		gbc_textLocalidad.gridy = 2;
		panel.add(textLocalidad, gbc_textLocalidad);
		textLocalidad.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(220, 204, 69, 23);
		frame.getContentPane().add(btnSalir);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(290, 204, 55, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(345, 204, 79, 23);
		frame.getContentPane().add(btnCancel);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNuevoDepartamento = new JMenuItem("Nuevo Departamento");
		menuBar.add(mntmNuevoDepartamento);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

}
