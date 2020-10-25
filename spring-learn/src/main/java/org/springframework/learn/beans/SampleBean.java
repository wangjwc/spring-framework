package org.springframework.learn.beans;

/**
 * @Author : wangjingwang
 * @Date : 2020/8/10 22:38
 * @Description :
 */
public class SampleBean {
	private String testStr = "default str";

	public SampleBean() {
		System.out.println("----------------SampleBean constructor----------------");
	}

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}
}
