package views.beans.jsp;

public class IntroducirIdentificadorView extends ViewBean{
	
	private static final String CODIGO_AUTORIZACION = "666";

	public String comprobarCodigoAutorizacion(String codigoAutorizacion) {		
		return codigoAutorizacion.equals(CODIGO_AUTORIZACION) ? "eliminarTema" : "identificadorErroneo";
	}

}
