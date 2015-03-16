package controllers;

import models.entities.Tema;

public interface VerVotacionesController extends TemaController{

	public Tema getTema(Integer id);
}
