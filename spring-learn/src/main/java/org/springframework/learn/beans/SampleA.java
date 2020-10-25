package org.springframework.learn.beans;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author : wangjingwang
 * @Date : 2020/9/13 21:55
 * @Description :
 */
public class SampleA {
	private String info = "default info SampleA";

	@Autowired
	private SampleB sampleB;

	private SampleB[] arr;

	private List<SampleB> list;

	private Map<String, SampleB> map;

	public SampleA() {
		System.out.println("----------------SampleA constructor----------------");
	}

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

	public SampleB[] getArr() {
		return arr;
	}

	public void setArr(SampleB[] arr) {
		this.arr = arr;
	}

	public List<SampleB> getList() {
		return list;
	}

	public void setList(List<SampleB> list) {
		this.list = list;
	}

	public Map<String, SampleB> getMap() {
		return map;
	}

	public void setMap(Map<String, SampleB> map) {
		this.map = map;
	}
}
