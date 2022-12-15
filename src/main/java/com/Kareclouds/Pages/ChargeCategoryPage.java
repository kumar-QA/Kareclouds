package com.Kareclouds.Pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ChargeCategoryPage extends GenericPage{
	public Logger log;
	public String result;
	public WebDriver driver;
	public ChargeCategoryPage(WebDriver Driver,Logger log) {
		super(Driver);
		driver=Driver;
		this.log=log;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[@class=\"box-title titlefix\"]")
	WebElement PageTitle;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchEle;
	@FindBy(linkText="Add Charge Category")
	WebElement AddBtnForChargeCategory;
	
	//-----------------FormElements----------------------
	
	@FindBy(xpath="//form[@id='formadd']//input[@name='name']")
	WebElement Name;
	@FindBy(xpath="//form[@id='formadd']//textarea[@name='description']")
	WebElement Description;
	@FindBy(xpath="//form[@id='formadd']//select[@name='charge_type']")
	WebElement ChargeTypeDropDown;
	@FindBy(xpath="//form[@id='formadd']//button[@id='formaddbtn']")
	WebElement SaveBtn;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMsg;
	
	
	public String checkPageTitle() {
		return PageTitle.getText();
	}
	
	public String searchOperation(String field){
		searchEle.sendKeys(field);
		String data=driver.findElement(By.xpath("//td[contains(text(),'"+field+"')]")).getText();
		if(data.equalsIgnoreCase(field)) {
			System.out.print(data);
			result=data;
		}
		return result;
	}
	
	public void addchargecategoryFormDetails(String name,String des,String data) throws InterruptedException {
		AddBtnForChargeCategory.click();
		Name.sendKeys(name);
		Description.sendKeys(des);
		selectClass(ChargeTypeDropDown,data);
		SaveBtn.click();
//
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
//				.withTimeout(Duration.ofSeconds(30)) 			
//				.pollingEvery(Duration.ofSeconds(5)) 			
//				.ignoring(StaleElementReferenceException.class,NoSuchElementException.class);
//		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
//		
//			public WebElement apply(WebDriver driver ) {
//				return toastMsg;
//			}
//		});
//		System.out.println("Data"+element.getText());
		
	}
	
	

}
