package viewsBeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.logging.log4j.LogManager;

import controllers.VerVotacionesController;

@ManagedBean
@RequestScoped
public class VerTemasView extends TemaView {

	public VerTemasView() {		
	}
	
	@PostConstruct
	@Override
	public void update() {
		super.update();
		VerVotacionesController verVotacionesController = this.getControllerFactory()
				.getVerVotacionesController();
		LogManager.getLogger(VerTemasView.class).debug("Se accede a la capa de negocio para recuperar temas");
		this.mostrarTemas(verVotacionesController);
	}
	
	public String process() {
		return "verDetallesTema";
	}
}
