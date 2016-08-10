package com.rabbit.think.annotation;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 注解的实际用途1
 * 
 * 通过在对象属性上使用自定义注解，来校验属性的值是否为空。
 * 实际应用场景：对接口的入参的对象的属性进行统一的非空校验，
 * 借助于拦截器来获取接口中的参数，然后进行逐一校验。
 * 
 * @author rabbit
 * 2016年8月10日
 */
public class AnnotationHandler {

	public static String handle(Object object){
		Class<? extends Object> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		String tip = "";
		try {
			for (Field field : fields) {
				//获取属性值
				Object val = null;
				if (Modifier.toString(field.getModifiers()).endsWith("private")) {
					Method getMethod = new PropertyDescriptor(field.getName(), clazz).getReadMethod();// 获得get方法
					val = getMethod.invoke(object);
				} else {
					val = field.get(object);
				}
				//获取属性上的注解
				NotNull nn = field.getAnnotation(NotNull.class);
				if(nn != null && val == null){
					tip = tip + (nn.desc().equals("") ? field.getName() : nn.desc()) + " ";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tip;
	}
	
	public static void main(String[] args) {
		Person person = new Person();
		person.setAge(12);
		person.setName("guoyankui");
		person.setPhone("13521238034");
		
		String tip = handle(person);
		if(tip.length() > 0){
			System.out.println(tip + "为关键参数，值不能为null！");
		}
		
	}
}
