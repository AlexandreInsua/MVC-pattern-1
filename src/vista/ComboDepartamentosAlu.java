package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.ControladorAlu;
import modelo.vo.Departamento;

public class ComboDepartamentosAlu extends JComboBox<Departamento> {
	ArrayList <Departamento> departamentos = null; 
	ControladorAlu controlador = new ControladorAlu();
	
	public void setControlador(ControladorAlu controlador) {
		this.controlador = controlador;
	}

	public ComboDepartamentosAlu() {
		cargarDepartamentos();
	}

	private void cargarDepartamentos() {
		
		departamentos = controlador.cargarDepartamentos();
		for(Departamento departamento : departamentos){
			this.addItem(departamento);
		}		
	}
}
