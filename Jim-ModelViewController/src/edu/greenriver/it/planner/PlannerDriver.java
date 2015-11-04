package edu.greenriver.it.planner;

import edu.greenriver.it.controller.PlannerController;
import edu.greenriver.it.model.IPlannerRepository;
import edu.greenriver.it.model.TestPlannerRepository;
import edu.greenriver.it.view.PlannerConsoleView;

public class PlannerDriver
{
	public static void main(String[] args)
	{
		IPlannerRepository model = new TestPlannerRepository();
		PlannerConsoleView view = new PlannerConsoleView();
		PlannerController controller = new PlannerController(model, view);
		
		controller.start();
		
	}
}
