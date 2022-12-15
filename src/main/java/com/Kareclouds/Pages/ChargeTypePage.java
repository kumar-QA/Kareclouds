package com.Kareclouds.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChargeTypePage extends GenericPage {
	public String result;
	public WebDriver driver;
	public Logger log;
	public ChargeTypePage(WebDriver Driver,Logger log) {
		super(Driver);
		this.log=log;
		this.driver=Driver;
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[@class=\"box-title titlefix\"]")
	WebElement PageTitle;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchEle;
	
	@FindBy(linkText="Add Charge Type")
	WebElement AddChargeTypeBtn;
	
	@FindBy(xpath="//form[@id='formadd']//input[@name='charge_type']")
	WebElement charge_type;
	
	@FindBy(xpath="//button[@id='formaddbtn']")
	WebElement savebtn;
	

	
	public String checkPageTitle() {
		return PageTitle.getText();
	}
	
	public String searchOperation(String field) {
		searchEle.sendKeys(field);
		String data=driver.findElement(By.xpath("//td[contains(text(),"+field+")]")).getText();
		if(data.equalsIgnoreCase(field)) {
			result=data;
		}
		return result;
	}
	
	public void AddChargeTypeForm(String Charges) {
		AddChargeTypeBtn.click();
		charge_type.sendKeys(Charges);
		savebtn.click();
	}
	
}
