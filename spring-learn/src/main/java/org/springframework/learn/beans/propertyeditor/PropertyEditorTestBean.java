package org.springframework.learn.beans.propertyeditor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author : wangjingwang
 * @Date : 2020/8/10 22:38
 * @Description :
 */
public class PropertyEditorTestBean {
	private Date dateValue;

	private BigDecimal bigDecimalValue;

	private String[] stringArrayValue;

	public PropertyEditorTestBean() {
		System.out.println("PropertyEditorTestBean constructor");
	}

	public Date getDateValue() {
		return dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	public BigDecimal getBigDecimalValue() {
		return bigDecimalValue;
	}

	public void setBigDecimalValue(BigDecimal bigDecimalValue) {
		this.bigDecimalValue = bigDecimalValue;
	}

	public String[] getStringArrayValue() {
		return stringArrayValue;
	}

	public void setStringArrayValue(String[] stringArrayValue) {
		this.stringArrayValue = stringArrayValue;
	}
}
