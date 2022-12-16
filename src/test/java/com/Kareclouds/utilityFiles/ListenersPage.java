package com.Kareclouds.utilityFiles;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Kareclouds.utilityFiles.ExtentReportNG;
import com.Kareclouds.TestPages.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersPage extends BaseTest implements ITestListener {
	
	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(" ***************** onTestStart Method  Listener *************");
		System.out.println("Test Name :"+result.getName()+" test case started");
		test = extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("*********onTestSuccess Method Listener **********************");
		 System.out.println("TestCase:"+result.getName()+"  Passed");
		 extenttest.get().log(Status.PASS, "Test case executed successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("************onTestFailure  Method Listener**********************");
		 System.out.println("TestCase : "+result.getName()+" Failed");
		//get driver
			try {
				driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			
			// Attach screenshots
			String path = null;
			try {
				path = getScreenshot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
				e.printStackTrace();
			}

			extenttest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		}
    @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    	System.out.println("***********************onTestFailedButWithinSuccessPercentage  Method Listener************");
    	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("*****************onTestSkipped  Method Listener *************************");
		System.out.println("TestCase :"+result.getName()+" Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("****************************onStart  Method Listener**************************");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("*****************************onFinish  Method Listener*****************************");
		extent.flush();
	}
}
