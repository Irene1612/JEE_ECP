package controllersEjb;

import java.util.List;

import models.daos.jpa.TemaDaoJpa;
import models.entities.Tema;
import controllers.VerVotacionesController;

public class VerVotacionesControllerEjb implements VerVotacionesController {
	
	private TemaDaoJpa tema;
	
	@Override
	public List<Tema> getTemas() {		
		return tema.findAll();
	}

	@Override
	public boolean hayTemas() {		
		return !tema.findAll().isEmpty();
	}

}
