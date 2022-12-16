package com.Kareclouds.TestPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Kareclouds.Pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public LoginPage login_page;
	public  Logger log;
	
	public WebDriver driverInitilization() throws IOException {
		FileInputStream fis=new FileInputStream("E:\\Eclipse_workspace\\Kareclouds\\src\\main\\java\\com\\Kareclouds\\resources\\config.properties");
		prop=new Properties();
		prop.load(fis);
		String BrowserName=prop.getProperty("browser");
		System.out.println(BrowserName);
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
		}else if(BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(BrowserName.equalsIgnoreCase("edgebrowser")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplication(ITestContext ctx) throws IOException {
		String testName = ctx.getCurrentXmlTest().getName();
		log =LogManager.getLogger(testName);
		log.info("Launch Application using driver initilization and login into the app");
		driver=driverInitilization();
		login_page=new LoginPage(driver,log);
		login_page.gotoUrl();
		log.info("Login page object returned");
		return login_page;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		log.info("Close driver");
		driver.close();
		
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot scrnshot=(TakesScreenshot)driver;
		File scrFile=scrnshot.getScreenshotAs(OutputType.FILE);
		File dstFile=new File("E:\\Eclipse_workspace\\Kareclouds\\Screenshots\\" +testCaseName +".png");
		FileUtils.copyFile(scrFile, dstFile);
		return "E:\\Eclipse_workspace\\Kareclouds\\Screenshots\\" +testCaseName +".png";
	}
	
}
