package com.Kareclouds.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends GenericPage{

	public WebDriver driver;
	
	public DashboardPage(WebDriver Driver) {
		super(Driver);
		driver=Driver;
		PageFactory.initElements(Driver, this);
	}
	
	@FindBy(className="logo-lg")
	WebElement log;
	
	@FindBy(xpath="//span[contains(text(),'Setup')]")
	WebElement SetupLink;
	
	@FindBy(xpath="//a[@href='http://kareclouds.com/admin/admin/search']")
	WebElement PatientLink;
	
	@FindBy(xpath="//a[contains(text(),'Hospital Charges')]")
	WebElement HospitalChargesLink;
	
	
	
	public boolean logCheck() {
		return log.isDisplayed();
	}

	public PatientPage selectPatientLink() {
//		Actions act=new Actions(driver);
//		act.moveToElement(SetupLink).click().build().perform();
//		act.moveToElement(PatientLink).click().build().perform();
		ActionFunction(SetupLink,PatientLink);
		PatientPage patient_page=new PatientPage(driver);
		return patient_page;
	}
	
	public HospitalChargesPage selectHospitaltLink() {
		ActionFunction(SetupLink,HospitalChargesLink);
		HospitalChargesPage hospital_page=new HospitalChargesPage(driver);
		return hospital_page;
	}
	
}
