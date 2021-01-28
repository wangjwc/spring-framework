package org.springframework.learn.aop;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class AopTestBeanB {
	private String info;

	private AopTestBeanA aopTestBeanA;

	public AopTestBeanB() {
		System.out.println("----------------AopTestBeanB constructor----------------");
	}

	public String hello() {
		System.out.println("AopTestBeanB.hello running");
		return "hello " + info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public AopTestBeanA getAopTestBeanA() {
		return aopTestBeanA;
	}

	public void setAopTestBeanA(AopTestBeanA aopTestBeanA) {
		this.aopTestBeanA = aopTestBeanA;
	}
}
