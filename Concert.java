package shows;

import performers.Performer;

public interface Concert extends Show{
	
	Performer getPerformer();
	int getPrice();
	void sellTickets(int numberOfTickets);
}
