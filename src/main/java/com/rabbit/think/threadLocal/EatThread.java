package com.rabbit.think.threadLocal;

public class EatThread implements Runnable {

	private final int id;
	
	public EatThread(int id){
		this.id = id;
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			NumberHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}
	
	@Override
	public String toString(){
		return id + " eat "+ NumberHolder.get();
	}

}
