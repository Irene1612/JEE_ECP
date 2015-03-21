package viewsBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;

import controllers.TemaController;
import models.entities.Tema;

public abstract class TemaView extends ViewBean {

	@ManagedProperty(value = "#{temas}")
	public List<Tema> temas;

	public boolean hayTemas;

	public String errorMsg;	

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
		this.temas = new ArrayList<Tema>();
	}

	protected void mostrarTemas(TemaController controller) {
		LogManager.getLogger(TemaView.class).debug("¿Hay temas?: " + controller.hayTemas());
		if (controller.hayTemas()) {
			this.setHayTemas(true);
			this.setTemas(controller.getTemas());
		} else {
			this.setHayTemas(false);
			this.setErrorMsg("No hay ningún tema para elegir!!!!!");
		}
	}
}
