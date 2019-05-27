package com.reservation;

import java.util.ArrayList;

public class Train {

	ArrayList<Ticket> confirmedTickets=new ArrayList<Ticket>();
	ArrayList<Ticket> racTickets=new ArrayList<Ticket>();
	ArrayList<Ticket> waitingListTickets=new ArrayList<Ticket>();
	Berth berth =new Berth();
	
	
	
	public void bookTicket(Ticket ticket) {
		  
		  if(confirmedTickets.size()<2) {
			  berth.allocateBerth(ticket);
			confirmedTickets.add(ticket);
		  }
		  else if(racTickets.size()<1) {
			  ticket.setConfirmationStatus("In RAC");
			  racTickets.add(ticket);
		  }
		  else if(waitingListTickets.size()<1){
			  ticket.setConfirmationStatus("In Waiting list");
			  waitingListTickets.add(ticket);
		  }
		  else {
			System.out.println("No Tickets Available");
			return;
		}
		  
		  displayTicket(ticket);
	  } 
	  
	
		
	 
	  public void cancelTicket(Ticket ticket) {
	  
	   	 if(removeTicket(ticket,confirmedTickets))
	   	 {
	   		 confirmedTickets.add(confirmedTickets.size(),racTickets.get(0));
	   		 racTickets.remove(0);
	   		  if(!waitingListTickets.isEmpty())
	   		  {
			  racTickets.add(racTickets.size(),waitingListTickets.get(0));
			  waitingListTickets.remove(0);
	   		  }
	   	 }else if(removeTicket(ticket,waitingListTickets)) {
	   		 return;
	   	 }
	   	 else if(removeTicket(ticket,racTickets)) {
	   		 if(!waitingListTickets.isEmpty()) {
	   		racTickets.add(racTickets.size()-1,waitingListTickets.get(0));
			  waitingListTickets.remove(0);
	   		 }
	   	 }
		else {
				System.out.println("your search does not match");
				return;
			}
	   	 
             
			
	  }
	  
	  private boolean removeTicket(Ticket ticket,ArrayList<Ticket> ticketBookings ) {
		  for(Ticket tickets:ticketBookings) {
	           if(tickets.getName().equals(ticket.getName()) && tickets.getAge()==ticket.getAge()) {
	        	   racTickets.get(0).setConfirmationStatus(tickets.getConfirmationStatus());
	        	   confirmedTickets.remove(tickets);
	        	  
	        	   return true;
	           }  		  
	   	  }
		  return false;
	  }
	  
	 
	  
	  private ArrayList<Ticket> findTicketStatus(Ticket ticket) {
		  if(confirmedTickets.contains(ticket))
			  return confirmedTickets;
		  else if(racTickets.contains(ticket))
			  return racTickets;
		  else {
			return waitingListTickets;
		}
	  }
	  
	  public void displayTicket(Ticket ticket) {
			  System.out.println(ticket.getName()+"\n"+ticket.getAge()+"\n"+ticket.getGender()+"\n"+ticket.getConfirmationStatus()+" "
					  +findTicketStatus(ticket).indexOf(ticket)
					  );
		  }
		  
	  
	  
	  public void displayAllTickets() {
		  for(Ticket ticket:confirmedTickets) {
			  System.out.println(ticket.getName()+"\n"+ticket.getAge()+"\n"+ticket.getGender()+"\n"+ticket.getConfirmationStatus()+" "
					  +findTicketStatus(ticket).indexOf(ticket)
					  );
		  }
		  for(Ticket ticket:racTickets) {
			  System.out.println(ticket.getName()+"\n"+ticket.getAge()+"\n"+ticket.getGender()+"\n"+ticket.getConfirmationStatus()+" "
					  +findTicketStatus(ticket).indexOf(ticket)
					  );
			  }
		  for(Ticket ticket:waitingListTickets) {
			  System.out.println(ticket.getName()+"\n"+ticket.getAge()+"\n"+ticket.getGender()+"\n"+ticket.getConfirmationStatus()+" "
					  +findTicketStatus(ticket).indexOf(ticket)
					  );
			  }
	  }
	  }
	

