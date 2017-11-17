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

public class VentanaDepartamentosEliminarAlu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCodDepart;
	private JTextField textFieldDepartamento;
	private JTextField textFieldLocalidad;
	private final JPanel panelCampos = new JPanel();
	private JButton okButton;

	

	/*private static VentanaDepartamentosEliminar dialog = new VentanaDepartamentosEliminar();
	private VentanaPrincipal vPrincipal = null;
	private static VentanaDepartamentosListado VDepartamentosListado = new VentanaDepartamentosListado();*/

	private ControladorAlu miControlador = null;
	private Departamento departamento = null;
	private JButton cancelButton;
	private JButton btnEliminar;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {

			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	
	/**
	 * Create the dialog.
	 */
	public VentanaDepartamentosEliminarAlu() {
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

		JLabel lblNuevoDepartamento = new JLabel("Departamentos");
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
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		btnEliminar.setBounds(496, 65, 89, 23);
		contentPanel.add(btnEliminar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setEnabled(false);
				okButton.addActionListener(new OkButtonActionListener());
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

	public void setMiControlador(ControladorAlu miControlador) {
		this.miControlador = miControlador;
	}

	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//cierra el cuadro de diálogo
			dispose();

		}
	}// fin metodo CancelButtonActionListener

	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		
			miControlador.eliminarDepartamento(Short.parseShort(textFieldCodDepart.getText()));

					
			limpiarCuadrosTexto();
			situacionInicial();

		}
	}// fin del metodo OK
	
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(textFieldCodDepart.getText().equals("")){
				JOptionPane.showMessageDialog(null, "El código no puede estar vacio");
			}else{
			
				String codigo = textFieldCodDepart.getText();
				boolean respuesta = miControlador.validarCodigoDepar(codigo);
				if(respuesta == false){
					textFieldCodDepart.setText("");
				}
				//pone el cursor en el cuadro de texto
				textFieldCodDepart.requestFocus();
			Departamento departamento = new Departamento();
			departamento = miControlador.buscarDepartamento(Short.parseShort(textFieldCodDepart.getText()));

			if(departamento == null){
				JOptionPane.showMessageDialog(null, "Departamento no existe", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				//pasamos los valores buscados al formulario
				textFieldDepartamento.setText(departamento.getDepartamento());
				textFieldLocalidad.setText(departamento.getLocalidad());
			}
			}
			okButton.setEnabled(true);
		}
		
	}
	

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
