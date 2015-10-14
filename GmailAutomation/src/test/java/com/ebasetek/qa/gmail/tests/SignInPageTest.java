package com.ebasetek.qa.gmail.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebasetek.qa.core.tests.BaseTest;
import com.ebasetek.qa.gmail.pageobject.HomePage;
import com.ebasetek.qa.gmail.pageobject.SignInPage;

public class SignInPageTest extends BaseTest{

	
	private SignInPage signInPage;
	private HomePage basePage;
			
		@Test
		public void verifySignInFunction() {
			System.out.println("Sign In functionality details...");
			basePage = new HomePage(driver);
			signInPage = basePage.clickSignInBtn();
			Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
			Assert.assertTrue(signInPage.verifySignInPageText(), "Page text not matching");
			Assert.assertTrue(signInPage.verifySignIn(), "Unable to sign in");

		}

}
