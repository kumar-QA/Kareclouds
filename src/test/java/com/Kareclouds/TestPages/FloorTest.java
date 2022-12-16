package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.FloorPage;
import com.Kareclouds.Pages.MainBedPage;

public class FloorTest extends BaseTest {
	public DashboardPage dashboard_page;
	public MainBedPage mainbedpage;
	public FloorPage floorpage;
	
	
	 @Test()//------Search Functionality 
	   public void VerifySearchOptionOfCT() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   mainbedpage=dashboard_page.selectBedLink();
		   floorpage=  mainbedpage.checkFloorLink();
			String result=floorpage.searchOperation("Alpha");
			Assert.assertEquals(result, "Alpha");
	   }
	 
	 @Test()//------add from Functionality 
	   public void Verifyform() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   mainbedpage=dashboard_page.selectBedLink();
		   floorpage=  mainbedpage.checkFloorLink();
		   floorpage.AddForm("4thfloor", "Special Icu ward");
			
	   }
	
	
}
