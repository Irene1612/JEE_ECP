package controllers;

import java.util.List;

import models.entities.Tema;

public interface TemaController {

	public List<Tema> getTemas();
	
	public boolean hayTemas();
}
