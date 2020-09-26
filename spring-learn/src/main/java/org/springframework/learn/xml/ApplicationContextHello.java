package org.springframework.learn.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.learn.beans.SampleBean;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class ApplicationContextHello {

	public static final class Simple {
		public static void main(String[] args) {
			ApplicationContext context = new ClassPathXmlApplicationContext("/spring/hello.xml");
			SampleBean sampleBean = (SampleBean)context.getBean("sampleBean");
			System.out.println(sampleBean.getTestStr());

		}
	}
}
