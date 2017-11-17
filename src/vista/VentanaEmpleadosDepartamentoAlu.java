package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controlador.ControladorAlu;
import modelo.vo.Departamento;

public class VentanaEmpleadosDepartamentoAlu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JScrollPane scrollPane ;
	
	ComboDepartamentosAlu comboDepartamentos;
	
	private ControladorAlu controlador;
	private JTable tableEmpleadosDepar;
	ModeloTablaEmpleadosSalarioAlu miModeloEmpleados;
	private JButton okButton;
	
	
	public void setComboDepartamentos(ComboDepartamentosAlu comboDepartamentos) {
		this.comboDepartamentos = comboDepartamentos;
	}

	public void setControlador(ControladorAlu controlador) {
		this.controlador = controlador;
	}

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			VentanaEmpleadosDepartamentoAlu dialog = new VentanaEmpleadosDepartamentoAlu();
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
	public VentanaEmpleadosDepartamentoAlu() {
		setTitle("Departamentos");
		setBounds(100, 100, 784, 348);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(12, 13, 142, 16);
		contentPanel.add(lblDepartamento);
		
		comboDepartamentos = new ComboDepartamentosAlu();
		comboDepartamentos.addItemListener(new ComboDepartamentosItemListener());
		comboDepartamentos.setBounds(138, 13, 248, 22);
		contentPanel.add(comboDepartamentos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 52, 732, 182);
		contentPanel.add(scrollPane);
		
		miModeloEmpleados = new ModeloTablaEmpleadosSalarioAlu();
		tableEmpleadosDepar = new JTable(miModeloEmpleados);
		//recuperar el valor del combo
		Departamento departamento = (Departamento) comboDepartamentos.getSelectedItem();
		miModeloEmpleados.cargarEmpleadosSalarios(departamento);
		
		scrollPane.setViewportView(tableEmpleadosDepar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
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
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			miModeloEmpleados = new ModeloTablaEmpleadosSalarioAlu();
			tableEmpleadosDepar = new JTable(miModeloEmpleados);
			
			miModeloEmpleados.cargarEmpleadosSalarios((Departamento)comboDepartamentos.getSelectedItem());
			scrollPane.setViewportView(tableEmpleadosDepar);
		}
	}
	private class ComboDepartamentosItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent arg0) {
			okButton.doClick();
		}
	}
}
