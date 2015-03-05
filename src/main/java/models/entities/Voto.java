package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Voto {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String usuarioIP;
	
	private String nivelEstudios;
	
	private int valoracion;

	public Voto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuarioIP() {
		return usuarioIP;
	}

	public void setUsuarioIP(String usuarioIP) {
		this.usuarioIP = usuarioIP;
	}

	public String getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(String nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}	
}
