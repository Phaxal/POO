/**
 * @author 
 * Diogo Pereira 44640
 * Andre Guerreiro 41680
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

import controller.MyTicket;
import controller.MyTicketClass;
import performers.Performer;
import shows.Concert;
import shows.Festival;
import shows.Show;


public class Main {
	
	private static final String ALL_SHOWS = "All shows:";
	private static final String NO_USER_LOGGED_IN = "No user is logged in.";
	

	private enum Command {
		LIST_SHOWS("SHOWS"), LIST_SHOWS_BY_CLIENTS("SHOWSBYCLIENTS"), 
		LIST_SHOWS_BY_TYPE("SHOWSBYTYPE"), SHOW_INFO("SHOW"), 
		SEARCH_PERFORMER("SEARCH"), REGISTER_USER("REGISTER"), EXIT("EXIT"),
		ADD_PERFORMER("ADDARTIST"), ADD_SHOW("ADDSHOW"),
		BUY_TICKET("BUYTICKET"), MY_TICKETS("MYTICKETS"),
		LOGIN("LOGIN"), LOGOUT("LOGOUT"),
		UNKNOWN("Unknown command.");

		private String description;

		Command (String description) {
			this.description = description;
		}
		
		public String toString() { 
			return this.description; 
		}    
	}

	private static Command getCommand(Scanner in) {
		try {
			return Command.valueOf(in.nextLine().toUpperCase());
		}
		catch (IllegalArgumentException e) {
			return Command.UNKNOWN;
		}
	}
	
	public static void main(String[] args)  {
		Scanner in = new Scanner(System.in);
		MyTicket ticketMaster = new MyTicketClass();
		program(in, ticketMaster);
	}
	
	public static void program(Scanner in, MyTicket ticketMaster){
		Command cmd = getCommand(in);
		while (!cmd.equals(Command.EXIT)) {
			switch (cmd) {
			case LIST_SHOWS:  
				listAllShows(ticketMaster);
				break;
			case LIST_SHOWS_BY_CLIENTS:
				listShowsByClients(ticketMaster);
				break;
			case LIST_SHOWS_BY_TYPE:
				listShowsByType(in, ticketMaster);
				break;
			case SHOW_INFO:
				getShowInfo(in, ticketMaster);
				break;
			case SEARCH_PERFORMER:
				listPerformerShows(in, ticketMaster);						
				break;
			case REGISTER_USER:
				registerUser(in, ticketMaster);						
				break;
			case ADD_PERFORMER:
				addPerformer(in, ticketMaster);						
				break;
			case ADD_SHOW: 
				addShow(in, ticketMaster);
				break;
			case BUY_TICKET: 
				buyTicket(in, ticketMaster);
				break;
			case MY_TICKETS: 
				listMyTickets(in, ticketMaster);
				break;
			case LOGIN: 
				login(in, ticketMaster);
				break;
			case LOGOUT: 
				logout(ticketMaster);
				break;
			default:
				System.out.println(cmd.description);
				break;
			}
			cmd = getCommand(in);
		}
		System.out.println("Exiting.");
	}

	private static void listAllShows(MyTicket ticketMaster) {
		System.out.println(Main.ALL_SHOWS);
		Iterator<Show> it = ticketMaster.listAllShows();
		while (it.hasNext()){
			Show show = it.next();
			if (ticketMaster.isConcert(show)){
				Concert concert = (Concert) show;
				System.out.println(ticketMaster.getConcertName(concert));
				System.out.println(ticketMaster.getConcertPerformer(concert));
				System.out.println(ticketMaster.getConcertDate(concert));
				System.out.println(ticketMaster.getConcertPrice(concert));
				System.out.println(ticketMaster.getTicketsLeftForConcert(concert));
			}
			
			if (ticketMaster.isFestival(show)){
				Festival festival = (Festival) show;
				System.out.println(ticketMaster.getFestivalName(festival));
				for (int day = 0; day < ticketMaster.getFestivalDays(festival); day++){
					System.out.println(getFestivalDate(festival, day));
					List<Performer> performers = getPerformersInFestivalDay(festival, day);
					for (Performer performer: performers){
						System.out.println(performer.getName());
					}
				}
				System.out.println(ticketMaster.getFestivalStart(festival));
				System.out.println(ticketMaster.getFestivalEnd(festival));
				List<Integer> prices = ticketMaster.getPricesForFestival(festival);
				for (Integer price: prices){
					System.out.println(prices.indexOf(price) + " " + price);
				}
				
				
			}
		}
	}

	private static void listShowsByClients(MyTicket ticketMaster) {
		// TODO Auto-generated method stub
	}

	private static void listShowsByType(Scanner in, MyTicket ticketMaster) {
		// TODO Auto-generated method stub
	}

	private static void getShowInfo(Scanner in, MyTicket ticketMaster) {
		// TODO Auto-generated method stub
	}

	private static void listPerformerShows(Scanner in, MyTicket ticketMaster) {
		// TODO Auto-generated method stub
		
	}

	private static void registerUser(Scanner in, MyTicket ticketMaster) {
		String type = in.nextLine().toUpperCase();
		String email = in.nextLine();
		if(!type.equals("ADMIN") && !type.equals("CLIENT"))
			System.out.println("Tipo de utilizador invalido.");
		else {
			if (ticketMaster.loggedIn())
				System.out.println("User already logged in.");
			else if (ticketMaster.hasUser(email))
				System.out.println("User already exists.");
			else {
				if (type.equals("ADMIN")){
					System.out.println("User was registered: " + ticketMaster.registerAdmin(email));
				}
				if (type.equals("CLIENT")){
					System.out.println("User was registered: " + ticketMaster.registerClient(email));
				}	
			}
		}
	}

	private static void addPerformer(Scanner in, MyTicket ticketMaster) {
		String artistName = in.nextLine();
		int numberOfRecords = in.nextInt(); in.nextLine();
		List<String> recordNames = new ArrayList<String>(numberOfRecords);
		for (int i = 0; i < recordNames.size(); i++){
			recordNames.add(in.nextLine());
		}
		int elements = in.nextInt(); in.nextLine();
		if (ticketMaster.adminLoggedIn()){
			if (!ticketMaster.hasPerformer(artistName)){
				if (elements == 1){
					ticketMaster.addArtist(artistName, recordNames);
				}
				else if (elements > 1) {
					List<String> bandMembers = new ArrayList<String>(elements);
					for (int i = 0; i < bandMembers.size(); i++){
						bandMembers.add(in.nextLine());
					}
					ticketMaster.addBand(artistName, recordNames, bandMembers);
				}
				else
					System.out.println("Invalid number of performers.");
			}
			else
				System.out.println("Artist name already exists.");
		}
		else
			System.out.println("User cannot execute this command.");
	}

	private static void addShow(Scanner in, MyTicket ticketMaster) {
		String name = in.nextLine();
		String description = in.nextLine();
		int numberOfTickets = in.nextInt(); in.nextLine();
		System.out.println("CONCERT OR FESTIVAL?");
		String type = in.nextLine().toUpperCase();
		
		if (type.equals("CONCERT")){
			String artistName = in.nextLine();
			LocalDate date = LocalDate.parse(in.nextLine());
			int price = in.nextInt(); in.nextLine();
			if (!ticketMaster.adminLoggedIn())
				System.out.println("User cannot execute this command.");
			else if (ticketMaster.hasConcert(name, date))
				System.out.println("Show already exists.");
			else if (!ticketMaster.hasPerformer(artistName))
				System.out.println("Artist name(s) do(es) not exist(s):\n" + artistName);
			else {
				ticketMaster.addConcert(name, description, numberOfTickets, artistName, price, date);
				System.out.println("Show added.");
			}
		}
		else if (type.equals("FESTIVAL")){
			int numberOfDays = in.nextInt(); in.nextLine();
			LocalDate start = LocalDate.parse(in.nextLine());
			Map<Integer, List<String>> festival = new HashMap<Integer, List<String>>();
			Map<Integer, Integer> prices = new HashMap<Integer, Integer>();
			int numberOfPerformers;
			List<String> performers;
			List<String> notListed;
			
			for (int i = 1; i <= numberOfDays; i++){
				numberOfPerformers = in.nextInt(); in.nextLine();
				performers = new ArrayList<String>(numberOfPerformers);
				notListed = new ArrayList<String>();
				for (int j = 0; j < numberOfPerformers; j++){
					String performer = in.nextLine();
					performers.add(performer);
					if (!ticketMaster.hasPerformer(performer))
						notListed.add(performer);
				}
				festival.put(i, performers);
			}

			for (int i = 1; i <= numberOfDays; i++){
				prices.put(i, in.nextInt());
				in.nextLine();
			}
			
				
			if (!ticketMaster.adminLoggedIn())
				System.out.println("User cannot execute this command.");
			else if (ticketMaster.hasFestival(name, start))
				System.out.println("Show already exists.");
			else if (!notListed.isEmpty()){
				System.out.println("Artist name(s) do(es) not exist(s):");
				Iterator<String> it = notListed.iterator();
				while (it.hasNext()){
					System.out.println(it.next());
				}
			}
			else {
				ticketMaster.addFestival(name, description, numberOfTickets, artistName, price, date);
				System.out.println("Show added.");
			}
			
		}
		else
			System.out.println("Invalid show type.");
	}

	private static void buyTicket(Scanner in, MyTicket ticketMaster) {
		
	}

	private static void listMyTickets(Scanner in, MyTicket ticketMaster) {
		
	}

	private static void login(Scanner in, MyTicket ticketMaster) {
		String email = in.nextLine();
		String password = in.nextLine();
		if (ticketMaster.hasUser(email)){
			if (ticketMaster.loggedIn()){
				if (ticketMaster.userLoggedIn(email))
					System.out.println("User already logged in.");
				
				else
					System.out.println("Another user is logged in.");
			}
			else {
				if (ticketMaster.comparePassword(password, email))
					System.out.println("Welcome " + email);
				else
					System.out.println("Wrong password.");
			}
		}
		else 
			System.out.println("User does not exist.");
	}

	private static void logout(MyTicket ticketMaster) {
		if (ticketMaster.clientLoggedIn() || ticketMaster.adminLoggedIn()){
			System.out.println("Goodbye " + ticketMaster.getUsername());
			ticketMaster.logout();	
		}
		else
			System.out.println(NO_USER_LOGGED_IN);
	}

}
