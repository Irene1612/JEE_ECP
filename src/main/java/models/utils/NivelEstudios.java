package models.utils;

public enum NivelEstudios {	
	SIN_ESTUDIOS("Sin estudios"), ESO("Eso"), BACHILLERATO_FP("Bachillerato-FP"), UNIVERSITARIO(
			"Universitario");

	private String nivel;

	private NivelEstudios(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return this.nivel;
	}
}
