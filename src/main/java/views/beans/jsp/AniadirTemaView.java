package views.beans.jsp;

import org.apache.logging.log4j.LogManager;

import models.entities.Tema;
import controllers.AniadirTemaController;

public class AniadirTemaView extends ViewBean{
	
	public String aniadirTema(Tema tema){
		LogManager.getLogger(AniadirTemaView.class).debug("Probando: " + this.getControllerFactory());
		AniadirTemaController aniadirTemaController = this.getControllerFactory().getAniadirTemaController();
		LogManager.getLogger(AniadirTemaView.class).debug("Se accede a la capa de negocio para aniadir un tema");
		aniadirTemaController.crearTema(tema);		
		return "temaAniadidoCorrectamente";
	}
}
