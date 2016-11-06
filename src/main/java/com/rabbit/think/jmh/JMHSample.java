package com.rabbit.think.jmh;

import org.openjdk.jmh.annotations.Benchmark;

public class JMHSample {
	
	@Benchmark
	public void helloJMH(){
		System.out.println("hello jmh");
	}

}
