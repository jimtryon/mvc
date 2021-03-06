package edu.greenriver.it.model;

import java.time.LocalDateTime;
import java.util.List;

import edu.greenriver.it.entities.Contact;
import edu.greenriver.it.entities.Email;

/**
 * IPlannerRepository interface that contains all of the abstract methods
 * for contacts and emails 
 * @author jtryon
 *
 */
public interface IPlannerRepository
{
	public List<Contact> getContacts();
	public List<Email> getEmails();
	
	public boolean contactExists(String firstNameOfContact, String lastNameOfContact);
	public Contact getContactByName(String firstNameOfContact, String lastNameOfContact);
	public List<Email> getRecentEmails(LocalDateTime emailAfterThisDate);
	public List<Email> getMatchingEmails(String emailStringToSearch);
}
