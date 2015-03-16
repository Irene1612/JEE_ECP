package controllersEjb;

import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import controllers.VerVotacionesController;

public class VerVotacionesControllerEjb extends TemaControllerEjb implements VerVotacionesController {
	
	public Tema getTema(Integer id){
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		return temaDao.read(id);
	}
}
