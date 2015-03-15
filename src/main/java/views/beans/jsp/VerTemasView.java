package views.beans.jsp;

import java.util.ArrayList;
import java.util.List;

import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.ControllerFactory;
import controllers.VerVotacionesController;

public class VerTemasView extends ViewBean{

	private List<Tema> temas;

	private boolean hayTemas;

	private String errorMsg;

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	
	public boolean isHayTemas() {
		return hayTemas;
	}

	public void setHayTemas(boolean hayTemas) {
		this.hayTemas = hayTemas;
	}

	public void update() {
		VerVotacionesController verVotacionesController = this.getControllerFactory().getVerVotacionesController();
		this.temas = new ArrayList<Tema>();
		LogManager.getLogger(VerTemasView.class).debug("Se accede a la capa de negocio para recuperar temas");
		LogManager.getLogger(VerTemasView.class).debug("Probando: " + verVotacionesController);		
		if (verVotacionesController.hayTemas()) {
			LogManager.getLogger(VerTemasView.class).debug("Entro en el if porque hay temas en la bbdd");
			this.setHayTemas(true);
			this.setTemas(verVotacionesController.getTemas());
		} else {
			this.setHayTemas(false);
		}
	}

//	public void setControllerFactory(ControllerFactory controllerFactory) {
//		controllerFactory = this.controllerFactory;
//	}
	
}
