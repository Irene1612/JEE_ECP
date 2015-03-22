package viewsBeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import controllers.EliminarTemaController;

@ManagedBean
public class EliminarTemaView extends TemaView {
	
	public EliminarTemaView() {		
	}

	@PostConstruct
	@Override
	public void update() {
		super.update();
		EliminarTemaController eliminarTemaController = this.getControllerFactory()
				.getEliminarTemaController();
		LogManager.getLogger(EliminarTemaView.class).debug(
				"Se accede a la capa de negocio para recuperar temas");
		this.mostrarTemas(eliminarTemaController);
	}

	public String eliminarTema(Integer id) {
		EliminarTemaController eliminarTemaController = this.getControllerFactory()
				.getEliminarTemaController();
		LogManager.getLogger(EliminarTemaView.class).debug(
				"Se accede a la capa de negocio para eliminar un tema");
		eliminarTemaController.eliminarTema(id);
		return "temaEliminadoCorrectamente";
	}

	public String process() {
		LogManager.getLogger(EliminarTemaView.class).debug("Process...");
		return this.eliminarTema(this.idTema);
	}
}
