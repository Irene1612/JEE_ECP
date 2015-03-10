package models.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;

import models.utils.NivelEstudios;

import org.junit.Before;
import org.junit.Test;

public class VotoTest {
	
	private Voto voto;

	@Before
	public void init() {
		voto = new Voto(1, "128.0.0.0", NivelEstudios.BACHILLERATO_FP, 3);
	}

	@Test
	public void testEqualsObject() {
		Voto votoAux = new Voto(1, "128.0.0.0", NivelEstudios.BACHILLERATO_FP, 3);
		assertTrue(voto.equals(votoAux));
	}

}
