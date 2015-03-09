package models.daos.jpa;

import static org.junit.Assert.*;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TemaDaoJpaTest {

	private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao(); // �se puede
																	// poner
																	// aqui?

	private Tema tema;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}

	@Before
	public void init() {
		tema = new Tema("tema1", "�Te gusta el tema 1?");
		dao.create(tema);
	}

	@Test
	public void testCreate() {
		Tema tema = new Tema("tema2", "�Te gusta el tema 2?");
		dao.create(tema);
		assertEquals(tema, dao.read(2));
	}

	@Test
	public void testRead() {
		assertEquals(tema, dao.read(1));
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
		for (int i = 0; i < dao.findAll().size(); i++) {
			dao.deleteById(i);
		}
	}

}
