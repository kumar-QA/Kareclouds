package com.Kareclouds.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BedTypePage extends GenericPage {

	public BedTypePage(WebDriver Driver) {
		super(Driver);
		this.driver=Driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[@class='box-title titlefix']")
	 WebElement  pageTitle;
	
	@FindBy(xpath = "//div[@id='DataTables_Table_0_filter']/label/input")
	WebElement searchinput;
	
	public String checkPageTitle() {
		return pageTitle.getText();
	}
	
	String result;
	public String searchOperation(String field){
		searchinput.sendKeys(field);
		String data=driver.findElement(By.xpath("//td[contains(text(),'"+field+"')]")).getText();
		if(data.equalsIgnoreCase(field)) {
			System.out.print(data);
			result=data;
		}
		return result;
	}
	

}
