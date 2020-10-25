package org.springframework.learn.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.learn.beans.AwareHello;
import org.springframework.learn.beans.SampleA;
import org.springframework.learn.beans.SampleB;
import org.springframework.learn.beans.SampleBean;

/**
 * @author wangjingwang
 * @version v1.0
 */
@Configuration
public class DemoAutoConfiguration {

	public DemoAutoConfiguration() {
		System.out.println("----------------DemoAutoConfiguration constructor----------------");
	}

	@Bean
	public SampleA sampleA() {
		SampleA a =  new SampleA();
		a.setInfo("init by AutoConfigurationDemo => @Configuration");
		return a;
	}

	@Bean
	public SampleB sampleB() {
		SampleB b = new SampleB();
		b.setInfo("init by AutoConfigurationDemo => @Configuration");
		return b;
	}

	@Bean
	public SampleBean sampleBean() {
		SampleBean bean = new SampleBean();
		bean.setTestStr("init by AutoConfigurationDemo => @Configuration");
		return bean;
	}

	@Bean
	public AwareHello awareHello() {
		AwareHello hello = new AwareHello();
		hello.setInfo("init by AutoConfigurationDemo => @Configuration");
		return hello;
	}
}
