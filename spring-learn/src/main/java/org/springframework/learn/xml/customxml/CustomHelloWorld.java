package org.springframework.learn.xml.customxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.learn.beans.SampleCustom;

import java.io.IOException;

/**
 * 自定义xml标签
 * @Author : wangjingwang
 * @Date : 2020/8/10 22:27
 * @Description :
 */
public class CustomHelloWorld {
	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("/spring/hello-custom.xml");

		// bean不存在时抛异常
		Object bean = context.getBean("myCustom");
		if (!(bean instanceof SampleCustom)) {
			System.out.println("myCustom type is " + bean.getClass().getName());
		} else {
			SampleCustom custom = (SampleCustom)bean;
			System.out.println("myCustom.userName=>" + custom.getUserName());
			System.out.println("myCustom.email=>" + custom.getEmail());
		}
	}
}
