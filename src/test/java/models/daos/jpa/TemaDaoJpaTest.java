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

	private TemaDao dao;

	private Tema tema;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.dropAndCreateTables();
	}

	@Before
	public void init() {
		dao = DaoJpaFactory.getFactory().getTemaDao();
		tema = new Tema("tema1", "¿Te gusta el tema 1?");	
		dao.create(tema);
	}

	@Test
	public void testCreateRead() {
		assertTrue(tema.equals(dao.read(tema.getId())));
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		dao.deleteById(tema.getId());
		assertNull(dao.read(tema.getId()));
	}

	@Test
	public void testFindAll() {
		assertEquals(1, dao.findAll().size());
	}

	@After
	public void after() {
		dao.deleteById(tema.getId());		
	}
}
