package modelo;

import javax.swing.JOptionPane;

import controlador.ControladorAlu;

public class LogicaAlu {
	//tenemos que relacionarla con el Controlador
	
	ControladorAlu miControlador;

	public void setMiControlador(ControladorAlu miControlador) {
		this.miControlador = miControlador;
	}

	public boolean validarCodigoDepar(String codigo) {
		if(Integer.parseInt(codigo) > 99  && Integer.parseInt(codigo) <1000)
			return true;
			else
			{
				JOptionPane.showMessageDialog(null, "Error código de 3 dígitos");
				return false;
				
			}
	}

	public boolean validarNombre(String nombre, int caso) {
		if(nombre.length() > 20){
			if(caso == 1)
				JOptionPane.showMessageDialog(null, "Error. El nombre no puede tener mas de 20 caracteres");
			else
				JOptionPane.showMessageDialog(null, "Erro. La localidad no puede tener más de 20 caracteres");
			return true;
		}
		else 
			return false;
	}
}
