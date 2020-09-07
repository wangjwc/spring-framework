package org.springframework.my.learn;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.my.learn.beans.SampleBean;

/**
 * @Author : wangjingwang
 * @Date : 2020/8/11 18:29
 * @Description :
 */
public class HelloTests {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		Resource resource = new FileSystemResource(path+"/src/test/java/org/springframework/beans/learn/xml/hello.xml");

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
		reader.loadBeanDefinitions(resource);

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
