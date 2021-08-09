package tickets;

import shows.Show;

public class TicketAbstractClass implements Ticket {

	private int price;
	private Show show;

	@Override
	public Show getShow() {
		return show;
	}

	@Override
	public int getPrice() {
		return price;
	}

	protected void setPrice(int price) {
		this.price = price;
	}

	protected void setShow(Show show) {
		this.show = show;
	}

}
