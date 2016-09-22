package com.rabbit.think.reflection;

import java.util.Date;

/**
 * 这里联系一下java反射
 * @author rabbitgyk
 *
 */
public class ReflectionMain {
	
	public static void main(String[] args) throws Exception{
		// 1. 反射一，初始化类
		String s = "java.util.Date";
		Class clazz = Class.forName(s);
		
		Date date = (Date)clazz.newInstance();
		System.out.println(date.getTime());
		
		// 2. 反射二，
	}

}
