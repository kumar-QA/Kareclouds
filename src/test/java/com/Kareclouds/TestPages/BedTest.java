package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.BedPage;
import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.MainBedPage;

public class BedTest extends BaseTest {

	public DashboardPage dashboard_page;
	public MainBedPage mainbedpage;
	public BedPage bedpage;
	
	
	 @Test()//------Search Functionality 
	   public void VerifySearchOfBedTest() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   mainbedpage=dashboard_page.selectBedLink();
		   bedpage=  mainbedpage.checkBedPageLink();
			String result=bedpage.searchOperation("Moses");
			Assert.assertEquals(result, "Moses");
	   }
	 
	 @Test()//------add form Functionality 
	   public void VerifyfromOfBedTest() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   mainbedpage=dashboard_page.selectBedLink();
		   bedpage=  mainbedpage.checkBedPageLink();
		   bedpage.AddForm("priya", "2", "1");;
	   }
	 
	 
	
}
