package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import shows.Concert;
import shows.Festival;
import shows.Show;
import tickets.ConcertTicket;
import tickets.FestivalTicket;
import users.Admin;
import users.AdminClass;
import users.Client;
import users.ClientClass;
import users.User;

public class MyTicketClass implements MyTicket {

	private User currentUser;
	private Map<String, User> users;
	private List<Client> clients;
	private List<Admin> admins;
	private List<Show> shows;
	private List<Concert> concerts;
	private List<Festival> festivals;
	
	public MyTicketClass() {
		currentUser = null;
		clients = new ArrayList<Client>();
		admins = new ArrayList<Admin>();
		concerts = new ArrayList<Concert>();
		festivals = new ArrayList<Festival>();
		shows = new ArrayList<Show>();
		users = new HashMap<String, User>();
	}
	
	@Override
	public boolean hasUser(String name){
		return users.containsKey(name);
	}	
	
	@Override
	public User getUser(String name){
		return users.get(name);
	}
	
	@Override
	public boolean comparePassword(String password, String name){
		return getUser(name).getPassword().equals(password);
	}
	
	@Override
	public String getUsername(){
		return currentUser.getEmail();
	}
	
	@Override
	public boolean hasAdmin(String name) {
		for (Admin admin : admins){
			if (admin.getEmail().equals(name))
				return true;
		}
		return false;
	}

	@Override
	public boolean hasClient(String name) {
		for (Client client : clients){
			if (client.getEmail().equals(name))
				return true;
		}
		return false;
	}

	@Override
	public boolean clientLoggedIn() {
		return currentUser instanceof Client;
	}

	@Override
	public boolean adminLoggedIn() {
		return currentUser instanceof Admin;
	}

	@Override
	public boolean loggedOut() {
		return currentUser == null;
	}

	@Override
	public boolean hasShow() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean hasFestival(String name, LocalDate date) {
		for (Festival festival : festivals){
			if (festival.getName().equals(name) && festival.getStartDate().equals(date))
				return true;
		}
		return false;
	}

	@Override
	public boolean hasConcert(String name, LocalDate date) {
		for (Concert concert : concerts){
			if (concert.getName().equals(name) && concert.getStartDate().equals(date))
				return true;
		}
		return false;
	}

	@Override
	public String registerClient(String email) {
		Client client;
		clients.add(client = new ClientClass(email, "client" + String.valueOf(clients.size() + 1)));
		users.put(email, client);
		return client.getPassword();
	}

	@Override
	public String registerAdmin(String email) {
		Admin admin;
		admins.add(admin = new AdminClass(email, "admin" + String.valueOf(admins.size() + 1)));
		users.put(email, admin);
		return admin.getPassword();
	}

	@Override
	public Iterator<Show> listAllShows() {
		return shows.iterator();
	}

	@Override
	public Iterator<Show> listShowsByClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Concert> listConcerts() {
		return concerts.iterator();
	}

	@Override
	public Iterator<Festival> listFestivals() {
		return festivals.iterator();
	}

	@Override
	public Show getShow() {
		return null;
	}

	@Override
	public Iterator<Concert> listArtistConcerts(String artist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Festival> listArtistFestivals(String artist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addArtist(String name, List<String> albums) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addBand(String name, List<String> albums, List<String> memberNames) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addConcert(String name, String desc, int tickets, String artistName, int price, LocalDate date) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFestival(String name, String desc, int tickets, int days, LocalDate start, List<Integer> prices) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLineUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public int buyConcertTicket(String name, LocalDate date, int tickets) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int buyFestivalTicket(String name, LocalDate date, int tickets) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addDayToFestivalTicket(LocalDate day) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<ConcertTicket> listConcertTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<FestivalTicket> listFestivalTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginClient(String email, String password) {		       
		User user = clients.get(indexOfClient(email));
		if (user.getPassword().equals(password)){
			currentUser = user;
			return true;
		}
		else return false;
	}

	@Override
	public boolean loginAdmin(String email, String password) {
		User user = admins.get(indexOfAdmin(email));
		if (user.getPassword().equals(password)){
			currentUser = user;
			return true;
		}
		else return false;
	}

	
	@Override
	public void logout() {
		currentUser = null;
	}

	private int indexOfClient(String email){
		for(Client client : clients){
			if(client.getEmail().equals(email))
				return clients.indexOf(client);
		}
		return -1;
	}
	
	private int indexOfAdmin(String email){
		for(Admin admin : admins){
			if(admin.getEmail().equals(email))
				return admins.indexOf(admin);
		}
		return -1;
	}

	@Override
	public boolean userLoggedIn(String name) {
		return currentUser.getEmail().equals(name);
	}

	@Override
	public boolean loggedIn() {
		return !currentUser.equals(null);
	}

	@Override
	public boolean isConcert(Show show) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFestival(Show show) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getConcertName(Concert concert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConcertPerformer(Concert concert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDate getConcertDate(Concert concert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getConcertPrice(Concert concert) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTicketsLeftForConcert(Concert concert) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasPerformer(String artistName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFestivalName(Festival festival) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] getFestivalStart(Festival festival) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] getFestivalEnd(Festival festival) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getPricesForFestival(Festival festival) {
		// TODO Auto-generated method stub
		return null;
	}
}
