package org.springframework.learn.xml;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.learn.beans.SampleBean;

import java.io.IOException;

/**
 * DefaultListableBeanFactory是bean注册的基础
 * XmlBeanDefinitionReader是xml读取的基础
 * 其他的启动方式都是对二者的封装
 * @Author : wangjingwang
 * @Date : 2020/8/10 22:27
 * @Description :
 */
public class BeanFactoryHello {
	public static void main(String[] args) throws IOException {
		ClassPathResource classPathResource = new ClassPathResource("/spring/hello.xml");
		System.out.println(classPathResource.getFile().getAbsolutePath());
		//String path = System.getProperty("user.dir");
		//Resource resource = new FileSystemResource(path+"/spring-learn/src/main/java/org/springframework/my/learn/xml/hello.xml");
		/*
		 * 初始化factory、registry
		 * ignoreDependencyInterface(BeanNameAware.class);
		 * ignoreDependencyInterface(BeanFactoryAware.class);
		 * ignoreDependencyInterface(BeanClassLoaderAware.class);
		 *
		 * DefaultListableBeanFactory是spring注册及加载bean的默认实现
		 */
		DefaultListableBeanFactory registry = new DefaultListableBeanFactory();

		/*
		 * 初始化resourceLoader和environment
		 */
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);

		/*
		 * 读取xml，注册BeanDefinition
		 */
		reader.loadBeanDefinitions(classPathResource);

		/*
		 * 获取bean
		 */
		SampleBean sampleBean = (SampleBean)registry.getBean("sampleBean");
		System.out.println(sampleBean.getTestStr());

		/*
		 * 从FactoryBean创建的bean
		 */
		SampleBean sampleBeanByFactory = (SampleBean)registry.getBean("sampleBeanByFactory");
		System.out.println(sampleBeanByFactory.getTestStr());

		/*
		 * 获取FactoryBean的原始实例, name前添加&
		 */
		Object obj = registry.getBean("&sampleBeanByFactory");
		System.out.println(obj.getClass());

		System.out.println("LearnXmlBeanFactory ");
	}
}
