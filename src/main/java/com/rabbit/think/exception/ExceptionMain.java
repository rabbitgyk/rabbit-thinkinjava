package com.rabbit.think.exception;

/**
 * 自定义异常的使用方法，修改getName方法的入参age的值能看到不同的异常构造形式
 * @author rabbit
 * 2016年9月19日
 */
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
