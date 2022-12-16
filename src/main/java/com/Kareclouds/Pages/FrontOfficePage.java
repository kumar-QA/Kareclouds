package com.Kareclouds.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
	@FindBy(xpath = "//div[@id='DataTables_Table_0_filter']/label/input")
	WebElement searchinput;
	
	
	
	
	
	public String checkPageTitle() {
		return pageTitle.getText();
	}

	String result;
	public String searchOperation(String field){
		searchinput.sendKeys(field);
		String data=driver.findElement(By.xpath("(//table[@id='DataTables_Table_0']/tbody/tr/td)[1]")).getText();
		if(data.equalsIgnoreCase(field)) {
			System.out.print(data);
			result=data;
		}
		return result;
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
