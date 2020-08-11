package org.springframework.my.xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.my.SampleBean;

/**
 * @Author : wangjingwang
 * @Date : 2020/8/10 22:27
 * @Description :
 */
public class LearnXmlBeanFactory {
	public static void main(String[] args) {
		//XmlBeanDefinitionReader // DefaultListableBeanFactory
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("org/springframework/my/test.xml"));
		SampleBean sampleBean = (SampleBean) bf.getBean("sampleBean");
		System.out.println(sampleBean.getTestStr());
		System.out.println("LearnXmlBeanFactory");
	}
}
