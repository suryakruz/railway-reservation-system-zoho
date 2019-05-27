package com.reservation;

public class Berth {
		private int LB=21;
		private int MB=21;
		private int UB=21;
		
		
     public void allocateBerth(Ticket ticket) {
    	 if(LB!=0 && ticket.getBirthPreference().equals("LB")) {
    		 LB--;
    		 ticket.setConfirmationStatus("booked LB");
    	 }
    	 else if(MB!=0 && ticket.getBirthPreference().equals("MB")) {
    		 MB--;
    		 ticket.setConfirmationStatus("booked MB");
    	 }
    	else if(UB!=0 && ticket.getBirthPreference().equals("UB")){
    		   UB--;
    		  ticket.setConfirmationStatus("booked UB");
    		 } 
    	 
    	else {
			if(LB!=0) {
				 ticket.setConfirmationStatus("booked LB");
			}
			else if(MB!=0)
			{
				 ticket.setConfirmationStatus("booked MB");
			}
			else {
				 ticket.setConfirmationStatus("booked UB");
			}
		}
    	 }
         	 
    	 
    	 
     
		
		
		
	}

