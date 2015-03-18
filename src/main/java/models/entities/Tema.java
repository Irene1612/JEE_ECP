package models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Voto> votos;

	public Tema() {
		this.votos = new ArrayList<Voto>();
	}

	public Tema(String nombre, String pregunta) {
		this();
		this.nombre = nombre;
		this.pregunta = pregunta;
	}

	public Tema(String nombre, String pregunta, List<Voto> votos) {
		this(nombre, pregunta);
		this.votos = new ArrayList<Voto>();
		this.votos.addAll(votos);
	}

	public Tema(Integer id, String nombre, String pregunta, List<Voto> votos) {
		this(nombre, pregunta, votos);
		this.id = id;
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

	public void putVoto(Voto voto) {
		this.votos.add(voto);
	}

	@Override
	public String toString() {
		return "Tema [id=" + id + ", nombre=" + nombre + ", pregunta=" + pregunta + ", votos=" + votos + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Tema tema = (Tema) obj;
		return this.id.equals(tema.id) && this.nombre.equals(tema.nombre)
				&& this.pregunta.equals(tema.pregunta) && this.listaVotosEqual(tema);
	}

	private boolean listaVotosEqual(Tema tema) {
		return this.votos.containsAll(tema.votos);
	}
}
