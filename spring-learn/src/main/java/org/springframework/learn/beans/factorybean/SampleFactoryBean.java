package org.springframework.learn.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.learn.beans.SampleBean;

/**
 * @Author : wangjingwang
 * @Date : 2020/9/10 07:26
 * @Description :
 */
public class SampleFactoryBean implements SmartFactoryBean<SampleFactoryBean.Bean>, SmartLifecycle {

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

	@Override
	public void start() {
		System.out.println("Lifecycle.start === > " + this.toString());
	}

	@Override
	public void stop() {
		System.out.println("Lifecycle.stop === > " + this.toString());
	}

	@Override
	public boolean isRunning() {
		return false;
	}

	/*
	 * 这里实现的SmartLifecycle没有效果，真正有效果的是SampleFactoryBean实现的SmartLifecycle
	 */
	public static final class Bean implements SmartLifecycle {
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

		@Override
		public void start() {
			System.out.println("Lifecycle.start === > " + this.toString());
		}

		@Override
		public void stop() {
			System.out.println("Lifecycle.stop === > " + this.toString());
		}

		@Override
		public boolean isRunning() {
			return false;
		}
	}
}
