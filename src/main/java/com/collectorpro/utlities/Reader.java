package com.collectorpro.utlities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Reader {
	HashMap<String, String> testNGValues = new LinkedHashMap<>();
	public static final String XLSX_FILE_PATH = "./TestData/Testdata.xls";
	@BeforeSuite
	@Parameters({"browser","browserVersion","OS","environment"})
	public void testNGValues(String browser, String browserVersion, String OS, String environment){
		
		try {
			testNGValues.put("browser", browser);
			testNGValues.put("browserVersion", browserVersion);
			testNGValues.put("OS", OS);
			testNGValues.put("environment", environment);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public HashMap<String, String> gettestNGValues(){
		return testNGValues;
	}
	
	public HashMap<String, String> testCaseValues(String methodName){
		
		HashMap<String, String> testCaseValues = new LinkedHashMap<>();
		try {
			testCaseValues.put("URL", "https://demo.broadleafcommerce.org");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return testCaseValues;
		
	}
}
