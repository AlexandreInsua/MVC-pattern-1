package controller;

import java.util.ArrayList;
import java.util.Iterator;
import model.LogicaAlu;
import model.DepartamentoDao;
import model.EmpleadoDao;
import model.Departamento;
import model.Empleado;
import view.VentanaDepartamentosNuevoAlu;
import view.VentanaPrincipalAlu;

public class ControladorAlu {

	// objetos de cada uno de los formularios
	VentanaPrincipalAlu miVentanaPrincipal;
	VentanaDepartamentosNuevoAlu miVentanaDepartamentosNuevo;

	// objeto de la clase Logica
	LogicaAlu miLogica;

	public ControladorAlu() {
		super();
	}

	// creamos los metodos set para los atributos de la clase ControladorAlu
	public void setMiVentanaDepartamentosNuevo(VentanaDepartamentosNuevoAlu miVentanaDepartamentosNuevo) {
		this.miVentanaDepartamentosNuevo = miVentanaDepartamentosNuevo;
	}

	public void setMiVentanaPrincipal(VentanaPrincipalAlu miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public void setMiLogica(LogicaAlu miLogica) {
		this.miLogica = miLogica;
	}

	// mostramos las ventanas
	public void mostrarVentanaNuevoDepartamento() {
		miVentanaDepartamentosNuevo.setVisible(true);
	}

	public boolean validarCodigoDepar(String codigo) {
		// TODO Auto-generated method stub
		return miLogica.validarCodigoDepar(codigo);
	}

	public boolean validarNombre(String nombre, int caso) {
		// TODO Auto-generated method stub
		return miLogica.validarNombre(nombre, caso);
	}

}
