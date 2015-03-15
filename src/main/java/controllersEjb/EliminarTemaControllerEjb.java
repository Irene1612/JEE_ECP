package controllersEjb;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import controllers.EliminarTemaController;

public class EliminarTemaControllerEjb implements EliminarTemaController {

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
	
	@Override
	public void eliminarTema(Integer id) {
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		LogManager.getLogger(AniadirTemaControllerEjb.class).debug("Tema eliminado: " + temaDao.read(id).toString());
		temaDao.deleteById(id);		
	}

}
