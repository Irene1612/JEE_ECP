package controllersEjb;

import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;
import controllers.VotarController;

public class VotarControllerEjb implements VotarController {

	@Override
	public Tema getTema(Integer id){
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		return temaDao.read(id);
	}

	@Override
	public void aniadirVoto(Integer temaId, int valoracion, NivelEstudios nivelEstudios, String ip) {
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		Tema tema = temaDao.read(temaId);
		Voto voto = new Voto(ip, nivelEstudios, valoracion);		
		tema.putVoto(voto);
		temaDao.update(tema);		
	}
}
