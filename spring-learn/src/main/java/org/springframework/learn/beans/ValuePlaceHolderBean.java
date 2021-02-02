package org.springframework.learn.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class ValuePlaceHolderBean {
	@Value("${sample.testStr}")
	private String value;

	@Value("GET_sample.testStr")
	private String value2;

	@Value("${sample.beanExpression}")
	private Object expressionToBean;

	public String getValue() {
		return value;
	}

	public String getValue2() {
		return value2;
	}

	public Object getExpressionToBean() {
		return expressionToBean;
	}
}
