package com.Kareclouds.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BedGroupPage extends GenericPage{

	public BedGroupPage(WebDriver Driver) {
		super(Driver);
		this.driver=Driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[@class='box-title titlefix']")
	 WebElement  pageTitle;
	
	@FindBy(xpath = "//div[@id='DataTables_Table_0_filter']/label/input")
	WebElement searchinput;
	
	@FindBy(xpath="//div[@class='box-tools pull-right']/a")
	WebElement AddBtn;
	@FindBy(xpath="//form[@id='addward']//input[@name='name']")
	WebElement Name;
	@FindBy(xpath="//form[@id='addward']//select[@name='floor']")
	WebElement floorDropdown;
	@FindBy(xpath="//form[@id='addward']//input[@name='name']")
	WebElement Description;
	
	@FindBy(xpath="//button[@id='addwardbtn']")
	WebElement SaveBtn;
	
	
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
	
	
	public void AddForm(String name,String floortype,String des) {
		AddBtn.click();
		Name.sendKeys(name);
		selectClass(floorDropdown,floortype);
		Description.sendKeys(des);
		SaveBtn.click();
	}
	
}
