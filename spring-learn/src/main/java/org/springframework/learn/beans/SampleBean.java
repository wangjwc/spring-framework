package org.springframework.learn.beans;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;

/**
 * @Author : wangjingwang
 * @Date : 2020/8/10 22:38
 * @Description :
 */
public class SampleBean implements SmartLifecycle {
	private String testStr = "default str";

	private boolean isRunning = false;

	public SampleBean() {
		System.out.println("----------------SampleBean constructor----------------");
	}

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	@Override
	public void start() {
		System.out.println("Lifecycle.start === > " + this.toString());
		this.isRunning = true;
	}

	@Override
	public void stop() {
		System.out.println("Lifecycle.stop === > " + this.toString());
		this.isRunning = false;
	}

	@Override
	public boolean isRunning() {
		return isRunning;
	}


}
