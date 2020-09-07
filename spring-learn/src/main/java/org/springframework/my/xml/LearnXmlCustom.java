package org.springframework.my.xml;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.my.learn.beans.SampleBean;

import java.io.IOException;

/**
 * @Author : wangjingwang
 * @Date : 2020/8/10 22:27
 * @Description :
 */
public class LearnXmlCustom {
	public static void main(String[] args) throws IOException {
		ClassPathResource classPathResource = new ClassPathResource("/spring/hello-custom.xml");
		System.out.println(classPathResource.getFile().getAbsolutePath());
		//String path = System.getProperty("user.dir");
		//Resource resource = new FileSystemResource(path+"/spring-learn/src/main/java/org/springframework/my/learn/xml/hello.xml");

		//XmlBeanDefinitionReader // DefaultListableBeanFactory
		/**
		 * 初始化factory、registry
		 * ignoreDependencyInterface(BeanNameAware.class);
		 * ignoreDependencyInterface(BeanFactoryAware.class);
		 * ignoreDependencyInterface(BeanClassLoaderAware.class);
		 *
		 * DefaultListableBeanFactory是spring注册及加载bean的默认实现
		 *
		 */
		DefaultListableBeanFactory registry = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.loadBeanDefinitions(classPathResource);


		SampleBean sampleBean = (SampleBean)registry.getBean("sampleBean");
		System.out.println(sampleBean.getTestStr());
		System.out.println("LearnXmlBeanFactory ");

//		SampleCustom sampleCustom = (SampleCustom)registry.getBean("myCustom");
//		if (null != sampleCustom) {
//			System.out.println("myCustom not found");
//		} else {
//			System.out.println("myCustom.userName=>" + sampleCustom.getUserName());
//			System.out.println("myCustom.email=>" + sampleCustom.getEmail());
//		}
	}
}
