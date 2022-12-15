package com.Kareclouds.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisabledPatientPage extends GenericPage{
	public WebDriver driver;
	public Logger log;
	public DisabledPatientPage(WebDriver Driver,Logger log) {
		super(Driver);
		this.driver=Driver;
		this.log=log;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[@class=\"box-title titlefix\"]")
	WebElement PageTitle;
	
	public String checkPageTitle() {
		return PageTitle.getText();
	}
}
