package tickets;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import shows.Show;

public class FestivalTicketClass extends TicketAbstractClass implements FestivalTicket {

	private SortedSet<LocalDate> dates;
	
	public FestivalTicketClass(Show show, int price) {
		dates = new TreeSet<LocalDate>();
		super.setPrice(price);
		super.setShow(show);
	}

	public Iterator<LocalDate> listTicketDates() {
		return dates.iterator();
	}

	public void addDate(LocalDate date) {
		dates.add(date);
	}

}
