package viewsBeans;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import controllers.VerVotacionesController;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudioVotos;
import models.utils.NivelEstudios;

public class VerDetallesTemaView extends ViewBean {
	public Tema tema;
	public Integer idTema;
	public int numeroVotos;
	public NivelEstudioVotos[] nivelEstudioVotos;

	public VerDetallesTemaView() {
		this.nivelEstudioVotos = new NivelEstudioVotos[NivelEstudios.values().length];
	}

	public Tema getTema() {
		return tema;
	}

	public Integer getIdTema() {
		return idTema;
	}

	public void setId(Integer id) {
		LogManager.getLogger(VerDetallesTemaView.class).debug("Le pongo al verDetallesView el id del tema");
		this.idTema = id;
	}

	public int getNumeroVotos() {
		return numeroVotos;
	}

	public NivelEstudioVotos[] getNivelEstudioVotos() {
		return nivelEstudioVotos;
	}

	public void update() {
		VerVotacionesController verVotacionesController = this.getControllerFactory()
				.getVerVotacionesController();
		LogManager.getLogger(VerDetallesTemaView.class).debug(
				"Se accede a la capa de negocio para recuperar el tema");
		this.tema = verVotacionesController.getTema(this.idTema);
		List<Voto> votos = this.tema.getVotos();
		this.numeroVotos = votos.size();
		LogManager.getLogger(VerDetallesTemaView.class).debug("Numero de votos:" + this.numeroVotos);
		nivelEstudioVotos = verVotacionesController.calcularMediaVotos(votos);
	}
}
