package org.springframework.learn.beans;

/**
 *
 * 用于测试桥接方法处理
 * @author wangjingwang
 * @version v1.0
 */
public abstract class GenericityTestParent<T> {
	public abstract T getGenericity();
}
