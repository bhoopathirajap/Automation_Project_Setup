package com.collectorpro.utlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Setup {

	public WebDriver launchBrowser(String browser, String browserVersion, String OS, String environment) {
		WebDriver driver = null;
		DesiredCapabilities capabilities = null;
		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
			if (environment.equals("local")) {
				switch (browser) {
				case "chrome":
					capabilities = DesiredCapabilities.chrome();
					break;
				case "firefox":
					capabilities = DesiredCapabilities.firefox();
					break;
				case "ie":
					capabilities = DesiredCapabilities.internetExplorer();
					break;
				default:
					break;
				}

				capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
				capabilities.setCapability(CapabilityType.PLATFORM_NAME, OS);
				driver = new RemoteWebDriver(capabilities);
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return driver;
	}

	public void launchURL(WebDriver driver, String URL) {
		try {
			driver.get(URL);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
