package org.springframework.learn.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.learn.beans.AwareHello;
import org.springframework.learn.beans.SampleA;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class ApplicationContextHello {
	private static final String BASE_PKG = "org.springframework.learn";

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BASE_PKG);

		//SampleA sampleA = context.getBean(SampleA.class);
		//System.out.println("sampleA ==> " + sampleA.getInfo());

		AwareHello awareHello = context.getBean(AwareHello.class);
		System.out.println("awareHello ==> " + awareHello.getInfo());
	}
}
