package org.springframework.learn.main.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.lang.Nullable;
import org.springframework.learn.beans.SampleBean;
import org.springframework.learn.beans.ValuePlaceHolderBean;
import org.springframework.learn.beans.factorybean.SampleFactoryBean;
import org.springframework.learn.beans.generic.GenericDependTestA;
import org.springframework.learn.beans.generic.GenericDependTestB;
import org.springframework.learn.beans.propertyeditor.PropertyEditorTestBean;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class ApplicationContextHello {
	public static class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {
		public MyClassPathXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent) {
			super(configLocations, refresh, parent);
		}

		@Override
		protected void initPropertySources() {
			// 设置required属性，如果不存在，那么在prepareRefresh中的getEnvironment().validateRequiredProperties()时会异常
			super.getEnvironment().setRequiredProperties("testRequired");
		}

		public static void main(String[] args){
			String[] path = new String[]{"/spring/hello-application-context.xml"};
			new MyClassPathXmlApplicationContext(path, true, null);
		}
	}

	public static final class Simple {
		public static void main(String[] args) {
			System.getProperties().put("spring.profiles.active", "sample");
			String[] path = new String[]{"/spring/hello-application-context.xml"};
			ApplicationContext context = new ClassPathXmlApplicationContext(path, true, null);
			System.out.println("profile => " + context.getEnvironment().getActiveProfiles()[0]);

			SampleBean sampleBean = (SampleBean)context.getBean("sampleBean");
			System.out.println("sampleBean => " + sampleBean.getTestStr());

			/*
			 * 从FactoryBean创建的bean
			 */
			SampleFactoryBean.Bean sampleFactoryBean = (SampleFactoryBean.Bean)context.getBean("sampleFactoryBean");
			System.out.println("SampleFactoryBean.Bean => " + sampleFactoryBean.getInfo());

			/*
			 * 获取FactoryBean的原始实例, name前添加&
			 */
			Object obj = context.getBean("&sampleFactoryBean");
			System.out.println("SampleFactoryBean.Bean instance => " + obj.toString());
		}
	}

	public static final class PropertyEditorTest {
		public static void main(String[] args) {
			System.getProperties().put("spring.profiles.active", "propertyEditor");
			String[] path = new String[]{"/spring/hello-application-context.xml"};
			ApplicationContext context = new ClassPathXmlApplicationContext(path, true, null);

			PropertyEditorTestBean propertyEditorTestBean = (PropertyEditorTestBean)context.getBean("propertyEditorTestBean");
			System.out.println(propertyEditorTestBean.getDateValue());
			System.out.println(propertyEditorTestBean.getBigDecimalValue());
			System.out.println(propertyEditorTestBean.getStringArrayValue()[1]);
		}
	}

	/**
	 * 典型的PropertySourcesPlaceholderConfigurer
	 */
	public static final class BeanFactoryPostProcessorTest {
		public static void main(String[] args){
			System.getProperties().put("spring.profiles.active", "beanFactoryPostProcessor");
			String[] path = new String[]{"/spring/hello-application-context.xml"};
			ApplicationContext context = new ClassPathXmlApplicationContext(path, true, null);

			SampleBean sampleBean = (SampleBean)context.getBean("sampleBean");
			System.out.println(sampleBean.getTestStr());

			SampleBean sampleBean2 = (SampleBean)context.getBean("sampleBean2");
			System.out.println(sampleBean2.getTestStr());

			ValuePlaceHolderBean valuePlaceHolderBean = (ValuePlaceHolderBean) context.getBean("valuePlaceHolderBean");
			System.out.println("valuePlaceHolderBean.value ==> " + valuePlaceHolderBean.getValue());
			System.out.println("valuePlaceHolderBean.value2 ==> " + valuePlaceHolderBean.getValue2());
		}
	}

	/*
	 * 泛型依赖
	 */
	public static final class GenericDependTest {
		public static void main(String[] args){
			System.getProperties().put("spring.profiles.active", "generic");
			String[] path = new String[]{"/spring/hello-application-context.xml"};
			ApplicationContext context = new ClassPathXmlApplicationContext(path, true, null);

			GenericDependTestA testA = context.getBean(GenericDependTestA.class);
			GenericDependTestB testB = context.getBean(GenericDependTestB.class);

			System.out.println("A.info => " + testA.getInfo());
			System.out.println("A.genericField ==> " + testA.getGenericField().toString());
			System.out.println("A.genericField.info ==> " + testA.getGenericField().getInfo());

			System.out.println("B ==> " + testB.toString());
			System.out.println("B.info ==> " + testB.getInfo());
		}
	}
	//
}
