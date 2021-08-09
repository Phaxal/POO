package tickets;

import shows.Show;

public interface Ticket {
	Show getShow();
	int getPrice();
}
