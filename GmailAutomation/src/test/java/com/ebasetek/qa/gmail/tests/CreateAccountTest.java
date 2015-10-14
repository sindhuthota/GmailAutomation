package com.ebasetek.qa.gmail.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebasetek.qa.core.tests.BaseTest;
import com.ebasetek.qa.gmail.pageobject.CreateAccountPage;
import com.ebasetek.qa.gmail.pageobject.HomePage;
import com.ebasetek.qa.gmail.pageobject.SignInPage;

public class CreateAccountTest extends BaseTest{
	
	private SignInPage signInPage;
	private HomePage basePage;
	private CreateAccountPage createAccountPage;
				
		@Test
		public void verifyCreateAnAccounPage() {
			System.out.println("Create An Account page test...");
			basePage = new HomePage(driver);
			signInPage = basePage.clickSignInBtn();
			createAccountPage = signInPage.clickonCreateAnAccount();
			Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
			Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
		}
		
		public void verifySignInFunction() {
			
		}
}
