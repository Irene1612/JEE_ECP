package views.beans.jsp;

import org.apache.logging.log4j.LogManager;

import controllers.EliminarTemaController;

public class EliminarTemaView extends TemaView{
	
	@Override
	public void update() {
		super.update();
		EliminarTemaController eliminarTemaController = this.getControllerFactory().getEliminarTemaController();
		LogManager.getLogger(EliminarTemaView.class).debug("Se accede a la capa de negocio para recuperar temas");
		this.mostrarTemas(eliminarTemaController);	
	}

	public String eliminarTema(Integer id) {
		EliminarTemaController eliminarTemaController = this.getControllerFactory().getEliminarTemaController();
		LogManager.getLogger(EliminarTemaView.class).debug("Se accede a la capa de negocio para aniadir un tema");
		eliminarTemaController.eliminarTema(id);	
		return "temaEliminadoCorrectamente";
	}

}
