package models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tema {

	@Id
	@GeneratedValue
	private Integer id;

	private String nombre;

	private String pregunta;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Voto> votos;

	public Tema() {
	}

	public Tema(Integer id, String nombre, String pregunta, List<Voto> votos) {
		this.id = id;
		this.nombre = nombre;
		this.pregunta = pregunta;
		this.votos = votos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Tema [id=" + id + ", nombre=" + nombre + ", pregunta="
				+ pregunta + ", votos=" + votos + "]";
	}

	public boolean equals(Tema tema) {
		boolean iguales = false;
		if (this.id == tema.id && this.nombre == tema.nombre
				&& this.pregunta == tema.pregunta && this.votosIguales(tema)) {
			iguales = true;
		}
		return iguales;
	}

	private boolean votosIguales(Tema tema) {
		boolean votosIguales = true;
		if (this.votos.size() == tema.votos.size()) {
			for (int i = 0; i < this.votos.size(); i++) {
				if (!this.votos.get(i).equals(tema.votos.get(i)))
					votosIguales = false;
			}
		} else {
			votosIguales = false;
		}
		return votosIguales;
	}

}
