package com.rabbit.think.exception;

public class ExceptionMain {

	public static void main(String[] args) {
		PersonService ps = new PersonService();
		String name = "";
		try {
			name = ps.getName(7);
		} catch (BizException e) {
			System.out.println(e.getCode() + " : " + e.getMsg());
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("查到名字：" + name);
	}
}
