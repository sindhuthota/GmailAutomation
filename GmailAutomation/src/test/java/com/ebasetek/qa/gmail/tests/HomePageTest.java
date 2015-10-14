package com.ebasetek.qa.gmail.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebasetek.qa.core.tests.BaseTest;
import com.ebasetek.qa.gmail.pageobject.HomePage;

public class HomePageTest extends BaseTest{

	@Test
	public void verifyHomePage() {
		System.out.println("Home page test...");
		HomePage homepage = new HomePage(driver);
		Assert.assertTrue(homepage.verifyBasePageTitle(), "Home page title doesn't match");
	}

}
