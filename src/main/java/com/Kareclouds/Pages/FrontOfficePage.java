package com.Kareclouds.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontOfficePage extends GenericPage{

	public Logger log;
	
	public FrontOfficePage(WebDriver Driver,Logger log) {
		super(Driver);
		driver = Driver;
		this.log=log;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[@class='box-title titlefix']")
	WebElement  pageTitle;
	
	@FindBy(linkText="Complain Type")
	WebElement ComplainTypeLink;
	@FindBy(linkText="Source")
	WebElement SourceLink;
	@FindBy(linkText="Appointment Priority")
	WebElement AppointmentPriorityLink;
	
	public String checkPageTitle() {
		return pageTitle.getText();
	}

	
	public ComplainTypePage checkComplainTypeLink() {
		ComplainTypeLink.click();
		ComplainTypePage complaintype_page=new ComplainTypePage(driver);
		return complaintype_page;
	}
	
	public SourcePage checkSourceLink() {
		SourceLink.click();
		SourcePage sources=new SourcePage(driver);
		return sources;
	}
	
	public AppointmentPriorityPage checkAppointmentPriorityLink() {
		AppointmentPriorityLink.click();
		AppointmentPriorityPage appointmentpage=new AppointmentPriorityPage(driver);
		return appointmentpage;
	}
}
