package edu.greenriver.it.view;

import java.util.Scanner;

public class PlannerConsoleView
{
	private Scanner console;

	public PlannerConsoleView()
	{
		console = new Scanner(System.in);
	}

	public void displayMenu()
	{
		System.out.println("Welcome to Planner Application\n");

		String[] menuOptions = 
		{
			"1. contact: view all contacts",
			"2. email: view all emails",
			"3. search: to search",
			"4. exit: to exit"
		};
		
		for (String option: menuOptions)
		{
			System.out.println(option);
		}

	}

}
