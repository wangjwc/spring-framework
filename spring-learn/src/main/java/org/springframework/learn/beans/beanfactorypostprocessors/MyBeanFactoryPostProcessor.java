package org.springframework.learn.beans.beanfactorypostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.util.StringValueResolver;

import java.util.Iterator;

/**
 * 自定义BeanFactoryPostProcessor实现自定义的placeHolder
 * @author wangjingwang
 * @version v1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	// 依赖内置placeHolder
	private PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();

	private Resource[] locations;

	public void setLocations(Resource... locations) {
		this.locations = locations;
		configurer.setLocations(locations);
	}

	private StringValueResolver valueResolver = new StringValueResolver() {
		@Override
		public String resolveStringValue(String strVal) {
			/*
			 * 当value值以GET_开头时，使用后面的字符串去获取配置
			 */
			//System.out.println("MyBeanFactoryPostProcessor => " + strVal);
			PropertySources sources = configurer.getAppliedPropertySources();
			// 这里包含environment和properties两中source，所以需要遍历
			Iterator<PropertySource<?>> iterator = sources.iterator();

			if (strVal.startsWith("GET_")) {
				String p = strVal.substring(4);
				while (iterator.hasNext()) {
					// environment或properties
					PropertySource<?> propertySource = iterator.next();
					// 获取属性
					Object value = propertySource.getProperty(p);
					if (null != value) {
						return "MyBeanFactoryPostProcessor: " + String.valueOf(value);
					}
				}
				return "MyBeanFactoryPostProcessor: not found";
			}
			return strVal;
		}
	};

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		configurer.postProcessBeanFactory(beanFactory);

		// 获取所有bean，遍历处理
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
			process(bd);
		}
	}

	private void process(BeanDefinition bd) {
		BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
		visitor.visitBeanDefinition(bd);
	}

}
