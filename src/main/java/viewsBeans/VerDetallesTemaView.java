package viewsBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.logging.log4j.LogManager;

import controllers.VerVotacionesController;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudioVotos;
import models.utils.NivelEstudios;

@ManagedBean
@RequestScoped
public class VerDetallesTemaView extends ViewBean {
	public Tema tema;
	public Integer idTema;
	public int numeroVotos;
	public NivelEstudioVotos[] nivelEstudioVotos;
	
	@ManagedProperty(value = "#{verTemasView}")
    private VerTemasView verTemasView;

	public VerDetallesTemaView() {
		this.nivelEstudioVotos = new NivelEstudioVotos[NivelEstudios.values().length];
	}
	
	public void setVerTemasView(VerTemasView verTemasView) {
        this.verTemasView = verTemasView;
    }

	public Tema getTema() {
		return tema;
	}

	public Integer getIdTema() {
		return idTema;
	}

	public void setId(Integer id) {
		LogManager.getLogger(VerDetallesTemaView.class).debug("Le pongo al verDetallesView el id del tema");
		this.idTema = id;
	}

	public int getNumeroVotos() {
		return numeroVotos;
	}

	public NivelEstudioVotos[] getNivelEstudioVotos() {
		return nivelEstudioVotos;
	}
	
	
	public void update() {
		VerVotacionesController verVotacionesController = this.getControllerFactory()
				.getVerVotacionesController();
		LogManager.getLogger(VerDetallesTemaView.class).debug(
				"Se accede a la capa de negocio para recuperar el tema cuyo id es: " + this.idTema);		
		this.tema = verVotacionesController.getTema(this.idTema);
		List<Voto> votos = this.tema.getVotos();
		this.numeroVotos = votos.size();
		LogManager.getLogger(VerDetallesTemaView.class).debug("Numero de votos:" + this.numeroVotos);
		nivelEstudioVotos = verVotacionesController.calcularMediaVotos(votos);
	}
	
	@PostConstruct
	public void updateJsf() {
		this.idTema = verTemasView.getIdTema();
		this.update();
	}
	
	public String process(){
		LogManager.getLogger(VerDetallesTemaView.class).debug(
				"Process....");
		return "votarTema";
	}
}
