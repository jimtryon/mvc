package edu.greenriver.it.view;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.greenriver.it.entities.Contact;
import edu.greenriver.it.entities.Email;

/**
 * PlannerConsoleView class that contains the methods for the view 
 * @author jtryon
 *
 */

/**
 * Constructor that initializes a console object for user input
 *
 */
public class PlannerConsoleView
{
	private Scanner console;

	public PlannerConsoleView()
	{
		console = new Scanner(System.in);
	}

/**
 * Method that displays the menu for the planner 
 */
	public void displayMenu()
	{		
		System.out.println("Welcome to Planner Application\n");
		
		System.out.println("contact: view all options\n" +
		"email: view all emails\n" + 
		"search: to search\n" + 
		"exit: to exit");
	}
/**
 * Method that displays the search menu	
 */
	public void displaySearchMenu()
	{
		System.out.println("contact: search by first and last name\n" +
		"recent: view recent emails (within 30 days)\n" +
		"email: to search subject and body of email");
	}

/**
 * Method that handles the main menu choices
 * @return the user's choice 
 */
	public String getMenuChoice()
	{

		// get the user's choice
		List<String> validChoices = Arrays.asList(new String[] {
				"contact", "email", "search", "exit"
		});
		
		String choice = console.nextLine();

		// validate the choice
		if (!validChoices.contains(choice))
		{
			// print out error message and display the menu again
			System.out.println("Enter a valid choice 1-4");
			return getMenuChoice(); // recursion
		}
		else
		{
			return choice;
		}
	}
	
	/**
	 * Method that handles the menu choices for the search menu
	 * @return the user's choice
	 */
	public String getSearchMenuChoice()
	{
		// get the user's choice
				List<String> validChoices = Arrays.asList(new String[] {
						"contact", "recent", "email"
				});
				
				String choice = console.nextLine();

				// validate the choice
				if (!validChoices.contains(choice))
				{
					// print out error message and display the menu again
					System.out.println("Enter a valid choice 1-3");
					return getMenuChoice(); // recursion
				}
				else
				{
					return choice;
				}
	}
	
	/**
	 * Method that displays all of the contacts
	 * @param contacts the list of contacts
	 */
	public void showContacts(List<Contact> contacts)
	{
		for (Contact contact: contacts)
		{
			showSingleContact(contact);
		}
	}
	
	/**
	 * Method that displays a single contact
	 * @param contact a single contact object
	 */
	public void showSingleContact(Contact contact)
	{
		System.out.println(contact.getFirstName() +
				", " + contact.getLastName() +
				":" + contact.getPhone());
	}
	
	
	/**
	 * Method that displays all of the emails 
	 * @param emails a list of emails
	 */
	public void ShowEmails(List<Email> emails)
	{
		for (Email email: emails)
		{
			showSingleEmail(email);
		}
	}
	
	/**
	 * Method that displays a single email with a formatted date
	 * @param email a single email object
	 */
	public void showSingleEmail(Email email)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
		String dateStr = email.getTimeReceived().format(formatter);
		System.out.println(dateStr + " " +
				email.getSubject() + "-" +
				email.getBody());
	}
	
	/**
	 * Method that accepts input from the console 
	 * @param prompt the question 
	 * @return the search value 
	 */
	public String getString(String prompt)
	{
		System.out.println(prompt);
		
		return console.nextLine(); // get the search value and return it
	}

}
