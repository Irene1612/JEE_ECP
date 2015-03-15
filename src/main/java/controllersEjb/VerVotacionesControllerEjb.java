package controllersEjb;

import java.util.List;

import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import controllers.VerVotacionesController;

public class VerVotacionesControllerEjb implements VerVotacionesController {
	
	@Override
	public List<Tema> getTemas() {	
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		return temaDao.findAll();
	}

	@Override
	public boolean hayTemas() {		
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		return !temaDao.findAll().isEmpty();
	}

}
