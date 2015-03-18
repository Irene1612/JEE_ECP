package controllersEjb;

import org.apache.logging.log4j.LogManager;

import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import controllers.AniadirTemaController;

public class AniadirTemaControllerEjb implements AniadirTemaController {

	@Override
	public void crearTema(Tema tema) {
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		temaDao.create(tema);
		LogManager.getLogger(AniadirTemaControllerEjb.class).debug("Tema creado: " + tema.toString());
	}
}
