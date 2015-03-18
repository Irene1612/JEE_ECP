package models.daos.jpa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import models.daos.DaoFactory;
import models.daos.VotoDao;
import models.entities.Voto;
import models.utils.NivelEstudios;

public class VotoDaoJpaTest {

	private VotoDao dao;

	private Voto voto;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.dropAndCreateTables();
	}

	@Before
	public void init() {
		dao = DaoJpaFactory.getFactory().getVotoDao();
		voto = new Voto("128.0.0.0", NivelEstudios.SIN_ESTUDIOS, 5);
		dao.create(voto);
	}

	@Test
	public void testCreateRead() {
		assertTrue(voto.equals(dao.read(voto.getId())));
	}

	@Test
	public void testUpdate() {
		voto.setNivelEstudios(NivelEstudios.UNIVERSITARIO);
		dao.update(voto);
		assertTrue(voto.equals(dao.read(voto.getId())));
	}

	@Test
	public void testDeleteById() {
		dao.deleteById(voto.getId());
		assertNull(dao.read(voto.getId()));
	}

	@Test
	public void testFindAll() {
		assertTrue(dao.findAll().size() == 1);
	}

	@After
	public void after() {
		dao.deleteById(voto.getId());
	}
}
