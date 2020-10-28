package org.springframework.learn.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.learn.beans.SampleBean;

/**
 * @Author : wangjingwang
 * @Date : 2020/9/10 07:26
 * @Description :
 */
public class SampleFactoryBean implements FactoryBean<SampleFactoryBean.Bean> {

	public SampleFactoryBean() {
		System.out.println("----------------SampleFactoryBean constructor----------------");
	}

	@Override
	public Bean getObject() throws Exception {
		Bean bean = new Bean();
		bean.setInfo("from SampleFactoryBean");
		return bean;
	}

	@Override
	public Class<SampleBean> getObjectType() {
		return SampleBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public static final class Bean {
		private String info = "default info SampleFactoryBean.Bean";

		public Bean() {
			System.out.println("----------------SampleFactoryBean.Bean constructor----------------");
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}
	}
}
