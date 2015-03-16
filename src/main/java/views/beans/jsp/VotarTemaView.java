package views.beans.jsp;

import models.entities.Tema;

public class VotarTemaView extends ViewBean{
	public Tema tema;
	public Integer id;
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
}
