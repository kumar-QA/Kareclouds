package com.Kareclouds.Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.tools.sjavac.Log;

public class PatientPage extends GenericPage {

	public WebDriver driver;
	public String result;
	public String order;
	public Logger log;
	List<String> patient=new ArrayList<String>();
	List<WebElement> TotalIds;
	boolean flag;
	String firstCell;
	String LastCell;
	int totalpages;
	List<List<String>> data;

	public PatientPage(WebDriver Driver,Logger Log) {
		super(Driver);
		driver = Driver;
		this.log=Log;
		PageFactory.initElements(driver, this);
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
	
	@FindBy(xpath="//a[@class='paginate_button next']")
	WebElement nextBtn;
	
//---------------Table Elements---------------------------

	//---------------Patient id-----------------
	
	@FindBy(css="th[aria-label='Patient Id: activate to sort column descending']")
	WebElement PatientIdBeforeClick;
	@FindBy(xpath="//th[@aria-label='Patient Id: activate to sort column ascending']")
	WebElement PatientIdAfterClick; 
	@FindBy(css="tbody tr:first-child td:first-child")
	WebElement PatientIdFirstCell;
	@FindBy(css="tbody tr:last-child td:first-child")
	WebElement PatientIdLastcell;
	//test
	@FindBy(xpath="//table[@id='DataTables_Table_0']/tbody/tr/td[1")
	List<WebElement> patientIdTotalCol;
	
	//-----------------patientName------------------
	@FindBy(css="th[aria-label='Patient Name: activate to sort column ascending']")
	WebElement PatientNameBeforeClick;
	@FindBy(xpath="//th[@aria-label='Patient Name: activate to sort column descending']")
	WebElement PatientNameAfterClick;	
	@FindBy(css="tbody tr:first-child td:nth-child(2) a:nth-child(1)")
	WebElement PatientNameFirstCell;
	@FindBy(css="tbody tr:last-child td:nth-child(2) a")
	WebElement PatientNameLastCell;
	//------------Age--------------------
	@FindBy(css="th[aria-label='Age: activate to sort column ascending']")
	WebElement AgecolumnBeforeClick;
	@FindBy(xpath="//th[@aria-label='Age: activate to sort column descending']")
	WebElement AgecolumnAfterClick;	
	@FindBy(css="tbody tr:first-child td:nth-child(3)")
	WebElement AgecolumnFirstCell;
	@FindBy(css="tbody tr:last-child td:nth-child(3)")
	WebElement AgecolumnLastCell;
	//--------Gender--------------
	@FindBy(css="th[aria-label='Gender: activate to sort column ascending']")
	WebElement GenderBeforeclick;
	@FindBy(xpath="//th[@aria-label='Gender: activate to sort column descending']")
	WebElement GenderAfterclick;
	@FindBy(css="tbody tr:first-child td:nth-child(4)")
	WebElement GenderFirstCell;
	@FindBy(css="tbody tr:first-child td:nth-child(4)")
	WebElement GenderAfterclickCell;
	//----------------PhoneNo-----
	@FindBy(css="th[aria-label='Phone: activate to sort column ascending']")
	WebElement PhoneNoBeforeClick;
	@FindBy(xpath="//th[@aria-label='Phone: activate to sort column descending']")
	WebElement PhoneNoAfterClick;
	@FindBy(css="tbody tr:first-child td:nth-child(5)")
	WebElement PhoneNoFirstCell;
	@FindBy(css="tbody tr:first-child td:nth-child(5)")
	WebElement PhoneNoAfterClickCell;
	
	//---------Guardian name--------------
	@FindBy(css="th[aria-label='Guardian Name: activate to sort column ascending']")
	WebElement GuardianNameBeforeClick;
	@FindBy(xpath="//th[@aria-label='Guardian Name: activate to sort column descending']")
	WebElement GuardaianNameAfterClick;
	@FindBy(css="tbody tr:first-child td:nth-child(6)")
	WebElement GuardaianNameFirstCell;
	@FindBy(css="tbody tr:nth-child(2) td:nth-child(6)")
	WebElement GuardaianNameAfterClickCell;
	//--------Address---------
	@FindBy(css="th[aria-label='Address: activate to sort column ascending']")
	WebElement AddressBeforeClick;
	@FindBy(css="th[aria-label='Address: activate to sort column descending']")
	WebElement AddressAfterClcik;
	@FindBy(css="tbody tr:first-child td:nth-child(7)")
	WebElement AddressFirstCell;
	@FindBy(css="tbody tr:nth-child(2) td:nth-child(7)")
	WebElement AddressAfterClickCell;
	
	//--------------Actions --details buton---------------
	
	@FindBy(xpath="//tbody/tr/td[8]/a[1]")
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
		}
		return result;
	}
	
	public DisabledPatientPage gotoDisabledPatientPage() {
		DisablePatientLink.click();
		DisabledPatientPage disabledPatient_pg=new DisabledPatientPage(driver,log);
		return disabledPatient_pg;
	}
	
	public boolean checkActionColumn(String id,String name) throws InterruptedException {	
		searchEle.sendKeys(id);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//tbody/tr/td[8]/a[1]")).click();
		waitForElementToAppear(pop_patientname);
		String firstcell= pop_patientname.getText();
		if(firstcell.equalsIgnoreCase(name)) {
			 flag=true;
			}
		return flag;

	}
	public void checklistBtnFunctionality() {
		
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
	
	

	public List<List<String>> sortingEachColumn(String ColumnName,int ColumnNumber) throws InterruptedException {
		if(ColumnName.equalsIgnoreCase("patientId")) {
			addingDataToList(ColumnNumber);
			Collections.reverse(patient);
			AfterSorting();
			PatientIdBeforeClick.click();
			data=addingSortedDataToList(ColumnNumber);	
		}else if(ColumnName.equalsIgnoreCase("patientname")){
			addingDataToList(ColumnNumber);
			  Collections.sort(patient, new Comparator<String>() {
				    @Override
				    public int compare(String s1, String s2) {
				        return s1.compareToIgnoreCase(s2);
				    }
				});
			AfterSorting();
			PatientNameBeforeClick.click();
			data=addingSortedDataToList(ColumnNumber);	
		}else if(ColumnName.equalsIgnoreCase("age")){
			addingDataToList(ColumnNumber);
			ArrayList<String> al=new ArrayList<String>();
			for(String d:patient) {
		  		al.add(d.split("Y")[0]);
//		  		String[] s=d.split("Y");
//		  		al.add(s[0]);
		  	}
		   Collections.sort(al);
		   for(String d:al) {
			   System.out.println("data:"+d);
		  	}
			Collections.sort(patient);
			AfterSorting();
			AgecolumnBeforeClick.click();
			data=addingSortedDataToList(ColumnNumber);	
		}else if(ColumnName.equalsIgnoreCase("gender")){
			addingDataToList(ColumnNumber);
			  Collections.sort(patient, new Comparator<String>() {
				    @Override
				    public int compare(String s1, String s2) {
				        return s1.compareToIgnoreCase(s2);
				    }
				});
			AfterSorting();
			GenderBeforeclick.click();
			data=addingSortedDataToList(ColumnNumber);	
		}else if(ColumnName.equalsIgnoreCase("phone")) {
			addingDataToList(ColumnNumber);
			  Collections.sort(patient, new Comparator<String>() {
				    @Override
				    public int compare(String s1, String s2) {
				        return s1.compareToIgnoreCase(s2);
				    }
				});
			AfterSorting();
			PhoneNoBeforeClick.click();
			data=addingSortedDataToList(ColumnNumber);	
		}else if(ColumnName.equalsIgnoreCase("GuardianName")) {
			addingDataToList(ColumnNumber);
			  Collections.sort(patient, new Comparator<String>() {
				    @Override
				    public int compare(String s1, String s2) {
				        return s1.compareToIgnoreCase(s2);
				    }
				});
			AfterSorting();
			GuardianNameBeforeClick.click();
			data=addingSortedDataToList(ColumnNumber);	
		}else if(ColumnName.equalsIgnoreCase("Address")) {
			addingDataToList(ColumnNumber);
//			Collections.sort(patient);
			  Collections.sort(patient, new Comparator<String>() {
				    @Override
				    public int compare(String s1, String s2) {
				        return s1.compareToIgnoreCase(s2);
				    }
				});
			AfterSorting();
			AddressBeforeClick.click();
			data=addingSortedDataToList(ColumnNumber);	
		}
		return data;
	}
	
	public void addingDataToList(int no) throws InterruptedException {
		totalpages=driver.findElements(By.xpath("//div[@id='DataTables_Table_0_paginate']/span/a[@aria-controls=\"DataTables_Table_0\"]")).size();
		System.out.println("Totalpages :"+totalpages);
		 TotalIds=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td["+no+"]"));	
		for(WebElement ele:TotalIds) {
			patient.add(ele.getText());
		}
		for(int i=0;i<totalpages-1;i++) {
			try {
				nextBtn.click();
				log.info("clicked on the linkNo "+i);
				Thread.sleep(2500);	
				driver.findElement(By.xpath("//a[@class='sidebar-toggle']")).click();
				driver.manage().window().minimize();
				driver.manage().window().maximize();
				TotalIds=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td["+no+"]"));
				for(WebElement ele:TotalIds) {
					patient.add(ele.getText());
				}
			} catch (IndexOutOfBoundsException e) {
	            System.out.println("no further links");
	            break;
	        }
			System.out.println(patient.size());
			
		}
		//************************* sorting through java**********************
			String firstCell=patient.get(0);
			String LastCell=patient.get(patient.size()-1);
			System.out.println("first cell :"+firstCell);
			System.out.println("last cell :"+LastCell);
	}
	public void AfterSorting() {
		System.out.println("-----------------After sort -----------------");
		firstCell=patient.get(0);
		LastCell=patient.get(patient.size()-1);
		System.out.println("first cell :"+firstCell);
		System.out.println("last cell :"+LastCell);
		System.out.println("*****************sorting through java*************************");
		for(String data:patient) {System.out.println(data);}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 0);"); 

	}
	List<WebElement> TotalIdsReverseOrder;
	public List<List<String>> addingSortedDataToList(int no) throws InterruptedException {
	List<String> sortedArrayWithWebTable=new ArrayList<String>();
	Thread.sleep(1500);
	TotalIdsReverseOrder=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td["+no+"]"));
	 for(WebElement ele:TotalIdsReverseOrder) {
		 sortedArrayWithWebTable.add(ele.getText());
	 }
	 for(int i=0;i<totalpages-1;i++) {
		try {
			nextBtn.click();
			Thread.sleep(1000);
			TotalIdsReverseOrder=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td["+no+"]"));
			for(WebElement ele:TotalIdsReverseOrder) {
				sortedArrayWithWebTable.add(ele.getText());
			}
		} catch (IndexOutOfBoundsException e) {
            System.out.println("no further links");
            break;
        }
	}
     System.out.println("Total Records :"+TotalIdsReverseOrder.size());
	System.out.println("*****************sorting through Web table*************************");
	 for(String ele:sortedArrayWithWebTable) {System.out.println(ele);}
	List<List<String>> data=new ArrayList<List<String>>();
	data.add(patient);
	data.add(sortedArrayWithWebTable);
	System.out.println("list 1:"+data.get(0));
	System.out.println("list 1:"+data.get(1));
	return data;
	}

	
//	public String patientIdAscendingSorting(String value){
//			PatientIdBeforeClick.click();
//			if(PatientIdLastcell.getText().equalsIgnoreCase(value)) {
//				PatientIdAfterClick.click();
//				order="Ascending order";
//				}
//			return order;
//		}
	
//	public String checkTableColumnSorting(String Webelement,String value) {
//		if(Webelement.equalsIgnoreCase("PatientId")){
//			if(PatientIdFirstCell.getText().equalsIgnoreCase(value)) {
//				System.out.println("Beforeclick");
//				PatientIdBeforeClick.click();
//				order="Descending order";
//				}
//		}else if(Webelement.equalsIgnoreCase("PatientName")) {
//			if(PatientNameFirstCell.getText().equalsIgnoreCase(value)) {
//				System.out.println("Beforeclick");
//				PatientNameBeforeClick.click();
//				order="Descending order";
//				}
//		}else if(Webelement.equalsIgnoreCase("Age")) {
//			if(AgecolumnFirstCell.getText().equalsIgnoreCase(value)) {
//				System.out.println("Beforeclick");
//				AgecolumnBeforeClick.click();				
//				order="Descending order";
//				}
//		}else if(Webelement.equalsIgnoreCase("gender")) {
//			if(GenderFirstCell.getText().equalsIgnoreCase(value)) {
//				System.out.println("Beforeclick");
//				GenderBeforeclick.click();
//				order="Descending order";				
//				}
//		}else if(Webelement.equalsIgnoreCase("phone")) {
//			if(PhoneNoFirstCell.getText().equalsIgnoreCase(value)) {
//				System.out.println("Beforeclick");
//				PhoneNoBeforeClick.click();
//				order="Descending order";
//				}
//		}else if(Webelement.equalsIgnoreCase("guardianName")) {
//			if(GuardaianNameFirstCell.getText().equalsIgnoreCase(value)) {
//				System.out.println("Beforeclick");
//				GuardianNameBeforeClick.click();
//				System.out.println("Afterclick");
//				order="Descending order";
//				}
//		}else if(Webelement.equalsIgnoreCase("address")) {
//			if(AddressFirstCell.getText().equalsIgnoreCase(value)) {
//				AddressBeforeClick.click();
//				order="Descending order";
//				}
//		}
//		return order;
//	}
	

	//--------------------------------------------------------Best Ways for Sorting------------------------------------------------------------------------
	
	
	
	
//	public boolean sortingPatientID_1stway() throws InterruptedException {	
//		
//	int totalpages=driver.findElements(By.xpath("//div[@id='DataTables_Table_0_paginate']/span/a[@aria-controls=\"DataTables_Table_0\"]")).size();
//	System.out.println("Totalpages :"+totalpages);
//	
//	List<WebElement> links=driver.findElements(By.xpath("//div[@id='DataTables_Table_0_paginate']/span/a[@class='paginate_button ']"));
//	System.out.println("Total Links:"+links.size());
//
//	 TotalIds=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]"));	
//	for(WebElement ele:TotalIds) {
//		patient.add(ele.getText());
//	}
//	
//	for(int i=0;i<totalpages;i++) {
//		try {
//			links.get(i).click();
//			Thread.sleep(500);
//			TotalIds=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]"));
//			for(WebElement ele:TotalIds) {
//				patient.add(ele.getText());
//			}
//		} catch (IndexOutOfBoundsException e) {
//            System.out.println("no further links");
//            break;
//        }
//		
//	}
//	
//	 firstCell=patient.get(0);
//	 LastCell=patient.get(patient.size()-1);
//	System.out.println("first cell :"+firstCell);
//	System.out.println("last cell :"+LastCell);
//	Collections.sort(patient);
//	System.out.println("-----------------After sort -----------------");
//	String firstCell1=patient.get(0);
//	String LastCell1=patient.get(patient.size()-1);
//	System.out.println("first cell :"+firstCell1);
//	System.out.println("last cell :"+LastCell1);
//	
//	
//	
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//	js.executeScript("window.scrollTo(0, 0);"); 
//	PatientIdBeforeClick.click();
//	Thread.sleep(1000);
//	String AfterclickFirstCell=driver.findElement(By.cssSelector("table tbody tr:first-child td:first-child")).getText();
//	if(AfterclickFirstCell.equalsIgnoreCase(LastCell)) {
//		System.out.println("first cell  after clcik:"+AfterclickFirstCell);
//		flag=true;
//	}
//	return flag;   
//	}
	

//	public boolean sortingPatientname_1stway() throws InterruptedException {	
//		totalpages=driver.findElements(By.xpath("//div[@id='DataTables_Table_0_paginate']/span/a[@aria-controls=\"DataTables_Table_0\"]")).size();
//		System.out.println("Totalpages :"+totalpages);
//		List<WebElement> links=driver.findElements(By.xpath("//div[@id='DataTables_Table_0_paginate']/span/a[@class='paginate_button ']"));
//		System.out.println("Total Links:"+links.size());
//		 TotalIds=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]"));	
//		for(WebElement ele:TotalIds) {
//			patient.add(ele.getText());
//		}
//		
//		for(int i=0;i<totalpages;i++) {
//			try {
//				links.get(i).click();
//				Thread.sleep(500);
//				TotalIds=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]"));
//				for(WebElement ele:TotalIds) {
//					patient.add(ele.getText());
//				}
//			} catch (IndexOutOfBoundsException e) {
//	            System.out.println("no further links");
//	            break;
//	        }
//			
//		}
//		
//		String firstCell=patient.get(0);
//		String LastCell=patient.get(patient.size()-1);
//		System.out.println("first cell :"+firstCell);
//		System.out.println("last cell :"+LastCell);
//		Collections.sort(patient);
//		System.out.println("-----------------After sort -----------------");
//		firstCell=patient.get(0);
//		LastCell=patient.get(patient.size()-1);
//		System.out.println("first cell :"+firstCell);
//		System.out.println("last cell :"+LastCell);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(0, 0);"); 
//		PatientNameBeforeClick.click();
//		Thread.sleep(1000);
//		String AfterclickFirstCell=driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText();
//		System.out.println("first cell  after clcik:"+AfterclickFirstCell);
//		if(AfterclickFirstCell.equalsIgnoreCase(firstCell)) {
//			System.out.println("first cell  after clcik:"+AfterclickFirstCell);
//			flag=true;
//		}
//		return flag;   
//		}

	
//	public List<List<String>> sortingPatientID_2ndway() throws InterruptedException {	
//		
//		int totalpages=driver.findElements(By.xpath("//div[@id='DataTables_Table_0_paginate']/span/a[@aria-controls=\"DataTables_Table_0\"]")).size();
//		System.out.println("Totalpages :"+totalpages);
//		
//		List<WebElement> links=driver.findElements(By.xpath("//div[@id='DataTables_Table_0_paginate']/span/a[@class='paginate_button ']"));
//		System.out.println("Total Links:"+links.size());
//
//		 TotalIds=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]"));	
//		 
//		for(WebElement ele:TotalIds) {
//			patient.add(ele.getText());
//		}
//		
//		for(int i=0;i<totalpages;i++) {
//			try {
//				links.get(i).click();
//				Thread.sleep(1000);
//				TotalIds=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]"));
//				for(WebElement ele:TotalIds) {
//					patient.add(ele.getText());
//				}
//			} catch (IndexOutOfBoundsException e) {
//	            System.out.println("no further links");
//	            break;
//	        }
//			
//		}
//		
//		//************************* sorting through java**********************
//			String firstCell=patient.get(0);
//			String LastCell=patient.get(patient.size()-1);
//			System.out.println("first cell :"+firstCell);
//			System.out.println("last cell :"+LastCell);
//			Collections.reverse(patient);
//			System.out.println("-----------------After sort -----------------");
//			firstCell=patient.get(0);
//			LastCell=patient.get(patient.size()-1);
//			System.out.println("first cell :"+firstCell);
//			System.out.println("last cell :"+LastCell);
//
//				System.out.println("*****************sorting through java*************************");
//				for(String data:patient) {System.out.println(data);}
//				
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(0, 0);"); 
//		PatientIdBeforeClick.click();
//		List<String> sortedArrayWithWebTable=new ArrayList<String>();
//		Thread.sleep(500);
//		List<WebElement> TotalIdsReverseOrder=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]"));
//		 for(WebElement ele:TotalIdsReverseOrder) {
//			 sortedArrayWithWebTable.add(ele.getText());
//		 }
//		List<WebElement> AfterSortlinks=driver.findElements(By.xpath("//div[@id='DataTables_Table_0_paginate']/span/a[@class='paginate_button ']"));
//		for(int i=0;i<totalpages;i++) {
//			try {
//				AfterSortlinks.get(i).click();
//				Thread.sleep(1000);
//				TotalIdsReverseOrder=driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[1]"));
//				for(WebElement ele:TotalIdsReverseOrder) {
//					sortedArrayWithWebTable.add(ele.getText());
//				}
//			} catch (IndexOutOfBoundsException e) {
//	            System.out.println("no further links");
//	            break;
//	        }
//		}
//		System.out.println("*****************sorting through Web table*************************");
//		 for(String ele:sortedArrayWithWebTable) {System.out.println(ele);}
//		
//		List<List<String>> data=new ArrayList<List<String>>();
//		data.add(patient);
//		data.add(sortedArrayWithWebTable);
//		System.out.println("list 1:"+data.get(0));
//		return data;
//		}
	

	
}
