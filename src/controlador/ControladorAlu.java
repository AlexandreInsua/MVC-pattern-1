package controlador;

import java.util.ArrayList;

import modelo.LogicaAlu;
import modelo.dao.DepartamentoDaoAlu;
import modelo.dao.EmpleadoDaoAlu;
import modelo.vo.Departamento;
import modelo.vo.EmpleadosSalarioAlu;
import vista.VentanaDepartamentosConsultarAlu;
import vista.VentanaDepartamentosEliminarAlu;
import vista.VentanaDepartamentosModificarAlu;
import vista.VentanaDepartamentosNuevoAlu;
import vista.VentanaEmpleadosDepartamentoAlu;
import vista.VentanaListadoDepartamentosAlu;
import vista.VentanaPrincipalAlu;

public class ControladorAlu {

	// objetos de cada uno de los formularios
	VentanaPrincipalAlu miVentanaPrincipal;
	VentanaDepartamentosNuevoAlu miVentanaDepartamentosNuevo;
	VentanaDepartamentosModificarAlu miVentanaDepartamentosModificar;
	VentanaDepartamentosEliminarAlu miVentanaDepartamentosEliminar;
	VentanaDepartamentosConsultarAlu miVentanaDepartamentosConsultar;
	VentanaListadoDepartamentosAlu miVentanaListadoDepartamentos;
	VentanaEmpleadosDepartamentoAlu miVentanaEmpleadosDepartamento;
	


	// objeto de la clase Logica
	LogicaAlu miLogica;

	//clases Dao

	DepartamentoDaoAlu departamentoDao = new DepartamentoDaoAlu();
	

	EmpleadoDaoAlu empleadoDao = new EmpleadoDaoAlu();



	public ControladorAlu() {
		super();
	}

	//creamos los metodos set para los atributos de la clase ControladorAlu
	public void setMiVentanaDepartamentosNuevo(VentanaDepartamentosNuevoAlu miVentanaDepartamentosNuevo) {
		this.miVentanaDepartamentosNuevo = miVentanaDepartamentosNuevo;
	}


	public void setMiVentanaPrincipal(VentanaPrincipalAlu miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}




	public void setMiVentanaDepartamentosModificar(VentanaDepartamentosModificarAlu miVentanaDepartamentosModificar) {
		this.miVentanaDepartamentosModificar = miVentanaDepartamentosModificar;
	}



	public void setMiVentanaDepartamentosEliminar(VentanaDepartamentosEliminarAlu miVentanaDepartamentosEliminar) {
		this.miVentanaDepartamentosEliminar = miVentanaDepartamentosEliminar;
	}

	
	
	public void setMiVentanaDepartamentosConsultar(VentanaDepartamentosConsultarAlu miVentanaDepartamentosConsultar) {
		this.miVentanaDepartamentosConsultar = miVentanaDepartamentosConsultar;
	}

	public void setMiVentanaListadoDepartamentos(VentanaListadoDepartamentosAlu miVentanaListadoDepartamentos) {
		this.miVentanaListadoDepartamentos = miVentanaListadoDepartamentos;
	}

	public void setMiLogica(LogicaAlu miLogica) {
		this.miLogica = miLogica;
	}
	
	public void setMiVentanaEmpleadosDepartamento(VentanaEmpleadosDepartamentoAlu miVentanaEmpleadosDepartamento) {
		this.miVentanaEmpleadosDepartamento = miVentanaEmpleadosDepartamento;
	}
	

	// mostramos las ventanas
	public void mostrarVentanaNuevoDepartamento() {
		miVentanaDepartamentosNuevo.setVisible(true);
	}

	public void mostrarVentanaModificarDepartamento() {
		miVentanaDepartamentosModificar.setVisible(true);

	}
	public void mostraVentanaConsultas() {
		miVentanaDepartamentosConsultar.setVisible(true);
		
	}
	
	public void mostrarVentanaListadoDepartamentos() {
		miVentanaListadoDepartamentos.setVisible(true);
		
	}
	public void mostrarVentanaEmpleadosDepartamento() {
		miVentanaEmpleadosDepartamento.setVisible(true);
		
	}
	
	public void mostrarVentanaEliminarDepartamento() {
		miVentanaDepartamentosEliminar.setVisible(true);
		
	}

	///////////////////////////////////////////////////////////////////////////////////
	public boolean validarCodigoDepar(String codigo) {

		return miLogica.validarCodigoDepar(codigo);
	}

	public boolean validarNombre(String nombre, int caso) {

		return miLogica.validarNombre(nombre, caso);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	public ArrayList<Departamento> cargarDepartamentos() {
		return departamentoDao.cargarDepartamentos();
		
	}

	public void nuevoDepartamento(Departamento departamento) {
		departamentoDao.nuevoDepartamento(departamento);

	}

	public Departamento buscarDepartamento(short codigo) {

		return departamentoDao.buscarDepartamento(codigo);
	}

	public void modificarDepartamento(Departamento departamento) {
		departamentoDao.modificarDepartamento(departamento);

	}

	public void eliminarDepartamento(short codigo) {
		departamentoDao.eliminarDepartamento(codigo);

	}

	public Departamento primerDepartamento() {
	
		return departamentoDao.primerDepartamento();
	}

	public Departamento ultimoDepartamento() {
		return departamentoDao.ultimoDepartamento();
	}

	public Departamento anteriorDepartamento(short codigo) {
		return departamentoDao.anteriorDepartamento(codigo);
		
	}
	
	public Departamento siguienteDepartamento(short codigo) {
		return departamentoDao.siguienteDepartamento(codigo);
	}

	////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<EmpleadosSalarioAlu> cargarEmpleadosSalarios(Departamento departamento) {
		// TODO Auto-generated method stub
		return empleadoDao.cargarEmpleadosSalarios(departamento.getCodigo());
	}
}
