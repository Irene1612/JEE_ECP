package viewsBeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;

import controllers.EliminarTemaController;

@ManagedBean
public class EliminarTemaView extends TemaView {
	
	@ManagedProperty(value = "#{idTema}")
	public Integer idTema;
	
	@ManagedProperty(value = "#{tema.getNombre()}")
    private String nombre;

	@ManagedProperty(value = "#{tema.getId()}")
    private Integer id;	
	
	public EliminarTemaView() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}

	@PostConstruct
	@Override
	public void update() {
		super.update();
		EliminarTemaController eliminarTemaController = this.getControllerFactory()
				.getEliminarTemaController();
		LogManager.getLogger(EliminarTemaView.class).debug(
				"Se accede a la capa de negocio para recuperar temas");
		this.mostrarTemas(eliminarTemaController);
	}

	public String eliminarTema(Integer id) {
		EliminarTemaController eliminarTemaController = this.getControllerFactory()
				.getEliminarTemaController();
		LogManager.getLogger(EliminarTemaView.class).debug(
				"Se accede a la capa de negocio para eliminar un tema");
		eliminarTemaController.eliminarTema(id);
		return "temaEliminadoCorrectamente";
	}

	public String process() {
		LogManager.getLogger(EliminarTemaView.class).debug("Process...");
		return this.eliminarTema(this.idTema);
	}
}
