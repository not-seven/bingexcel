package com.bing.excel.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.ArrayUtils;

import com.bing.excel.convertor.Convertor;

/**
 * 创建时间：2015-12-14下午2:11:27 项目名称：excel
 * 
 * @author shizhongtao
 * @version 1.0
 * @since JDK 1.7 文件名称：BingConvertor.java 类说明：
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BingConvertor {
	Class<? extends Convertor> value();

	Class<?>[] types() default {};

	String[] strings() default {};

	byte[] bytes() default {};

	char[] chars() default {};

	short[] shorts() default {};

	int[] ints() default {};

	long[] longs() default {};

	float[] floats() default {};

	double[] doubles() default {};

	boolean[] booleans() default {};
}
