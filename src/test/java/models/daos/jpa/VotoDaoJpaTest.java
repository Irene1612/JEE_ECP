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

	private VotoDao dao = DaoJpaFactory.getFactory().getVotoDao(); // ¿se puede
																	// poner
																	// aqui?

	private Voto voto;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}

	@Before
	public void init() {
		voto = new Voto("128.0.0.0", NivelEstudios.SIN_ESTUDIOS, 5);
		dao.create(voto);
	}

	@Test
	public void testCreate() {
		Voto voto = new Voto("13.62.0.0", NivelEstudios.ESO, 3);
		dao.create(voto);
		assertEquals(voto, dao.read(2));
	}

	@Test
	public void testRead() {		
		assertEquals(voto, dao.read(1));
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		dao.deleteById(1);
		assertNull(dao.read(1));
	}

	@Test
	public void testFindAll() {
		assertEquals(1, dao.findAll().size());
	}

	@After
	public void after() {
		DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}
}
