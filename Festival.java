package shows;

import performers.Performer;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public interface Festival extends Show {
	
	LocalDate getEndDate();
	Iterator<Performer> listPerformersByDay(LocalDate day);
	int priceForXDays(int numberOfDays);
	void setPriceForXDays(int days, int price);
	void addPerformersToDay(LocalDate day, List<Performer> artists);
	
}
