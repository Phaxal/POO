package shows;

import java.time.LocalDate;
import java.util.LinkedList;

import performers.Artist;
import performers.Band;
import performers.Performer;
import users.Client;

public class ConcertClass extends ShowAbstractClass implements Concert {

	private Performer performer;
	private int price;
	
	public ConcertClass
	(String concertName, int price, int tickets, String description, LocalDate date, Band band) {
		super.setDescription(description);
		super.setName(concertName);
		super.setStartDate(date);
		super.setNumberOfTickets(tickets);
		super.setClientList(new LinkedList<Client>());
		this.price = price;
		performer = band;
	}
	
	public ConcertClass
	(String concertName, int price, int tickets, String description, LocalDate date, Artist artist) {
		super.setDescription(description);
		super.setName(concertName);
		super.setStartDate(date);
		super.setNumberOfTickets(tickets);
		this.price = price;
		performer = artist;
	}

	@Override
	public Performer getPerformer() {
		return performer;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public void sellTickets(int numberOfTickets) {
		super.setNumberOfTickets(super.getNumberOfTickets() - numberOfTickets);
		//add ticket here
	}
}
