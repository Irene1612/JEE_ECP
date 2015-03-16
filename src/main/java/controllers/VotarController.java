package controllers;

import models.entities.Tema;
import models.utils.NivelEstudios;

public interface VotarController {

	Tema getTema(Integer id);

	void aniadirVoto(Integer id, int valoracion, NivelEstudios nivelEstudios, String ip);

}
