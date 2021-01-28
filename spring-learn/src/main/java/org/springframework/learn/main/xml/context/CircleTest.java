package org.springframework.learn.main.xml.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.learn.aop.AopTestBean;
import org.springframework.learn.aop.AopTestBeanA;
import org.springframework.learn.aop.AopTestBeanB;
import org.springframework.learn.beans.circle.CircleA;
import org.springframework.learn.beans.circle.CircleB;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class CircleTest {
	static final String[] PATH = new String[]{"/spring/circle-application-context.xml"};

	public static final class Simple {
		public static void main(String[] args) {
			System.getProperties().put("spring.profiles.active", "sample");
			ApplicationContext context = new ClassPathXmlApplicationContext(PATH, true, null);

			System.out.println("\n\n----------------------circleA----------------------");
			CircleA circleA = (CircleA) context.getBean("circleA");
			System.out.println("=====> " + circleA.hello());
			System.out.println("=====> " + circleA.getCircleB().hello());


			System.out.println("\n\n----------------------circleB----------------------");
			CircleB circleB = (CircleB) context.getBean("circleB");
			System.out.println("=====> " + circleB.hello());
			System.out.println("=====> " + circleB.getCircleA().hello());

		}
	}

	public static final class BeanCurrentlyInCreationException {
		public static void main(String[] args) {
			System.getProperties().put("spring.profiles.active", "BeanCurrentlyInCreationException");
			new ClassPathXmlApplicationContext(PATH, true, null);
		}
	}
}

