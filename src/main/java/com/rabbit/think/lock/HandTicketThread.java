package com.rabbit.think.lock;

import com.rabbit.think.lock.Tickets.Ticket;

public class HandTicketThread extends Thread {
	private Tickets tickets;

	public HandTicketThread(Tickets tickets) {
		this.tickets = tickets;
	}

	@Override
	public void run() {
		Ticket ticket = null;
		do{
			ticket = tickets.getTicket();
			System.out.println(ticket);
		}while(ticket != null);
		
	}
}