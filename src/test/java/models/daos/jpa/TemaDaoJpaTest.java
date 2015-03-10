package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

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
		tema = new Tema("tema1", "¿Te gusta el tema 1?", new ArrayList<Voto>());	
		dao.create(tema);
	}

	@Test
	public void testCreateRead() {
		assertTrue(tema.equals(dao.read(tema.getId())));
	}

	@Test
	public void testUpdate() {
		Voto voto = new Voto(1, "13.0.0.0", NivelEstudios.BACHILLERATO_FP,3);		
		tema.putVoto(voto);
		dao.update(tema);
		assertEquals(tema, dao.read(tema.getId()));
	}

	@Test
	public void testDeleteById() {
		dao.deleteById(tema.getId());
		assertNull(dao.read(tema.getId()));
	}

	@Test
	public void testFindAll() {
		assertTrue(dao.findAll().size() == 1);
	}

	@After
	public void after() {
		dao.deleteById(tema.getId());		
	}
}
