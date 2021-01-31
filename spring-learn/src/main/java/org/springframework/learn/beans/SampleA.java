package org.springframework.learn.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author : wangjingwang
 * @Date : 2020/9/13 21:55
 * @Description :
 */
public class SampleA extends GenericityTestParent<String> {
	private String info = "default info SampleA";

	@Autowired
	private SampleB sampleB;

	@Lazy
	private SampleB lazySampleB;

	private Optional<SampleB> optionalSampleB;

	private SampleB[] arr;

	private List<SampleB> list;

	private Map<String, SampleB> map;

	public SampleA() {
		System.out.println("----------------SampleA constructor----------------");
	}

	@Override
	public String getGenericity() {
		// 测试桥接方法
		return "test";
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

	public SampleB getLazySampleB() {
		return lazySampleB;
	}

	@Lazy
	public void setLazySampleB(SampleB lazySampleB) {
		this.lazySampleB = lazySampleB;
	}

	public Optional<SampleB> getOptionalSampleB() {
		return optionalSampleB;
	}

	public void setOptionalSampleB(Optional<SampleB> optionalSampleB) {
		this.optionalSampleB = optionalSampleB;
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
