package org.springframework.beans.learn;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Author : wangjingwang
 * @Date : 2020/9/6 18:57
 * @Description :
 */
public class MyCustomNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		// 将自定义解析起注册到spring容器
		registerBeanDefinitionParser("user", new MyCustomBeanDefinitionParser());
	}
}
