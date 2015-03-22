package viewsBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;

@ManagedBean
public class IntroducirIdentificadorView extends ViewBean {

	private static final String CODIGO_AUTORIZACION = "666";
	
	@ManagedProperty(value = "#{codigoAutorizacion}")
	private String codigoAutorizacion;
	
	public IntroducirIdentificadorView() {
	}

	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	public void setCodigoAutorizacion(String codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	public String comprobarCodigoAutorizacion(String codigoAutorizacion) {
		LogManager.getLogger(IntroducirIdentificadorView.class).debug("Comprobando la autorizacion... ¿Es 666?: " + codigoAutorizacion.equals(CODIGO_AUTORIZACION));
		return codigoAutorizacion.equals(CODIGO_AUTORIZACION) ? "eliminarTema" : "identificadorErroneo";
	}
	
	public String process() {
		LogManager.getLogger(IntroducirIdentificadorView.class).debug("Process...");
		return this.comprobarCodigoAutorizacion(this.codigoAutorizacion);
	}

}
