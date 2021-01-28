package org.springframework.learn.beans.circle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 模拟循环依赖情况下，因为postProcessAfterInitialization改变导致的循环依赖检查异常
 * @author wangjingwang
 * @version v1.0
 */
public class ChangeInstanceBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		try {
			return bean.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return bean;
	}
}
