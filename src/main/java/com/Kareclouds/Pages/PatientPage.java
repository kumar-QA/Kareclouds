package com.Kareclouds.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PatientPage extends GenericPage {

	public WebDriver driver;
	public String result;
	public String order;

	public PatientPage(WebDriver Driver) {
		super(Driver);
		driver = Driver;
		PageFactory.initElements(Driver, this);
	}
// ---------------------------FormElements--------------------------------------
	@FindBy(id = "name")
	WebElement Patient_name;
	@FindBy(css = "div[class='col-lg-6 col-md-6 col-sm-6'] input[name='guardian_name']")
	WebElement Patient_GuardianName;
	@FindBy(id = "addformgender")
	WebElement gender;
	@FindBy(id = "birth_date")
	WebElement DoB;
	@FindBy(xpath = "//div[@class='col-sm-3']/div[@class='form-group']/select[@name='blood_group']")
	WebElement BloodGroup;
	@FindBy(xpath = "//*[@id=\"formaddpa\"]/div[1]/div/div/div/div/div[4]/div/div[2]/div/select")
	WebElement Marital_Status;
	@FindBy(xpath = "//div[@class='dropify-wrapper']/input[@class='filestyle form-control']")
	WebElement patientPhoto;
	@FindBy(id = "number")
	WebElement phoneno;
	@FindBy(id = "addformemail")
	WebElement email;
	@FindBy(css = "div[class='col-lg-12 col-md-12 col-sm-12'] div[class='row'] input[name='address']")
	WebElement Address;
	@FindBy(xpath = "//textarea[@id='note']")
	WebElement Remark;
	@FindBy(xpath = "//div[@class='col-lg-12 col-md-12 col-sm-12']//div[@class='row']//textarea[@name='known_allergies']")
	WebElement Allergies;
	@FindBy(id = "formaddpabtn")
	WebElement saveBtn;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMsg;
	
//---------------Page Elements--------------------------------

	@FindBy(xpath="//h3[@class=\"box-title titlefix\"]")
	WebElement PageTitle;
	@FindBy(id = "addp")
	WebElement AddPatient;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchEle;
	@FindBy(xpath="//div[@class='box-tools pull-right']/a[contains(text(),'Disabled Patient List')]")
	WebElement DisablePatientLink;
	
//---------------Table Elements---------------------------
	
	@FindBy(css="th[aria-label='Patient Id: activate to sort column descending']")
	WebElement PatientIdBeforeClick;
	@FindBy(xpath="//th[@aria-label='Patient Id: activate to sort column ascending']")
	WebElement PatientIdAfterClick; 
	@FindBy(css="tbody tr:first-child td:first-child")
	WebElement PatientIdFirstCell;
	@FindBy(css="tbody tr:last-child td:first-child")
	WebElement PatientIdLastcell;
	
	@FindBy(css="th[aria-label='Patient Name: activate to sort column ascending']")
	WebElement PatientNameBeforeClick;
	@FindBy(xpath="//th[@aria-label='Patient Name: activate to sort column descending']")
	WebElement PatientNameAfterClick;	
	@FindBy(css="tbody tr:first-child td:nth-child(2) a:nth-child(1)")
	WebElement PatientNameFirstCell;
	@FindBy(css="tbody tr:last-child td:nth-child(2) a")
	WebElement PatientNameLastCell;
	
	@FindBy(css="th[aria-label='Age: activate to sort column ascending']")
	WebElement AgecolumnBeforeClick;
	@FindBy(xpath="//th[@aria-label='Age: activate to sort column descending']")
	WebElement AgecolumnAfterClick;	
	@FindBy(css="tbody tr:first-child td:nth-child(3)")
	WebElement AgecolumnFirstCell;
	@FindBy(css="tbody tr:last-child td:nth-child(3)")
	WebElement AgecolumnLastCell;
	
	@FindBy(css="th[aria-label='Gender: activate to sort column ascending']")
	WebElement GenderBeforeclick;
	@FindBy(xpath="//th[@aria-label='Gender: activate to sort column descending']")
	WebElement GenderAfterclick;
	@FindBy(css="tbody tr:first-child td:nth-child(4)")
	WebElement GenderFirstCell;
	@FindBy(css="tbody tr:first-child td:nth-child(4)")
	WebElement GenderAfterclickCell;
	
	@FindBy(css="th[aria-label='Phone: activate to sort column ascending']")
	WebElement PhoneNoBeforeClick;
	@FindBy(xpath="//th[@aria-label='Phone: activate to sort column descending']")
	WebElement PhoneNoAfterClick;
	@FindBy(css="tbody tr:first-child td:nth-child(5)")
	WebElement PhoneNoFirstCell;
	@FindBy(css="tbody tr:first-child td:nth-child(5)")
	WebElement PhoneNoAfterClickCell;
	
	@FindBy(css="th[aria-label='Guardian Name: activate to sort column ascending']")
	WebElement GuardianNameBeforeClick;
	@FindBy(xpath="//th[@aria-label='Guardian Name: activate to sort column descending']")
	WebElement GuardaianNameAfterClick;
	@FindBy(css="tbody tr:first-child td:nth-child(6)")
	WebElement GuardaianNameFirstCell;
	@FindBy(css="tbody tr:nth-child(2) td:nth-child(6)")
	WebElement GuardaianNameAfterClickCell;
	@FindBy(css="th[aria-label='Address: activate to sort column ascending']")
	WebElement AddressBeforeClick;
	@FindBy(css="th[aria-label='Address: activate to sort column descending']")
	WebElement AddressAfterClcik;
	@FindBy(css="tbody tr:first-child td:nth-child(7)")
	WebElement AddressFirstCell;
	@FindBy(css="tbody tr:nth-child(2) td:nth-child(7)")
	WebElement AddressAfterClickCell;
	@FindBy(xpath="//tbody/tr[1]/td[8]/a[1]")
	WebElement showBtn;
	@FindBy(xpath="//span[@id=\"patient_name\"]")
	WebElement pop_patientname;
	@FindBy(xpath="//i[@class=\"fa fa-ellipsis-v\"]")
	WebElement listBtn;
	@FindBy(xpath="//ul[@role='menu']/li/a[contains(text(),'OPD')]")
	WebElement OPDLink;
	@FindBy(xpath="//ul[@role='menu']/li/a[contains(text(),'Pharmacy')]")
	WebElement PharmacyLink;
	@FindBy(xpath="//ul[@role='menu']/li/a[contains(text(),'Operation Theatre')]")
	WebElement OperationTheatreLink;
	@FindBy(xpath="//h3[contains(text(),'Abhijeet Sharma')]")
	WebElement OPDPageFiled;
	@FindBy(xpath="//h3[contains(text(),' Pharmacy Bill')]")
	WebElement PharamacyPageTitle;
	@FindBy(xpath="//h3[contains(text(),'Operation Theatre Patient')]")
	WebElement OperationTheatreTitle; 
	
	
	
	
//--------------------------Actions-----------------------------	
	public String checkPageTitle() {
		return PageTitle.getText();
	}		
	public String enterFormDetails(String name, String guardianName, String Gender, String month, String day,String Bgroup, String ms, String filepath, String number, String Email, String address, String remark,String allergies) {
		AddPatient.click();
		waitForElementToAppear(Patient_name);
		Patient_name.sendKeys(name);
		waitForElementToAppear(Patient_GuardianName);
		Patient_GuardianName.sendKeys(guardianName);
//		Select sel = new Select(gender);
//		sel.selectByVisibleText(Gender);
		selectClass(gender,Gender);
		DoB.click();
		while (true) {
			String text1 = driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr/th[@class='datepicker-switch']")).getText();
			if (text1.equalsIgnoreCase(month)) {
				driver.findElement(By.xpath("//div[@class='datepicker-days']/table[@class='table table-condensed']/tbody/tr/td[contains(text(),"+ day + ")]")).click();
				break;
			} else {
				driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr/th[@class='prev']")).click();
			}
		}
		js_Click(BloodGroup);
		selectClass(BloodGroup,Bgroup);
//		Select bloodgroup = new Select(BloodGroup);
//		bloodgroup.selectByVisibleText(Bgroup);
		selectClass(Marital_Status,ms);
//		Select marital = new Select(Marital_Status);
//		marital.selectByVisibleText(ms);
		patientPhoto.sendKeys(filepath);
		phoneno.sendKeys(number);
		email.sendKeys(Email);
		Address.sendKeys(address); 
		Remark.sendKeys(remark);
		Allergies.sendKeys(allergies);
		saveBtn.click();
		return toastMsg.getText();
	}
	public String searchOperation(String field) {
		searchEle.sendKeys(field);
		String data=driver.findElement(By.xpath("//td[contains(text(),"+field+")]")).getText();
		if(data.equalsIgnoreCase(field)) {
			result=data;
//			checkActionColumn();
//			checklistBtnOPD();
//			driver.navigate().back();
//			checklistBtnPharamacy();
//			driver.navigate().back();
//			checklistBtnOT();
		}
		return result;
	}
	public DisabledPatientPage gotoDisabledPatientPage() {
		DisablePatientLink.click();
		DisabledPatientPage disabledPatient_pg=new DisabledPatientPage(driver);
		return disabledPatient_pg;
	}
	
	public String patientIdAscendingSorting(String value){
			PatientIdBeforeClick.click();
			if(PatientIdLastcell.getText().equalsIgnoreCase(value)) {
				PatientIdAfterClick.click();
				order="Ascending order";
				}
			return order;
		}
	
	public String checkTableColumnSorting(String Webelement,String value) {
		if(Webelement.equalsIgnoreCase("PatientId")){
			if(PatientIdFirstCell.getText().equalsIgnoreCase(value)) {
				System.out.println("Beforeclick");
				PatientIdBeforeClick.click();
				order="Descending order";
				}
		}else if(Webelement.equalsIgnoreCase("PatientName")) {
			if(PatientNameFirstCell.getText().equalsIgnoreCase(value)) {
				System.out.println("Beforeclick");
				PatientNameBeforeClick.click();
				order="Descending order";
				}
		}else if(Webelement.equalsIgnoreCase("Age")) {
			if(AgecolumnFirstCell.getText().equalsIgnoreCase(value)) {
				System.out.println("Beforeclick");
				AgecolumnBeforeClick.click();				
				order="Descending order";
				}
		}else if(Webelement.equalsIgnoreCase("gender")) {
			if(GenderFirstCell.getText().equalsIgnoreCase(value)) {
				System.out.println("Beforeclick");
				GenderBeforeclick.click();
				order="Descending order";				
				}
		}else if(Webelement.equalsIgnoreCase("phone")) {
			if(PhoneNoFirstCell.getText().equalsIgnoreCase(value)) {
				System.out.println("Beforeclick");
				PhoneNoBeforeClick.click();
				order="Descending order";
				}
		}else if(Webelement.equalsIgnoreCase("guardianName")) {
			if(GuardaianNameFirstCell.getText().equalsIgnoreCase(value)) {
				System.out.println("Beforeclick");
				GuardianNameBeforeClick.click();
				System.out.println("Afterclick");
				order="Descending order";
				}
		}else if(Webelement.equalsIgnoreCase("address")) {
			if(AddressFirstCell.getText().equalsIgnoreCase(value)) {
				AddressBeforeClick.click();
				order="Descending order";
				}
		}
		return order;
	}
	
	public String checkActionColumn() {
		showBtn.click();
		waitForElementToAppear(pop_patientname);
		return pop_patientname.getText();
	}
	
	public String checklistBtnOPD() {
		listBtn.click();
		OPDLink.click();
		return OPDPageFiled.getText();
	}
	public String checklistBtnPharamacy() {
		listBtn.click();
		PharmacyLink.click();
		return PharamacyPageTitle.getText();
		
	}
	public String checklistBtnOT() {
		listBtn.click();
		OperationTheatreLink.click();
		return OperationTheatreTitle.getText();
	}
	

}
