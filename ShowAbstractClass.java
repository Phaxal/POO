package shows;

import java.time.LocalDate;
import java.util.List;
import users.Client;

public abstract class ShowAbstractClass implements Show {

	private String name;
	private String description;
	private LocalDate startDate;
	private int numberOfTickets;
	private List<Client> clientList;
	
	public List<Client> getClientList() {
		return clientList;
	}
	
	public void addClient(Client client){
		clientList.add(client);
	}

	protected void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public String getName() {
		return name;
	}
	
	public int getNumberOfTickets(){
		return numberOfTickets;
	}
	
	protected void setNumberOfTickets(int tickets) {
		this.numberOfTickets = tickets;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	protected void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

}
