package org.springframework.my.learn;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.my.learn.beans.SampleCustom;
import org.w3c.dom.Element;

/**
 * @Author : wangjingwang
 * @Date : 2020/9/6 16:45
 * @Description :
 */
public class MyCustomBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	/**
	 * 返回自定义element对应的bean的类的类名（该方发和getBeanClass方法实现任意一个便可以了
	 *
	 * 推荐使用该方法代替getBeanClass，以便实现对BeanClass没有强依赖
	 * @param element the {@code Element} that is being parsed
	 * @return
	 */
	@Override
	protected String getBeanClassName(Element element) {
		return SampleCustom.class.getName();
	}

	/**
	 * 返回自定义element对应的bean的类
	 * @param element the {@code Element} that is being parsed
	 * @return
	 */
	@Override
	protected Class<?> getBeanClass(Element element) {
		return SampleCustom.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		builder.addPropertyValue("userName", element.getAttribute("userName"));
		builder.addPropertyValue("email", element.getAttribute("email"));
	}
}
