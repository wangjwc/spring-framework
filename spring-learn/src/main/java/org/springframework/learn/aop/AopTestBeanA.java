package org.springframework.learn.aop;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class AopTestBeanA {
	private String info;

	private AopTestBeanB aopTestBeanB;

	public AopTestBeanA() {
		System.out.println("----------------AopTestBeanA constructor----------------");
	}

	public String hello() {
		System.out.println("AopTestBeanA.hello running");
		return "hello " + info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public AopTestBeanB getAopTestBeanB() {
		return aopTestBeanB;
	}

	public void setAopTestBeanB(AopTestBeanB aopTestBeanB) {
		this.aopTestBeanB = aopTestBeanB;
	}
}
