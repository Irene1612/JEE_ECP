package viewsBeans;

import javax.faces.bean.ManagedProperty;

import controllers.ControllerFactory;

public abstract class ViewBean {

	@ManagedProperty(value = "#{controllerFactory}")
	protected ControllerFactory controllerFactory;

	public void setControllerFactory(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
	}

	protected ControllerFactory getControllerFactory() {
		return controllerFactory;
	}

}
