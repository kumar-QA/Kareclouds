package com.Kareclouds.Pages;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends GenericPage{

	public WebDriver driver;
	public Logger log;
	public DashboardPage(WebDriver Driver,Logger Log) {
		super(Driver);
		driver=Driver;
		this.log=Log;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="logo-lg")
	WebElement logo;
	
	@FindBy(xpath="//span[contains(text(),'Setup')]")
	WebElement SetupLink;
	
	@FindBy(xpath="//a[@href='http://kareclouds.com/admin/admin/search']")
	WebElement PatientLink;
	
	@FindBy(xpath="//a[contains(text(),'Hospital Charges')]")
	WebElement HospitalChargesLink;
	
	@FindBy(xpath="//a[@href=\"http://kareclouds.com/admin/setup/bed/status\"]")
	WebElement bedlink;
	
	@FindBy(xpath="//a[@href=\"http://kareclouds.com/admin/visitorspurpose\"]")
	WebElement frontofficelink;
	
	
	public boolean logCheck() {
		return logo.isDisplayed();
	}

	public PatientPage selectPatientLink() {
		ActionFunction(SetupLink,PatientLink);
		PatientPage patient_page=new PatientPage(driver,log);
		return patient_page;
	}
	public HospitalChargesPage selectHospitaltLink() {
		ActionFunction(SetupLink,HospitalChargesLink);
		HospitalChargesPage hospital_page=new HospitalChargesPage(driver,log);
		return hospital_page;
	}
	
	public MainBedPage selectBedLink() {
		ActionFunction(SetupLink,bedlink);
		MainBedPage main_bedpage=new MainBedPage(driver,log);
		return main_bedpage;
	}
	
	public FrontOfficePage selectFrontOfficeLink() {
		ActionFunction(SetupLink,frontofficelink);
		FrontOfficePage front_officepage=new FrontOfficePage(driver,log);
		return front_officepage;
	}
	
}
