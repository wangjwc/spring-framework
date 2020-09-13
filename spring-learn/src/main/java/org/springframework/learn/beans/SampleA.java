package org.springframework.learn.beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author : wangjingwang
 * @Date : 2020/9/13 21:55
 * @Description :
 */
public class SampleA {
	private String info = "default info SampleA";

	@Autowired
	private SampleB sampleB;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public SampleB getSampleB() {
		return sampleB;
	}

	public void setSampleB(SampleB sampleB) {
		this.sampleB = sampleB;
	}
}
