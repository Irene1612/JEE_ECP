package views.beans.jsp;

import java.util.ArrayList;
import java.util.List;

import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.EliminarTemaController;

public class EliminarTemaView extends ViewBean{
	
	private List<Tema> temas;

	private boolean hayTemas;

	private String errorMsg;
	
	
	public List<Tema> getTemas() {
		return temas;
	}
	
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public boolean isHayTemas() {
		return hayTemas;
	}

	public void setHayTemas(boolean hayTemas) {
		this.hayTemas = hayTemas;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public void update() {
		EliminarTemaController eliminarTemaController = this.getControllerFactory().getEliminarTemaController();
		this.temas = new ArrayList<Tema>();
		LogManager.getLogger(VerTemasView.class).debug("Se accede a la capa de negocio para recuperar temas");
		LogManager.getLogger(VerTemasView.class).debug("¿Hay temas?: " + eliminarTemaController.hayTemas());		
		if (eliminarTemaController.hayTemas()) {
			LogManager.getLogger(VerTemasView.class).debug("Entro en el if porque hay temas en la bbdd");
			this.setHayTemas(true);
			this.setTemas(eliminarTemaController.getTemas());
		} else {
			this.setHayTemas(false);
			this.setErrorMsg("No hay ningún tema para elegir!!!!!");
		}
	}

	public String eliminarTema(Integer id) {
		EliminarTemaController eliminarTemaController = this.getControllerFactory().getEliminarTemaController();
		LogManager.getLogger(EliminarTemaView.class).debug("Se accede a la capa de negocio para aniadir un tema");
		eliminarTemaController.eliminarTema(id);	
		return "temaEliminadoCorrectamente";
	}

}
