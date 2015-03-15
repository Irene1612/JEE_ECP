package controllersEjb;

import org.apache.logging.log4j.LogManager;

import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import controllers.EliminarTemaController;

public class EliminarTemaControllerEjb extends TemaControllerEjb implements EliminarTemaController {
	
	@Override
	public void eliminarTema(Integer id) {
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		LogManager.getLogger(AniadirTemaControllerEjb.class).debug("Tema eliminado: " + temaDao.read(id).toString());
		temaDao.deleteById(id);		
	}

}
