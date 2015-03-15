package controllers;

import java.util.List;

import models.entities.Tema;

public interface EliminarTemaController {
	void eliminarTema(Integer id);

	List<Tema> getTemas();

	boolean hayTemas();
}
