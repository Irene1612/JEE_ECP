package views.beans.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.ControllerFactory;
import controllersEjb.ControllerEjbFactory;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/viewsJsp/";

	private ControllerFactory controllerFactory;

	@Override
	public void init() throws ServletException {
		super.init();
		controllerFactory = new ControllerEjbFactory();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo().substring(1);
		LogManager.getLogger(Dispatcher.class).debug("accion: " + action);
		String view;
		
		switch (action) {
		case "verTemas":
			VerTemasView verTemaView = new VerTemasView();
			verTemaView.setControllerFactory(controllerFactory);
			request.setAttribute(action + "View", verTemaView);
			view = action;
			break;
		case "introducirIdentificador":
			IntroducirIdentificadorView introducirIdentificadorView = new IntroducirIdentificadorView();
			introducirIdentificadorView.setControllerFactory(controllerFactory);
			request.setAttribute(action + "View", introducirIdentificadorView);
			view = action;
			break;		
		case "aniadirTema":
			AniadirTemaView aniadirTemaView = new AniadirTemaView();
			aniadirTemaView.setControllerFactory(controllerFactory);
			request.setAttribute(action + "View", aniadirTemaView);
			view = action;
			break;
		case "verDetallesTema":
			VerDetallesTemaView verDetallesTemaView = new VerDetallesTemaView();
			verDetallesTemaView.setControllerFactory(controllerFactory);
			verDetallesTemaView.setId(Integer.valueOf(request.getParameter("tema")));
			request.setAttribute(action + "View", verDetallesTemaView);
			view = action;
			break;	
		default:
			view = "home";
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		Tema tema = new Tema();
		String view;
		Integer id;
		switch (action) {
			case "introducirIdentificador":				
				IntroducirIdentificadorView introducirIdentificadorView = new IntroducirIdentificadorView();
				introducirIdentificadorView.setControllerFactory(controllerFactory);
				String codigoAutorizacion = request.getParameter("codigoAutorizacion");				
				view = introducirIdentificadorView.comprobarCodigoAutorizacion(codigoAutorizacion);
				if(view.equals("eliminarTema")){					
					EliminarTemaView eliminarTemaView = new EliminarTemaView();
					eliminarTemaView.setControllerFactory(controllerFactory);
					request.setAttribute("eliminarTemaView", eliminarTemaView);
				}
				break;
			case "aniadirTema":
				AniadirTemaView aniadirTemaView = new AniadirTemaView();
				aniadirTemaView.setControllerFactory(controllerFactory);
				tema.setNombre(request.getParameter("nombreTema"));
				tema.setPregunta(request.getParameter("preguntaTema"));
	            request.setAttribute(action, aniadirTemaView);
				view = aniadirTemaView.aniadirTema(tema);
				break;
			case "eliminarTema":
				EliminarTemaView eliminarTemaView = new EliminarTemaView();
				eliminarTemaView.setControllerFactory(controllerFactory);
				id = Integer.valueOf(request.getParameter("tema"));
	            request.setAttribute(action, eliminarTemaView);	            
				view = eliminarTemaView.eliminarTema(id);
				break;			
			default:
				view = "home";
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);
	}

}
