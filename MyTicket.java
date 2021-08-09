package controller;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import shows.Concert;
import shows.Festival;
import shows.Show;
import tickets.ConcertTicket;
import tickets.FestivalTicket;
import users.User;

public interface MyTicket {
	boolean hasAdmin(String name);
	boolean hasClient(String name);
	boolean clientLoggedIn();
	boolean adminLoggedIn();
	boolean userLoggedIn(String name);
	boolean loggedIn();
	boolean loggedOut();
	boolean hasShow();
	boolean hasFestival(String name, LocalDate date);
	boolean hasConcert(String name, LocalDate date);
	String registerClient(String email);
	String registerAdmin(String email);
	Iterator<Show> listAllShows();
	Iterator<Show> listShowsByClients();
	Iterator<Concert> listConcerts();
	Iterator<Festival> listFestivals();
	Show getShow(); //?
	Iterator<Concert> listArtistConcerts(String artist);
	Iterator<Festival> listArtistFestivals(String artist);
	void addArtist(String name, List<String> albums);
	void addBand(String name, List<String> albums, List<String> memberNames);
	void addConcert(String name, String desc, int tickets, String artistName, int price, LocalDate date);
	void addFestival(String name, String desc, int tickets, int days, LocalDate start, List<Integer> prices);
	void addLineUp();//adding a lineup to a festival soon™
	int buyConcertTicket(String name, LocalDate date, int tickets);
	int buyFestivalTicket(String name, LocalDate date, int tickets);
	void addDayToFestivalTicket(LocalDate day); //?
	Iterator<ConcertTicket> listConcertTickets();
	Iterator<FestivalTicket> listFestivalTickets();
	void logout();
	boolean loginClient(String email, String password);
	boolean loginAdmin(String email, String password);
	boolean isConcert(Show show);
	boolean isFestival(Show show);
	String getConcertName(Concert concert);
	String getConcertPerformer(Concert concert);
	LocalDate getConcertDate(Concert concert);
	int getConcertPrice(Concert concert);
	int getTicketsLeftForConcert(Concert concert);
	String getUsername();
	boolean hasUser(String name);
	User getUser(String name);
	boolean comparePassword(String password, String name);
	boolean hasPerformer(String artistName);
	String getFestivalName(Festival festival);
	char[] getFestivalStart(Festival festival);
	char[] getFestivalEnd(Festival festival);
	List<Integer> getPricesForFestival(Festival festival);
}
