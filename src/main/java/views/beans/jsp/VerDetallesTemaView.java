package views.beans.jsp;

import org.apache.logging.log4j.LogManager;

import controllers.VerVotacionesController;
import models.entities.Tema;

public class VerDetallesTemaView extends ViewBean{
	public Tema tema;

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public Tema conseguirTema(Integer id) {		
		VerVotacionesController verVotacionesController = this.getControllerFactory().getVerVotacionesController();
		LogManager.getLogger(VerTemasView.class).debug("Se accede a la capa de negocio para recuperar el tema");
		return verVotacionesController.getTema(id);
	}
}
