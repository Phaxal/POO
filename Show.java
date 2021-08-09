package shows;

import java.time.LocalDate;
import java.util.List;

import users.Client;

public interface Show {
	
	String getName();
	String getDescription();
	int getNumberOfTickets();
	LocalDate getStartDate();
	List<Client> getClientList(); 
	public void addClient(Client client);
}
