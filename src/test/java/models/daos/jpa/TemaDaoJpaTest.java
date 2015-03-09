package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.daos.TemaDao;
import models.entities.Tema;
import models.entities.Voto;

import org.junit.Before;
import org.junit.Test;

public class TemaDaoJpaTest {

	private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();

	private Tema tema;

	@Before
	public void init() {
		tema = new Tema("tema1", "¿Te gusta el tema 1?", new ArrayList<Voto>());
	}

	@Test
	public void testCreate() {
		Tema tema = new Tema("tema2", "¿Te gusta el tema 2?",
				new ArrayList<Voto>());
		dao.create(tema);
		assertEquals(dao.read(1), tema);
	}

	@Test
	public void testRead() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

}
