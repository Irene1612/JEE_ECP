package views.beans.jsp;

import java.util.ArrayList;
import java.util.List;

import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.ControllerFactory;
import controllersEjb.ControllerEjbFactory;
import controllersEjb.VerVotacionesControllerEjb;

public class VerTemasView {

	private List<Tema> temas;

	private boolean hayTemas;

	private String errorMsg;

	private ControllerFactory controllerFactory;

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
		//VerVotacionesControllerEjb verVotacionesControllerEjb = this.getControllerFactory().getVerVotacionesController();
		this.temas = new ArrayList<Tema>();
		
		//this.setControllerFactory(new ControllerEjbFactory());
		LogManager.getLogger(VerTemasView.class).debug("Se accede a la capa de negocio para recuperar temas");
		LogManager.getLogger(VerTemasView.class).debug("Probando: " + controllerFactory);		
		if (controllerFactory.getVerVotacionesController().hayTemas()) {
			LogManager.getLogger(VerTemasView.class).debug("Entro en el if porque hay temas en la bbdd");
			this.setHayTemas(true);
			this.setTemas(controllerFactory.getVerVotacionesController().getTemas());
		} else {
			this.setHayTemas(false);
		}
	}

	// public String process() {
	// if (this.temas.size() == 0) {
	// this.errorMsg = "No se ha añadido ningún tema.";
	// return "error";
	// } else {
	// LogManager.getLogger(VerTemasView.class).debug(
	// "Se accede a la capa de negocio para ver temas.");
	// return "tema";
	// }
	// }

//	public void setControllerFactory(ControllerFactory controllerFactory) {
//		controllerFactory = this.controllerFactory;
//	}
	
	
	private ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

	public void setControllerFactory(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
	}
}
