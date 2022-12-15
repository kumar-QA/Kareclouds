package com.Kareclouds.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComplainTypePage extends GenericPage{
	public WebDriver driver;
	public ComplainTypePage(WebDriver Driver) {
		super(Driver);
		this.driver = Driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//h3[@class=\"box-title titlefix\"]")
	WebElement PageTitle;
	
	public String checkPageTitle() {
		return PageTitle.getText();
	}
}
