package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import controller.ControladorAlu;
import model.LogicaAlu;
import model.Departamento;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaDepartamentosNuevoAlu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCodDepart;
	private JTextField textFieldDepartamento;
	private JTextField textFieldLocalidad;
	private final JPanel panelCampos = new JPanel();
	private JButton okButton;
	private JButton cancelButton;

	/*
	 * private static VentanaDepartamentosNuevoAlu dialog = new
	 * VentanaDepartamentosNuevoAlu(); private VentanaPrincipalAlu vPrincipal =
	 * null;
	 */

	private ControladorAlu controlador = null;
	private Departamento departamento = null;

	public void setControlador(ControladorAlu controlador) {
		this.controlador = controlador;
	}

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try {
	 * 
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 */
	public VentanaDepartamentosNuevoAlu() {
		setTitle("Gesti\u00F3n de Empleados");
		setBounds(100, 100, 712, 309);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new EmptyBorder(0, 1, 0, 0));
		panelTitulo.setBounds(0, 0, 607, 35);
		contentPanel.add(panelTitulo);

		JLabel lblNuevoDepartamento = new JLabel("Nuevo Departamento");
		lblNuevoDepartamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelTitulo.add(lblNuevoDepartamento);
		panelCampos.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCampos.setBounds(10, 35, 384, 117);
		contentPanel.add(panelCampos);
		panelCampos.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(16, 8, 44, 16);
		panelCampos.add(lblCdigo);

		textFieldLocalidad = new JTextField();
		textFieldLocalidad.addActionListener(new TextFieldLocalidadActionListener());
		textFieldLocalidad.setEditable(true);
		textFieldLocalidad.setBounds(114, 69, 244, 22);
		panelCampos.add(textFieldLocalidad);
		textFieldLocalidad.setColumns(10);

		textFieldDepartamento = new JTextField();
		textFieldDepartamento.addActionListener(new TextFieldDepartamentoActionListener());
		textFieldDepartamento.setEditable(true);
		textFieldDepartamento.setBounds(114, 34, 244, 22);
		panelCampos.add(textFieldDepartamento);
		textFieldDepartamento.setColumns(10);

		JLabel lblNewLabel = new JLabel("Departamento:");
		lblNewLabel.setBounds(16, 37, 86, 16);
		panelCampos.add(lblNewLabel);

		textFieldCodDepart = new JTextField();
		textFieldCodDepart.addActionListener(new TextFieldCodDepartActionListener());
		textFieldCodDepart.setBounds(114, 5, 116, 22);
		panelCampos.add(textFieldCodDepart);
		textFieldCodDepart.setColumns(10);

		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setBounds(16, 66, 94, 16);
		panelCampos.add(lblLocalidad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setEnabled(true);
				okButton.addActionListener(new OkButtonActionListener());

				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new BtnSalirActionListener());
				buttonPane.add(btnSalir);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new CancelButtonActionListener());
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}// fin del constructor VentanaDepartamentos

	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// cierra el cuadro de diálogo
			// dispose();

			limpiarCuadrosTexto();
			textFieldCodDepart.requestFocus();
		}
	}// fin metodo CancelButtonActionListener

	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			// creamos n departamento donde guardamos los campos insertados en
			// los
			// cuadros de texto, tanto si es nuevo como si lo hemos modificado
			departamento = new Departamento();
			departamento.setCodigo(Short.parseShort(textFieldCodDepart.getText()));
			departamento.setDepartamento(textFieldDepartamento.getText());
			departamento.setLocalidad(textFieldLocalidad.getText());

			// creamos el objeto controlador
			controlador = new ControladorAlu();
			// controlador.nuevoDepartamento(departamento);

			limpiarCuadrosTexto();
			situacionInicial();

		}
	}// fin del metodo OK

	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}

	private class TextFieldCodDepartActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String codigo = textFieldCodDepart.getText();
			if (controlador.validarCodigoDepar(codigo) == true)
				textFieldDepartamento.requestFocus();
			else {
				textFieldCodDepart.setText("");
				textFieldCodDepart.requestFocus();
			}

		}
	}

	private class TextFieldDepartamentoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombre = textFieldDepartamento.getText();
			if (controlador.validarNombre(nombre, 1) == true) {
				textFieldDepartamento.setText("");
				textFieldDepartamento.requestFocus();
			} else
				textFieldLocalidad.requestFocus();
		}
	}

	private class TextFieldLocalidadActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String localidad = textFieldLocalidad.getText();
			if (controlador.validarNombre(localidad, 2) == true) {
				textFieldLocalidad.setText("");
				textFieldLocalidad.requestFocus();
			}
		}
	}

	public void limpiarCuadrosTexto() {

		textFieldCodDepart.setText("");
		textFieldDepartamento.setText("");
		textFieldLocalidad.setText("");

	}// fin metodo limpiarCuadrosTexto()

	// este metodo inhabilita los cuadros de texto y los botones
	public void situacionInicial() {
		// habilitar y deshabilitar los cuadros de texto
		textFieldCodDepart.setEditable(true);
		textFieldDepartamento.setEditable(true);
		textFieldLocalidad.setEditable(true);

		// pone el cursor en el cuadro de texto
		textFieldCodDepart.requestFocus();

		okButton.setEnabled(true);
		cancelButton.setEnabled(true);
	}// fin del metodo situacionInicial

	public void editarCuadrosTexto() {
		// editamos los campos
		textFieldCodDepart.setEditable(true);
		textFieldDepartamento.setEditable(true);
		textFieldLocalidad.setEditable(true);
	} // fin metodo editarCuadrosTexto

}
