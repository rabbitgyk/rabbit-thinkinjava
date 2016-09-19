package com.rabbit.think.exception;

/**
 * java 异常中return 和 finally同时使用时，需注意的点，先运行main，会发现结果是：
 * >>>>>> abc <<<<<<
 * >>>>>> abc1 <<<<<
 * >>>>>> abc12 <<<<
 * 解释：catch中的return在finally之后执行，但是会将return的值放到一个地方存起来，
 * 所以finally中的name = name + 2会执行，但返回值是abc1。
 * 
 * @author rabbit
 * 2016年9月19日
 */
public class ExceptionFinallyReturn {

	static String name = "abc";

	public static String getName() {
		try {
			throw new Exception();
		} catch (Exception e) {
			name = name + 1;
			return name;
		} finally {
			name = name + 2;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(name);
		System.out.println(getName());
		System.out.println(name);
	}

}
