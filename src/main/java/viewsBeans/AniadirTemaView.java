package viewsBeans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;

import models.entities.Tema;
import controllers.AniadirTemaController;

@ManagedBean
public class AniadirTemaView extends ViewBean {
	
	@ManagedProperty(value = "#{nombreTema}")
	private String nombreTema;
	
	@ManagedProperty(value = "#{preguntaTema}")
	private String preguntaTema;

	public AniadirTemaView() {
	}

	public String getNombreTema() {
		return nombreTema;
	}

	public void setNombreTema(String nombre) {
		this.nombreTema = nombre;
	}

	public String getPreguntaTema() {
		return preguntaTema;
	}

	public void setPreguntaTema(String pregunta) {
		this.preguntaTema = pregunta;
	}

	public String aniadirTema(Tema tema) {
		LogManager.getLogger(AniadirTemaView.class).debug("Probando: " + this.getControllerFactory());
		AniadirTemaController aniadirTemaController = this.getControllerFactory().getAniadirTemaController();
		LogManager.getLogger(AniadirTemaView.class).debug(
				"Se accede a la capa de negocio para aniadir un tema");
		aniadirTemaController.crearTema(tema);
		return "temaAniadidoCorrectamente";
	}
	
	public String process() {
		LogManager.getLogger(AniadirTemaView.class).debug("Process...");
		Tema tema = new Tema(this.nombreTema, this.preguntaTema);
		return this.aniadirTema(tema);
	}
}
