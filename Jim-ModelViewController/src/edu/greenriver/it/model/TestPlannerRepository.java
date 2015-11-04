package edu.greenriver.it.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.greenriver.it.entities.Contact;
import edu.greenriver.it.entities.Email;

public class TestPlannerRepository implements IPlannerRepository
{
	private ArrayList<Contact> listOfContacts = new ArrayList<>();
	
	public TestPlannerRepository()
	{
		listOfContacts.add(new Contact("Sarah", "Smith", "100 North Road", "512-380-5600"));
		listOfContacts.add(new Contact("Dan", "Meister", "5000 Daffodil Lane", "426-832-1777"));	
	}

	@Override
	public List<Contact> getContacts()
	{
		return Collections.unmodifiableList(listOfContacts);
	}

	@Override
	public List<Email> getEmails()
	{
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public List<Email> getRecentEmails(LocalDateTime emailAfterThisDate)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Email> getMatchingEmails(String emailStringToSearch)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
