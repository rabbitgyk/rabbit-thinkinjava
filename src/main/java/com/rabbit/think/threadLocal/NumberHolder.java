package com.rabbit.think.threadLocal;

import java.util.Random;

public class NumberHolder {
	//number holder的初始化
	private static ThreadLocal<Integer> number = new ThreadLocal<Integer>(){
		private Random random = new Random(47);
		protected synchronized Integer initialValue() {
	        return random.nextInt(10000);
	    }
	};
	
	public static void increment(){
		number.set(number.get() + 1);
	}
	
	public static Integer get(){
		return number.get();
	}
}
