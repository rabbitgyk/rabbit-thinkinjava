package com.rabbit.think.exception;

public class PersonService {

	public String getName(int age) throws BizException{
		if(age < 0){
			throw new BizException();
		}else if(age < 10){
			throw new BizException("age不能小于10");
		}else if(age < 22){
			throw new BizException("e135", "不符和法定结婚年龄");
		}else if(age < 30){
			throw new BizException("e136", "不符和法定生小孩年龄");
		}
		return "rabbit" + age;
	}
}
