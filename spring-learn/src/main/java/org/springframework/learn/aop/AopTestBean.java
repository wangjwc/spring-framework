package org.springframework.learn.aop;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class AopTestBean {
	private String info;

	public String hello() {
		System.out.println("AopTestBean.hello running");
		return "hello " + info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
