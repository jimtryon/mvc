package edu.greenriver.it.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.greenriver.it.entities.Contact;
import edu.greenriver.it.entities.Email;

/**
 * TestPlannerRepository class that creates a list of contacts and emails 
 * and contains methods to display, fetch, and search within the lists
 *  
 * @author jtryon
 *
 */
public class TestPlannerRepository implements IPlannerRepository
{
	private ArrayList<Contact> listOfContacts = new ArrayList<>();
	private ArrayList<Email> listOfEmails = new ArrayList<>();
	
	public TestPlannerRepository()
	{
		listOfContacts.add(new Contact("Sarah", "Smith", "100 North Road", "512-380-5600"));
		listOfContacts.add(new Contact("Dan", "Meister", "5000 Daffodil Lane", "426-832-1777"));
		
		listOfEmails.add(new Email(LocalDateTime.now().minusDays(7), 
				"Want to go see a movie?", "There is this great movie coming"
						+ "out next Friday.  We should go see it!"));
		listOfEmails.add(new Email(LocalDateTime.now().minusDays(20), 
				"How are you?", "When you have some free time off work, let's get lunch."));
	}

	/**
	 * Method that returns all of the contacts
	 */
	@Override
	public List<Contact> getContacts()
	{
		return Collections.unmodifiableList(listOfContacts);
	}

	/** 
	 * Method that returns all of the emails
	 */
	@Override
	public List<Email> getEmails()
	{
		return Collections.unmodifiableList(listOfEmails);
	}

	/** 
	 * Method that returns true if a contact exists with the specified first and last name
	 */
	@Override
	public boolean contactExists(String firstNameOfContact, String lastNameOfContact)
	{
		for (Contact contact : listOfContacts) 
		{
			if (contact.getFirstName().equals(firstNameOfContact)
				&& contact.getLastName().equals(lastNameOfContact)) 
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Method that retrieves a contact by name 
	 */
	@Override
	public Contact getContactByName(String firstNameOfContact, String lastNameOfContact)
	{
		for (Contact contact : listOfContacts) 
		{
			if (contact.getFirstName().equals(firstNameOfContact)
				&& contact.getLastName().equals(lastNameOfContact)) 
			{
				return contact;
			}
		}
		throw new IllegalArgumentException("Contact is not found");
	}

	/**
	 * Method that retrieves a list of emails within the past 30 days 
	 */	
	@Override
	public List<Email> getRecentEmails(LocalDateTime emailAfterThisDate)
	{
		emailAfterThisDate = LocalDateTime.now().minusMonths(1);
		
		List<Email> localListOfEmails = new ArrayList<>();
 	
		for (Email email: listOfEmails)
		{
			if (email.getTimeReceived().isAfter(emailAfterThisDate))
			{
				localListOfEmails.add(email);
			}
		}
		return localListOfEmails;
		
	}

	/**
	 * Method that retrieves a list of emails with the specified search string
	 */
	@Override
	public List<Email> getMatchingEmails(String emailStringToSearch)
	{
		List<Email> localListOfEmails = new ArrayList<>();
		
		for (Email email : listOfEmails)
		{
			if (email.getBody().contains(emailStringToSearch) || 
					email.getSubject().contains(emailStringToSearch))
			{
				localListOfEmails.add(email);
			}
		}
		return localListOfEmails;
	}

}
