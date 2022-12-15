package com.Kareclouds.utilityFiles;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Kareclouds.utilityFiles.ExtentReportNG;
import com.Kareclouds.TestPages.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ListenersPage extends BaseTest implements ITestListener {
	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(" ***************** onTestStart Method  Listener *************");
		System.out.println("Test Name :"+result.getName()+" test case started");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("*********onTestSuccess Method Listener **********************");
		 System.out.println("TestCase:"+result.getName()+"  Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("************onTestFailure  Method Listener**********************");
		 System.out.println("TestCase : "+result.getName()+" Failed");
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
	}
}
