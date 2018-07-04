package com.collectorpro.test;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.collectorpro.utlities.Reader;
import com.collectorpro.utlities.Setup;

public class TC01_Login extends Reader {
	WebDriver driver;
	
	@Test
	public void loginTest() {

		try {
			// values from testng.xml file
			HashMap<String, String> testNGValues = gettestNGValues();
			// values from test data
			String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			HashMap<String, String> testCaseValues = testCaseValues(methodName);
			
			Setup setup = new Setup();
			
			driver = setup.launchBrowser(testNGValues.get("browser"), testNGValues.get("browserVersion"),
					testNGValues.get("OS"), testNGValues.get("environment"));
			
			setup.launchURL(driver, testCaseValues.get("URL"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		
	}

}
