package controllersEjb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controllers.AniadirTemaController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.VerVotacionesController;
import controllers.VotarController;

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {

	private VotarController votarController;

	private VerVotacionesController verVotacionesController;

	private AniadirTemaController aniadirTemaController;

	private EliminarTemaController eliminarTemaController;

	public ControllerEjbFactory() {
	}

	@Override
	public VotarController getVotarController() {
		if (votarController == null) {
			votarController = new VotarControllerEjb();
		}
		return votarController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (verVotacionesController == null) {
			verVotacionesController = new VerVotacionesControllerEjb();
		}
		return verVotacionesController;
	}

	@Override
	public AniadirTemaController getAniadirTemaController() {
		if (aniadirTemaController == null) {
			aniadirTemaController = new AniadirTemaControllerEjb();
		}
		return aniadirTemaController;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		if (eliminarTemaController == null) {
			eliminarTemaController = new EliminarTemaControllerEjb();
		}
		return eliminarTemaController;
	}
}
