package shows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import performers.Performer;
import users.Client;

public class FestivalClass extends ShowAbstractClass implements Festival {

	private int numberOfDays;
	private List<Integer> pricePerDays;
	private List<FestivalDay> festivalDays;
	
	public FestivalClass(LocalDate start, int days, int tickets, String desc, String name) {
		super.setStartDate(start);
		super.setNumberOfTickets(tickets);
		super.setName(name);
		super.setDescription(desc);
		super.setClientList(new LinkedList<Client>());
		festivalDays = new ArrayList<FestivalDay>(days);
		this.numberOfDays = days;
		pricePerDays = new ArrayList<Integer>(days + 1);
	}

	public LocalDate getEndDate() {
		return super.getStartDate().plusDays(numberOfDays-1);
	}
	
	public void addPerformersToDay(LocalDate day, List<Performer> artists){
		festivalLineup.put(day, artists);
	}

	public Iterator<Performer> listPerformersByDay(LocalDate day) {
		return festivalLineup.get(day).iterator();
	}

	public void setPriceForXDays(int days, int price){
		pricePerDays.add(days, price);
	}
	
	public int priceForXDays(int numberOfDays) {
		return pricePerDays.get(numberOfDays);
	}

}
