package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.ForgotPage;

public class ForgotPasswordTest extends BaseTest{

	
	@Test()
	public void verifyErrorValidatiOnEmptyEmail() {
		ForgotPage forgot_page=login_page.clickOnForgotBtn();
		String result=forgot_page.errorValidationWithoutEntryEmail();
		Assert.assertEquals(result,"The Email field is required.");
	}
	
	@Test()
	public void verifyErrorValidatiOnInvalidEmail() {
		ForgotPage forgot_page=login_page.clickOnForgotBtn();
		String result=forgot_page.errorValidationWithInavalidEmail("xyz@gmail.com");
		Assert.assertEquals(result,"Invalid Email ");
	}
	
	
	
}
