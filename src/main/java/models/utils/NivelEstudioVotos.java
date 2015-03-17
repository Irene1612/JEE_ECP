package models.utils;

public class NivelEstudioVotos {
	private String nombre;
	private Double mediaVotos;	
	
	public NivelEstudioVotos(String nivelEstudios) {
			this.setNivelEstudios(nivelEstudios);
			this.mediaVotos = null;
	}

	public String getNombre() {
		return nombre;
	}	

	public void setNivelEstudios(String nivelEstudios) {
		this.nombre = nivelEstudios;
	}
	
	public Double getMediaVotos() {
		return mediaVotos;
	}
	public void setMediaVotos(Double mediaVotos) {
		this.mediaVotos = mediaVotos;
	}	
	
	public Double calcularMedia(Double valoraconAcumulada, int numeroVotos){
		return valoraconAcumulada/numeroVotos;
	}
}
