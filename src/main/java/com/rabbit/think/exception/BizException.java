package com.rabbit.think.exception;

/** 
 * @author rabbit
 * @version 20160919220150
 * 
 * 在rpc接口调用结束，响应错误结果时，一般采用异常的形式来表示错误，这是一个自定义异常的例子，
 * 一般的错误的含义是通过自定义异常的命名来表示的，
 * 当异常命名难以明确表达错误的时候，通过在异常中定义错误码和错误信息，来传递具体的错误信息。
 */
public class BizException extends Exception {

	private static final long serialVersionUID = -4586497711041741635L;
	private static String TIP_HEAD = "业务处理出现异常";
	private String code = "e999";
	private String msg = "异常";
	public BizException(){
		super(TIP_HEAD);
	}
	public BizException(String message){
		super(TIP_HEAD + " - " + message);
	}
	public BizException(String code, String msg){
		super(TIP_HEAD + " - " + code + ":" + msg);
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
