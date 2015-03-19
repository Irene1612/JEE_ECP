package controllersEjb;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import viewsBeans.VerDetallesTemaView;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudioVotos;
import models.utils.NivelEstudios;
import controllers.VerVotacionesController;

public class VerVotacionesControllerEjb extends TemaControllerEjb implements VerVotacionesController {

	@Override
	public Tema getTema(Integer id) {
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		return temaDao.read(id);
	}

	@Override
	public NivelEstudioVotos[] calcularMediaVotos(List<Voto> votos) {
		LogManager.getLogger(VerDetallesTemaView.class).debug("Calculando la media de votos por estudio...");
		NivelEstudioVotos[] nivelEstudioVotos = new NivelEstudioVotos[NivelEstudios.values().length];
		int[] numeroVotosEstudio = new int[NivelEstudios.values().length];
		Double[] valoracionAcumuladaEstudio = new Double[NivelEstudios.values().length];
		this.inicializarArrays(numeroVotosEstudio, valoracionAcumuladaEstudio);
		// calculo la media por cada nivel de estudios
		if (votos.size() != 0) {
			LogManager.getLogger(VerDetallesTemaView.class).debug("Entro en el if porque hay votos");
			for (int i = 0; i < votos.size(); i++) {
				switch (votos.get(i).getNivelEstudios()) {
					case SIN_ESTUDIOS:
						numeroVotosEstudio[NivelEstudios.SIN_ESTUDIOS.ordinal()]++;
						if (valoracionAcumuladaEstudio[NivelEstudios.SIN_ESTUDIOS.ordinal()] == null) {
							valoracionAcumuladaEstudio[NivelEstudios.SIN_ESTUDIOS.ordinal()] = 0.0;
						}
						valoracionAcumuladaEstudio[NivelEstudios.SIN_ESTUDIOS.ordinal()] += votos.get(i)
								.getValoracion();
						LogManager.getLogger(VerVotacionesControllerEjb.class).debug(
								"Hay " + numeroVotosEstudio[NivelEstudios.SIN_ESTUDIOS.ordinal()]
										+ " voto de SIN ESTUDIOS");
						LogManager.getLogger(VerVotacionesControllerEjb.class).debug(
								"Valoracion acumulada: "
										+ valoracionAcumuladaEstudio[NivelEstudios.SIN_ESTUDIOS.ordinal()]
										+ " SIN ESTUDIOS");
						break;
					case ESO:
						numeroVotosEstudio[NivelEstudios.ESO.ordinal()]++;
						if (valoracionAcumuladaEstudio[NivelEstudios.ESO.ordinal()] == null) {
							valoracionAcumuladaEstudio[NivelEstudios.ESO.ordinal()] = 0.0;
						}
						valoracionAcumuladaEstudio[NivelEstudios.ESO.ordinal()] += votos.get(i)
								.getValoracion();
						LogManager.getLogger(VerVotacionesControllerEjb.class).debug(
								"Hay " + numeroVotosEstudio[NivelEstudios.ESO.ordinal()] + " voto de ESO");
						LogManager.getLogger(VerVotacionesControllerEjb.class).debug(
								"Valoracion acumulada: "
										+ valoracionAcumuladaEstudio[NivelEstudios.ESO.ordinal()] + " ESO");
						break;
					case BACHILLERATO_FP:
						numeroVotosEstudio[NivelEstudios.BACHILLERATO_FP.ordinal()]++;
						if (valoracionAcumuladaEstudio[NivelEstudios.BACHILLERATO_FP.ordinal()] == null) {
							valoracionAcumuladaEstudio[NivelEstudios.BACHILLERATO_FP.ordinal()] = 0.0;
						}
						valoracionAcumuladaEstudio[NivelEstudios.BACHILLERATO_FP.ordinal()] += votos.get(i)
								.getValoracion();
						LogManager.getLogger(VerVotacionesControllerEjb.class).debug(
								"Hay " + numeroVotosEstudio[NivelEstudios.BACHILLERATO_FP.ordinal()]
										+ " voto de BACHILLERATO FP");
						LogManager.getLogger(VerVotacionesControllerEjb.class).debug(
								"Valoracion acumulada: "
										+ valoracionAcumuladaEstudio[NivelEstudios.BACHILLERATO_FP.ordinal()]
										+ " BACHILLERATO_FP");
						break;
					case UNIVERSITARIO:
						numeroVotosEstudio[NivelEstudios.UNIVERSITARIO.ordinal()]++;
						if (valoracionAcumuladaEstudio[NivelEstudios.UNIVERSITARIO.ordinal()] == null) {
							valoracionAcumuladaEstudio[NivelEstudios.UNIVERSITARIO.ordinal()] = 0.0;
						}
						valoracionAcumuladaEstudio[NivelEstudios.UNIVERSITARIO.ordinal()] += votos.get(i)
								.getValoracion();
						LogManager.getLogger(VerVotacionesControllerEjb.class).debug(
								"Hay" + numeroVotosEstudio[NivelEstudios.UNIVERSITARIO.ordinal()]
										+ "voto de UNIVERSITARIO");
						LogManager.getLogger(VerVotacionesControllerEjb.class).debug(
								"Valoracion acumulada: "
										+ valoracionAcumuladaEstudio[NivelEstudios.UNIVERSITARIO.ordinal()]
										+ " UNIVERSITARIO");
						break;
					default:
						break;
				}
			}
		}
		for (int i = 0; i < NivelEstudios.values().length; i++) {
			nivelEstudioVotos[i] = new NivelEstudioVotos(NivelEstudios.values()[i].toString());
			LogManager.getLogger(VerVotacionesControllerEjb.class).debug(
					"Creado nuevo nivelEstudioVotos -> " + NivelEstudios.values()[i]
							+ ", con una valoracionAcumulada de: " + valoracionAcumuladaEstudio[i]);
			if (valoracionAcumuladaEstudio[i] != null) {
				Double media = nivelEstudioVotos[i].calcularMedia(valoracionAcumuladaEstudio[i],
						numeroVotosEstudio[i]);
				nivelEstudioVotos[i].setMediaVotos(media);
			}
		}
		return nivelEstudioVotos;
	}

	private void inicializarArrays(int[] numeroVotosEstudio, Double[] valoracionAcumuladaEstudio) {
		for (int i = 0; i < NivelEstudios.values().length; i++) {
			numeroVotosEstudio[i] = 0;
			valoracionAcumuladaEstudio[i] = null;
		}
	}
}
