package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.BedGroupPage;
import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.MainBedPage;

public class BedGroupTest extends BaseTest{

	public DashboardPage dashboard_page;
	public MainBedPage mainbedpage;
	public BedGroupPage bedgrouppage;
	
	
	 @Test()//------Search Functionality 
	   public void VerifySearchOptionOfBedGroup() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   mainbedpage=dashboard_page.selectBedLink();
		   bedgrouppage=  mainbedpage.checkBedGroupLink();
			String result=bedgrouppage.searchOperation("NICU");
			Assert.assertEquals(result, "NICU");
	   }
	 
	 @Test()//------add form Functionality 
	   public void VerifyformOfBedGroup() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   mainbedpage=dashboard_page.selectBedLink();
		   bedgrouppage=  mainbedpage.checkBedGroupLink();
		   bedgrouppage.AddForm("ICU ward", "32", "Emergency");
			
	   }
}
