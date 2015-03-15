package views.beans.jsp;

import models.entities.Tema;
import controllers.AniadirTemaController;

public class AniadirTemaView extends ViewBean{
	
	public String aniadirTema(Tema tema){
		AniadirTemaController aniadirTemaController = this.getControllerFactory().getAniadirTemaController();
		aniadirTemaController.crearTema(tema);
		
		return "temaAniadidoCorrectamente";
	}
}
