package com.Kareclouds.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisabledPatientPage extends GenericPage{

	public DisabledPatientPage(WebDriver Driver) {
		super(Driver);
		PageFactory.initElements(Driver, this);
	}

	@FindBy(xpath="//h3[@class=\"box-title titlefix\"]")
	WebElement PageTitle;
	
	public String checkPageTitle() {
		return PageTitle.getText();
	}
}
