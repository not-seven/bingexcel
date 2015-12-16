package com.bing.excel.convertor;

import java.lang.reflect.Field;

import org.apache.poi.ss.usermodel.Cell;

/**  
 * 创建时间：2015-12-15下午2:12:56  
 * 项目名称：excel  
 * @author shizhongtao  
 * @version 1.0   
 * @since JDK 1.7
 * 文件名称：Convertor.java  
 * 类说明：  
 */
public interface Convertor {
	 // void marshal(Object source,   MarshallingContext context);
	  Object unmarshal(Cell cell, Class<?> clazz);
}