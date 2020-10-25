package org.springframework.learn.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class AwareHello implements ApplicationContextAware, EnvironmentAware, EmbeddedValueResolverAware,
		ResourceLoaderAware, ApplicationEventPublisher, MessageSourceAware {

	public String info;

	private ApplicationContext applicationContext;

	private Environment environment;

	private StringValueResolver stringValueResolver;

	private ResourceLoader resourceLoader;

	private MessageSource messageSource;

	public AwareHello() {
		System.out.println("----------------AwareHello constructor----------------");
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("AwareHello.setApplicationContext ==> start get sampleBean: ");
		this.applicationContext = applicationContext;
		SampleBean sampleBean = applicationContext.getBean(SampleBean.class);
		System.out.println("AwareHello.setApplicationContext ==> end get sampleBean: " + sampleBean.getTestStr());
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.stringValueResolver = resolver;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public void publishEvent(Object event) {
		System.out.println("AwareHello: publish event: " + String.valueOf(event));
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
