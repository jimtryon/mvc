package edu.greenriver.it.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.greenriver.it.entities.Contact;
import edu.greenriver.it.entities.Email;

public class TestPlannerRepository implements IPlannerRepository
{
	private ArrayList<Contact> listOfContacts = new ArrayList<>();
	private ArrayList<Email> listofEmails = new ArrayList<>();
	
	public TestPlannerRepository()
	{
		listOfContacts.add(new Contact("Sarah", "Smith", "100 North Road", "512-380-5600"));
		listOfContacts.add(new Contact("Dan", "Meister", "5000 Daffodil Lane", "426-832-1777"));
		
		listofEmails.add(new Email(LocalDateTime.now().minusDays(7), 
				"Want to go see a movie?", "There is this great movie coming"
						+ "out next Friday.  We should go see it!"));
		listofEmails.add(new Email(LocalDateTime.now().minusDays(20), 
				"How are you?", "When you have some free time off work, let's get lunch."));
	}

	@Override
	public List<Contact> getContacts()
	{
		return Collections.unmodifiableList(listOfContacts);
	}

	@Override
	public List<Email> getEmails()
	{
		return Collections.unmodifiableList(listofEmails);
	}

	@Override
	public boolean contactExists(String firstNameOfContact, String lastNameOfContact)
	{
		for (Contact contact : listOfContacts) 
		{
			if (contact.equals(firstNameOfContact)
				&& contact.equals(lastNameOfContact)) 
			{
				return true;
			}
		}
		return false;
	}

	@Override
	// 
	public Contact getContactByName(String firstNameOfContact, String lastNameOfContact)
	{
		for (Contact contact : listOfContacts) 
		{
			if (contact.equals(firstNameOfContact)
				&& contact.equals(lastNameOfContact)) 
			{
				return contact;
			}
		}
		throw new IllegalArgumentException("Contact is not found");
	}

	// retrieve a list of emails within the past 30 days 
	@Override
	public List<Email> getRecentEmails(LocalDateTime emailAfterThisDate)
	{
		
		return null;
		
	}

	// check if the string we are looking for is in the email
	//"hello"
	@Override
	public List<Email> getMatchingEmails(String emailStringToSearch)
	{
		List<Email> listofEmails = new List<Email>();
		
		for (Email email : listofEmails)
		
		return listofEmails;
	}

}
