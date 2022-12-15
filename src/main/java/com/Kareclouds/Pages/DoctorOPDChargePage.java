package com.Kareclouds.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorOPDChargePage extends GenericPage {
	public String result;
	public WebDriver driver;
	public Logger log;
	public DoctorOPDChargePage(WebDriver Driver,Logger log) {
		super(Driver);
		this.driver=Driver;
		this.log=log;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[@class=\"box-title titlefix\"]")
	WebElement PageTitle;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchEle;
	@FindBy(linkText="Add Charge")
	WebElement AddChargeBtn;
	@FindBy(xpath="//form[@id='formadd']//select[@name='doctor']")
	WebElement DoctorDropdown;
	@FindBy(xpath="//form[@id='formadd']//input[@name='standard_charge']")
	WebElement standcharges;
	@FindBy(xpath="//form[@id='formadd']//button[@type='button']")
	WebElement ApplyToAllBtn;
	@FindBy(xpath="//button[@id='formaddbtn']")
	WebElement savebtn;
	
	
	public String checkPageTitle() {
		return PageTitle.getText();
	}
	public String searchOperation(String field) {
		searchEle.sendKeys(field);
		String data=driver.findElement(By.xpath("//td[contains(text(),'"+field+"')]")).getText();
		if(data.equalsIgnoreCase(field)) {
			result=data;
		}
		return result;
	}
	
	public void AddChargeForm(String data,String Charges) {
		AddChargeBtn.click();
		selectClass(DoctorDropdown,data);
		standcharges.sendKeys("");
		ApplyToAllBtn.click();
		savebtn.click();
	}
	
	
}
