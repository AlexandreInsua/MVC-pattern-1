package vista;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controlador.ControladorAlu;
import modelo.vo.Departamento;
import modelo.vo.EmpleadosSalarioAlu;

public class ModeloTablaEmpleadosSalarioAlu extends AbstractTableModel {
	ArrayList<String> nombresColumnas;
	ArrayList<EmpleadosSalarioAlu> datos;
	
	public ModeloTablaEmpleadosSalarioAlu() {
		nombresColumnas = new ArrayList<>();
		
		nombresColumnas.add("Empleado");
		nombresColumnas.add("Categoría");
		nombresColumnas.add("Fecha alta");
		nombresColumnas.add("Salario");
		nombresColumnas.add("Comisión");
		nombresColumnas.add("Total");
		
		datos = new ArrayList<EmpleadosSalarioAlu>();
		
		cargarEmpleadosSalario();
	}

	@Override
	public int getColumnCount() {
		return nombresColumnas.size();
	}

	@Override
	public int getRowCount() {
		return datos.size();
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		
		EmpleadosSalarioAlu empleado = datos.get(fila); 
		switch(columna){
		case 0:
			return empleado.getNombre();
		case 1:
			return empleado.getPuesto();
		case 2:
			return empleado.getFechaAlta();
		case 3:
			return empleado.getSalario();
		case 4:
			return empleado.getComision();
		case 5: 
			return empleado.getSuma();
		}
		return empleado;
	}
	
	@Override
	public String getColumnName(int columna){
		return nombresColumnas.get(columna);
	}
	
	// Sin implementar sería para listar los empleados
	private void cargarEmpleadosSalario() {
		ControladorAlu controlador = new ControladorAlu();
	//	datos = controlador.cargarEmpleados();
		
	}

	public void cargarEmpleadosSalarios(Departamento departamento) {
		ControladorAlu controlador = new ControladorAlu();
		datos = controlador.cargarEmpleadosSalarios(departamento);
		
	}

}
