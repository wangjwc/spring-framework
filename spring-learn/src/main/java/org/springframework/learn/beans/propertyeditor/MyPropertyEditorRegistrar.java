package org.springframework.learn.beans.propertyeditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.learn.beans.propertyeditor.custom.PropertyEditorForBigDecimal;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * PropertyEditorRegistrar用于支持将字符串格式的属性值转换为bean中对应的属性类型
 * 比如class类型、date类型等
 * @author wangjingwang
 * @version v1.0
 */
public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar {
	private String format = "yyyy-MM-dd";

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		/*
		// spring内置日期类型编辑器
		registry.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat(format), true));*/

		// spring内置字符串数组编辑器
		registry.registerCustomEditor(String[].class, new StringArrayPropertyEditor());


		// 自定义的BigDecimal编辑器
		registry.registerCustomEditor(BigDecimal.class, new PropertyEditorForBigDecimal());


	}
}
