package models.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.utils.NivelEstudios;

import org.junit.Before;
import org.junit.Test;

public class TemaTest {

	private Tema tema;

	@Before
	public void init() {
		tema = new Tema(1, "tema1", "¿Te gusta el tema 1?", new ArrayList<Voto>());
	}

	@Test
	public void testPutVoto() {
		tema.putVoto(new Voto("13.0.0.0", NivelEstudios.BACHILLERATO_FP, 3));
		assertTrue(tema.getVotos().size() == 1);
	}

	@Test
	public void testEqualsTema() {
		Voto voto = new Voto("13.0.0.0", NivelEstudios.BACHILLERATO_FP, 3);
		tema.putVoto(voto);
		Tema temaAux = new Tema(1, "tema1", "¿Te gusta el tema 1?",
				new ArrayList<Voto>());
		temaAux.putVoto(voto);
		assertTrue(tema.equals(temaAux));
	}
}
