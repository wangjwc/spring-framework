package org.springframework.learn.beans.factorybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.ResolvableType;
import org.springframework.learn.beans.SampleBean;

/**
 * @Author : wangjingwang
 * @Date : 2020/9/10 07:26
 * @Description :
 */
public class SampleBeanFactoryBean implements FactoryBean<SampleBean> {

	@Override
	public SampleBean getObject() throws Exception {
		SampleBean sampleBean = new SampleBean();
		sampleBean.setTestStr("from FactoryBean");
		return sampleBean;
	}

	@Override
	public Class<SampleBean> getObjectType() {
		return SampleBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
