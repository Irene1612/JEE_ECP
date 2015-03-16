package views.beans.jsp;

import controllers.VotarController;
import models.entities.Tema;
import models.utils.NivelEstudios;

public class VotarTemaView extends ViewBean{
	public Tema tema;
	public Integer id;
	public NivelEstudios[] nivelEstudios;
	
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
	
	
	
	public NivelEstudios[] getNivelEstudios() {
		return nivelEstudios;
	}

	public void update() {
		VotarController votarController = this
				.getControllerFactory().getVotarController();
		this.tema = votarController.getTema(this.id);
		this.nivelEstudios = NivelEstudios.values();
	}

	public String aniadirVoto(Integer id, int valoracion, String nivelEstudios, String ip) {
		VotarController votarController = this.getControllerFactory().getVotarController();
		votarController.aniadirVoto(id, valoracion, NivelEstudios.valueOf(nivelEstudios), ip);
		return "votoAniadidoCorrectamente";
	}
}
