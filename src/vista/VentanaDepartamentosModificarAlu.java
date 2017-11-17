package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.ControladorAlu;
import modelo.vo.Departamento;

public class VentanaDepartamentosModificarAlu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCodDepart;
	private JTextField textFieldDepartamento;
	private JTextField textFieldLocalidad;
	private final JPanel panelCampos = new JPanel();
	private JButton okButton;


	//
	ControladorAlu controlador;
	
	Departamento departamento;
	
	

	public void setControlador(ControladorAlu controlador) {
		this.controlador = controlador;
	}

	private JButton cancelButton;
	private JButton btnSalir;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {

			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public VentanaDepartamentosModificarAlu() {
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

		JLabel lblNuevoDepartamento = new JLabel("Modificar Departamento");
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
		textFieldLocalidad.setEditable(false);
		textFieldLocalidad.setBounds(114, 69, 244, 22);
		panelCampos.add(textFieldLocalidad);
		textFieldLocalidad.setColumns(10);

		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setEditable(false);
		textFieldDepartamento.setBounds(114, 34, 244, 22);
		panelCampos.add(textFieldDepartamento);
		textFieldDepartamento.setColumns(10);

		JLabel lblNewLabel = new JLabel("Departamento:");
		lblNewLabel.setBounds(16, 37, 86, 16);
		panelCampos.add(lblNewLabel);

		textFieldCodDepart = new JTextField();
		textFieldCodDepart.setBounds(114, 5, 116, 22);
		panelCampos.add(textFieldCodDepart);
		textFieldCodDepart.setColumns(10);

		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setBounds(16, 66, 94, 16);
		panelCampos.add(lblLocalidad);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new BtnModificarActionListener());
		btnModificar.setBounds(492, 69, 89, 23);
		contentPanel.add(btnModificar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setEnabled(false);
				okButton.addActionListener(new OkButtonActionListener());
				
				btnSalir = new JButton("Salir");
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
			//cierra el cuadro de diálogo
			dispose();

		}
	}// fin metodo CancelButtonActionListener

	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			//creamos n departamento donde guardamos los campos insertados en los
			// cuadros de texto, tanto si es nuevo como si lo hemos modificado
			departamento = new Departamento();
			departamento.setCodigo(Short.parseShort(textFieldCodDepart.getText()));
			departamento.setDepartamento(textFieldDepartamento.getText());
			departamento.setLocalidad(textFieldLocalidad.getText());
			
		
			controlador.modificarDepartamento(departamento);
				
			limpiarCuadrosTexto();
			situacionInicial();

		}
	}// fin del metodo OK
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(textFieldCodDepart.getText().equals("")){
				JOptionPane.showMessageDialog(null, "El código no puede estar vacio");
			}else{
				String codigo = textFieldCodDepart.getText();
				boolean respuesta = controlador.validarCodigoDepar(codigo);
				if(respuesta == false){
					textFieldCodDepart.setText("");
					//pone el cursor en el cuadro de texto
					textFieldCodDepart.requestFocus();
				}else{
				
				

				//deshabilitamos los botones que no se deben pulsar
				okButton.setEnabled(true);
				cancelButton.setEnabled(true);
		

				//buscamos el codigo introducido
				
				departamento = new Departamento();
				departamento = controlador.buscarDepartamento(Short.parseShort(textFieldCodDepart.getText()));

				if(departamento == null){
					JOptionPane.showMessageDialog(null, "Departamento no existe", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					//pasamos los valores buscados al formulario
					textFieldDepartamento.setText(departamento.getDepartamento());
					textFieldLocalidad.setText(departamento.getLocalidad());

					editarCuadrosTexto();
					textFieldCodDepart.setEditable(false); // el codigo no se puede cambiar

					//pone el cursor en el cuadro de texto
					textFieldDepartamento.requestFocus();
				}
				}
			}
		
		}
	}// fin BtnModificarActionListener
	
	
	public void limpiarCuadrosTexto(){

		textFieldCodDepart.setText("");
		textFieldDepartamento.setText("");
		textFieldLocalidad.setText("");

	}// fin metodo limpiarCuadrosTexto()

	//este metodo inhabilita los cuadros de texto y los botones
	public void situacionInicial(){
		//habilitar y deshabilitar los cuadros de texto
		textFieldCodDepart.setEditable(true);
		textFieldDepartamento.setEditable(false);
		textFieldLocalidad.setEditable(false);

		//pone el cursor en el cuadro de texto
		textFieldCodDepart.requestFocus();

		
		okButton.setEnabled(true);
		cancelButton.setEnabled(true);
	}// fin del metodo situacionInicial

	public void editarCuadrosTexto(){
		//editamos los campos
		textFieldCodDepart.setEditable(true);
		textFieldDepartamento.setEditable(true);
		textFieldLocalidad.setEditable(true);
	} // fin metodo editarCuadrosTexto
	
	
}
