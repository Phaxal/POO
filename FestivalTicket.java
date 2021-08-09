package tickets;

import java.time.LocalDate;
import java.util.Iterator;

public interface FestivalTicket extends Ticket {
	
	Iterator<LocalDate> listTicketDates();
	void addDate(LocalDate date);

}
