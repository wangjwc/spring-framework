package org.springframework.learn.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.learn.beans.SampleBean;
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
			String[] path = new String[]{"/spring/hello-application-context.xml"};
			ApplicationContext context = new ClassPathXmlApplicationContext(path, true, null);
			SampleBean sampleBean = (SampleBean)context.getBean("sampleBean");
			System.out.println(sampleBean.getTestStr());
		}
	}

	public static final class PropertyEditorTest {
		public static void main(String[] args) {
			String[] path = new String[]{"/spring/hello-application-context.xml"};
			ApplicationContext context = new ClassPathXmlApplicationContext(path, true, null);
			PropertyEditorTestBean propertyEditorTestBean = (PropertyEditorTestBean)context.getBean("propertyEditorTestBean");
			System.out.println(propertyEditorTestBean.getDateValue());
			System.out.println(propertyEditorTestBean.getBigDecimalValue());
			System.out.println(propertyEditorTestBean.getStringArrayValue()[1]);
		}
	}
}
