package viewsBeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import controllers.VotarController;
import models.entities.Tema;
import models.utils.NivelEstudios;

@ManagedBean
@RequestScoped
public class VotarTemaView extends ViewBean {
	public static final int VALOR_MAXIMO_VOTACION = 10;
	public Tema tema;
	public Integer id;
	public NivelEstudios[] nivelEstudios;
	public int valorMaximoVotacion;
	public String[] nivelesEstudiosString;
	public int cantidadNiveles;
	
	@ManagedProperty(value = "#{verDetallesTemaView}")
    private VerDetallesTemaView verDetallesTemaView;

	public VotarTemaView() {
		this.valorMaximoVotacion = VALOR_MAXIMO_VOTACION;
		this.nivelesEstudiosString = new String[NivelEstudios.values().length];
		this.cantidadNiveles = NivelEstudios.values().length - 1;
		this.nivelEstudios = NivelEstudios.values();
		for (int i = 0; i < NivelEstudios.values().length; i++) {
			this.nivelesEstudiosString[i] = NivelEstudios.values()[i].toString();
		}
	}
	
	public void setVerDetallesTemaView(VerDetallesTemaView verDetallesTemaView) {
        this.verDetallesTemaView = verDetallesTemaView;
    }

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

	public int getValorMaximoVotacion() {
		return this.valorMaximoVotacion;
	}

	public String[] getNivelesEstudiosString() {
		return this.nivelesEstudiosString;
	}

	public int getCantidadNiveles() {
		return this.cantidadNiveles;
	}
	
	public void update() {
		VotarController votarController = this.getControllerFactory().getVotarController();
		this.tema = votarController.getTema(this.id);
	}
	
	@PostConstruct
	public void updateJsf() {
		this.id = verDetallesTemaView.getIdTema();
		this.update();
	}

	public String aniadirVoto(Integer id, int valoracion, int nivelEstudios, String ip) {
		VotarController votarController = this.getControllerFactory().getVotarController();
		votarController.aniadirVoto(id, valoracion, this.nivelEstudios[nivelEstudios], ip);
		return "votoAniadidoCorrectamente";
	}
	
	public String process(){
		return null;
	}
}
