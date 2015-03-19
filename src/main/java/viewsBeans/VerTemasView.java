package viewsBeans;

import org.apache.logging.log4j.LogManager;

import controllers.VerVotacionesController;

public class VerTemasView extends TemaView {

	@Override
	public void update() {
		super.update();
		VerVotacionesController verVotacionesController = this.getControllerFactory()
				.getVerVotacionesController();
		LogManager.getLogger(VerTemasView.class).debug("Se accede a la capa de negocio para recuperar temas");
		this.mostrarTemas(verVotacionesController);
	}
}