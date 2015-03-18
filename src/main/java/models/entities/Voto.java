package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import models.utils.NivelEstudios;

@Entity
public class Voto {

	public static final String TABLE = "voto";

	public static final String ID = "ID";

	@Id
	@GeneratedValue
	private Integer id;

	public static final String USUARIO_IP = "USUARIOIP";
	private String usuarioIP;

	public static final String NIVEL_ESTUDIOS = "NIVELESTUDIOS";
	private NivelEstudios nivelEstudios;

	public static final String VALORACION = "VALORACION";
	private int valoracion;

	public Voto() {
	}

	public Voto(String usuarioIP, NivelEstudios nivelEstudios, int valoracion) {
		this.usuarioIP = usuarioIP;
		this.nivelEstudios = nivelEstudios;
		this.valoracion = valoracion;
	}

	public Voto(Integer id, String usuarioIP, NivelEstudios nivelEstudios, int valoracion) {
		this(usuarioIP, nivelEstudios, valoracion);
		this.id = id;
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
		return "Voto [id=" + id + ", usuarioIP=" + usuarioIP + ", nivelEstudios=" + nivelEstudios
				+ ", valoracion=" + valoracion + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Voto voto = (Voto) obj;
		return this.id == voto.id && this.nivelEstudios.equals(voto.nivelEstudios)
				&& this.usuarioIP.equals(voto.usuarioIP) && this.valoracion == voto.valoracion;
	}
}
