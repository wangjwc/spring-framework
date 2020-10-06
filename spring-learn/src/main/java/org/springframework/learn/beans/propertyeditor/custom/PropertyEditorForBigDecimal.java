package org.springframework.learn.beans.propertyeditor.custom;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class PropertyEditorForBigDecimal extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			super.setValue(new BigDecimal(text));
		} catch (Exception e) {
			throw new IllegalArgumentException("illegal BigDecimal string: [" + text + "]", e);
		}
	}
}
