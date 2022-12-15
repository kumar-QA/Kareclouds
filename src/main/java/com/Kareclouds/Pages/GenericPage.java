package com.Kareclouds.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericPage {
	
	public WebDriver driver;
	public GenericPage(WebDriver Driver){
		driver=Driver;
	}
	
	public void waitForElementToAppear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForElementToAppear(List<WebElement> ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	public void waitForElementToAppear(By locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void js_Click(WebElement ele) {
		JavascriptExecutor script=(JavascriptExecutor)driver;
		script.executeScript("arguments[0].click()", ele);
	}
	public void ActionFunction(WebElement ele1,WebElement ele2) {
		Actions act=new Actions(driver);
		act.moveToElement(ele1).click().build().perform();
		act.moveToElement(ele2).click().build().perform();
	}
	public void selectClass(WebElement ele,String Parameter) {
		Select sel=new Select(ele);
//		sel.selectByVisibleText(Parameter);
		sel.selectByValue(Parameter);
	}
}
