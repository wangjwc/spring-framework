package org.springframework.learn.beans.generic;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class GenericBase<T> {
	private T genericField;

	public T getGenericField() {
		return genericField;
	}

	public void setGenericField(T genericField) {
		this.genericField = genericField;
	}
}
