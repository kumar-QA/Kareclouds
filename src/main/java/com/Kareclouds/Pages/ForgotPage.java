package com.Kareclouds.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPage extends GenericPage {
	public Logger log;
	public WebDriver driver;
	public ForgotPage(WebDriver Driver,Logger log) {
		super(Driver);
		this.log=log;
		driver=Driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "form-username")
	WebElement Email;
	@FindBy(className = "btn")
	WebElement SubmitBtn;
	@FindBy(xpath = "//span/p[contains(text(),'The Email')]")
	WebElement emailErrorMsg;
	@FindBy(css=".alert-danger")
	WebElement invalidEmailMsg;
	@FindBy(css=".font-white")
	WebElement PageName;
	
	
	
	public void errorValidationWithoutEntryEmail() {
		SubmitBtn.click();
	}
	public String errorValidationWithInavalidEmail(String email) {
		Email.sendKeys(email);
		SubmitBtn.click();
		return invalidEmailMsg.getText();
	}
	public String pageValidation() {
		return PageName.getText();
	}

}
