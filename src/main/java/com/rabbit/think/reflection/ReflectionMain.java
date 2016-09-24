package com.rabbit.think.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * 这里联系一下java反射
 * @author rabbitgyk
 *
 */
public class ReflectionMain {
	
	public static void main(String[] args) throws Exception{
		// 1. 反射一，初始化类
		String s = "java.util.Date";
		Class<? extends Object> clazz = Class.forName(s);
		
		Object object = clazz.newInstance();
		// 注：强转之前 最好做个类型校验
		if(object instanceof Date){
			System.out.println(((Date)object).getTime());
		}
		
		// 2. 反射二，各种反射方法
		Field[] fields = clazz.getDeclaredFields();
		System.out.println(JSONObject.toJSONString(fields));
		Method method = clazz.getMethod("getTime");
		System.out.println(JSONObject.toJSONString(method));
	}

}
