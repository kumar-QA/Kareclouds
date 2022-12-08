package com.Kareclouds.TestPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Kareclouds.Pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public LoginPage login_page;
	
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplication() throws IOException {
		driver=driverInitilization();
		login_page=new LoginPage(driver);
		login_page.gotoUrl();
		return login_page;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
		
	}
	
}
