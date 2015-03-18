package controllers;

import java.util.List;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudioVotos;

public interface VerVotacionesController extends TemaController {

	public Tema getTema(Integer id);

	public NivelEstudioVotos[] calcularMediaVotos(List<Voto> votos);
}
