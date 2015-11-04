package edu.greenriver.it.controller;

import edu.greenriver.it.model.IPlannerRepository;
import edu.greenriver.it.view.PlannerConsoleView;

public class PlannerController
{
	private IPlannerRepository model;
	private PlannerConsoleView view;
	
	public PlannerController(IPlannerRepository model, PlannerConsoleView view)
	{
		this.model = model;
		this.view = view;
	}
	
	public void start()
	{
		view.displayMenu();
	}
	
}
