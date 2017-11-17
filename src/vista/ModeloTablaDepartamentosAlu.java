package vista;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controlador.ControladorAlu;
import modelo.vo.Departamento;

public class ModeloTablaDepartamentosAlu extends AbstractTableModel {
	ArrayList <String> nombresColumnas;
	ArrayList <Departamento> datos;

	public  ModeloTablaDepartamentosAlu() {
		nombresColumnas = new ArrayList<>();

		nombresColumnas.add("Código");
		nombresColumnas.add("Departamento");
		nombresColumnas.add("Localidad");

		datos = new ArrayList<Departamento>();

		cargarDepartamentos();
	}

	private void cargarDepartamentos() {
		ControladorAlu controlador = new ControladorAlu();
		datos = controlador.cargarDepartamentos();
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

		Departamento departamento = datos.get(fila);

		switch(columna){
		case 0:
			return departamento.getCodigo();
		case 1:
			return departamento.getDepartamento();
		case 2:
			return departamento.getLocalidad();
		}
		return departamento;
	}

	@Override
	public String getColumnName(int columna){
		return nombresColumnas.get(columna);
	}
}


