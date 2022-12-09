package com.Kareclouds.utilityFiles;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Kareclouds.TestPages.BaseTest;

public class ListenersPage extends BaseTest implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		System.out.println(result.getName()+" test case started");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("onTestSuccess");
		 System.out.println("The name of the testcase passed is :"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		 System.out.println("The name of the testcase failed is :"+result.getName());
		}
    @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    	System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		System.out.println("The name of the testcase Skipped is :"+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	}
}
