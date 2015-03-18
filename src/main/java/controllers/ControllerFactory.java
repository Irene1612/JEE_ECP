package controllers;

public abstract class ControllerFactory {
	public abstract VotarController getVotarController();

	public abstract VerVotacionesController getVerVotacionesController();

	public abstract AniadirTemaController getAniadirTemaController();

	public abstract EliminarTemaController getEliminarTemaController();
}
