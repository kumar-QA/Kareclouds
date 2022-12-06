package com.Kareclouds.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GenericPage {
	public WebDriver driver;

	public LoginPage(WebDriver Driver) {
		super(Driver);
		driver = Driver;
		PageFactory.initElements(Driver, this);
	}

	@FindBy(id = "email")
	WebElement UserName;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(xpath = "//button[@type='submit' and @class='btn']")
	WebElement siginBtn;
	@FindBy(className = "forgot")
	WebElement forgotBtn;
	@FindBy(css = ".alert-danger")
	WebElement errorMsg;
	@FindBy(xpath = "//span/p[contains(text(),'The Username field is required')]")
	WebElement userNameErrorMsg;
	@FindBy(xpath = "//span/p[contains(text(),'The Password field is required')]")
	WebElement PasswordeErrorMsg;

	public void gotoUrl() {
		driver.get("http://kareclouds.com/site/login");
	}
	
	
	public DashboardPage loginWithValidCredentials(String email, String pwd) throws InterruptedException {
		UserName.sendKeys(email);
		Password.sendKeys(pwd);
		siginBtn.click();
		Thread.sleep(3000);
		DashboardPage dashboard_page = new DashboardPage(driver);
		return dashboard_page;
	}

	public String loginWithoutUserName(String pwd) {
		Password.sendKeys(pwd);
		siginBtn.click();
		return userNameErrorMsg.getText();
	}

	public String loginWithoutPassword(String email) {
		UserName.sendKeys(email);
		siginBtn.click();
		return PasswordeErrorMsg.getText();
	}

	public String loginWithInavalidCredentials(String email, String pwd) {
		UserName.sendKeys(email);
		Password.sendKeys(pwd);
		siginBtn.click();
		return errorMsg.getText();
	}

	public ForgotPage clickOnForgotBtn() {
		forgotBtn.click();
		ForgotPage forgot_page=new ForgotPage(driver);
		return forgot_page;
	}

}
