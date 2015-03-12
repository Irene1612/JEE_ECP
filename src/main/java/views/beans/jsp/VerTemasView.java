package views.beans.jsp;

import java.util.List;

import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.ControllerFactory;

public class VerTemasView {
	
	private List<Tema> temas;
	
	private String errorMsg;

	private ControllerFactory controllerFactory;
	
	public VerTemasView(){		
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	public String getErrorMsg() {
        return errorMsg;
    }
	
	public void update() {
        LogManager.getLogger(VerTemasView.class).debug(
                "Se accede a la capa de negocio para recuperar temas");
        //this.temas = controllerFactory.getVerVotacionesController().getTemas();
    }	
	
	public String process() {
        if (this.temas.size() == 0) {
            this.errorMsg = "No se ha añadido ningún tema.";
            return "error";
        } else {
            LogManager.getLogger(VerTemasView.class).debug(
                    "Se accede a la capa de negocio para ver temas.");
            return "tema";
        }
    }

	public void setControllerFactory(ControllerFactory controllerFactory) {
		controllerFactory = this.controllerFactory;
		
	}
}
