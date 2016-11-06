package com.rabbit.think.lock;

/**
 * 这是对java中锁相关概念的一个深入理解
 * @author rabbitgyk
 *
 */
public class MainLock {

	public static void main(String[] args) {
		
		Tickets tickets = new Tickets();
		
		HandTicketThread thread0 = new HandTicketThread(tickets);
		HandTicketThread thread1 = new HandTicketThread(tickets);
		HandTicketThread thread2 = new HandTicketThread(tickets);
		
		thread0.start();
		thread1.start();
		thread2.start();
		
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
