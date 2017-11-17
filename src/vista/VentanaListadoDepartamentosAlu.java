package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controlador.ControladorAlu;

public class VentanaListadoDepartamentosAlu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableDepartamentos;
	ModeloTablaDepartamentosAlu miModeloDepartamentos;
	
	ControladorAlu controlador;
	
	

	public void setControlador(ControladorAlu controlador) {
		this.controlador = controlador;
	}

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			VentanaListadoDepartamentosAlu dialog = new VentanaListadoDepartamentosAlu();
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
	public VentanaListadoDepartamentosAlu() {
		setTitle("Departamentos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 48, 408, 135);
		contentPanel.add(scrollPane);
		
		miModeloDepartamentos = new ModeloTablaDepartamentosAlu();
		tableDepartamentos = new JTable(miModeloDepartamentos);
		scrollPane.setViewportView(tableDepartamentos);
		
		JLabel lblListadoDepartamentos = new JLabel("LISTADO DEPARTAMENTOS");
		lblListadoDepartamentos.setBounds(52, 13, 344, 16);
		contentPanel.add(lblListadoDepartamentos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new OkButtonActionListener());
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new CancelButtonActionListener());
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
