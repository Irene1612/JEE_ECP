package views.beans.jsp;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import controllers.VerVotacionesController;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

public class VerDetallesTemaView extends ViewBean {
	private static final int SIN_ESTUDIOS = 0;
	private static final int ESO = 1;
	private static final int BACH_FP = 2;
	private static final int UNI = 3;
	public Tema tema;
	public Integer id;
	public int numeroVotos;
	public int[] numeroVotosEstudio;
	public double[] mediaPorNivelEstudios;

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		LogManager.getLogger(VerDetallesTemaView.class).debug(
				"Le pongo al verDetallesView el id del tema");
		this.id = id;
	}

	public int getNumeroVotos() {
		return numeroVotos;
	}

	public double[] getMediaPorNivelEstudios() {
		return mediaPorNivelEstudios;
	}

	public void update() {
		VerVotacionesController verVotacionesController = this
				.getControllerFactory().getVerVotacionesController();
		LogManager.getLogger(VerDetallesTemaView.class).debug(
				"Se accede a la capa de negocio para recuperar el tema");
		this.tema = verVotacionesController.getTema(this.id);
		List<Voto> votos = this.tema.getVotos();
		this.numeroVotos = votos.size();
		LogManager.getLogger(VerDetallesTemaView.class).debug(
				"Numero de votos:" + this.numeroVotos);
		// inicializo los arrays
		this.numeroVotosEstudio = new int[NivelEstudios.values().length];
		this.mediaPorNivelEstudios = new double[NivelEstudios.values().length];
		for (int i = 0; i < NivelEstudios.values().length; i++) {
			this.numeroVotosEstudio[i] = 0;
			this.mediaPorNivelEstudios[i] = 0.0;
		}
		// calculo la media por cada nivel de estudios
		if (this.numeroVotos != 0) {
			LogManager.getLogger(VerDetallesTemaView.class).debug(
					"Entro en el if porque hay votos");
			for (int i = 0; i < votos.size(); i++) {
				switch (votos.get(i).getNivelEstudios()) {
				case SIN_ESTUDIOS:
					this.numeroVotosEstudio[VerDetallesTemaView.SIN_ESTUDIOS]++;
					this.mediaPorNivelEstudios[VerDetallesTemaView.SIN_ESTUDIOS] += votos
							.get(i).getValoracion();
					break;
				case ESO:
					this.numeroVotosEstudio[VerDetallesTemaView.ESO]++;
					this.mediaPorNivelEstudios[VerDetallesTemaView.ESO] += votos
							.get(i).getValoracion();
					break;
				case BACHILLERATO_FP:
					this.numeroVotosEstudio[VerDetallesTemaView.BACH_FP]++;
					this.mediaPorNivelEstudios[VerDetallesTemaView.BACH_FP] += votos
							.get(i).getValoracion();
					break;
				case UNIVERSITARIO:
					this.numeroVotosEstudio[VerDetallesTemaView.BACH_FP]++;
					this.mediaPorNivelEstudios[VerDetallesTemaView.UNI] += votos
							.get(i).getValoracion();
					break;
				default:
					break;
				}
			}
			if (this.numeroVotosEstudio[VerDetallesTemaView.SIN_ESTUDIOS] != 0)
				this.mediaPorNivelEstudios[VerDetallesTemaView.SIN_ESTUDIOS] = this.mediaPorNivelEstudios[VerDetallesTemaView.SIN_ESTUDIOS]
						/ this.numeroVotosEstudio[VerDetallesTemaView.SIN_ESTUDIOS];
			if (this.numeroVotosEstudio[VerDetallesTemaView.ESO] != 0)
				this.mediaPorNivelEstudios[VerDetallesTemaView.ESO] = this.mediaPorNivelEstudios[VerDetallesTemaView.ESO]
						/ this.numeroVotosEstudio[VerDetallesTemaView.ESO];
			if (this.numeroVotosEstudio[VerDetallesTemaView.ESO] != 0)
				this.mediaPorNivelEstudios[VerDetallesTemaView.BACH_FP] = this.mediaPorNivelEstudios[VerDetallesTemaView.BACH_FP]
						/ this.numeroVotosEstudio[VerDetallesTemaView.BACH_FP];
			if (this.numeroVotosEstudio[VerDetallesTemaView.ESO] != 0)
				this.mediaPorNivelEstudios[VerDetallesTemaView.UNI] = this.mediaPorNivelEstudios[VerDetallesTemaView.UNI]
						/ this.numeroVotosEstudio[VerDetallesTemaView.UNI];
		}

	}
}
