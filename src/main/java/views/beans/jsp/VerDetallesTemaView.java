package views.beans.jsp;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import controllers.VerVotacionesController;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

public class VerDetallesTemaView extends ViewBean {
	public Tema tema;
	public Integer id;
	public int numeroVotos;
	public int[] numeroVotosEstudio;
	public Double[] mediaPorNivelEstudios;
	public String[] nivelesEstudios;
	public int cantidadNiveles;
	
	public VerDetallesTemaView() {
		this.numeroVotosEstudio = new int[NivelEstudios.values().length];
		this.mediaPorNivelEstudios = new Double[NivelEstudios.values().length];
		this.nivelesEstudios = new String[NivelEstudios.values().length];
		this.cantidadNiveles = NivelEstudios.values().length - 1;
		for (int i = 0; i < NivelEstudios.values().length; i++) {
			this.numeroVotosEstudio[i] = 0;
			this.mediaPorNivelEstudios[i] = null;
			this.nivelesEstudios[i] = NivelEstudios.values()[i].toString();
		}		
	}

	public Tema getTema() {
		return tema;
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

	public Double[] getMediaPorNivelEstudios() {
		return mediaPorNivelEstudios;
	}		

	public String[] getNivelesEstudios() {
		return nivelesEstudios;
	}

	public int getCantidadNiveles() {
		return cantidadNiveles;
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
		
		this.calcularMediaVotos(votos);
	}

	private void calcularMediaVotos(List<Voto> votos) {
		// calculo la media por cada nivel de estudios
		if (this.numeroVotos != 0) {
			LogManager.getLogger(VerDetallesTemaView.class).debug(
					"Entro en el if porque hay votos");
			for (int i = 0; i < votos.size(); i++) {
				switch (votos.get(i).getNivelEstudios()) {
					case SIN_ESTUDIOS:
						this.rellenarNumeroVotosYMediaPorEstudio(NivelEstudios.SIN_ESTUDIOS.ordinal(), votos, i);
						LogManager.getLogger(VerDetallesTemaView.class).debug(
								"Hay un voto de SIN ESTUDIOS");
						break;
					case ESO:
						this.rellenarNumeroVotosYMediaPorEstudio(NivelEstudios.ESO.ordinal(), votos, i);
						LogManager.getLogger(VerDetallesTemaView.class).debug(
								"Hay un voto de ESO");
						break;
					case BACHILLERATO_FP:
						this.rellenarNumeroVotosYMediaPorEstudio(NivelEstudios.BACHILLERATO_FP.ordinal(), votos, i);
						LogManager.getLogger(VerDetallesTemaView.class).debug(
								"Hay un voto de BACHILLERATO FP");
						break;
					case UNIVERSITARIO:
						this.rellenarNumeroVotosYMediaPorEstudio(NivelEstudios.UNIVERSITARIO.ordinal(), votos, i);
						LogManager.getLogger(VerDetallesTemaView.class).debug(
								"Hay "+this.numeroVotosEstudio[NivelEstudios.UNIVERSITARIO.ordinal()]+" voto/s de UNIVERSITARIO");
						break;
					default:
						break;
				}
			}			
			for(int i = 0; i< NivelEstudios.values().length; i++){
				if (this.numeroVotosEstudio[i] != 0){					
					this.mediaPorNivelEstudios[i] = this.mediaPorNivelEstudios[i]
							/ this.numeroVotosEstudio[i];
					LogManager.getLogger(VerDetallesTemaView.class).debug(
							"Entro en el if porque hay voto/s en el nivel de estudio. La media es: " + this.mediaPorNivelEstudios[i]);
				}
			}
		}

	}

	private void rellenarNumeroVotosYMediaPorEstudio(int ordinal, List<Voto> votos, int iteradorVotos) {		
		this.numeroVotosEstudio[ordinal]++;
		if(this.mediaPorNivelEstudios[ordinal] == null){
			this.mediaPorNivelEstudios[ordinal] = 0.0;
		}
			this.mediaPorNivelEstudios[ordinal] += votos
					.get(iteradorVotos).getValoracion();		
	}
}
