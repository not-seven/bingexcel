package com.chinamobile.excel;

import com.bing.common.ExcleBuilder;
import com.bing.excel.annotation.CellConfig;
import com.bing.excel.annotation.OutAlias;
import com.bing.excel.converter.AbstractFieldConvertor;
import com.bing.excel.core.BingExcel;
import com.bing.excel.core.BingExcelBuilder;
import com.bing.excel.core.handler.ConverterHandler;
import com.bing.excel.core.impl.BingExcelImpl.SheetVo;
import com.bing.utils.StringParseUtil;
import com.google.common.base.MoreObjects;
import java.io.File;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author shizhongtao
 * 
 * date 2016-3-23 Description:
 */
public class ReadTest8 {

	@Test
	public void readExcelTest() throws URISyntaxException {
		// InputStream in = Person.class.getResourceAsStream("/person.xlsx");
		URL url = Salary.class.getResource("/salary7.xlsx");
		File f = new File(url.toURI());

		ExcleBuilder<BingExcel> bingExcelExcleBuilder = BingExcelBuilder.toBuilder();
		BingExcel bing = bingExcelExcleBuilder
				.addFieldConversionMapper(Salary.class,"name",2).registerFieldConverter(Date.class, new MyDateConverter()).build();
		try {
			//ReaderCondition<Salary> condition = new ReaderCondition<>(0, 1,
		//			Salary.class);
			SheetVo vo = bing.readFile(f, Salary.class,1);
			List objectList = vo.getObjectList();
			for (Object o : objectList) {
				System.out.println(o);
			}
		//	bing.writeExcel("/Users/shi/workspace/gaoxinqu/a.xlsx",objectList);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@OutAlias("hghg")
	public static class Salary {

		@CellConfig(index = 1)
		private String employNum;
		@CellConfig(index = 9)

		private Date workingTime;

		private String name;

		public String toString() {
			return MoreObjects.toStringHelper(this.getClass()).omitNullValues()
					.add("employNum", employNum)
					.add("workingTime", workingTime).add("name",name)
					.toString();
		}
	}
	public static class MyDateConverter extends AbstractFieldConvertor{

		@Override
		public boolean canConvert(Class<?> clz) {
			
			return Date.class.isAssignableFrom(clz);
		}

		@Override
		public Object fromString(String cell, ConverterHandler converterHandler,Type type) {
			if (StringUtils.isBlank(cell)) {
				return null;
			}
			try {
				return StringParseUtil.convertYMDT2Date(cell);
			} catch (ParseException e) {

				throw new RuntimeException(e);
			}
		}
		
	}
}
