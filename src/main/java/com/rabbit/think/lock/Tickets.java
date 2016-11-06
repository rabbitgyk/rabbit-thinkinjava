package com.rabbit.think.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 这是一个装有10张票的票箱子，多线程情况下，取票的方法需要控制并发数（synchronized ReentrantLock）
 * @author rabbitgyk
 *
 */
public class Tickets {

	final public int count = 10;
	private int currentId = 0;
	
	final ReentrantLock lock = new ReentrantLock();
	
	public Ticket getTicket(){
		Ticket ticket = null;
		lock.lock();
		if(currentId < count){
			currentId++;
			ticket = new Ticket(currentId);
		}
		lock.unlock();
		return ticket;
	}
	
	public int ticketId(Ticket ticket){
		return ticket.getId();
	}

	public class Ticket{
		private int id;
		
		public Ticket(int id){
			this.id = id;
		}

		public int getId() {
			return id;
		}
		
		@Override
		public String toString() {
			return Thread.currentThread().getName()+" : the ticket's id is " + id;
		}

	}
}
