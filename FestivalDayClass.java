package shows;

import java.time.LocalDate;
import java.util.List;

import performers.Performer;

public class FestivalDayClass implements FestivalDay {
	
	LocalDate day;
	int ticketsAvailable;
	List<Performer> lineUp;
	
	public FestivalDayClass(LocalDate day, int tickets, List<Performer> lineUp) {
		this.day = day;
		this.ticketsAvailable = tickets;
		this.lineUp = lineUp;
	}

}
