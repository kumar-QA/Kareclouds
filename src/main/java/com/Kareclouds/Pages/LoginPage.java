package com.Kareclouds.Pages;



import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends GenericPage {
	public WebDriver driver;
	public Logger log;
	public LoginPage(WebDriver Driver,Logger Log) {
		super(Driver);
		driver = Driver;
		this.log=Log;
		PageFactory.initElements(driver, this);
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
		log.info("going to enter url ");
		driver.get("http://kareclouds.com/site/login");
	}
	
	
	public DashboardPage loginWithValidCredentials(String email, String pwd) throws InterruptedException {
		log.info("loginWithValidCredentials function started ");
		UserName.sendKeys(email);
		Password.sendKeys(pwd);
		siginBtn.click();
		Thread.sleep(3000);
		log.info("Creating DashBoard  page object ");
		DashboardPage dashboard_page = new DashboardPage(driver,log);
		log.info("returning Dashboard page object");
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
		ForgotPage forgot_page=new ForgotPage(driver,log);
		return forgot_page;
	}

}
