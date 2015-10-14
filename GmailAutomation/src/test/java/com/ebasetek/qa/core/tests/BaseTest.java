package com.ebasetek.qa.core.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ebasetek.qa.core.Browser;
import com.ebasetek.qa.core.DriverFactory;

public class BaseTest {
 protected WebDriver driver;
 
 @BeforeClass
 public void setUp(){
	 driver=DriverFactory.getDriver(Browser.FIREFOX.getValue());
	 driver.get("http://www.google.com");
	 
 }
 @AfterClass
 public void tearDown(){
	 driver.quit();
 }
}
