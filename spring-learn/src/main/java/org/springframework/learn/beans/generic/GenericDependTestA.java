package org.springframework.learn.beans.generic;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class GenericDependTestA extends GenericBase<GenericDependTestB> {
	private String info = "default";

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
