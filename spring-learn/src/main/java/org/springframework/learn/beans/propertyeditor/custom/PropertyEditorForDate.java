package org.springframework.learn.beans.propertyeditor.custom;

import groovy.transform.WithReadLock;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author wangjingwang
 * @version v1.0
 */
public class PropertyEditorForDate extends PropertyEditorSupport {
	private String format = "yyyy-MM-dd";

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			super.setValue(df.parse(text));
		} catch (ParseException e) {
			throw new IllegalArgumentException("illegal date string: [" + text + "]", e);
		}
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
