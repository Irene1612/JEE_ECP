package controllers;

import java.util.List;

import models.entities.Tema;

public interface VerVotacionesController {

	public List<Tema> getTemas();
	
	public boolean hayTemas();

}
