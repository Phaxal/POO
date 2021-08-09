package tickets;

import shows.Show;

public class ConcertTicketClass extends TicketAbstractClass implements ConcertTicket {

	private int ticketSize;
	
	public ConcertTicketClass(Show show, int price, int people) {
		super.setPrice(price);
		super.setShow(show);
		this.ticketSize = people;
	}

	@Override
	public int getTicketSize() {
		return ticketSize;
	}
}
