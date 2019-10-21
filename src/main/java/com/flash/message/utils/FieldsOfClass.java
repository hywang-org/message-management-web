package com.flash.message.utils;

import java.lang.reflect.Field;

public class FieldsOfClass {

	public static <T> Field[] refrect(T obj) {
		Class cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);//设置属性可读
		}
		return fields;
	}
}
