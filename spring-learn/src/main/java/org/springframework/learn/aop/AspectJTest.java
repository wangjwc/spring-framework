package org.springframework.learn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Aspect: 切面
 * advice: 通知（增强）
 * join point: 连接点，比如方法、异常。在spring中，专指方法
 * point cut: 切点，即提供规则，给指定的join point（即方法）添加增强（可以理解为选择器）
 * introduction: 为一个类型添加额外的方法或字段. Spring AOP 允许我们为 目标对象 引入新的接口(和对应的实现).
 * 		例如我们可以使用 introduction 来为一个 bean 实现 IsModified 接口, 并以此来简化 caching 的实现.
 * target: 要织入advice的代理类
 *
 * Advisor: 通知（增强）器
 *
 * 1. @Around before
 * 2. point.proceed();
 * 3. 	@Before
 * 4. 		origin method
 * 5. 	@After
 * 6. @Around after
 *
 *
 *
 * @author wangjingwang
 * @version v1.0
 */
@Aspect
public class AspectJTest {

	private String info = "default";

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	@Pointcut("execution(* *.hello(..))")
	public void helloMethodPoint() {

	}

	@Before("helloMethodPoint()")
	public void beforeTest() {
		System.out.println("before hello: " + info);
	}

	@After("helloMethodPoint()")
	public void afterTest() {
		System.out.println("after hello: " + info);
	}

	@Around("helloMethodPoint()")
	public Object aroundTest(ProceedingJoinPoint point) throws Exception {
		System.out.println("around hello: before: " + info);
		Object o = null;
		try {
			o = point.proceed();
		} catch (Throwable t) {
			throw new Exception("around", t);
		}
		System.out.println("around hello: after: " + info);
		return o;
	}
}
