package com.in.Uid.utlity;

import java.io.FileInputStream;
import java.util.Properties;

public class DBUtility {
	private static Properties p;
	static {
		try {

			p = new Properties();
			// p.getClass().getResourceAsStream("");
			FileInputStream f = new FileInputStream(
					"D:\\eclipse-workspace\\servlet-jsp\\jspPrpject/src/com/p.properties");
			p.load(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return p.getProperty(key);
	}
}
