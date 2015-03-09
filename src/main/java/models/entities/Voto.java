package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import models.utils.NivelEstudios;

@Entity
public class Voto {

	@Id
	@GeneratedValue
	private Integer id;

	private String usuarioIP;

	private NivelEstudios nivelEstudios;

	private int valoracion;

	public Voto() {
	}

	public Voto(Integer id, String usuarioIP, NivelEstudios nivelEstudios,
			int valoracion) {
		this.id = id;
		this.usuarioIP = usuarioIP;
		this.nivelEstudios = nivelEstudios;
		this.valoracion = valoracion;
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

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", usuarioIP=" + usuarioIP
				+ ", nivelEstudios=" + nivelEstudios + ", valoracion="
				+ valoracion + "]";
	}

	public boolean equals(Voto voto) {
		boolean iguales = false;
		if (this.id == voto.id && this.nivelEstudios == voto.nivelEstudios
				&& this.usuarioIP == voto.usuarioIP
				&& this.valoracion == voto.valoracion)
			iguales = true;
		return iguales;
	}

}
