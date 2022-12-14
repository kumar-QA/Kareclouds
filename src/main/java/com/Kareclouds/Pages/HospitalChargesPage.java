package com.Kareclouds.Pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HospitalChargesPage extends GenericPage {
	public Logger log;
	public WebDriver driver;
	public HospitalChargesPage(WebDriver Driver,Logger Log) {
		super(Driver);
		this.log=Log;
		this.driver=Driver;
		PageFactory.initElements(driver, this);
	}
//--------------------------Page Elements-----------------------------------------------	

	@FindBy(xpath = "//h3[@class='box-title titlefix']")
	WebElement PageTitle;
	@FindBy(xpath = "//div[@id='DataTables_Table_0_filter']/label/input")
	WebElement searchinput;
	@FindBy(xpath = "//div[@class='box-tools pull-right']/a")
	WebElement AddchargeBtn;
	@FindBy(linkText="Charge Category")
	WebElement chargecategorylink;
	@FindBy(linkText="Doctor OPD Charge")
	WebElement doctorOPDchargeLink;
	@FindBy(linkText="Charge Type")
	WebElement chargetypeLink;


//---------------------------AddChargeType Form Elements--------------------------------------------
	@FindBy(xpath = "//form[@id='formadd']/div[@class='row']//div[@class='form-group']/select[@name='charge_type']")
	WebElement ChargeType;
	@FindBy(xpath = "//select[@id='charge_category']")
	WebElement ChargeCategory;
	@FindBy(xpath = "//form[@id='formadd']/div[@class='row']//div[@class='form-group']/input[@name='code']")
	WebElement Code;
	@FindBy(xpath = "//input[@id='standard_charge']")
	WebElement standardcharges;
	@FindBy(xpath = "//button[@class='plusign']")
	WebElement ApplyToAll;
	@FindBy(xpath = "//form[@id='formadd']/div[@class='row']//div[@class='form-group']//textarea[@name='description']")
	WebElement Description;
	@FindBy(xpath = "//button[@id='formaddbtn']")
	WebElement SaveBtn;
	@FindBy(xpath = "//div[@id='toast-container']//div[@class=\"toast-message\"]/p[contains(text(),'The Charge Category field')]")
	WebElement ChargeCategoryErrorMsg;

//---------------------------------------------------- Table Form Elements-----------------------------------
	@FindBy(xpath = "//table[@id='DataTables_Table_0']/thead/tr/th")
	List<WebElement> tabelHeaderKeys;

	@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody/tr/td")
	List<WebElement> tableDataValues;

	@FindBy(xpath = "//table[@id='DataTables_Table_0']/tbody/tr")
	List<WebElement> NoOfRecords;

	public String checkPageTitle() {
		return PageTitle.getText();
	}

	public String addChargeFormDetailsWithError(String chargetype, String code, String stcharges, String des) {
		AddchargeBtn.click();
		selectClass(ChargeType, chargetype);
		Code.sendKeys(code);
		standardcharges.sendKeys(stcharges);
		Description.sendKeys(des);
		ApplyToAll.click();
		SaveBtn.click();
		return ChargeCategoryErrorMsg.getText();
	}

	boolean flag;
	public boolean checkTabelDataWithSearch(String data) {
		searchinput.sendKeys(data);
	int row=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr")).size();
	System.out.println(row);
		List<WebElement> chargecategory=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]"));
		//List<WebElement> changeType=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]"));
		//List<WebElement> Code=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[3]"));
		List<WebElement> standarCharges=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[4]"));
			for(int i=0;i<row;i++) {
					for(WebElement ele:chargecategory) {
						if(ele.getText().equalsIgnoreCase("Blood pressure check")) {
							for(WebElement ele1:standarCharges) {
								if(ele1.getText().equalsIgnoreCase(data)) {
									System.out.println(ele.getText());
									System.out.println("ele1:"+ele1.getText());
									flag=true;
								}
							}
						}
					}
								
				}
		return flag;
	}
	
	public ChargeCategoryPage checkingChargeCategoryLink() {
		chargecategorylink.click();
		ChargeCategoryPage chargecategory=new ChargeCategoryPage(driver,log);
		return chargecategory;
	}
	public DoctorOPDChargePage checkingDoctorOPDChargeLink() {
		doctorOPDchargeLink.click();
		DoctorOPDChargePage doctoropd=new DoctorOPDChargePage(driver,log);
		return doctoropd;
		}
	public ChargeTypePage checkingChargeTypeLink() {
		chargetypeLink.click();
		ChargeTypePage chargeType=new ChargeTypePage(driver,log);
		return chargeType;
	}

}
