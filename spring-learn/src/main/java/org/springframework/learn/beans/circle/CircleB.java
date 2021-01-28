package org.springframework.learn.beans.circle;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class CircleB {
	private String info;

	private CircleA circleA;

	public CircleB() {
		System.out.println("----------------AopTestBeanB constructor----------------");
	}

	public String hello() {
		return "hello " + info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public CircleA getCircleA() {
		return circleA;
	}

	public void setCircleA(CircleA circleA) {
		this.circleA = circleA;
	}
}
