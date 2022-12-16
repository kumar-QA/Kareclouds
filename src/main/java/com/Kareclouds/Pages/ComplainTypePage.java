package com.Kareclouds.Pages;

import org.openqa.selenium.By;
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
	@FindBy(xpath = "//div[@id='DataTables_Table_0_filter']/label/input")
	WebElement searchinput;
	@FindBy(xpath="//div[@class='box-tools pull-right']/a")
	WebElement AddcomplainBtn;
	@FindBy(xpath="//form[@id='formadd']//input[@name='complaint_type']")
	WebElement complaintype;
	@FindBy(xpath="//form[@id='formadd']//textarea[@name='description']")
	WebElement Description;
	@FindBy(xpath="//button[@id='formaddbtn']")
    WebElement saveBtn;
	
	
	public String checkPageTitle() {
		return PageTitle.getText();
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
	
	public void AddComplainTypeForm(String complain,String des) {
		AddcomplainBtn.click();
		complaintype.sendKeys(complain);
		Description.sendKeys(des);
		saveBtn.click();
	}
}
