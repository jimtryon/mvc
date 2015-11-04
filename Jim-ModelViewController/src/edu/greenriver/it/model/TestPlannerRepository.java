package edu.greenriver.it.model;

import java.time.LocalDateTime;
import java.util.List;

import edu.greenriver.it.entities.Contact;
import edu.greenriver.it.entities.Email;

public class TestPlannerRepository implements IPlannerRepository
{

	@Override
	public List<Contact> getContacts()
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contact getContactByName(String firstNameOfContact, String lastNameOfContact)
	{
		// TODO Auto-generated method stub
		return null;
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
