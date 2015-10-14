package com.ebasetek.qa.core;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	private static final String DRIVER_PROPS = "driver.properties";
	private static final String BROWSER_KEY = "browser.key";

	private static Properties properties = null;

	private static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
	private static final String CHROME_DRIVER_PATH = "C:\\selenium\\Downloads\\chromedriver.exe";
	private static final String CHROME_DRIVER_REL_PATH = "chromedriver.exe";
	private static final String IE_DRIVER_KEY = "webdriver.ie.driver";
	private static final String IE_DRIVER_PATH = "C:\\selenium\\Downloads\\IEDriverServer.exe";
	private static final String IE_DRIVER_REL_PATH = "IEDriverServer.exe";

	static {
		if (properties == null) {
			properties = new Properties();
			InputStream in = null;
			try {
				in = DriverFactory.class.getResourceAsStream(DRIVER_PROPS);
				try {
					properties.load(in);
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			} catch (IOException ie) {
				ie.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}

			}

		}

	}

	public static WebDriver getDriver() {
		String browsername = properties.getProperty(BROWSER_KEY);
		System.out.println(browsername);
		return getDriver(browsername);
	}

	public synchronized static WebDriver getDriver(String browser) {
		WebDriver driver = null;
		if (browser == null || browser.length() == 0) {
			throw new IllegalArgumentException("provide valid browser name " + browser);
		}
		if (Browser.CHROME.getValue().equals(browser)) {

			System.setProperty(CHROME_DRIVER_KEY, CHROME_DRIVER_REL_PATH);
		//	driver = new ChromeDriver();
			driver.get("http://www.google.com");
			driver.close();
		} else if (Browser.IE.getValue().equals(browser)) {
			System.setProperty(IE_DRIVER_KEY, IE_DRIVER_REL_PATH);
		//	driver = new InternetExplorerDriver();
			driver.get("http://www.expedia.com");
		} else if (Browser.FIREFOX.getValue().equals(browser)) {
			driver = new FirefoxDriver();
			driver.get("http://www.salesforce.com");
		} else {
			throw new IllegalArgumentException("no driver for this browser" + browser);

		}

		return driver;
	}

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getDriver();

		System.out.println(driver);

		System.out.println();
	}
}
