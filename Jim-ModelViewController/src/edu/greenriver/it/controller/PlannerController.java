package edu.greenriver.it.controller;

import java.time.LocalDateTime;
import java.util.List;

import edu.greenriver.it.entities.Email;
import edu.greenriver.it.model.IPlannerRepository;
import edu.greenriver.it.view.PlannerConsoleView;

/**
 * PlannerController class that handles the interactions between the model and the view
 * @author jtryon
 *
 */
public class PlannerController
{
	private IPlannerRepository model;
	private PlannerConsoleView view;
	
	/**
	 * Constructor that initializes the controller with a model and view
	 * @param model the methods that are called in the controller
	 * @param view the console object 
	 */
	public PlannerController(IPlannerRepository model, PlannerConsoleView view)
	{
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Method that begins the application
	 * Controller makes methods calls to the view and model to print the menu,
	 * display contacts and emails, and search contacts and emails  
	 */
	public void start()
	{
		//view.displayMenu();
		
		String choice = "";
		
		do
		{
			view.displayMenu();
			choice = view.getMenuChoice();
			
			switch(choice)
			{
				case "contact":	// view all contacts
					view.showContacts(model.getContacts());
					break;
				case "email":	// view all emails
					view.ShowEmails(model.getEmails());		
					break;
				case "search":	// to search
					view.displaySearchMenu();
					String searchChoice = view.getSearchMenuChoice();
					
					// if searchChoice is equal to "contact, email, recent"
					// depending on search, ask a question
					if (searchChoice.equals("contact"))
					{ 
						String firstName = view.getString("What is the first name?");
						String lastName = view.getString("What is your last name?");
						
						if (model.contactExists(firstName, lastName))
						{     
						   view.showSingleContact(model.getContactByName(firstName,
								   lastName));
						}
						else
						{
						   System.out.println("Contact does not exist");
						}		
					}
					else if (searchChoice.equals("recent"))
					{
						view.ShowEmails(model.getRecentEmails(LocalDateTime.now()));
					}
					else 
					{
						String emailStr = view.getString("Enter a search term: ");
						List<Email> emailMatch = model.getMatchingEmails(emailStr);
						
						if (emailMatch.size() == 0) 
						{
							System.out.println("Email not found");
						}
						else
						{
							for (Email email: emailMatch)
							{
								view.showSingleEmail(email);
							}
						}
						
					}
					
					
			}			
		} while (!choice.equals("exit"));
	}
	
}
