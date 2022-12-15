package com.Kareclouds.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorReturn;

public class MainBedPage extends GenericPage {

	public Logger log;
	public MainBedPage(WebDriver Driver,Logger Log) {
		super(Driver);
		driver = Driver;
		this.log=Log;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Bed")
	WebElement BedLink;
	@FindBy(linkText="Bed Type")
	WebElement BedTypeLink;
	@FindBy(linkText="Bed Group")
	WebElement BedGroupLink;
	@FindBy(linkText="Floor")
	WebElement FloorLink;
	
	@FindBy(xpath="//h3[@class='box-title titlefix']")
	 WebElement  pageTitle;
	public String checkPageTitle() {
		return pageTitle.getText();
	}
	
	public BedPage checkBedPageLink() {
		BedLink.click();
		BedPage bed_page=new BedPage(driver);
		return bed_page;
	}
	
	public BedTypePage checkBedTypeLink() {
		BedTypeLink.click();
		BedTypePage bedTypepage=new BedTypePage(driver);
		return bedTypepage;
	}
	
	public BedGroupPage checkBedGroupLink() {
		BedGroupLink.click();
		BedGroupPage bedgrouppage=new BedGroupPage(driver);
		return bedgrouppage;
	}
	
	public FloorPage checkFloorLink() {
		FloorLink.click();
		FloorPage floor=new FloorPage(driver);
		return floor;
	}
	
	
}
