package org.springframework.learn.xml;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.lang.NonNull;
import org.springframework.learn.beans.SampleA;
import org.springframework.learn.beans.SampleBean;

import java.io.IOException;

/**
 * DefaultListableBeanFactory是bean注册的基础
 * XmlBeanDefinitionReader是xml读取的基础
 * 其他的启动方式都是对二者的封装
 * @author  wangjingwang
 * @since 2020/8/10 22:27
 */
public class HelloWorldDependInject {
	public static class MyEnvironmentCapableRegistry extends DefaultListableBeanFactory implements EnvironmentCapable {
		private StandardEnvironment environment = new StandardEnvironment();

		public MyEnvironmentCapableRegistry() {
			super();
		}

		@NonNull
		@Override
		public StandardEnvironment getEnvironment() {
			return this.environment;
		}
	}

	private static MyEnvironmentCapableRegistry load(String profile) throws IOException {
		ClassPathResource classPathResource = new ClassPathResource("/spring/hello-depend.xml");
		System.out.println(classPathResource.getFile().getAbsolutePath());
		//String path = System.getProperty("user.dir");
		MyEnvironmentCapableRegistry registry = new MyEnvironmentCapableRegistry();
		registry.getEnvironment().setActiveProfiles(profile);

		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.loadBeanDefinitions(classPathResource);
		return registry;
	}

	/**
	 * xml方式依赖注入
	 */
	public static class InjectByXml extends HelloWorldDependInject {
		public static void main(String[] args) throws IOException {
			/*
			 * hello-depend.xml中的property profile
			 */
			MyEnvironmentCapableRegistry registry = load("property");
			SampleA sampleA = (SampleA)registry.getBean("sampleA");
			System.out.println(sampleA.getInfo());
			System.out.println(sampleA.getSampleB().getInfo());
		}
	}

	/**
	 * 注解方式依赖注入
	 */
	public static class InjectByAnnotation extends HelloWorldDependInject {
		public static void main(String[] args) throws IOException {
			/*
			 * hello-depend.xml中的property annotation
			 */
			MyEnvironmentCapableRegistry registry = load("annotation");

			// 添加注解支持的InstantiationAwareBeanPostProcessorAdapter，必须是bean，见xml
			registry.addBeanPostProcessor(registry.getBean(AutowiredAnnotationBeanPostProcessor.class));

			SampleA sampleA = (SampleA)registry.getBean("sampleA");
			System.out.println(sampleA.getInfo());
			System.out.println(sampleA.getSampleB().getInfo());
		}
	}



}
