package org.springframework.my.xml;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.my.SampleBean;

/**
 * @Author : wangjingwang
 * @Date : 2020/8/10 22:27
 * @Description :
 */
public class LearnXmlBeanFactory {
	public static void main(String[] args) {
		//XmlBeanDefinitionReader // DefaultListableBeanFactory
		DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);

		reader.loadBeanDefinitions(new FileSystemResource("D:\\Workspaces\\IdeaProjects\\Spring\\spring-framework\\spring-learn\\src\\main\\resources\\test.xml"));
		SampleBean sampleBean = (SampleBean) registry.getBean("sampleBean");
		System.out.println(sampleBean.getTestStr());
		System.out.println("LearnXmlBeanFactory ");
	}
}
