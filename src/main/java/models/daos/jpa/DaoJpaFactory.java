package models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;

import org.apache.logging.log4j.LogManager;


public class DaoJpaFactory extends DaoFactory {
    private static final String PERSISTENCE_UNIT = "tictactoe";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

	@Override
	public TemaDao getUserDao() {
		return null;
	}

	@Override
	public VotoDao getCategoryDao() {
		return null;
	}
}
