package views.beans.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
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
        	case "eliminarTema":
        		view = action;
        		break;
        	case "aniadirTema":
        		view = action;
        		break;	
	        default:
	            view = "home";
        }

        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
