package org.springframework.learn.beans.beanfactorypostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;
import org.springframework.util.StringValueResolver;

import java.util.Iterator;

/**
 * 自定义BeanFactoryPostProcessor实现自定义的placeHolder
 * @author wangjingwang
 * @version v1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	// 依赖内置placeHolder
	private PropertySourcesPlaceholderConfigurer configurer;

	private StringValueResolver valueResolver = new StringValueResolver() {
		@Override
		public String resolveStringValue(String strVal) {
			//System.out.println("MyBeanFactoryPostProcessor => " + strVal);
			PropertySources sources = configurer.getAppliedPropertySources();
			Iterator<PropertySource<?>> iterator = sources.iterator();

			if (strVal.startsWith("GET_")) {
				String p = strVal.substring(4);

				while (iterator.hasNext()) {
					PropertySource<?> propertySource = iterator.next();
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

	public void setConfigurer(PropertySourcesPlaceholderConfigurer configurer) {
		this.configurer = configurer;
	}
}
