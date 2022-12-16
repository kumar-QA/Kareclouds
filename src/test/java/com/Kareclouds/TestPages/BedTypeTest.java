package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.BedTypePage;
import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.MainBedPage;

public class BedTypeTest extends BaseTest{
	public DashboardPage dashboard_page;
	public MainBedPage mainbedpage;
	public BedTypePage bedtypepage;
	
	
	 @Test()//------Search Functionality 
	   public void VerifySearchOptionOfBedType() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   mainbedpage=dashboard_page.selectBedLink();
		   bedtypepage=  mainbedpage.checkBedTypeLink();
			String result=bedtypepage.searchOperation("VIP");
			Assert.assertEquals(result, "VIP");
	   }
	 
	 
	 @Test()//------add form Functionality 
	   public void VerifyfromOfBedType() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   mainbedpage=dashboard_page.selectBedLink();
		   bedtypepage=  mainbedpage.checkBedTypeLink();
		   bedtypepage.AddForm("ICU");
			
	   }
}
