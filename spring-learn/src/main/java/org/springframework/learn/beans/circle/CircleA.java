package org.springframework.learn.beans.circle;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class CircleA {
	private String info;

	private CircleB circleB;

	public CircleA() {
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

	public CircleB getCircleB() {
		return circleB;
	}

	public void setCircleB(CircleB circleB) {
		this.circleB = circleB;
	}
}
