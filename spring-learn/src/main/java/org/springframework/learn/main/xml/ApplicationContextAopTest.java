package org.springframework.learn.main.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.learn.aop.AopTestBean;
import org.springframework.learn.beans.SampleBean;
import org.springframework.learn.beans.ValuePlaceHolderBean;
import org.springframework.learn.beans.factorybean.SampleFactoryBean;
import org.springframework.learn.beans.generic.GenericDependTestA;
import org.springframework.learn.beans.generic.GenericDependTestB;
import org.springframework.learn.beans.propertyeditor.PropertyEditorTestBean;

import java.util.regex.Pattern;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class ApplicationContextAopTest {

	static final String[] PATH = new String[]{"/spring/aop-application-context.xml"};

	public static final class Simple {
		public static void main(String[] args) {
			System.getProperties().put("spring.profiles.active", "sample");
			ApplicationContext context = new ClassPathXmlApplicationContext(PATH, true, null);

			System.out.println("----------------------aopTestBean----------------------");
			AopTestBean aopTestBean = (AopTestBean) context.getBean("aopTestBean");
			System.out.println("=====> " + aopTestBean.hello());

			System.out.println("----------------------org.springframework.learn.aop.AopTestBean.ORIGINAL----------------------");
			AopTestBean aopTestBeanOriginal = (AopTestBean) context.getBean("org.springframework.learn.aop.AopTestBean.ORIGINAL");
			System.out.println("=====> " + aopTestBeanOriginal.hello());

		}
	}
}
